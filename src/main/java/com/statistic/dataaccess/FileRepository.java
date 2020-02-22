package com.statistic.dataaccess;

import com.statistic.logic.models.FileData;

import java.sql.*;

public class FileRepository {
    private Connection connection;

    public FileRepository(Connector connector) {
        this.connection = connector.getConnect();
    }

    public boolean Create(FileData file) throws SQLException {
        String sql = "INSERT INTO File (filename, textfile) VALUES (?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, file.getName());
        statement.setString(2, file.getTextFile());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            return true;
        }
        return false;
    }

}
