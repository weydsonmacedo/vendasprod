package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Local;

import br.com.vendasprod.entity.Cliente;

/**
 * Determina a interface de negocio para estipular o servico da entidade cliente
 * @author Macedo
 */
@Local
public interface ClienteService {

	public Cliente save(Cliente cliente);
	
	public void remove(Cliente cliente);
	
	public Cliente find(Long id);
	
	public List<Cliente> findAll();

}
