package com.statistic.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


interface IConnector {
    Connection getConnect() throws SQLException;
}

public class Connector implements IConnector {

    private String url;
    private Connection con;

    public Connector(String url) {
        this.url = url;
    }

    public Connection getConnect() {
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
