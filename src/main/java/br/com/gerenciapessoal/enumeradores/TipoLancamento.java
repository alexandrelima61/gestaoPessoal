/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.enumeradores;

/**
 *
 * @author jalima
 */
public enum TipoLancamento {

    R("RECEITA"), D("DESPESA");

    private String tpES;

    private TipoLancamento(String tpES) {
        this.tpES = tpES;
    }

    public String getTpES() {
        return tpES;
    }
}
