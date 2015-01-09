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
    private Date emissaode;
    private Date emissaoate;
    private Integer dia;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Date getEmissaode() {
        return emissaode;
    }

    public void setEmissaode(Date emissaode) {
        this.emissaode = emissaode;
    }

    public Date getEmissaoate() {
        return emissaoate;
    }

    public void setEmissaoate(Date emissaoate) {
        this.emissaoate = emissaoate;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

}
