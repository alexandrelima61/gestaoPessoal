/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciapessoal.model;

import br.com.gerenciapessoal.enumeradores.TipoConta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jalima
 */
@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    private Long id;
    private Integer agencia;
    private Integer dvAgencia;
    private Integer conta;
    private Integer dvConta;
    private TipoConta tipoConta;
    private Banco banco;
    private BigDecimal saldo;
    private Usuario usuario;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "agecia", nullable = false, length = 5)
    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    @Column(name = "digito_agencia", length = 1)
    public Integer getDvAgencia() {
        return dvAgencia;
    }

    public void setDvAgencia(Integer dvAgencia) {
        this.dvAgencia = dvAgencia;
    }

    @NotNull
    @Column(name = "conta", nullable = false, length = 7)
    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    @Column(name = "digito_conta", nullable = false, length = 1)
    public Integer getDvConta() {
        return dvConta;
    }

    public void setDvConta(Integer dvConta) {
        this.dvConta = dvConta;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_conta", nullable = false)
    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "banco_id", nullable = false)
    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Column(name = "saldo", nullable = false, precision = 10, scale = 2)
    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
