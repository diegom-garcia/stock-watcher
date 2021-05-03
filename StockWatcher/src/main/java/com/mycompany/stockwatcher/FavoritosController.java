/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import com.mycompany.stockwatcher.modelo.ModeloDAO;
import com.mycompany.stockwatcher.modelo.Modelo;
import java.io.IOException;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    
    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnSobre;
    
    @FXML
    private Button btnCarteira;

    @FXML
    private Button btnHistorico;

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
    @FXML
    void acaoPesquisar(ActionEvent event) {
        trocaTelaPesquisar(idUser);
    }

    @FXML
    void acaoHistorico(ActionEvent event) {
        trocaTelaHistorico(idUser);
    }

    @FXML
    void acaoCarteira(ActionEvent event) {
        trocaTelaCarteira(idUser);
    }

    @FXML
    void acaoSobre(ActionEvent event) {
        trocaTelaSobre(idUser);
    }
    void trocaTelaPesquisar(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPesquisar.fxml"));
            PesquisarController telaP = new PesquisarController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));
            telaP.setIdUser(id);
            stage.show();
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaHistorico(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaHistorico.fxml"));
            HistoricoController telaP = new HistoricoController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));
            telaP.setIdUser(id);
            stage.show();
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaCarteira(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCarteira.fxml"));
            CarteiraController telaP = new CarteiraController();
            loader.setController(telaP);
            Scene scene = new Scene(loader.load(), 1110, 700);
            scene.getStylesheets().add("Style.css");
            stage.setScene(scene);;
            telaP.setIdUser(id);
            //telaP.initTable();
            stage.show();
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaSobre(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaSobre.fxml"));
            SobreController telaP = new SobreController();
            loader.setController(telaP);
            Scene scene = new Scene(loader.load(), 1110, 700);
            scene.getStylesheets().add("Style.css");
            stage.setScene(scene);;
            telaP.setIdUser(id);
           // telaP.initTable();
            stage.show();
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
