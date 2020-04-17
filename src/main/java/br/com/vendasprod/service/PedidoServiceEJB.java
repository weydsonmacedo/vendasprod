package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vendasprod.dao.PedidoDAO;
import br.com.vendasprod.entity.Pedido;
import br.com.vendasprod.entity.QtdProduto;

/** Implementa as operações de negócio do Pedido
 * 
 * @author Macedo
 *
 */
@Stateless
public class PedidoServiceEJB implements PedidoService {

	@Inject
	private QtdProdutoService qtdProdutoService;
	@Inject
	private ProdutoService produtoService;
	
	@Inject
	private PedidoDAO dao;


	@Override
	public Pedido saveQtdProdutosAndPedido(Pedido pedido, List<QtdProduto> listQtdProd) {
		pedido = this.save(pedido);
		for (QtdProduto qtdProduto : listQtdProd) {
			produtoService.subtractQtdProduto(qtdProduto.getQtdProdutos(), qtdProduto.getProduto());
			qtdProduto.setPedido(pedido);
			qtdProdutoService.save(qtdProduto);	
		}
		return pedido;
	}
	
	@Override
	public List<Pedido> findAllEager(){
		return this.dao.findAllEager();
	}
	
	@Override
	public void remove(Pedido entity) {
		qtdProdutoService.removeAll(entity.getQtdProdutos());
		this.dao.remove(entity);
	}

	@Override
	public Pedido save(Pedido pedido) {
		return this.dao.save(pedido);
	}

	@Override
	public Pedido find(Long id) {
		return this.dao.find(id);
	}

	@Override
	public List<Pedido> findAll() {
		return this.dao.findAll();
	}
}
