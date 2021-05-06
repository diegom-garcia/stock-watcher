package com.mycompany.stockwatcher;

import com.mycompany.stockwatcher.modelo.Modelo;
import com.mycompany.stockwatcher.modelo.ModeloDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HistoricoController {

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnCarteira;

    @FXML
    private TableView<Modelo> tabelaHistoricoAcoes;

    @FXML
    private TableView<Modelo> tabelaHistoricoFII;

    @FXML
    private TableColumn<Modelo, String> colNomeAcaoHistorico;

    @FXML
    private TableColumn<Modelo, String> colNomeFIIHistorico;

    @FXML
    private Button btnDeletarHistorico;

    private Connection connection;
    private Statement statement;
    String idUser;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void initTable() {
        colNomeAcaoHistorico.setCellValueFactory(new PropertyValueFactory("nome_ativo"));
        colNomeFIIHistorico.setCellValueFactory(new PropertyValueFactory("nome_ativo"));
        tabelaHistoricoAcoes.setEditable(false);
        tabelaHistoricoFII.setEditable(false);
        colNomeAcaoHistorico.setEditable(false);
        colNomeFIIHistorico.setEditable(false);
        tabelaHistoricoAcoes.setItems(atualizaTabelaAcaoHistorico());
        tabelaHistoricoFII.setItems(atualizaTabelaFIIHistorico());
    }

    public ObservableList<Modelo> atualizaTabelaAcaoHistorico() {
        System.out.println("favoritos controler  " + idUser);
        ModeloDAO dao = new ModeloDAO(idUser);
        return FXCollections.observableArrayList(dao.getListHistoricoAcao());
    }

    public ObservableList<Modelo> atualizaTabelaFIIHistorico() {
        System.out.println("favoritos controler  " + idUser);
        ModeloDAO dao = new ModeloDAO(idUser);
        return FXCollections.observableArrayList(dao.getListHistoricoFII());
    }

    void trocaTelaPesquisar(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPesquisar.fxml"));
            PesquisarController telaP = new  PesquisarController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));

            telaP.setIdUser(id);
            stage.show();
            stage.setResizable(false);
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
            stage.setScene(new Scene(loader.load(), 1110, 700));

            telaP.setIdUser(id);
            stage.show();
            stage.setResizable(false);
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaFavorito(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFavoritos.fxml"));
            FavoritosController telaP = new FavoritosController();
            loader.setController(telaP);
            Scene scene = new Scene(loader.load(), 1110, 700);
            scene.getStylesheets().add("Style.css");
            stage.setScene(scene);;

            telaP.setIdUser(id);
            telaP.initTable();
            stage.show();
            stage.setResizable(false);
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaSobre(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFavoritos.fxml"));
            FavoritosController telaP = new FavoritosController();
            loader.setController(telaP);
            Scene scene = new Scene(loader.load(), 1110, 700);
            scene.getStylesheets().add("Style.css");
            stage.setScene(scene);;

            telaP.setIdUser(id);
            telaP.initTable();
            stage.show();
            stage.setResizable(false);
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void acaoPesquisar(ActionEvent event) {
        trocaTelaPesquisar(idUser);
    }

    @FXML
    void acaoFavoritos(ActionEvent event) {
        trocaTelaFavorito(idUser);
    }

    @FXML
    void acaoCarteira(ActionEvent event) {
        trocaTelaCarteira(idUser);
    }

    @FXML
    void acaoSobre(ActionEvent event) {
        trocaTelaSobre(idUser);
    }

    @FXML
    void acaoDeletarHistorico(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("TODOS OS ITENS FORAM REMOVIDOS DO HISTÓRICO!");
        alert.show();
        ModeloDAO m = new ModeloDAO(idUser);
        m.deleteHistorico();
        initTable();

    }

}
