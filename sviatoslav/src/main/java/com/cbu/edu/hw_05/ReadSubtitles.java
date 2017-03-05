package com.cbu.edu.hw_05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sviatoslav on 05.03.2017.
 */
public class ReadSubtitles {
    private HashMap<String, Integer> subtitles;
    private ArrayList<String> arrayList;

    public ReadSubtitles(HashMap<String, Integer> subtitles) {
        this.subtitles = subtitles;
        this.arrayList = new ArrayList<>();
    }

    public ArrayList<String> readFromFiles() {
        String path = "E:\\ProjectAndOther\\IDEAProjects\\java-professional-03\\sviatoslav\\src\\main\\java\\com\\cbu\\edu\\hw_05\\Game.of.Thrones.-.03x02.txt";
        try (InputStream is = new BufferedInputStream(new FileInputStream(path))) {
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            String[] lines = new String(buffer).split("\\n");
            for (String line : lines) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.matches("([a-zA-Z]{2,})+")) {
                        arrayList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public int countDuplicatedWords(String example) {
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (example.equals(arrayList.get(i))) {
                count++;
            }
        }
        return count;
    }

    public HashMap<String, Integer> fillMap() {
        for (int i = 0; i < arrayList.size(); i++) {
            subtitles.putIfAbsent(arrayList.get(i), countDuplicatedWords(arrayList.get(i)));
        }
        return subtitles;
    }

    public int totalWords() {
        return arrayList.size();
    }

    public int totalUniqueWords() {
        return subtitles.size();
    }
}
