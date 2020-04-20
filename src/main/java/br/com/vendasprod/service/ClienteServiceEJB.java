package br.com.vendasprod.service;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vendasprod.dao.ClienteDAO;
import br.com.vendasprod.entity.Cliente;


/** Implementas as operações de negócio do Cliente
 * 
 * @author Macedo
 *
 */
@Stateless
public class ClienteServiceEJB implements ClienteService {

	
	
	@Inject
	private ClienteDAO dao;
	
	
	

/**
 * método teporário para carregamento dos dados de cliente! deve ser retirado após realizar a carga manual via sql	
 */
	@Override
	public List<Cliente> findAll(){
//		return inserirExemploCliente();
		return this.dao.findAll();
	}
	
	public List<Cliente> inserirExemploCliente() {
		if (this.dao.findAll().isEmpty()) {
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes.add(new Cliente("GLEICA", "SÃO JOSÉ DOS CAMPOS"));
			clientes.add(new Cliente("THIAGO", "SEABRA"));
			clientes.add(new Cliente("WEYDSON", "CAIRÚ"));
			clientes.add(new Cliente("KEZIA", "LIBERTY CITY"));
			clientes.add(new Cliente("JAMILE", "SALVADOR"));
			clientes.add(new Cliente("MOANA", "ISLAND"));
			clientes.add(new Cliente("ANNE WITH AN E", "LAKE OF THE SHINING WATERS"));
			clientes.add(new Cliente("STEFANINI", "INEMA"));
			clientes.stream().forEach(c -> this.save(c));
			return clientes;

		}
		return this.dao.findAll();
	}
	
	@Override
	public Cliente save(Cliente cliente) {
		return this.dao.save(cliente);
	}
	@Override
	public void remove(Cliente cliente) {
		this.dao.remove(cliente);
	}
	@Override
	public Cliente find(Long id) {
		return this.dao.find(id);
	}
}
