/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository.filter;

import br.com.gerenciapessoal.enumeradores.TipoConta;
import br.com.gerenciapessoal.model.Banco;
import br.com.gerenciapessoal.model.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author jalima
 */
public class ContaFilter implements Serializable {

    private Integer agc;
    private Integer dvagc;
    private Integer conta;
    private Integer dvconta;
    private TipoConta tipoConta;
    private Banco banco;

    public Integer getAgc() {
        return agc;
    }

    public void setAgc(Integer agc) {
        this.agc = agc;
    }

    public Integer getDvagc() {
        return dvagc;
    }

    public void setDvagc(Integer dvagc) {
        this.dvagc = dvagc;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getDvconta() {
        return dvconta;
    }

    public void setDvconta(Integer dvconta) {
        this.dvconta = dvconta;
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
