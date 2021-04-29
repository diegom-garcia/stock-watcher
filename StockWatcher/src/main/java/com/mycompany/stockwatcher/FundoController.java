/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
    String idUser;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
    public void initLabel() {
        lblValorAtual.setText("1");
        lblMinSemanas.setText("1");
        lblValorizacao.setText("1");
        lblMaxSemanas.setText("1");
        lblDivYield.setText("1");
        lblDivUltimos.setText("1");
        lblDataPag.setText("1");
        lblDataBase.setText("1");
        lblCotBase.setText("1");
        lblUltDiv.setText("1");
        lblRendimento.setText("1");
        lblCnpj.setText("1");
        lblDuracao.setText("1");
        lblInicioFundo.setText("1");
        lblCotistas.setText("1");
       lblProxDiv.setText("1");
        lblMediaDiv.setText("1");
        lblDvCagr.setText("1");
        lblCaixa.setText("1");
        lblVpC.setText("1");
        lblPVP.setText("1");
        lblTaxaAdm.setText("1");
        lblLiqMedia.setText("1");
       lblSegmento.setText("1");
        lblTipo.setText("1");
        lblDataCom.setText("1");
        lblPagamento.setText("1");
        lblValor.setText("1");
        lblTipo2.setText("1");
        lblDataCom2.setText("1");
        lblPagamento2.setText("1");
        lblValor2.setText("1");
        lblTipo3.setText("1");
        lblDataCom3.setText("1");
        lblPagamento3.setText("1");
        lblValor3.setText("1");
        lblTipo4.setText("1");
        lblDataCom4.setText("1");
        lblPagamento4.setText("1");
        lblValor4.setText("1");
        lblTipo5.setText("1");
        lblDataCom5.setText("1");
        lblPagamento5.setText("1");
        lblValor5.setText("1");
        lblTipo6.setText("1");
        lblDataCom6.setText("1");
        lblPagamento6.setText("1");
        lblValor6.setText("1");

    }
}
