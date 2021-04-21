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
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author DIEGO
 */
public class Teste {

    String className = "d-md-inline-block";

    public static void main(String[] args) {
        ArrayList<Integer> index = new ArrayList<>();
        index.add(0);
        index.add(1);
        index.add(2);
        index.add(3);
        index.add(4);
        ArrayList<String> aux = new ArrayList<>();
        aux.add("23.33");
        aux.add("21.53");
        aux.add("29.75");
        aux.add("5.79");
        aux.add("-9.19");
        aux.add("ON");
        aux.add("100");
        aux.add("182.778.331.06");
        aux.add("5.79");
        aux.add("7.30");
        aux.add("3.19");
        aux.add("0.59");
        aux.add("");
        try {
//log(""+round(Double.parseDouble(el.get(i).html().replace("%", "").replace(",", ".")), 2));        Para depois
            /*
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        //log(doc.getElementsByClass(""));
        
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
             */
            Document doc = Jsoup.connect("https://statusinvest.com.br/acoes/bbse3").get();
            log(doc.title());
            Elements el = doc.getElementsByClass("value");
            for (int i = 0; i < el.size(); i++) {
//                if (index.contains(i)) {
                log(el.get(i).html().replace("%", ""));
//                    log("" + i);
//                if (aux.contains(el.get(i).html().replace("%", "").replace(",", "."))) {
//                    log("" + i);
//                }
//                }
//                }
            }
// 0,1,2,3,4,5,6,7,11,13,18,24,27,30
            //if (els != null && els.size() > 0) {
            //    log(els.get(0).text());
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

}
