/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author User
 */
public class FundoController {

    @FXML
    private Label lblValorizacao;

    @FXML
    private Label lblMediaDiv;

    @FXML
    private Label lblMinSemanas;

    @FXML
    private Label lblDvCagr;

    @FXML
    private Label lblDataCom;

    @FXML
    private Label lblUltDiv;

    @FXML
    private Label lblMaxSemanas;

    @FXML
    private Label lblInicioFundo;

    @FXML
    private Label lblRendimento;

    @FXML
    private Label lblVpC;

    @FXML
    private Label lblTipo6;

    @FXML
    private Label lblDuracao;

    @FXML
    private Label lblCaixa;

    @FXML
    private Label lblTipo4;

    @FXML
    private Label lblTipo5;

    @FXML
    private Label lblCnpj;

    @FXML
    private Label lblPagamento;

    @FXML
    private Label lblTipo2;

    @FXML
    private Label lblTipo3;

    @FXML
    private Label lblDataCom6;

    @FXML
    private Label lblPagamento5;

    @FXML
    private Label lblTaxaAdm;

    @FXML
    private Label lblDataCom5;

    @FXML
    private Label lblPagamento4;

    @FXML
    private Label lblPagamento6;

    @FXML
    private Label lblDataPag;

    @FXML
    private Label lblDataCom2;

    @FXML
    private Label lblDataBase;

    @FXML
    private Label lblPagamento3;

    @FXML
    private Label lblDataCom3;

    @FXML
    private Label lblPagamento2;

    @FXML
    private Label lblCotistas;

    @FXML
    private Label lblProxDiv;

    @FXML
    private Label lblDataCom4;

    @FXML
    private Label lblSegmento;

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
    private Label lblCotBase;

    @FXML
    private Label lblValor2;

    @FXML
    private Label lblLiqMedia;

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
    private ImageView imgFavoritado;
    String idUser;
    private boolean fav;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    void acaoFavoritado(ActionEvent event) {
        fav = !fav;
        imgFavoritado.setVisible(fav);
        if (fav) {
            //insert
        } else {
            //delete
        }
    }

    private void initFav() {
        fav = false;
        // fav = select
    }

    public void initLabel(String fundo) {
        FiiGrabber html = new FiiGrabber();
        String[] values = html.grabFund(fundo);
        lblValorAtual.setText(values[0]);
        lblMinSemanas.setText(values[1]);
        lblValorizacao.setText(values[4]);
        lblMaxSemanas.setText(values[2]);
        lblDivYield.setText(values[3]);
        lblDivUltimos.setText(values[18]);
        lblDataPag.setText(values[24]);
        lblDataBase.setText(values[23]);
        lblCotBase.setText(values[22]);
        lblUltDiv.setText(values[19]);
        lblRendimento.setText(values[21]);
        lblCnpj.setText(values[14]);
        lblDuracao.setText(values[16]);
        lblInicioFundo.setText(values[15]);
        lblCotistas.setText(values[9]);
        lblProxDiv.setText(values[20]);
        lblMediaDiv.setText(values[10]);
        lblDvCagr.setText(values[8]);
        lblCaixa.setText(values[7]);
        lblVpC.setText(values[5]);
        lblPVP.setText(values[6]);
        lblTaxaAdm.setText(values[11]);
        lblLiqMedia.setText(values[12]);
        lblSegmento.setText(values[17]);
        lblTipo.setText(values[29]);
        lblDataCom.setText(values[30]);
        lblPagamento.setText(values[31]);
        lblValor.setText(values[32]);
        lblTipo2.setText(values[33]);
        lblDataCom2.setText(values[34]);
        lblPagamento2.setText(values[35]);
        lblValor2.setText(values[36]);
        lblTipo3.setText(values[37]);
        lblDataCom3.setText(values[38]);
        lblPagamento3.setText(values[39]);
        lblValor3.setText(values[40]);
        lblTipo4.setText(values[41]);
        lblDataCom4.setText(values[42]);
        lblPagamento4.setText(values[43]);
        lblValor4.setText(values[44]);
        lblTipo5.setText(values[45]);
        lblDataCom5.setText(values[46]);
        lblPagamento5.setText(values[47]);
        lblValor5.setText(values[48]);
        lblTipo6.setText(values[49]);
        lblDataCom6.setText(values[50]);
        lblPagamento6.setText(values[51]);
        lblValor6.setText(values[52]);
        initFav();
    }
}
