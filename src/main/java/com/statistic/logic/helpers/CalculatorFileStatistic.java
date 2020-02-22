package com.statistic.logic.helpers;

import com.statistic.logic.models.LineStatistic;

import java.util.*;

public class CalculatorFileStatistic {
    public static String getLongestWord(List<LineStatistic> lineStatistics) {
        String[] longestWordArray = new String[lineStatistics.size()];
        for (int i = 0; i < longestWordArray.length; i++) {
            longestWordArray[i] = lineStatistics.get(i).getLongestWord();
        }
        Arrays.sort(longestWordArray, Comparator.comparingInt(String::length));
        return longestWordArray[longestWordArray.length - 1];
    }

    public static String getShortestWord(List<LineStatistic> lineStatistics) {
        String[] shortestWordArray = new String[lineStatistics.size()];
        for (int i = 0; i < shortestWordArray.length; i++) {
            shortestWordArray[i] = lineStatistics.get(i).getShortestWord();
        }
        Arrays.sort(shortestWordArray, Comparator.comparingInt(String::length));
        return shortestWordArray[0];
    }

    public static double getAverageWord(List<LineStatistic> lineStatistics) {
        String[] averageWordArray = new String[lineStatistics.size()];
        for (int i = 0; i < averageWordArray.length; i++) {
            averageWordArray[i] = lineStatistics.get(i).getLongestWord();
        }
        double count = 0;
        double sum = 0;
        int currentWordLength;
        String tempString;
        for (int i = 0; i < averageWordArray.length; i++) {
            averageWordArray[i] = averageWordArray[i].replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
            tempString = averageWordArray[i];
            currentWordLength = tempString.length();
            sum += currentWordLength;
            count++;
        }
        double averageWordLength = sum / count;
        return Math.round(averageWordLength * 100) / 100D;
    }

    public static Map<String, Integer> getDuplicateMap(List<LineStatistic> lineStatistics) {
        String[] averageWordArray = new String[lineStatistics.size()];
        for (int i = 0; i < averageWordArray.length; i++) {
            averageWordArray[i] = lineStatistics.get(i).getLongestWord();
        }
        Map<String, Integer> currentMap = new HashMap<>();
        for (String c : averageWordArray) {
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
