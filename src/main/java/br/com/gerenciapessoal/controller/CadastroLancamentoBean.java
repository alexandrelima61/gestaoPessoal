/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.controller;

import br.com.gerenciapessoal.enumeradores.TipoLancamento;
import br.com.gerenciapessoal.model.Categoria;
import br.com.gerenciapessoal.model.Lancamento;
import br.com.gerenciapessoal.repository.Categorias;
import br.com.gerenciapessoal.repository.Usuarios;
import br.com.gerenciapessoal.service.CadastroLancamentoService;
import br.com.gerenciapessoal.util.jsf.FacesUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class CadastroLancamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Categorias categorias;

    @Inject
    private CadastroLancamentoService cadastroLancamentoService;

    private Lancamento lancamento;
    private List<Categoria> categoria;

    private boolean disabledBotao = false;

    private String tipoLancamento;

    public CadastroLancamentoBean() {
        limpar();
    }

    public void inicialiazar() {
        if (FacesUtil.isNotPostback()) {
            categoria = categorias.categoriaList();
        }
    }

    public void Salvar() {
        this.lancamento = cadastroLancamentoService.salvar(lancamento);

        limpar();
        FacesUtil.addInfoMessage("Movimento incluso com sucesso!");
    }

    private void limpar() {
        lancamento = new Lancamento();
        tipoLancamento = "";
    }

    public void receita() {
        tipoLancamento = "Receita";
        lancamento.setTipoMov(TipoLancamento.R);
    }

    public void despesa() {
        tipoLancamento = "Dispesa";
        lancamento.setTipoMov(TipoLancamento.D);
    }

    @SuppressWarnings("null")
    public void setSaldo() {
        if (((lancamento.getValorLanca() != new BigDecimal(BigInteger.ZERO) && (lancamento.getValorLanca() != null)))
                && ((lancamento.getVlTotal() != new BigDecimal(BigInteger.ZERO) && (lancamento.getVlTotal() != null)))) {
            lancamento.valorizaSaldo();
        }
    }

    public void onDateSelect() {
        if ((lancamento.getDataEmissao() != null) && (lancamento.getDataVencimento() != null)) {
            if (lancamento.getDataEmissao().after(lancamento.getDataVencimento())) {
                FacesUtil.addErrorMessage("A data de emissão, deve ser menor que a data de vencimento!");

                disabledBotao = true;
            } else {
                disabledBotao = false;
            }
        }
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public boolean isDisabledBotao() {
        return disabledBotao;
    }

    public void setDisabledBotao(boolean disabledBotao) {
        this.disabledBotao = disabledBotao;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

}
