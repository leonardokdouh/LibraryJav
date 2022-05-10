package com.solvd.library.Util;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private final String URL = "jdbc:mysql://localhost:3306/mydb";
    private final String USER = "root";
    private final String PASS = "devintern";
    private static ConnectionPool datasource;
    private BasicDataSource basicDataSource = null;

    private ConnectionPool() {
//Singleton type pool
        basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        //This setups minconnection, max, total active and inactive
        basicDataSource.setInitialSize(2);
        basicDataSource.setMinIdle(3);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(40);
        basicDataSource.setMaxWaitMillis(10000);
    }
    public static ConnectionPool getInstance() {
        if (datasource == null) {
            datasource = new ConnectionPool();
            return datasource;
        } else {
            return datasource;
        }
    }
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = this.basicDataSource.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }


}
