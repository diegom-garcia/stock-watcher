package com.mycompany.stockwatcher;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    String idUser;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    void trocaTelaPesquisar(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPesquisar.fxml"));
            AcaoController telaP = new AcaoController();
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
            stage.setScene(new Scene(loader.load(), 1110, 700));

            telaP.setIdUser(id);
            stage.show();
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

}
