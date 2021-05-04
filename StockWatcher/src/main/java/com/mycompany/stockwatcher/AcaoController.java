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
    
    public void initLabel(String stock) {
        StockGrabber html = new StockGrabber();
        String[] values = html.grabStock(stock);
        lblValorAtual.setText("R$"+values[0]);
        lblMinSemanas.setText("R$"+values[1]);
        lblValorizacao.setText(values[4]+"%");
        lblMaxSemanas.setText("R$"+values[2]);
        lblDivYield.setText(values[3]+"%");
        lblTipo.setText(values[5]);
        lblTagAlong.setText(values[6]+"%");
        lblLiqDiaria.setText("R$"+values[7]);
        lblDivUltimos.setText("R$"+values[24]);
        lblMBruta.setText(values[13]+"%");
        lblMLiquida.setText(values[14]+"%");
        lblPL.setText(values[8]);
        lblPVP.setText(values[9]);
        lblVPA.setText(values[10]);
        lblDivPL.setText(values[11]);
        lblROIC.setText(values[17]+"%");
        lblROA.setText(values[16]+"%");
        lblROE.setText(values[15]+"%");
        lblPatLiquido.setText("R$"+values[18]);
        lblDividaB.setText("R$"+values[19]);
        lblDividaL.setText("R$"+values[20]);
        lblSegAtuacao.setText(values[23]);
        lblValorMercado.setText("R$"+values[21]);
        lblFreeFloat.setText(values[22]+"%");
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

    }

}
