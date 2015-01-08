/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.controller;

import br.com.gerenciapessoal.model.Banco;
import br.com.gerenciapessoal.repository.Bancos;
import br.com.gerenciapessoal.repository.filter.BancoFilter;
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
@Named(value = "pesquisarBancos")
@ViewScoped
public class PesquisarBancos implements Serializable {

    @Inject
    private Bancos bancos;

    private BancoFilter filter;
    private List<Banco> bancoFiltrado;

    private Banco bancoSelecionado;

    public PesquisarBancos() {
        filter = new BancoFilter();
    }

    public void pesquisar() {
        bancoFiltrado = bancos.filtrados(filter);
    }

    public void excluir() {
        bancos.remover(bancoSelecionado);
        bancoFiltrado.remove(this.bancoSelecionado);

        FacesUtil.addInfoMessage("Banco " + bancoSelecionado.getNome()
                + " excluido com suecsso");

    }

    public List<Banco> getBancoFiltrado() {
        return bancoFiltrado;
    }

    public BancoFilter getFilter() {
        return filter;
    }

    public Banco getBancoSelecionado() {
        return bancoSelecionado;
    }

    public void setBancoSelecionado(Banco bancoSelecionado) {
        this.bancoSelecionado = bancoSelecionado;
    }

}
