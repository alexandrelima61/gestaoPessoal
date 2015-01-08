/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.service;

import br.com.gerenciapessoal.model.Conta;
import br.com.gerenciapessoal.repository.Contas;
import br.com.gerenciapessoal.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author FamilaLimaFeitoza
 */
public class CadastroContaService implements Serializable {

    @Inject
    private Contas contas;

    @Transactional
    public Conta salvarConta(Conta conta) {
        return contas.gardarConta(conta);
    }

}
