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
public enum TipoConta {

    POUPANCA("Poupança"),
    CORRENTE("Corrente");

    private final String descricao;

    private TipoConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescicao() {
        return this.descricao;
    }
}
