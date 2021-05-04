package com.mycompany.stockwatcher;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PesquisarController {

    String idUser;
    @FXML
    private TextField txtPesquisa;

    @FXML
    private Button btnPesquisarAcao;

    @FXML
    private Button btnPesquisarFII;

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnCarteira;

    @FXML
    private Button btnHistorico;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    void trocaTelaHistorico(String id) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPesquisar.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPesquisar.fxml"));
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
            stage.setScene(scene);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaSobre.fxml"));
            SobreController telaP = new SobreController();
            loader.setController(telaP);
            Scene scene = new Scene(loader.load(), 1110, 700);
            stage.setScene(scene);
            telaP.setIdUser(id);
            //telaP.initTable();
            stage.show();
            Stage stage2 = (Stage) btnCarteira.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void acaoPesquisarFII(ActionEvent event) {
        try {
            if (txtPesquisa.getText().equals("")) {
                Document checkFii = Jsoup.connect("https://statusinvest.com.br/fundos-imobiliarios/" + txtPesquisa.getText()).get();
                if (checkFii.title().equals("OPS. . .Não encontramos o que você está procurando - Status Invest") == false) {
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFundo.fxml"));
                    FundoController telaP = new FundoController();
                    loader.setController(telaP);
                    Scene scene = new Scene(loader.load(), 1110, 700);
                    stage.setScene(scene);
                    telaP.initLabel(txtPesquisa.getText());
                    telaP.setIdUser(idUser);
                    stage.show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void acaoPesquisarAcao(ActionEvent event) {
        try {
            if (txtPesquisa.getText().equals("")) {
                Document checkStock = Jsoup.connect("https://statusinvest.com.br/acoes/" + txtPesquisa.getText()).get();
                if (checkStock.title().equals("OPS. . .Não encontramos o que você está procurando - Status Invest") == false) {
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaAcao.fxml"));
                    AcaoController telaP = new AcaoController();
                    loader.setController(telaP);
                    Scene scene = new Scene(loader.load(), 1110, 700);
                    stage.setScene(scene);
                    telaP.initLabel(txtPesquisa.getText());
                    telaP.setIdUser(idUser);
                    stage.show();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @FXML
    void acaoFavorito(ActionEvent event) {
        trocaTelaFavorito(idUser);
    }

}
