package com.mycompany.stockwatcher;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SobreController {

    String idUser;

    @FXML
    private Button btnSelo;

    @FXML
    private Button btnComentarios;

    @FXML
    private Button btnMembros;

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnCarteira;

    @FXML
    private Button btnHistorico;

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
            stage.setResizable(false);
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
            telaP.initTable();
            telaP.setIdUser(id);
            stage.show();
            stage.setResizable(false);
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
            stage.setResizable(false);
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
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
            stage.setResizable(false);
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void trocaTelaMembros() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaMembros.fxml"));
            MembrosController telaP = new MembrosController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 633, 401));
            stage.show();
            stage.setResizable(false);
//            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
//            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void trocaTelaComentarios() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaComentarios.fxml"));
            ComentariosController telaP = new ComentariosController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 800, 505));
            stage.show();
            stage.setResizable(false);
//            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
//            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void trocaTelaSelo() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaSelo.fxml"));
            SeloController telaP = new SeloController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 710, 450));
            stage.show();
            stage.setResizable(false);
//            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
//            stage2.close();

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
    void acaoHistorico(ActionEvent event) {
        trocaTelaHistorico(idUser);
    }

    @FXML
    void acaoCarteira(ActionEvent event) {
        trocaTelaCarteira(idUser);
    }

    @FXML
    void acaoMembros(ActionEvent event) {
        trocaTelaMembros();
    }

    @FXML
    void acaoComentarios(ActionEvent event) {
        trocaTelaComentarios();
    }

    @FXML
    void acaoSelo(ActionEvent event) {
        trocaTelaSelo();
    }

}
