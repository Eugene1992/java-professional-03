package com.cbu.edu.hw_03_02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Sviatoslav on 26.02.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Document document = null;
        Elements elements = null;
        try {
            document = Jsoup.connect("http://flangex.herokuapp.com/io/load").get();
            elements = document.select("a");
            for (Element element : elements) {
                System.out.println(element.attr("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
