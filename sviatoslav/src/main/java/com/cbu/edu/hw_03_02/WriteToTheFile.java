package com.cbu.edu.hw_03_02;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Sviatoslav on 26.02.2017.
 */
public class WriteToTheFile {
    public static void WriteTo(String path, String urlReference) throws IOException {
        byte arr[] = new byte[512];
        try (BufferedInputStream bufRead = new BufferedInputStream(new URL(urlReference).openStream());
             FileOutputStream fout = new FileOutputStream((path))) {
            int count;
            while ((count = bufRead.read(arr, 0, arr.length)) != -1) {
                fout.write(arr, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
