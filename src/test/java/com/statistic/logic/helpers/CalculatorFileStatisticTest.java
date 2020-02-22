package com.statistic.logic.helpers;

import com.statistic.logic.models.FileData;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorFileStatisticTest {

    @Test
    void getLongestWord() {

        FileData temp = new FileData(FIleHelper.GetFileName("TestFile"), "Do not go gentle into that good night Old age should burn and rave at close of day");
        String result = CalculatorFileStatistic.getLongestWord(temp.LineInfo);
        assertEquals("should", result);
    }

    @Test
    void getShortestWord() {
        FileData temp = new FileData(FIleHelper.GetFileName("TestFile"), "Do not go gentle into that good night Old age should burn and rave at close of day");
        String result = CalculatorFileStatistic.getShortestWord(temp.LineInfo);
        assertEquals("Do", result);
    }

    @Test
    void getAverageWord() {
        FileData temp = new FileData(FIleHelper.GetFileName("TestFile"), "Do not go gentle into that good night Old age should burn and rave at close of day");

        double d = CalculatorFileStatistic.getAverageWord(temp.LineInfo);

        assertEquals(6.0, d);

    }

    @Test
    void getDuplicateMap() {
        FileData temp = new FileData(FIleHelper.GetFileName("TestFile"), "Do not go gentle into that good night Old age should burn and rave at close of day");
        Map<String, Integer> result = CalculatorFileStatistic.getDuplicateMap(temp.LineInfo);
        Map<String, Integer> ex = new HashMap<String, Integer>();
        assertEquals(ex, result);
    }
}