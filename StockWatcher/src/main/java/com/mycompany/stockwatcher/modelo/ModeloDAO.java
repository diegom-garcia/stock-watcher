/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher.modelo;

import com.mycompany.stockwatcher.LoginController;
import com.mycompany.stockwatcher.modelo.Modelo;
import conexao.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class ModeloDAO {

   
   

    private Connection connection;
    private Statement statement;
    private String idUsuario;

    public ModeloDAO(String id) {
        this.idUsuario = id;
        this.connection = new DBConnection().getConnection();
        System.out.println(id);
    }

//    public void abrirConexao() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", "root", "123");
//            statement = connection.createStatement();
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println("oie");
//
//        }
//    }
    public boolean add(Modelo m) {
        try {
            String sql = "INSERT INTO favorito(nome_ativo,tipo_ativo,id_usuario,id_favorito) values (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, m.getNome_ativo());
            stmt.setString(2, m.getTipo_ativo());
            stmt.setInt(3, m.getId_usuario());
            stmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("deu erro no modelo dao na funcao add");
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    public void trazId() {
//        PreparedStatement stmt;
//        int test = 0;
//        try {
//            stmt = connection.prepareStatement("SELECT id_usuario from usuario where login = '"+txtUsername.getText()+"'");
//            ResultSet result = stmt.executeQuery();
//            while (result.next()) {
//                test = result.getInt("id_usuario");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //return test;
//    }

    public List<Modelo> getListAcoes() {
        List<Modelo> modelo = new ArrayList<>();
        String sql = "select nome_ativo from favorito where tipo_ativo = 'A' and id_usuario = " + idUsuario;
        System.out.println(idUsuario);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Modelo m = new Modelo();
                m.setNome_ativo(result.getString("nome_ativo"));
                modelo.add(m);

            }
            stmt.close();
            result.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro no modeloDAO na funcao getList");
            return null;
        }
        return modelo;
    }

    public List<Modelo> getListFundo() {
        List<Modelo> modelo = new ArrayList<>();
        String sql = "select nome_ativo from favorito where tipo_ativo = 'F' and id_usuario = " + idUsuario;
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Modelo m = new Modelo();
                m.setNome_ativo(result.getString("nome_ativo"));
                modelo.add(m);

            }
            stmt.close();
            result.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro no modeloDAO na funcao getList");
            return null;
        }
        return modelo;
    }

}
