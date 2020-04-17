package br.com.vendasprod.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Produto;

public class ProdutoDAO extends AbstractPersistence<Produto, Long>{
 
	public ProdutoDAO() {
		super(Produto.class);
	}
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
