/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository.filter;

import br.com.gerenciapessoal.model.Conta;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jalima
 */
public class LancamentoFilter implements Serializable {

    private Conta conta;
    private Date emissao;
    private Integer dia;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

}
