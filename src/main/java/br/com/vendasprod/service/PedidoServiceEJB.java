package br.com.vendasprod.service;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Pedido;

/** Implementas as operações de negócio do Pedido
 * 
 * @author Macedo
 *
 */
@Stateless
public class PedidoServiceEJB extends AbstractPersistence<Pedido, Long> implements PedidoService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public PedidoServiceEJB() {
		super(Pedido.class);
	}
	
}
