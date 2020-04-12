package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Local;

import br.com.vendasprod.entity.Produto;

/**
 * Determina a interface de negocio para estipular o serviço da entidade 
 * 
 * @author Macedo
 */
@Local
public interface ProdutoService {

	public Produto save(Produto produto);
	
	public void remove(Produto produto);
	
	public Produto find(Long id);
	
	public List<Produto> findAll();
	
	public void subtractQtdProduto(Integer qtd, Produto produto);

}
