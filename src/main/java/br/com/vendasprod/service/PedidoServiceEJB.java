package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import br.com.vendasprod.entity.Pedido;
import br.com.vendasprod.entity.QtdProduto;

/** Implementas as operações de negócio do Pedido
 * 
 * @author Macedo
 *
 */
@Stateless
public class PedidoServiceEJB extends AbstractPersistence<Pedido, Long> implements PedidoService {

	@PersistenceContext
    private EntityManager em;
	
	@Inject
	private QtdProdutoService qtdProdutoService;
	@Inject
	private ProdutoService produtoService;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public PedidoServiceEJB() {
		super(Pedido.class);
	}
	


	@Override
	public Pedido saveQtdProdutosAndPedido(Pedido pedido, List<QtdProduto> listQtdProd) {
		
		pedido = this.save(pedido);
		for (QtdProduto qtdProduto : listQtdProd) {
			produtoService.subtractQtdProduto(qtdProduto.getQtdProdutos(), qtdProduto.getProduto());
			qtdProduto.setPedido(pedido);
			qtdProdutoService.save(qtdProduto);	
		}
		return null;
	}
	
	@Override
	public List<Pedido> findAllEager(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pedido> q = cb.createQuery(Pedido.class);
		Root<Pedido> c = q.from(Pedido.class);  
		Fetch<Pedido,QtdProduto> p = c.fetch("qtdProdutos");
		 q.select(c);
		 TypedQuery<Pedido> typedQuery = em.createQuery(q);
		  return typedQuery.getResultList();
	}
}
