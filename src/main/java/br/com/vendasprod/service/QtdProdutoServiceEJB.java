package br.com.vendasprod.service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.entity.QtdProduto;


/** Implementas as operações de negócio do QtdProduto
 * 
 * @author Macedo
 *
 */
@Stateless
public class QtdProdutoServiceEJB extends AbstractPersistence<QtdProduto, Long> implements QtdProdutoService {

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public QtdProdutoServiceEJB() {
		super(QtdProduto.class);
	}

	@Override
	public List<QtdProduto> parseProdutoToQtdProduto(List<Produto> produtos) {
		return produtos.stream().map(this::parse).collect(Collectors.toList());
	}
	
	private QtdProduto parse(Produto produto) {
		 	QtdProduto obj = new QtdProduto();
		 	obj.setProduto(produto);
		 	return obj;
	}
}
