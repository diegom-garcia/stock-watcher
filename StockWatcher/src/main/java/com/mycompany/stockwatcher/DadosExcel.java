/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import java.sql.Date;

/**
 *
 * @author DIEGO
 */
public class DadosExcel {
    String tipo;
    String nome;
    Date data;
    Double preco;
    Integer qtd;
    String operacao;

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public Date getData() {
        return data;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQtd() {
        return qtd;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    
}
