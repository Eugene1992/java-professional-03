package com.cbu.edu.Java8_hw_6.subtitleWithLambda;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sviatoslav on 05.03.2017.
 */
public class SubtitleMain {
    public static void main(String[] args) {
        ReadSubtitles subtitles = new ReadSubtitles(new HashMap<>());
        Path path = Paths.get("E:\\ProjectAndOther\\IDEAProjects\\java-professional-03\\sviatoslav\\src\\main\\java\\com\\cbu\\edu\\Java8_hw_6\\subtitleWithLambda\\Game.of.Thrones.txt");
        System.out.println(subtitles.readFromFiles(path));
        Set<Map.Entry<String, Integer>> entries = subtitles.fillMap().entrySet();
        for (Map.Entry<String, Integer> next : entries) {
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.printf("Word: %15s --%3d\n", key, value);
        }
        System.out.printf("Total words: %4d\n", subtitles.totalWords());
        System.out.printf("Total of unique word: %4d\n", subtitles.totalUniqueWords());
    }

}
