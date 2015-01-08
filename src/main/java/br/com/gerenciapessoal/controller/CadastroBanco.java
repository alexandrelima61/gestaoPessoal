/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.controller;

import br.com.gerenciapessoal.model.Banco;
import br.com.gerenciapessoal.service.CadastroBancoService;
import br.com.gerenciapessoal.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jalima
 */
@Named
@ViewScoped
public class CadastroBanco implements Serializable {

    @Inject
    private CadastroBancoService cadastroBancoService;

    private Banco banco;

    public CadastroBanco() {
        limpar();
    }

    public void salvarBanco() {
        this.banco = cadastroBancoService.salvar(this.banco);

        limpar();
        FacesUtil.addInfoMessage("Cadastro realizado com sucesso!");
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    private void limpar() {
        banco = new Banco();
    }

    public boolean isEditando() {
        return this.banco.getId() != null;
    }

}
