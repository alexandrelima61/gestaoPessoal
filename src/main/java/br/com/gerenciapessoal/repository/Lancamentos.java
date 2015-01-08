/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository;

import br.com.gerenciapessoal.model.Lancamento;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author jalima
 */
public class Lancamentos implements Serializable {

    @Inject
    private EntityManager manager;

    public Lancamento gardar(Lancamento lancamento) {
        return manager.merge(lancamento);
    }
}
