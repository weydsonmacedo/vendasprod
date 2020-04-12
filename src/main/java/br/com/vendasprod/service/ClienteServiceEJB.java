package br.com.vendasprod.service;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Cliente;


/** Implementas as operações de negócio do Cliente
 * 
 * @author Macedo
 *
 */
@Stateless
public class ClienteServiceEJB extends AbstractPersistence<Cliente, Long> implements ClienteService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public ClienteServiceEJB() {
		super(Cliente.class);
	}
	
	
	public List<Cliente> findAll(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		 clientes.add(new Cliente( "GLEICA", "SÃO JOSÉ DOS CAMPOS"));
		 clientes.add(new Cliente( "THIAGO", "SEABRA"));
		 clientes.add(new Cliente( "WEYDSON", "CAIRÚ"));
		 clientes.add(new Cliente( "KEZIA", "LIBERTY CITY"));
		 clientes.add(new Cliente( "JAMILE", "SALVADOR"));
		 clientes.add(new Cliente( "MOANA", "ISLAND"));
		 clientes.add(new Cliente( "ANNE WITH E", "LAKE OF THE SHINNING WATERS"));
		 clientes.add(new Cliente( "STAFANINI", "INEMA"));
		 clientes.stream().forEach( c -> this.save(c) );
		 return clientes;
	}
}
