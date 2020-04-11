package br.com.vendasprod.mb;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.entity.QtdProduto;
import br.com.vendasprod.service.PedidoService;
import br.com.vendasprod.service.QtdProdutoService;

/**
 * Componente responsável por finalizar o pedido
 * @author Macedo
 *
 */
@Named
@RequestScoped
public class PedidoMB implements Serializable {
	
	private static final String LISTA_COMPRAS = "lista_compras";

	/**
	 * ReferÃªncia para o componente EJB, injetado pelo container.
	 */
	@Inject
	private PedidoService service;
	
	@Inject 
	private QtdProdutoService qtdProdutoService;
	
	private List<QtdProduto> listQtdProdutos;
	private  List<QtdProduto> selectedExcluirProdutos;
	private Double precoTotal; 
	
	@PostConstruct
	public void init() {
		List<Produto> listProdutos = (List<Produto>) FacesContext.getCurrentInstance().getExternalContext().getFlash().get(LISTA_COMPRAS);
		this.listQtdProdutos  = qtdProdutoService.parseProdutoToQtdProduto(listProdutos);
		this.precoTotal = this.listQtdProdutos.stream().map(q -> q.getProduto().getPreco()).reduce(Double.valueOf(0),Double::sum);
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

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

}
