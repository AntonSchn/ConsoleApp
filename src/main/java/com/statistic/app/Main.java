package com.statistic.app;

import com.statistic.logic.helpers.InputHelper;
import com.statistic.logic.helpers.StatisticHelper;
import com.statistic.logic.models.FileData;
import com.statistic.dataaccess.Connector;
import com.statistic.dataaccess.FileRepository;
import com.statistic.dataaccess.FileStatisticRepository;
import com.statistic.dataaccess.LineStatisticRepository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:statistic.db";

        Connector connector = new Connector(url);
        FileRepository repository = new FileRepository(connector);
        LineStatisticRepository lineRepo = new LineStatisticRepository(connector);
        FileStatisticRepository fileRepo = new FileStatisticRepository(connector);

        while (true) {
            System.out.println("Specify the path to the file :");
            String path = InputHelper.GetPath();
            if (!path.isEmpty() && Files.exists(Paths.get(path))) {

                FileData temp = FileData.getFileDataByPath(path);
                StatisticHelper.PrintFullStatistic(temp);

                try {
                    boolean resultWriteFileToDatabase = repository.Create(temp);
                    for (int i = 0; i < temp.LineInfo.size(); i++) {
                        boolean resultWriteLineStatisticToDatabase = lineRepo.Create(temp.getId(), temp.LineInfo.get(i));
                    }
                    boolean resultWriteFileStatisticToDatabase = fileRepo.Create(temp);


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Path entered incorrectly! ");
            }
        }

    }
}
