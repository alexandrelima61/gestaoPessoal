/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.service;

import br.com.gerenciapessoal.model.Lancamento;
import br.com.gerenciapessoal.repository.Lancamentos;
import br.com.gerenciapessoal.util.jpa.Transactional;
import br.com.gerenciapessoal.util.service.NegocioException;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author jalima
 */
public class CadastroLancamentoService implements Serializable {

    @Inject
    private Lancamentos lancamentos;

    @Transactional
    public Lancamento salvar(Lancamento lancamento) {

        if (lancamento.getId() != null) {
            Lancamento l = lancamentos.porId(lancamento.getId());
            if (l.isBaixa()) {
                throw new NegocioException("Você não pode alterar este movimento, pois já foi dado baixa no mesmo!");
            }
        }

        return lancamentos.gardar(lancamento);
    }
}
