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
public class Carteira {
    String tipo;
    String nome;
    Date data;
    Double preco;
    Double qtd;
    String operacao;
    Double preco_atual;

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

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    
}
