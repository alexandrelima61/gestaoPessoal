/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository.filter;

import br.com.gerenciapessoal.enumeradores.TipoConta;
import br.com.gerenciapessoal.model.Banco;
import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author jalima
 */
public class ContaFilter implements Serializable {

    private Integer agencia;
    private Integer dvAgencia;
    private Integer conta;
    private Integer dvConta;
    private TipoConta tipoConta;
    private Banco banco;

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getDvAgencia() {
        return dvAgencia;
    }

    public void setDvAgencia(Integer dvAgencia) {
        this.dvAgencia = dvAgencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getDvConta() {
        return dvConta;
    }

    public void setDvConta(Integer dvConta) {
        this.dvConta = dvConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    @Enumerated(EnumType.STRING)
    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

}
