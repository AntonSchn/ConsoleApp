package com.statistic.logic.helpers;

import com.statistic.logic.models.FileData;
import com.statistic.logic.models.LineStatistic;

import java.util.Map;

public class StatisticHelper {
    public static void PrintFullStatistic(FileData file) {
        for (LineStatistic line : file.LineInfo) {
            System.out.println("TextLine: " + line.TextLine + " | " +
                    "TextLine Length: " + line.TextLine.length() + " | " +
                    "Longest Word: " + line.getLongestWord() +
                    " | " + "Shortest Word: " + line.getShortestWord() +
                    " | " + "Average Length Word: " + line.getAverageWordLength() +
                    " | " + "Duplicate Word: " + line.getDuplicationWord().size()

            );
            for (Map.Entry<String, Integer> entry : line.getDuplicationWord().entrySet()) {
                System.out.print("Key: " + entry.getKey() + " Value: " + entry.getValue());
            }
        }


        System.out.println("Longest Word: " + file.fileStatistic.getLongestWord());
        System.out.println("Shortest Word: " + file.fileStatistic.getShortestWord());
        System.out.println("Average Length Word: " + file.fileStatistic.getAverageWordLength());
        System.out.println("Duplicate Word: " + file.fileStatistic.getDuplicationWord().size());

        for (Map.Entry<String, Integer> entry : file.fileStatistic.getDuplicationWord().entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    public static void PrintLineStatistic(FileData file) {
        for (LineStatistic line : file.LineInfo) {
            System.out.println("TextLine: " + line.TextLine + " | " +
                    "TextLine Length: " + line.TextLine.length() + " | " +
                    "Longest Word: " + line.getLongestWord() +
                    " | " + "Shortest Word: " + line.getShortestWord() +
                    " | " + "Average Length Word: " + line.getAverageWordLength() +
                    " | " + "Duplicate Word: " + line.getDuplicationWord().size()

            );
            for (Map.Entry<String, Integer> entry : line.getDuplicationWord().entrySet()) {
                System.out.print("Key: " + entry.getKey() + " Value: " + entry.getValue());
            }
        }
    }

    public static void PrintFileStatistic(FileData file) {
        System.out.println("Longest Word: " + file.fileStatistic.getLongestWord());
        System.out.println("Shortest Word: " + file.fileStatistic.getShortestWord());
        System.out.println("Average Length Word: " + file.fileStatistic.getAverageWordLength());
        System.out.println("Duplicate Word: " + file.fileStatistic.getDuplicationWord().size());

        for (Map.Entry<String, Integer> entry : file.fileStatistic.getDuplicationWord().entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
