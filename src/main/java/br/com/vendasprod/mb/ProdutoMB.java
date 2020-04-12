package br.com.vendasprod.mb;



import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.service.ProdutoService;

/**
 * Componente respons�vel por integrar o front-end (paginas JSF) c/ camada de servi�o (EJB).
 * @author Macedo
 */
@Named
@RequestScoped
public class ProdutoMB extends GenericMB implements Serializable {
	
	private static final String LISTA_COMPRAS = "lista_compras";
	Logger logger = Logger.getLogger("br.com.vendasprod.mb.ProdutoMB");

	/**
	 * Referência para o componente EJB, injetado pelo container.
	 */
	@Inject
	private ProdutoService service;
	
	/**
	 * Referência para a mercadoria utiliza na inclusão (nova) ou edição.
	 */
	@Inject
	private Produto produto;
	
	private Long idSelecionado;
	
	private List<Produto> produtos;
	
	private List<Produto> selectedProdutos;
	
	public ProdutoMB() {
	}
	
	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
	
	public Long getIdSelecionado() {
		return idSelecionado;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		produto = service.find(idSelecionado);
		logger.debug("Pronto pra editar");
	}
	
	public List<Produto> getProdutos() {
		logger.info("buscando..." +service.getClass());
		if (produtos == null) {
			produtos = service.findAll();
		}
		return produtos;
	}

	
	public String salvar() {
		try {
			logger.info("salvando..." +service.getClass());
			service.save(produto);
		} catch(Exception ex) {
			logger.error("Erro ao salvar produto.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar.produto"), ex.getMessage());
			return "";
		}
		logger.debug("Salvou produto "+produto.getId());
		return "listaProdutos";
	}
	
	public String remover() {
		try {
			service.remove(produto);
		} catch(Exception ex) {
			logger.error("Erro ao remover produto.", ex);
			addMessage(getMessageFromI18N("msg.erro.remover.produto"), ex.getMessage());
			return "";
		}
		logger.debug("Removeu produto "+produto.getId());
		return "listaProdutos";
	}
	
	public String finalizarCompra() {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put(LISTA_COMPRAS, selectedProdutos);
		return "pedido";
	}
	
	public List<Produto> getSelectedProdutos() {
		return selectedProdutos;
	}

	public void setSelectedProdutos(List<Produto> selectedProdutos) {
		this.selectedProdutos = selectedProdutos;
	}

}
