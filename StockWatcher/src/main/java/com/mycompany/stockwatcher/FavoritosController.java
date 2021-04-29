/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import com.mycompany.stockwatcher.modelo.ModeloDAO;
import com.mycompany.stockwatcher.modelo.Modelo;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author User
 */
public class FavoritosController {

    @FXML
    private TableView<Modelo> tabelaAcoes;
    @FXML
    private TableView<Modelo> tabelaFundos;
    @FXML
    private TableColumn<Modelo, String> colAtivoAcoes;
    @FXML
    private TableColumn<Modelo, String> colAtivoFundos;

    private Connection connection;
    private Statement statement;
    String idUser;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
        System.out.println("setid do favorito " + idUser);
    }

    private void popularTabela() {
        tabelaAcoes.setEditable(true);

    }

//    public ObservableList<String> atualizaTabela(){
//        
//        
//        
//    }

    
   public void initTable(){
       colAtivoAcoes.setCellValueFactory(new PropertyValueFactory("nome_ativo"));
       colAtivoFundos.setCellValueFactory(new PropertyValueFactory("nome_ativo"));
       tabelaAcoes.setItems(atualizaTabelaAcoes());
       tabelaFundos.setItems(atualizaTabelaFundos());
   }
   
   public ObservableList <Modelo> atualizaTabelaAcoes(){
       System.out.println("favoritos controler  " + idUser);
       ModeloDAO dao = new ModeloDAO(idUser);
       return FXCollections.observableArrayList(dao.getListAcoes());
   }
    public ObservableList <Modelo> atualizaTabelaFundos(){
       ModeloDAO dao = new ModeloDAO(idUser);
       return FXCollections.observableArrayList(dao.getListFundo());
   }
   
    private void abrirConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", "root", "123");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("oie");

        }
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        initTable();
//        
//    }
}
