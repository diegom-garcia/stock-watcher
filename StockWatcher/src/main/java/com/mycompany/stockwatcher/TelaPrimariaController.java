package com.mycompany.stockwatcher;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaPrimariaController {

    String idUser;

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnCarteira;

    @FXML
    private Button btnHistorico;

    void trocaTelaPesquisa(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaAcao.fxml"));
            AcaoController telaP = new AcaoController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 710, 400));

            telaP.setIdUser(id);
            stage.show();
            

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
            scene.getStylesheets().add("/com.mycompany.stockwatcher.css/Favoritoscss.css");
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
    void acaoFavoritos(ActionEvent event) {
        trocaTelaFavorito(idUser);
    }

    @FXML
    void acaoPesquisar(ActionEvent event) {
        trocaTelaPesquisa(idUser);
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
        System.out.println(this.idUser);
    }

}
