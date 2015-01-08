/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.convert;

import br.com.gerenciapessoal.model.Categoria;
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
@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

    //@Inject
    private final Categorias categorias;

    public CategoriaConverter() {
        categorias = CDIServiceLocator.getBean(Categorias.class);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Categoria retorno = null;

        if (value != null) {
            Long id = new Long(value);
            return categorias.porId(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj != null) {
            return ((Categoria) obj).getId().toString();
        }
        return "";
    }
}
