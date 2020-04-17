package br.com.vendasprod.service;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vendasprod.dao.ProdutoDAO;
import br.com.vendasprod.entity.Produto;

/**
 * implementa as operações de negócio para o Produto
 * @author Macedo
 *
 */
@Stateless
public class ProdutoServiceEJB implements ProdutoService {

	@Inject
	private ProdutoDAO dao;
	
	@Override
	public void subtractQtdProduto(Integer qtd, Produto produto) {
		produto = this.find(produto.getId());
		produto.setQuantidade(produto.getQuantidade() - qtd);
		this.save(produto);
		
	}

	@Override
	public Produto save(Produto produto) {
		return this.dao.save(produto);
	}

	@Override
	public void remove(Produto produto) {
		this.dao.remove(produto);
	}

	@Override
	public Produto find(Long id) {
		return this.dao.find(id);
	}

	@Override
	public List<Produto> findAll() {
		return this.dao.findAll();
	}
	
}
