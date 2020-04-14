package br.com.vendasprod.base;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.inject.Named;

/**
 * classe genérica de mensagens
 * @author Macedo
 *
 */

@Named
public class GenericMensage implements Serializable{

	/**
	 * @param key
	 * @return Recupera a mensagem do arquivo properties ResourceBundle.
	 */
	protected String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	
	/**
	 * Adiciona uma mensagem no contexto do Faces.
	 * @param summary
	 * @param detail
	 */
	protected void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, detail));
	}
	
	protected void addMessage(String summary) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}
}
