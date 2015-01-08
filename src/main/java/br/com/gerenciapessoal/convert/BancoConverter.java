/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.convert;

import br.com.gerenciapessoal.model.Banco;
import br.com.gerenciapessoal.model.Categoria;
import br.com.gerenciapessoal.repository.Bancos;
import br.com.gerenciapessoal.repository.Categorias;
import br.com.gerenciapessoal.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jalima
 */
@FacesConverter(forClass = Banco.class)
public class BancoConverter implements Converter {

    //@Inject
    private final Bancos bancos;

    public BancoConverter() {
        bancos = CDIServiceLocator.getBean(Bancos.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Banco retorno = null;

        if (value != null) {
            Long id = new Long(value);
            return bancos.porId(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null) {
            Banco banco = (Banco) obj;

            return banco.getId() == null ? null : banco.getId().toString();
        }
        return "";
    }
}
