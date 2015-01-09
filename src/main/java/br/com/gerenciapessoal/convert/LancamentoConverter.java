/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.convert;

import br.com.gerenciapessoal.model.Lancamento;
import br.com.gerenciapessoal.repository.Lancamentos;
import br.com.gerenciapessoal.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jalima
 */
@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {

    //@Inject
    private final Lancamentos lancamentos;

    public LancamentoConverter() {
        lancamentos = CDIServiceLocator.getBean(Lancamentos.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Lancamentos retorno = null;

        if (value != null) {
            Long id = new Long(value);
            return lancamentos.porId(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null) {
            Lancamento lancamento = (Lancamento) obj;

            return lancamento.getId() == null ? null : lancamento.getId().toString();
        }
        return "";
    }
}
