package br.com.vendasprod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import br.com.vendasprod.entity.Pedido;
import br.com.vendasprod.entity.QtdProduto;

public class PedidoDAO extends AbstractPersistence<Pedido, Long>{
 
	public PedidoDAO() {
		super(Pedido.class);
	}
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Pedido> findAllEager() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pedido> q = cb.createQuery(Pedido.class);
		Root<Pedido> c = q.from(Pedido.class);  
		Fetch<Pedido,QtdProduto> p = c.fetch("qtdProdutos");
		 q.select(c).distinct(true);
		 TypedQuery<Pedido> typedQuery = em.createQuery(q);
		  return typedQuery.getResultList();
	}

}
