package com.cbu.edu.Java8_hw_6.subtitleWithLambda;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;
import static java.util.Arrays.stream;

/**
 * Created by Sviatoslav on 05.03.2017.
 */
public class ReadSubtitles {
    private HashMap<String, Integer> subtitles;
    private List<String> list;

    public ReadSubtitles(HashMap<String, Integer> subtitles) {
        this.subtitles = subtitles;
        this.list = new ArrayList<>();
    }

    public List<String> readFromFiles(Path path) {
        try {
            list = readAllLines(path)
                    .stream()
                    .map(String::toLowerCase)
                    .flatMap(word -> stream(word.split(" ")))
                    .filter(w -> w.matches("([a-zA-Z]{2,})+"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countDuplicatedWords(String example) {
        return (int) list
                .stream()
                .filter(example::equals)
                .count();
    }

    public HashMap<String, Integer> fillMap() {
        for (int i = 0; i < list.size(); i++) {
            subtitles.putIfAbsent(list.get(i), countDuplicatedWords(list.get(i)));
        }
        return subtitles;
    }

    public int totalWords() {
        return list.size();
    }

    public int totalUniqueWords() {
        return subtitles.size();
    }
}
