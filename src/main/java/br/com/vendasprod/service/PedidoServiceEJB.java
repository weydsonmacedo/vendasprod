package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	
}
