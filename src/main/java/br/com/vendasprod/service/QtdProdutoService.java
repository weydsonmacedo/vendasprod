package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Local;

import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.entity.QtdProduto;

/**
 * Interface de neg�cio para o QtdProduto
 * @author Macedo
 *
 */
@Local
public interface QtdProdutoService {

	public QtdProduto save(QtdProduto produto);
	
	public void remove(QtdProduto produto);
	
	public QtdProduto find(Long id);
	
	public List<QtdProduto> findAll();
	
	public  List<QtdProduto> parseProdutoToQtdProduto(List<Produto> produtos);

}