/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.controller;

import br.com.gerenciapessoal.model.Grupo;
import br.com.gerenciapessoal.model.Usuario;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author FamilaLimaFeitoza
 */
@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

    @Inject
    private EntityManager manager;

    private Usuario usuario;

    private List<Grupo> gruposDisponiveis;

    private Grupo novoGrupo;

    public CadastroUsuarioBean() {
        limpar();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private void limpar() {
        setUsuario(new Usuario());
    }

    /**
     * @return the novoGrupo
     */
    public Grupo getNovoGrupo() {
        return novoGrupo;
    }

    /**
     * @param novoGrupo the novoGrupo to set
     */
    public void setNovoGrupo(Grupo novoGrupo) {
        this.novoGrupo = novoGrupo;
    }

    public List<Grupo> getGruposDisponiveis() {
        return gruposDisponiveis;
    }

    public void setGruposDisponiveis(List<Grupo> gruposDisponiveis) {
        this.gruposDisponiveis = gruposDisponiveis;
    }

    public void salvar() {

    }

    public void adicionarGrupo() {
        this.usuario.getGrupos().add(novoGrupo);
    }

    public boolean isEditando() {
        return this.usuario.getId() != null;
    }

    public void inicializar() {
        gruposDisponiveis = manager.createQuery("from Grupo", Grupo.class).getResultList();

    }

}
