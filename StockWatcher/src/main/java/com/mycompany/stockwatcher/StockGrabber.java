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
 *
 * @author DIEGO
 */
public class StockGrabber {

    public String[] grabStock(String stock) {
        ArrayList<Integer> index = new ArrayList<>();
        Collections.addAll(index, 0, 1, 2, 3, 4, 5, 6, 7, 11, 13, 18, 24, 27, 30, 33, 34, 35, 36, 53, 56, 58, 59, 63, 67);
        String[] str = new String[49];
        Integer ind = 0;
        String substr;
        try {

            Document doc = Jsoup.connect("https://statusinvest.com.br/acoes/" + stock).get();

            log(doc.title());
            Elements el = doc.getElementsByClass("value");
            Elements sub = doc.getElementsByClass("sub-value");
            Elements table = doc.getElementsByClass("list").get(7).getElementsByTag("tbody").get(0).getElementsByTag("tr");
            for (int i = 0; i < el.size(); i++) {
                if (index.contains(i)) {
                    //log(i + " - " + el.get(i).html().replace("%", ""));
                    str[ind] = el.get(i).html().replace("%", "");
                    ind++;
                }
            }

            str[ind] = sub.get(3).html().replace("R$ ", "");
            ind++;
            //Get The table
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
