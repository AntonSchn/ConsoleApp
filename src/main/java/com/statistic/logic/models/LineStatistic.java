package com.statistic.logic.models;

import com.statistic.logic.helpers.CalculatorLineStatistic;

import java.util.Map;

public class LineStatistic {
    int Id;
    int FileId;
    public String TextLine;

    public LineStatistic(int fileId, String textLine) {
        FileId = fileId;
        TextLine = textLine;
        LongestWord = CalculatorLineStatistic.getLongestWord(TextLine);
        ShortestWord = CalculatorLineStatistic.getShortestWord(TextLine);
        LineLength = CalculatorLineStatistic.getLineLength(TextLine);
        AverageWordLength = CalculatorLineStatistic.getAverageWord(TextLine);
        DuplicationWord = CalculatorLineStatistic.getDuplicateMap(TextLine);
    }

    String LongestWord;
    String ShortestWord;
    int LineLength;
    double AverageWordLength;
    Map<String, Integer> DuplicationWord;

    public String getTextLine() {
        return TextLine;
    }

    public String getLongestWord() {
        return LongestWord;
    }

    public String getShortestWord() {
        return ShortestWord;
    }

    public int getLineLength() {
        return LineLength;
    }

    public double getAverageWordLength() {
        return AverageWordLength;
    }

    public Map<String, Integer> getDuplicationWord() {
        return DuplicationWord;
    }
}

