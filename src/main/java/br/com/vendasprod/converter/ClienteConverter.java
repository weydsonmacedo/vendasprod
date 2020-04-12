package br.com.vendasprod.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendasprod.base.GenericMensage;
import br.com.vendasprod.entity.Cliente;
import br.com.vendasprod.service.ClienteService;

@Named
@FacesConverter(value = "clienteConverter", managed = true)
public class ClienteConverter extends GenericMensage implements Converter<Object>{

	@Inject 
	private ClienteService clienteService;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return clienteService.find(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, getMessageFromI18N("msg.erro.converter"), getMessageFromI18N("msg.erro.converter.cliente")));
            }
        }
        else {
            return null;
        }
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Cliente) object).getId());
        }
        else {
            return null;
        }
    }   
}
