/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository;

import br.com.gerenciapessoal.model.Conta;
import br.com.gerenciapessoal.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author jalima
 */
public class Contas implements Serializable {

    @Inject
    private EntityManager manager;

    public Conta porId(Long id) {
        return manager.find(Conta.class, id);
    }

    public Conta gardarConta(Conta conta) {
        return manager.merge(conta);
    }

    @SuppressWarnings("JPQLValidation")
    public List<Conta> listaConta() {
        try {
            Usuario u = manager.find(Usuario.class, 1L);

            return manager.createQuery("from Conta where usuario_id = :usuario", Conta.class)
                    .setParameter("usuario", u.getId())
                    .getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }
}
