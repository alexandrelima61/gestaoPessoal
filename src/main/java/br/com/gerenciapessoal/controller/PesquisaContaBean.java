/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.controller;

import br.com.gerenciapessoal.model.Banco;
import br.com.gerenciapessoal.repository.Contas;
import br.com.gerenciapessoal.model.Conta;
import br.com.gerenciapessoal.repository.Bancos;
import br.com.gerenciapessoal.repository.filter.ContaFilter;
import br.com.gerenciapessoal.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jalima
 */
@Named
@ViewScoped
public class PesquisaContaBean implements Serializable {

    @Inject
    private Contas contas;

    @Inject
    private Bancos bancos;

    private final ContaFilter contaFilter;
    private Conta contaSelecionada;

    private List<Conta> listaConta;

    private List<Banco> listaBanco;

    public PesquisaContaBean() {
        contaFilter = new ContaFilter();
    }

    public void inicializaBancoPes() {
        if (FacesUtil.isNotPostback()) {
            listaBanco = bancos.listaBanco();
        }
    }

    public void ecluirConta() {
        contas.remover(this.contaSelecionada);
        listaConta.remove(this.contaSelecionada);

        FacesUtil.addInfoMessage("A conta " + contaSelecionada.getAgencia() + "-"
                + contaSelecionada.getDvConta() + "-"
                + contaSelecionada.getBanco().getNome()
                + ", foi excluida com suecsso!");
    }

    public void pesquisarConta() {
        listaConta = contas.pesquisarConta(contaFilter);
    }

    public ContaFilter getContaFilter() {
        return contaFilter;
    }

    public List<Conta> getListaConta() {
        return listaConta;
    }

    public List<Banco> getListaBanco() {
        return listaBanco;
    }

    public Conta getContaSelecionada() {
        return contaSelecionada;
    }

    public void setContaSelecionada(Conta contaSelecionada) {
        this.contaSelecionada = contaSelecionada;
    }

}
