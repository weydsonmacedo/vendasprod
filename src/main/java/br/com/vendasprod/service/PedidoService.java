package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Local;

import br.com.vendasprod.entity.Pedido;
import br.com.vendasprod.entity.QtdProduto;

/**
 * Interface de neg�cio para o pedido
 * @author Macedo
 *
 */
@Local
public interface PedidoService {

	public Pedido save(Pedido pedido);
	public Pedido saveQtdProdutosAndPedido(Pedido pedido, List<QtdProduto> listQtdProd);
	
	public void remove(Pedido pedido);
	
	public Pedido find(Long id);
	
	public List<Pedido> findAll();
	
	public List<Pedido> findAllEager();
}
