package com.cbu.edu.traffic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

/**
 * Created by Sviatoslav on 12.03.2017.
 */
public class ReadAndParse {

    private List<TrafficModel> list;


    public List<TrafficModel> readFile(Path path) {
        try {
            list = Files.readAllLines(path)
                    .stream()
                    .map(this::parseFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public TrafficModel parseFile(String lines) {
        String[] parts = lines.split("\\t");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
        LocalDate dateTime = LocalDate.parse(parts[0].split(" ")[0]);
        double uaInput = parseDouble(parts[1]);
        double uaOutput = parseDouble(parts[2]);
        double inetInput = parseDouble(parts[3]);
        double inetOutput = parseDouble(parts[4]);
        double someValue = parseDouble(parts[5]);
        double anotherValue = parseDouble(parts[6]);
        return new TrafficModel(dateTime, uaInput, uaOutput, inetInput, inetOutput, someValue, anotherValue);
    }

    public double sumUaInput() {
        return list.stream()
                .mapToDouble(TrafficModel::getUaInput)
                .sum();
    }

    public double sumUaOutput() {
        return list.stream()
                .mapToDouble(TrafficModel::getUaOutput)
                .sum();
    }

    public double sumInetInput() {
        return list.stream()
                .mapToDouble(TrafficModel::getInetInput)
                .sum();
    }

    public double sumInetOutput() {
        return list.stream()
                .mapToDouble(TrafficModel::getInetOutput)
                .sum();
    }

    public double sumInputTraffic() {
        return list.stream()
                .mapToDouble(TrafficModel::getSomeValue)
                .sum();
    }

    public double sumOutputTraffic() {
        return list.stream()
                .mapToDouble(TrafficModel::getAnotherValue)
                .sum();
    }

   /* public List<Double> sumAllFromInterval(LocalDate from, LocalDate to) {
        List<Double> summ = null;
        List<TrafficModel> collect = list.stream()
                .filter(e -> e.getDate().isAfter(from))
                .filter(s -> s.getDate().isBefore(to))
                .collect(Collectors.toList());
        summ.add(collect.stream()
                .mapToDouble(e -> sumInetOutput())
                .sum());
        return summ;
    }*/
}

