package br.com.vendasprod.mb;



import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.service.ProdutoService;

/**
 * Componente responsável por integrar o front-end (páginas JSF) c/ camada de serviço (EJB), para resolver o cadastro de <code>Mercadoria</code>.
 * 
 * <p>Trata-se de um <code>Managed Bean</code>, ou seja, as instâncias dessa classe são controladas pelo <code>JSF</code>. 
 * Objetos de <code>MercadoriaMB</code> são criados e gerenciados pelo <code>CDI</code>, no escopo de <code>Request<code>.</p>
 * 
 * <p>Esse componente atua com um papel parecido com o <code>Controller</code> de outros frameworks <code>MVC</code>, ele resolve o fluxo de navegação e liga os componentes visuais com os dados.</p>
 * 
 * @author YaW Tecnologia
 */
@Named
@RequestScoped
public class ProdutoMB implements Serializable {
	
	private static final String LISTA_COMPRAS = "lista_compras";

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
		//log.debug("Pronto pra editar");
	}
	
	public List<Produto> getProdutos() {
		System.out.println("service: "+service);
		if (produtos == null) {
			produtos = service.findAll();
		}
		return produtos;
	}

	
	public String salvar() {
		try {
			System.out.println("service: "+service);
			service.save(produto);
		} catch(Exception ex) {
			//log.error("Erro ao salvar mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.salvar.produto"), ex.getMessage());
			return "";
		}
		//log.debug("Salvour mercadoria "+mercadoria.getId());
		return "listaProdutos";
	}
	
	public String remover() {
		try {
			service.remove(produto);
		} catch(Exception ex) {
			//log.error("Erro ao remover mercadoria.", ex);
			addMessage(getMessageFromI18N("msg.erro.remover.produto"), ex.getMessage());
			return "";
		}
		//log.debug("Removeu mercadoria "+mercadoria.getId());
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

	/**
	 * @param key
	 * @return Recupera a mensagem do arquivo properties <code>ResourceBundle</code>.
	 */
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	
	/**
	 * Adiciona um mensagem no contexto do Faces (<code>FacesContext</code>).
	 * @param summary
	 * @param detail
	 */
	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
}
