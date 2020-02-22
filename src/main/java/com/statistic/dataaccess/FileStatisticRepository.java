package com.statistic.dataaccess;

import com.statistic.logic.models.FileData;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileStatisticRepository {

    private Connection connection;

    public FileStatisticRepository(Connector connector) {
        this.connection = connector.getConnect();
    }


    public boolean Create(FileData file) throws SQLException {

        String sql = "INSERT INTO FileStatistic (fileId, longestWord, shortestWord," +
                " averageWordLength, duplicationWord) VALUES (?, ?, ?, ? ,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, file.getId());
        statement.setString(2, file.fileStatistic.getLongestWord());
        statement.setString(3, file.fileStatistic.getShortestWord());
        statement.setDouble(4, file.fileStatistic.getAverageWordLength());
        Gson gson = new Gson();
        String json = gson.toJson(file.fileStatistic.getDuplicationWord());
        statement.setString(5, json);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            return true;
        }
        return false;
    }
}
