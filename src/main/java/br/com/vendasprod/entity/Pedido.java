package br.com.vendasprod.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@OneToMany(mappedBy = "pedido")
	private List<QtdProduto> qtdProdutos;
	
	@ManyToOne
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((qtdProdutos == null) ? 0 : qtdProdutos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (qtdProdutos == null) {
			if (other.qtdProdutos != null)
				return false;
		} else if (!qtdProdutos.equals(other.qtdProdutos))
			return false;
		return true;
	}

	
}
