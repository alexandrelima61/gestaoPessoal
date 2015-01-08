/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository;

import br.com.gerenciapessoal.model.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author jalima
 */
public class Categorias implements Serializable {

    @Inject
    private EntityManager manager;

    @SuppressWarnings("JPQLValidation")
    public List<Categoria> categoriaList() {
        return manager.createQuery("from Categoria", Categoria.class)
                .getResultList();
    }

    public Categoria porId(Long id) {
        return manager.find(Categoria.class,id);
    }
}
