package com.cbu.edu.traffic;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Sviatoslav on 12.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\ProjectAndOther\\IDEAProjects\\java-professional-03\\sviatoslav\\src\\main\\java\\com\\cbu\\edu\\traffic\\Standartdata.txt");
        ReadAndParse reader = new ReadAndParse();
        reader.readFile(path);
        System.out.println("Sum for UaInp = " + reader.sumUaInput());
        System.out.println("Sum for UaOut = " + reader.sumUaOutput());
        System.out.println("Sum for InetInp = " + reader.sumInetInput());
        System.out.println("Sum for InetOut = " + reader.sumInetOutput());
        System.out.println("Sum for InputTraffic = " + reader.sumInputTraffic());
        System.out.println("Sum for OutPutTraffic = " + reader.sumOutputTraffic());
        //reader.sumAllFromInterval(2016-12-14 , 2016-12-24)

    }
}
