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
        FiiGrabber html = new FiiGrabber();
        String[] values = html.grabFund("xpcm11");
        lblValorAtual.setText(values[0]);
        lblMinSemanas.setText(values[0]);
        lblValorizacao.setText(values[0]);
        lblMaxSemanas.setText(values[0]);
        lblDivYield.setText(values[0]);
        lblDivUltimos.setText(values[0]);
        lblDataPag.setText(values[0]);
        lblDataBase.setText(values[0]);
        lblCotBase.setText(values[0]);
        lblUltDiv.setText(values[0]);
        lblRendimento.setText(values[0]);
        lblCnpj.setText(values[0]);
        lblDuracao.setText(values[0]);
        lblInicioFundo.setText(values[0]);
        lblCotistas.setText(values[0]);
        lblProxDiv.setText(values[0]);
        lblMediaDiv.setText(values[0]);
        lblDvCagr.setText(values[0]);
        lblCaixa.setText(values[0]);
        lblVpC.setText(values[0]);
        lblPVP.setText(values[0]);
        lblTaxaAdm.setText(values[0]);
        lblLiqMedia.setText(values[0]);
        lblSegmento.setText(values[0]);
        lblTipo.setText(values[0]);
        lblDataCom.setText(values[0]);
        lblPagamento.setText(values[0]);
        lblValor.setText(values[0]);
        lblTipo2.setText(values[0]);
        lblDataCom2.setText(values[0]);
        lblPagamento2.setText(values[0]);
        lblValor2.setText(values[0]);
        lblTipo3.setText(values[0]);
        lblDataCom3.setText(values[0]);
        lblPagamento3.setText(values[0]);
        lblValor3.setText(values[0]);
        lblTipo4.setText(values[0]);
        lblDataCom4.setText(values[0]);
        lblPagamento4.setText(values[0]);
        lblValor4.setText(values[0]);
        lblTipo5.setText(values[0]);
        lblDataCom5.setText(values[0]);
        lblPagamento5.setText(values[0]);
        lblValor5.setText(values[0]);
        lblTipo6.setText(values[0]);
        lblDataCom6.setText(values[0]);
        lblPagamento6.setText(values[0]);
        lblValor6.setText(values[0]);

    }
}
