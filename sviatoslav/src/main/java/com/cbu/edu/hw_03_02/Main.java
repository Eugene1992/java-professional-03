package com.cbu.edu.hw_03_02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.cbu.edu.hw_03_02.WriteToTheFile.writeTo;

/**
 * Created by Sviatoslav on 26.02.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Document document;
        Elements elements;
        try {
            document = Jsoup.connect("http://flangex.herokuapp.com/io/load").get();
            elements = document.select("a");
            for (Element element : elements) {
                String fullReference[] = element.attr("href").split("/");
                String fileName = fullReference[fullReference.length - 1];
                writeTo("E:\\ProjectAndOther\\IDEAProjects\\java-professional-03\\sviatoslav\\src\\main\\java\\com\\cbu\\edu\\hw_03_02\\Files\\" + fileName,
                        "http://flangex.herokuapp.com" + element.attr("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
