package com.statistic.logic.helpers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CalculatorLineStatistic {
    public static String getLongestWord(String text) {
        String[] array = text.split(" ");
        Arrays.sort(array, Comparator.comparingInt(String::length));
        return array[array.length - 1];
    }

    public static String getShortestWord(String text) {
        String[] array = text.split(" ");
        Arrays.sort(array, Comparator.comparingInt(String::length));
        return array[0];
    }

    public static int getLineLength(String text) {
        return text.length();
    }

    public static double getAverageWord(String text) {
        String[] average = text.split(" ");

        double count = 0;
        double sum = 0;
        int currentWordLength;
        String tempString;
        for (int i = 0; i < average.length; i++) {
            average[i] = average[i].replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
            tempString = average[i];
            currentWordLength = tempString.length();
            sum += currentWordLength;
            count++;
        }
        double averageWordLength = sum / count;
        return Math.round(averageWordLength * 100) / 100D;
    }

    public static Map<String, Integer> getDuplicateMap(String text) {
        String[] array = text.split(" ");
        Map<String, Integer> currentMap = new HashMap<>();
        for (String c : array) {
            if (currentMap.containsKey(c)) {
                int counter = currentMap.get(c);
                currentMap.put(c, ++counter);
            } else {
                currentMap.put(c, 1);
            }
        }

        return Distinct(currentMap);
    }

    private static Map<String, Integer> Distinct(Map<String, Integer> map) {
        Map<String, Integer> currentMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                currentMap.put(entry.getKey(), entry.getValue());
        }

        return currentMap;
    }

}
