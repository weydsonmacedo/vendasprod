package br.com.vendasprod.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.QtdProduto;

public class QtdProdutoDAO extends AbstractPersistence<QtdProduto, Long>{
 
	public QtdProdutoDAO() {
		super(QtdProduto.class);
	}
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
