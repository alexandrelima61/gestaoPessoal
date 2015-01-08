/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.repository.filter;

import br.com.gerenciapessoal.validation.NUMBANCO;
import java.io.Serializable;

/**
 *
 * @author jalima
 */
public class BancoFilter implements Serializable {

    private String numBanco;
    private String nome;
    private String endereco;
    private String uf;
    private String estado;    

    @NUMBANCO
    public String getNumBanco() {
        return numBanco;
    }

    public void setNumBanco(String numBanco) {
        this.numBanco = numBanco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
