/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.convert;

import br.com.gerenciapessoal.model.Conta;
import br.com.gerenciapessoal.repository.Contas;
import br.com.gerenciapessoal.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jalima
 */
@FacesConverter(forClass = Conta.class)
public class ContaConverter implements Converter {

    //@Inject
    private final Contas contas;

    public ContaConverter() {
        contas = CDIServiceLocator.getBean(Contas.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Conta retorno = null;

        if (value != null) {
            Long id = new Long(value);
            return contas.porId(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null) {
            Conta conta = (Conta) obj;

            return conta.getId() == null ? null : conta.getId().toString();
        }
        return "";
    }
}
