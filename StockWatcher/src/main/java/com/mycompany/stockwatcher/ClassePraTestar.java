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
public class ClassePraTestar {

    public static void main(String[] args) {
        StockGrabber aa;
        aa = new StockGrabber();
        String[] bb = aa.grabStock("bbse3");
        for(int i=0; i<bb.length;i++){
            System.out.println(i +" = " +bb[i]);
        }
    }
}
