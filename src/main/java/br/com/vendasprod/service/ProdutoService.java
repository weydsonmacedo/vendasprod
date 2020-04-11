package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Local;

import br.com.vendasprod.entity.Produto;

/**
 * Determina a interface de negócio para estipular o serviço da entidade <code>Mercadoria</code>.
 * 
 * <p>Indica o uso da interface <code>Local</code> para o serviço <code>EJB</code>.
 * 
 * @author YaW Tecnologia
 */
@Local
public interface ProdutoService {

	public Produto save(Produto produto);
	
	public void remove(Produto produto);
	
	public Produto find(Long id);
	
	public List<Produto> findAll();

}
