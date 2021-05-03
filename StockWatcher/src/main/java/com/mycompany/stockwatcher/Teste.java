/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author DIEGO
 */
public class Teste {

    String className = "d-md-inline-block";

    public static void main(String[] args) {
        ArrayList<Integer> index = new ArrayList<>();
        Collections.addAll(index, 0, 1, 2, 3, 4, 5, 6, 7, 11, 13, 18, 24, 27, 30, 33, 34, 35, 36, 53, 56, 58, 59, 63, 67);
        String[] str = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        Integer ind = 0;
        String substr;
        try {

            Document doc = Jsoup.connect("https://statusinvest.com.br/fundos-imobiliarios/xpcm11").get();

            log(doc.title());
            Elements el = doc.getElementsByClass("value");
            Elements sub = doc.getElementsByClass("sub-value");
            Elements table = doc.getElementsByClass("list").get(7).getElementsByTag("tbody").get(0).getElementsByTag("tr");
            Elements el2 = doc.getElementsByClass("mb-5 d-flex flex-wrap flex-lg-nowrap justify-between");
            for (int i = 0; i < el2.size(); i++) {
                substr = el2.get(i).getElementsByClass("value d-inline-block fs-5 fw-900").html().replace("%", "");
                log(substr);
            }
            for (int i = 0; i < el2.size(); i++) {
                substr = el2.get(i).getElementsByClass("sub-value fs-4 lh-3").html().replace("%", "");
                log(substr);
            }
//            for (int i = 0; i < el.size(); i++) {
//                substr =i+ el.get(i).html().replace("%", "");
//                log(substr);
//            }

//            for (int i = 0; i < table.size(); i++) {
////                if (index.contains(i)) {
//                for (int j = 0; j < 4; j++) {
//                    substr = table.get(i).getElementsByTag("td").get(j).html().replace("%", "");
//                    if (substr.indexOf('<') == -1) {
//                        log(substr);
//                    } else {
//                        if (substr.charAt(0) == '<') {
//                            log(substr.substring(substr.indexOf('>') + 3, substr.indexOf("<", substr.indexOf('>')) - 1));
//
//                        } else {
//                            log(substr.substring(0, substr.indexOf('<')));
//                        }
//                    }
//                }
//            }
//                    str[ind] = el.get(i).html().replace("%", "");
//                    ind++;
//0,1,2,3,4,5,6,7,8,10,11,12,13,15,22,24,25
//                }
//            substr = "aa" + " - " + table.get(1).getElementsByTag("td").get(3).html().replace("%", "");
            //for (int i = 0; i < 10; i++) {
            //  System.out.println(i + "-" + substr.charAt(i));
            // }
            //log("Ultimos 12 meses - " + sub.get(3).html().replace("R$ ", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

}
