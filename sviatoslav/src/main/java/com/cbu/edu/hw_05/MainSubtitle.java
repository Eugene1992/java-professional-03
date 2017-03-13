package com.cbu.edu.hw_05;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sviatoslav on 05.03.2017.
 */
public class MainSubtitle {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\ProjectAndOther\\IDEAProjects\\java-professional-03\\sviatoslav\\src\\main\\java\\com\\cbu\\edu\\hw_05\\Game.of.Thrones.txt");
        ReadSubtitles subtitles = new ReadSubtitles(new HashMap<>());
        subtitles.readFromFiles(path);
        Set<Map.Entry<String, Integer>> entries = subtitles.fillMap().entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.printf("Word: %15s --%3d\n", key, value);
        }
        System.out.printf("Total words: %4d\n", subtitles.totalWords());
        System.out.printf("Total of unique word: %4d\n", subtitles.totalUniqueWords());
    }

}
