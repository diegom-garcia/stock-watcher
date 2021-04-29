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
public class AcaoController {

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
        lblTipo.setText("1");
        lblTagAlong.setText("1");
        lblLiqDiaria.setText("1");
        lblDivUltimos.setText("1");
        lblMBruta.setText("1");
        lblMLiquida.setText("1");
        lblPL.setText("1");
        lblPVP.setText("1");
        lblVPA.setText("1");
        lblDivPL.setText("1");
        lblROIC.setText("1");
        lblROA.setText("1");
        lblROE.setText("1");
        lblPatLiquido.setText("1");
        lblDividaB.setText("1");
        lblDividaL.setText("1");
        lblSegAtuacao.setText("1");
        lblValorMercado.setText("1");
        lblFreeFloat.setText("1");
        lblTipo1.setText("1");
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
