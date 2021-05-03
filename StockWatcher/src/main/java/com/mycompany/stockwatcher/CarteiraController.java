
package com.mycompany.stockwatcher;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CarteiraController {
    
    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnHistorico;
    
    String idUser;

    @FXML
    void acaoPesquisar(ActionEvent event) {
        trocaTelaPesquisar(idUser);
    }

    @FXML
    void acaoFavoritos(ActionEvent event) {
        trocaTelaFavorito(idUser);
    } 

    @FXML
    void acaoHistorico(ActionEvent event) {
        trocaTelaHistorico(idUser);
    }

    @FXML
    void acaoSobre(ActionEvent event) {
        trocaTelaSobre(idUser);
    }
    
    
    public void setIdUser(String idUser) {
        this.idUser = idUser;
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
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
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
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
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
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
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
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
