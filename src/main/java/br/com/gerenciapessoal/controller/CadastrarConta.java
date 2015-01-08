/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.controller;

import br.com.gerenciapessoal.enumeradores.TipoConta;
import br.com.gerenciapessoal.model.Banco;
import br.com.gerenciapessoal.model.Conta;
import br.com.gerenciapessoal.repository.Bancos;
import br.com.gerenciapessoal.repository.Usuarios;
import br.com.gerenciapessoal.service.CadastroContaService;
import br.com.gerenciapessoal.util.jsf.FacesUtil;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class CadastrarConta implements Serializable {
    
    private Conta conta;
    @Inject
    private CadastroContaService cadastroContaService;
    
    @Inject
    private Bancos bancos;
    
    @Inject
    private Usuarios usuarios;
    
    private List<Banco> listaBancos;
    
    public CadastrarConta() {
        limpar();
    }
    
    public void inicializaBanco() {
        if (FacesUtil.isNotPostback()) {
            listaBancos = bancos.listaBanco();
        }
    }
    
    public void salvarConta() {
        conta.setUsuario(usuarios.usuario());
        
        conta = cadastroContaService.salvarConta(conta);
        
        limpar();
        FacesUtil.addInfoMessage("Conta cadastrada com sucesso!");
    }
    
    public TipoConta[] getTipoConta() {
        return TipoConta.values();
    }
    
    public Conta getConta() {
        return conta;
    }
    
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    public List<Banco> getListaBancos() {
        return listaBancos;
    }
    
    public boolean isEditandoConta() {
        return conta.getId() != null;
    }
    
    private void limpar() {
        conta = new Conta();
        if (conta.getSaldo() == null) {
            conta.setSaldo(BigDecimal.ZERO);
        }
        
    }
    
}
