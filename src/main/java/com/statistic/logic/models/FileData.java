package com.statistic.logic.models;

import com.statistic.logic.helpers.FIleHelper;

import java.util.ArrayList;
import java.util.List;

public class FileData {
    int Id;
    String Name;
    String TextFile;
    public List<LineStatistic> LineInfo;
    public FileStatistic fileStatistic;

    public FileData(String name, String textFile) {
        Id = (int) System.currentTimeMillis();
        Name = name;
        TextFile = textFile;
        LineInfo = getLineFromTextFile(textFile);
        fileStatistic = new FileStatistic(Id, LineInfo);
    }

    public static FileData getFileDataByPath(String path) {
        return new FileData(FIleHelper.GetFileName(path), FIleHelper.ReadFile(path));

    }

    private List<LineStatistic> getLineFromTextFile(String TextFile) {
        List<LineStatistic> currentStat = new ArrayList<>();
        String[] array = TextFile.split("\r\n");
        try {
            for (int i = 0; i < array.length; i++) {
                currentStat.add(new LineStatistic(Id, array[i]));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return currentStat;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getTextFile() {
        return TextFile;
    }
}
