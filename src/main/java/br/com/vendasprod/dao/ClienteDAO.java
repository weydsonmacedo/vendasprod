package br.com.vendasprod.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Cliente;


public class ClienteDAO extends AbstractPersistence<Cliente, Long>{
 
	public ClienteDAO() {
		super(Cliente.class);
	}
	@PersistenceContext
    private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
