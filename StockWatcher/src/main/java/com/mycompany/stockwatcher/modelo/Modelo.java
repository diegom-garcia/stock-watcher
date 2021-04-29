/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher.modelo;

/**
 *
 * @author User
 */
public class Modelo {
    private String nome_ativo;
    private String tipo_ativo;
    private int id_usuario;
    private int id_favorito;

    public Modelo(String nome_ativo, String tipo_ativo, int id_usuario, int id_favorito) {
        this.nome_ativo = nome_ativo;
        this.tipo_ativo = tipo_ativo;
        this.id_usuario = id_usuario;
        this.id_favorito = id_favorito;
    }

    public Modelo(String nome_ativo, String tipo_ativo) {
        this.nome_ativo = nome_ativo;
        this.tipo_ativo = tipo_ativo;
    }

    public Modelo() {
    }

    
    
    
    public String getNome_ativo() {
        return nome_ativo;
    }

    public void setNome_ativo(String nome_ativo) {
        this.nome_ativo = nome_ativo;
    }

    public String getTipo_ativo() {
        return tipo_ativo;
    }

    public void setTipo_ativo(String tipo_ativo) {
        this.tipo_ativo = tipo_ativo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }
    
}
