package br.com.vendasprod.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *  Classe que representa os pedidos
 * @author Macedo
 *
 */
@Entity
@Table(name="pedido")
public class Pedido implements AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8535485870828844815L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<QtdProduto> qtdProdutos;
	
	private Cliente cliente;
	
	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<QtdProduto> getQtdProdutos() {
		return qtdProdutos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setQtdProdutos(List<QtdProduto> qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

}
