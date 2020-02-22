package com.statistic.dataaccess;

import com.statistic.logic.models.LineStatistic;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LineStatisticRepository {

    private Connection connection;

    public LineStatisticRepository(Connector connector) {
        this.connection = connector.getConnect();
    }

    public boolean Create(int fileId, LineStatistic line) throws SQLException {

        String sql = "INSERT INTO LineStatistic (fileId, textLine, longestWord, shortestWord," +
                " lineLength, averageWordLength, duplicationWord) VALUES (?, ?, ?, ? ,? ,?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, fileId);
        statement.setString(2, line.getTextLine());
        statement.setString(3, line.getLongestWord());
        statement.setString(4, line.getShortestWord());
        statement.setInt(5, line.getLineLength());
        statement.setDouble(6, line.getAverageWordLength());

        Gson gson = new Gson();
        String json = gson.toJson(line.getDuplicationWord());

        statement.setString(7, json);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            return true;
        }
        return false;
    }
}
