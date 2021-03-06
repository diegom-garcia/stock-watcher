/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import com.mycompany.stockwatcher.modelo.Modelo;
import com.mycompany.stockwatcher.modelo.ModeloDAO;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author User
 */
public class AcaoController {

    private boolean fav;
    @FXML
    private ImageView imgFavoritado;

    @FXML
    private Label lblSegAtuacao;

    @FXML
    private Label lblValorizacao;

    @FXML
    private Label lblPatLiquido;

    @FXML
    private Label lblMinSemanas;

    @FXML
    private Label lblFreeFloat;

    @FXML
    private Label lblDataCom;

    @FXML
    private Label lblROA;

    @FXML
    private Label lblMaxSemanas;

    @FXML
    private Label lblROE;

    @FXML
    private Label lblDividaL;

    @FXML
    private Label lblPL;

    @FXML
    private Label lblTipo6;

    @FXML
    private Label lblMBruta;

    @FXML
    private Label lblTipo4;

    @FXML
    private Label lblTipo5;

    @FXML
    private Label lblTipo2;

    @FXML
    private Label lblPagamento;

    @FXML
    private Label lblTipo3;

    @FXML
    private Label lblDataCom6;

    @FXML
    private Label lblPagamento5;

    @FXML
    private Label lblTagAlong;

    @FXML
    private Label lblDataCom5;

    @FXML
    private Label lblPagamento4;

    @FXML
    private Label lblPagamento6;

    @FXML
    private Label lblDataCom2;

    @FXML
    private Label lblDataCom4;

    @FXML
    private Label lblPagamento3;

    @FXML
    private Label lblDataCom3;

    @FXML
    private Label lblPagamento2;

    @FXML
    private Label lblValorMercado;

    @FXML
    private Label lblDividaB;

    @FXML
    private Label lblLiqDiaria;

    @FXML
    private Label lblMLiquida;

    @FXML
    private Label lblDivPL;

    @FXML
    private Label lblVPA;

    @FXML
    private Label lblValor6;

    @FXML
    private Label lblPVP;

    @FXML
    private Label lblDivUltimos;

    @FXML
    private Label lblValor;

    @FXML
    private Label lblValor3;

    @FXML
    private Label lblROIC;

    @FXML
    private Label lblValor2;

    @FXML
    private Label lblValor5;

    @FXML
    private Label lblDivYield;

    @FXML
    private Label lblValor4;

    @FXML
    private Label lblValorAtual;

    @FXML
    private Label lblTipo;
    @FXML
    private Label lblTipo1;
    @FXML
    private Button btnFavorito;
    String idUser;
    String acao;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void acaoFavoritado(ActionEvent event) {
        fav = !fav;
        imgFavoritado.setVisible(fav);
        if (fav) {
            addFav();
        } else {
            deletarFav();
        }
    }

    private void initFav() {
        fav = testaFav();
        imgFavoritado.setVisible(fav);
    }

    public void initLabel(String stock) {
        acao = stock;
        StockGrabber html = new StockGrabber();
        String[] values = html.grabStock(stock);
        lblValorAtual.setText("R$" + values[0]);
        lblMinSemanas.setText("R$" + values[1]);
        lblValorizacao.setText(values[4] + "%");
        lblMaxSemanas.setText("R$" + values[2]);
        lblDivYield.setText(values[3] + "%");
        lblTipo.setText(values[5]);
        lblTagAlong.setText(values[6] + "%");
        lblLiqDiaria.setText("R$" + values[7]);
        lblDivUltimos.setText("R$" + values[24]);
        lblMBruta.setText(values[13] + "%");
        lblMLiquida.setText(values[14] + "%");
        lblPL.setText(values[8]);
        lblPVP.setText(values[9]);
        lblVPA.setText(values[10]);
        lblDivPL.setText(values[11]);
        lblROIC.setText(values[17] + "%");
        lblROA.setText(values[16] + "%");
        lblROE.setText(values[15] + "%");
        lblPatLiquido.setText("R$" + values[18]);
        lblDividaB.setText("R$" + values[19]);
        lblDividaL.setText("R$" + values[20]);
        lblSegAtuacao.setText(values[23]);
        lblValorMercado.setText("R$" + values[21]);
        lblFreeFloat.setText(values[22] + "%");
        lblTipo1.setText(values[25]);
        lblDataCom.setText(values[26]);
        lblPagamento.setText(values[27]);
        lblValor.setText(values[28]);
        lblTipo2.setText(values[29]);
        lblDataCom2.setText(values[30]);
        lblPagamento2.setText(values[31]);
        lblValor2.setText(values[32]);
        lblTipo3.setText(values[33]);
        lblDataCom3.setText(values[34]);
        lblPagamento3.setText(values[35]);
        lblValor3.setText(values[36]);
        lblTipo4.setText(values[37]);
        lblDataCom4.setText(values[38]);
        lblPagamento4.setText(values[39]);
        lblValor4.setText(values[40]);
        lblTipo5.setText(values[41]);
        lblDataCom5.setText(values[42]);
        lblPagamento5.setText(values[43]);
        lblValor5.setText(values[44]);
        lblTipo6.setText(values[45]);
        lblDataCom6.setText(values[46]);
        lblPagamento6.setText(values[47]);
        lblValor6.setText(values[48]);
        initFav();
    }

    public boolean testaFav() {
        ModeloDAO modelo = new ModeloDAO(idUser);
        List<Modelo> lista = modelo.getListAcoes();
        boolean bo = false;

        for (int x = 0; x < lista.size(); x++) {
            if (lista.get(x).getNome_ativo().equals(acao)) {
                bo = true;
            }
        }
        return bo;
    }

    public void addFav() {

        ModeloDAO modelo = new ModeloDAO(idUser);
        Modelo modelao = new Modelo();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        try {
            modelao.setId_usuario(Integer.parseInt(idUser));
            modelao.setNome_ativo(acao);
            modelao.setTipo_ativo("A");
            modelo.addFav(modelao);
        } catch (Exception ex) {
            alert.setContentText("N??o foi poss??vel adicionar este item a tabela Favorito");
            alert.show();
        }
    }

    public void deletarFav() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        ModeloDAO modelo = new ModeloDAO(idUser);
        try {
            modelo.deleteFav(acao);
        } catch (Exception ex) {
            alert.setContentText("N??o foi poss??vel remover este item");
            alert.show();

        }

    }

}
