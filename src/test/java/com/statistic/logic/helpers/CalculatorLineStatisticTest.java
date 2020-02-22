package com.statistic.logic.helpers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorLineStatisticTest {

    @Test
    void getLongestWord() {
        String text = "Do not go gentle into that good night Old age should burn and rave at close of day.";
        String result = CalculatorLineStatistic.getLongestWord(text);
        assertEquals("should", result);
    }

    @Test
    void getShortestWord() {
        String text = "Do not go gentle into that good night Old age should burn and rave at close of day.";
        String result = CalculatorLineStatistic.getShortestWord(text);
        assertEquals("Do", result);
    }

    @Test
    void getLineLength() {
        String text = "Do not go gentle into that good night Old age should burn and rave at close of day.";
        int result = CalculatorLineStatistic.getLineLength(text);
        assertEquals(text.length(), result);
    }

    @Test
    void getAverageWord() {
        String text = "Do not go gentle into that good night Old age should burn and rave at close of day.";

        double d = CalculatorLineStatistic.getAverageWord(text);

        assertEquals(3.61, d);
    }

    @Test
    void getDuplicateMap() {
        String text = "Do not go gentle into that good night Old age should burn and rave at close of day.";
        Map<String, Integer> result = CalculatorLineStatistic.getDuplicateMap(text);
        Map<String, Integer> ex = new HashMap<String, Integer>();
        assertEquals(ex, result);
    }
}