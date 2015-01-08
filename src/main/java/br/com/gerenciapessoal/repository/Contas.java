/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository;

import br.com.gerenciapessoal.model.Conta;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author jalima
 */
public class Contas implements Serializable {
    
    @Inject
    private EntityManager manager;
    
    public Conta porId(Long id){
        return manager.find(Conta.class, id);
    }

    public Conta gardarConta(Conta conta) {
        return manager.merge(conta);
    }
}
