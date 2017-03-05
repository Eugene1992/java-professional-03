package com.cbu.edu.hw_05;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by Sviatoslav on 05.03.2017.
 */
public class ReadSubtitles {
    private HashMap<String, Integer> subtitles;
    private String line;

    public ReadSubtitles(HashMap<String, Integer> subtitles) {
        this.subtitles = subtitles;
    }

    public HashMap<String, Integer> readFromFiles() {
        Pattern pattern = Pattern.compile("[a-zA-Z]{2,}+");
        String path = "E:\\ProjectAndOther\\IDEAProjects\\java-professional-03\\sviatoslav\\src\\main\\java\\com\\cbu\\edu\\hw_05\\Game.of.Thrones.-.03x02.txt";
        try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(path))) {
            byte[] data = new byte[1024];
            int check = br.read(data, 0, data.length);
            while (check != 0){

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return subtitles;
    }

    /*public int countWords(String str) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.equals(str)) {
                count++;
            }
        }
        return count;
    }*/
}
