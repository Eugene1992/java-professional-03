package com.cbs.edu.io.file_stream;

import java.io.*;

public class SimpleCopy {
    public static void main(String[] args) {
        File from = new File("D:\\java-professional-03\\src\\main\\java\\collections\\io\\file_stream\\from");
        File to = new File("D:\\java-professional-03\\src\\main\\java\\collections\\io\\file_stream\\to");

        try (InputStream is = new FileInputStream(from);
             OutputStream os = new FileOutputStream(to)) {
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
