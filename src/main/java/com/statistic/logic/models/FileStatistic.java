package com.statistic.logic.models;

import com.statistic.logic.helpers.CalculatorFileStatistic;

import java.util.List;
import java.util.Map;

public class FileStatistic {
    int Id;
    int FileId;
    String LongestWord;
    String ShortestWord;
    double AverageWordLength;
    Map<String, Integer> DuplicationWord;

    public FileStatistic(int fileId, List<LineStatistic> list) {
        FileId = fileId;
        LongestWord = CalculatorFileStatistic.getLongestWord(list);
        ShortestWord = CalculatorFileStatistic.getShortestWord(list);
        AverageWordLength = CalculatorFileStatistic.getAverageWord(list);
        DuplicationWord = CalculatorFileStatistic.getDuplicateMap(list);
    }

    public String getLongestWord() {
        return LongestWord;
    }

    public String getShortestWord() {
        return ShortestWord;
    }

    public double getAverageWordLength() {
        return AverageWordLength;
    }

    public Map<String, Integer> getDuplicationWord() {
        return DuplicationWord;
    }
}
