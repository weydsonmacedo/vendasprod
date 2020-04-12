package br.com.vendasprod.mb;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.vendasprod.entity.Cliente;
import br.com.vendasprod.entity.Pedido;
import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.entity.QtdProduto;
import br.com.vendasprod.service.ClienteService;
import br.com.vendasprod.service.PedidoService;
import br.com.vendasprod.service.QtdProdutoService;

/**
 *  Componente responsável por integrar o front-end (paginas JSF) c/ camada de serviço (EJB) e por finalizar o pedido.
 * @author Macedo
 *
 */
@Named
@ViewScoped
public class PedidoMB extends GenericMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -837088857888574909L;
	Logger logger = Logger.getLogger("br.com.vendasprod.mb.PedidoMB");
	
	private static final String LISTA_COMPRAS = "lista_compras";

	/**
	 * ReferÃªncia para o componente EJB, injetado pelo container.
	 */
	@Inject
	private PedidoService service;
	
	@Inject 
	private QtdProdutoService qtdProdutoService;
	@Inject 
	private ClienteService clienteService;
	@Inject
	private Pedido pedido;
	
	private List<Pedido> listPedidos;
	
	private List<QtdProduto> listQtdProdutos;
	private  List<QtdProduto> selectedExcluirProdutos;
	private List<Cliente> listClientes;
	private Cliente cliente;
	
	@PostConstruct
	public void init() {
		List<Produto> listProdutos = (List<Produto>) FacesContext.getCurrentInstance().getExternalContext().getFlash().get(LISTA_COMPRAS);
		this.listQtdProdutos  = qtdProdutoService.parseProdutoToQtdProduto(listProdutos);
		this.getPrecoTotal();
		this.listClientes = clienteService.findAll();
	}

	public Double getPrecoTotal() {
		return this.qtdProdutoService.calcularPrecoTotal(this.listQtdProdutos);
	}
	public String salvar() {
		if (!this.verificaQtd()) {
			return"";
		}
		montarPedido();
		try {
			logger.info("salvando..." +service.getClass());
			service.saveQtdProdutosAndPedido(this.pedido, this.listQtdProdutos);
		} catch(Exception ex) {
			logger.error("Erro ao salvar pedido.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar.pedido"), ex.getMessage());
			return "";
		}
		logger.debug("Salvou pedido "+pedido.getId());
		return "listaPedidos";
	}
	
	
	
	private void montarPedido() {
		this.pedido.setCliente(this.cliente);
		this.pedido.setPreco(this.getPrecoTotal());
		this.pedido.setQtdProdutos(this.listQtdProdutos);
	}


	public boolean verificaQtd() {
			Produto prod = this.qtdProdutoService.verificaProdutoQtdExcedido(listQtdProdutos);
		if(prod!= null) {
			addMessage(getMessageFromI18N("msg.warn.qtdproduto.excedido"), "Máximo de "+prod.getNome() +" disponíveis :"+ prod.getQuantidade());
			return false;
		}
		return true;
	}
	public PedidoService getService() {
		return service;
	}

	public void setService(PedidoService service) {
		this.service = service;
	}

	public QtdProdutoService getQtdProdutoService() {
		return qtdProdutoService;
	}

	public void setQtdProdutoService(QtdProdutoService qtdProdutoService) {
		this.qtdProdutoService = qtdProdutoService;
	}

	public List<QtdProduto> getListQtdProdutos() {
		return listQtdProdutos;
	}

	public void setListQtdProdutos(List<QtdProduto> listQtdProdutos) {
		this.listQtdProdutos = listQtdProdutos;
	}

	public List<QtdProduto> getSelectedExcluirProdutos() {
		return selectedExcluirProdutos;
	}

	public void setSelectedExcluirProdutos(List<QtdProduto> selectedExcluirProdutos) {
		this.selectedExcluirProdutos = selectedExcluirProdutos;
	}
	
	public List<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ClienteService getClienteService() {
		return clienteService;
	}


	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public List<Pedido> getListPedidos() {
		if (this.listPedidos == null) {
			this.listPedidos = service.findAllEager();
		}
		return this.listPedidos;
	}


	public void setListPedidos(List<Pedido> listPedidos) {
		this.listPedidos = listPedidos;
	}

}
