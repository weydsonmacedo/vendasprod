package br.com.vendasprod.entity;



import java.io.Serializable;

/**
 * Estipula um contrato base para as entidades persistentes da aplicacao.
 * @author Macedo
 */
public interface AbstractEntity extends Serializable {

	/**
	 * @return A referencia para a chave primaria (Primary Key) de cada objeto persistido.
	 * 	
	 */
	public Number getId();
	
}
