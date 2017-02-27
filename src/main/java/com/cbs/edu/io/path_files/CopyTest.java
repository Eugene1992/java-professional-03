package com.cbs.edu.io.path_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Eugene on 20.09.2016.
 */
public class CopyTest {
    public static void main(String[] args) {
        Path pathSource = Paths.get("D:\\java-professional-03\\src\\main\\java\\collections\\io\\path_files\\file_data.txt");
        Path pathDestination = Paths.get("D:\\java-professional-03\\src\\main\\java\\collections\\io\\path_files\\a\\file_data.txt");
        try {
            Files.copy(pathSource, pathDestination);
            System.out.println("Source file copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
