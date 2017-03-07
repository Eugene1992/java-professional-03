package com.cbu.edu.hw_05;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import static java.nio.file.Files.readAllLines;

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

    public ArrayList<String> readFromFiles(Path path) {
        try {
            String[] lines = (String[]) readAllLines(path).toArray();
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
