package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Local;

import br.com.vendasprod.entity.Pedido;

/**
 * Interface de negócio para o pedido
 * @author Macedo
 *
 */
@Local
public interface PedidoService {

	public Pedido save(Pedido pedido);
	
	public void remove(Pedido pedido);
	
	public Pedido find(Long id);
	
	public List<Pedido> findAll();

}
