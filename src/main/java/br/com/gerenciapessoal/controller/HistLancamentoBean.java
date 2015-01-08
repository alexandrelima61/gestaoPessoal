/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.controller;

import br.com.gerenciapessoal.model.Lancamento;
import br.com.gerenciapessoal.repository.filter.LancamentoFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author jalima
 */
@Named
@ViewScoped
public class HistLancamentoBean implements Serializable {

    private LancamentoFilter lancementoFilter;

    private Lancamento lancamentoSelecionado;
    private List<Lancamento> lancamentosFiltrados;

    public HistLancamentoBean() {
        lancementoFilter = new LancamentoFilter();
        lancamentosFiltrados = new ArrayList<>();
    }

    public Lancamento getLancamentoSelecionado() {
        return lancamentoSelecionado;
    }

    public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
        this.lancamentoSelecionado = lancamentoSelecionado;
    }

    public LancamentoFilter getLancementoFilter() {
        return lancementoFilter;
    }

    public List<Lancamento> getLancamentosFiltrados() {
        return lancamentosFiltrados;
    }

    public void setLancamentosFiltrados(List<Lancamento> lancamentosFiltrados) {
        this.lancamentosFiltrados = lancamentosFiltrados;
    }

}
