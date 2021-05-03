/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

/**
 *
 * @author DIEGO
 */
public class Classe_teste_fii {

    public static void main(String[] args) {
        FiiGrabber aa;
        aa = new FiiGrabber();
        String[] bb = aa.grabFund("xpcm11");
        for (int i = 0; i < bb.length; i++) {
            System.out.println(i + " - " + bb[i]);
        }
    }
}
