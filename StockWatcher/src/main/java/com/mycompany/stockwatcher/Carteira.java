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

    String nome;
    String tipo;
    Double preco;
    Integer qtd;
    Double preco_medio;
    Double total_pago;
    Double variação_valor;
    Double variação_porc;
    Double posição;
    Double total_atual;
    Double preco_atual;
    Double patrimanio_atual;
    Double valor_gasto;

    public Double getPatrimanio_atual() {
        return patrimanio_atual;
    }

    public void setPatrimanio_atual(Double patrimanio_atual) {
        this.patrimanio_atual = patrimanio_atual;
    }

    public Double getValor_gasto() {
        return valor_gasto;
    }

    public void setValor_gasto(Double valor_gasto) {
        this.valor_gasto = valor_gasto;
    }

    public Double getPreco_atual() {
        return preco_atual;
    }

    public void setPreco_atual(Double preco_atual) {
        this.preco_atual = preco_atual;
    }

    public Double getTotal_atual() {
        return total_atual;
    }

    public void setTotal_atual(Double total_atual) {
        this.total_atual = total_atual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getPreco_medio() {
        return preco_medio;
    }

    public void setPreco_medio(Double preco_medio) {
        this.preco_medio = preco_medio;
    }

    public Double getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(Double total_pago) {
        this.total_pago = total_pago;
    }

    public Double getVariação_valor() {
        return variação_valor;
    }

    public void setVariação_valor(Double variação_valor) {
        this.variação_valor = variação_valor;
    }

    public Double getVariação_porc() {
        return variação_porc;
    }

    public void setVariação_porc(Double variação_porc) {
        this.variação_porc = variação_porc;
    }

    public Double getPosição() {
        return posição;
    }

    public void setPosição(Double posição) {
        this.posição = posição;
    }

}
