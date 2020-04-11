package br.com.vendasprod.service;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Produto;

/**
 * Componente <code>EJB</code> que implementa as operações de negócio da entidade <code>Mercadoria</code>.
 * 
 * <p>Herda <code>AbstractPersistence</code> para resolver as operações básicas da persistência de <code>Mercadoria</code>.</p>
 * 
 * @see br.com.ProdutoService.cdi.service.MercadoriaService
 * @author YaW Tecnologia
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
	
}
