/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * /**
 *
 * @author DIEGO
 */
public class FiiGrabber {

    public String[] grabFund(String fundo) {
        ArrayList<Integer> index = new ArrayList<>();
        Collections.addAll(index, 0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 22, 24, 25, 28);
        String[] str = new String[47];
        Integer ind = 0;
        String substr;
        try {

            Document doc = Jsoup.connect("https://statusinvest.com.br/fundos-imobiliarios/" + fundo).get();
            log(doc.title());
            Elements el = doc.getElementsByClass("value");
            Elements sub = doc.getElementsByClass("sub-value");
            Elements el2 = doc.getElementsByClass("mb-5 d-flex flex-wrap flex-lg-nowrap justify-between");
            Elements table = doc.getElementsByClass("list").get(7).getElementsByTag("tbody").get(0).getElementsByTag("tr");
            for (int i = 0; i < el.size(); i++) {
                if (index.contains(i)) {
                    //log(i + " - " + el.get(i).html().replace("%", ""));
                    str[ind] = el.get(i).html().replace("%", "");
                    ind++;

                }
            }
            System.out.println(ind);
            str[ind] = sub.get(3).html().replace("R$ ", "");
            ind++;
            for (int i = 0; i < el2.get(0).getElementsByClass("value d-inline-block fs-5 fw-900").size(); i++) {
                str[ind] = el2.get(0).getElementsByClass("value d-inline-block fs-5 fw-900").get(i).html().replace("%", "");
                ind++;

            }
            for (int i = 0; i < 2; i++) {
                str[ind] = el2.get(0).getElementsByClass("sub-value fs-4 lh-3").get(i).html().replace("%", "");
                ind++;

            }
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    substr = table.get(i).getElementsByTag("td").get(j).html().replace("%", "");
                    if (substr.indexOf('<') == -1) {
//                        log(substr);
                        str[ind] = substr;
                        ind++;
                    } else {
                        if (substr.charAt(0) == '<') {
//                            log(substr.substring(substr.indexOf('>') + 3, substr.indexOf("<", substr.indexOf('>')) - 1));
                            str[ind] = substr.substring(substr.indexOf('>') + 3, substr.indexOf("<", substr.indexOf('>')) - 1);
                            ind++;

                        } else {
//                            log(substr.substring(0, substr.indexOf('<')));
                            str[ind] = substr.substring(0, substr.indexOf('<'));
                            ind++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

}
