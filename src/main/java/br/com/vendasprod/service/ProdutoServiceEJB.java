package br.com.vendasprod.service;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Produto;

/**
 * Interface de negócio para o Produto
 * @author Macedo
 *
 */
@Stateless
public class ProdutoServiceEJB extends AbstractPersistence<Produto, Long> implements ProdutoService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public ProdutoServiceEJB() {
		super(Produto.class);
	}

	@Override
	public void subtractQtdProduto(Integer qtd, Produto produto) {
		produto = this.find(produto.getId());
		produto.setQuantidade(produto.getQuantidade() - qtd);
		this.save(produto);
		
	}
	
}
