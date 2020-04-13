package br.com.vendasprod.service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.entity.QtdProduto;


/** Implementas as opera��es de neg�cio do QtdProduto
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
		if (produtos != null) {			
			return produtos.stream().map(this::parse).collect(Collectors.toList());
		}
		return null;
	}
	
	private QtdProduto parse(Produto produto) {
		 	QtdProduto obj = new QtdProduto();
		 	obj.setProduto(produto);
		 	return obj;
	}

	@Override
	public Double calcularPrecoTotal(List<QtdProduto> listQtdProdutos) {
		if (listQtdProdutos != null) {			
			return listQtdProdutos.stream().map(q -> q.getProduto().getPreco() * (q.getQtdProdutos()!= null ? q.getQtdProdutos() : 0 )).reduce(Double.valueOf(0),Double::sum);
		}
		return null;
	}

	@Override
	public Produto verificaProdutoQtdExcedido(List<QtdProduto> listQtdProdutos) {
		Optional<QtdProduto> op = listQtdProdutos.stream().filter( q -> (q.getQtdProdutos() == null ? 0 : q.getQtdProdutos()) > q.getProduto().getQuantidade()).findFirst();
		if(op.isPresent()) {			
			return op.get().getProduto();
		}
		return null;
	}

	@Override
	public void removeAll(List<QtdProduto> qtdProdutos) {
		qtdProdutos.stream().forEach(q-> this.remove(q));
		
	}

	@Override
	public boolean verificaProdutoQtdZerado(List<QtdProduto> listQtdProdutos) {
		return listQtdProdutos.stream().anyMatch(p -> p.getQtdProdutos() == null || p.getQtdProdutos() <= 0);
	}
}
