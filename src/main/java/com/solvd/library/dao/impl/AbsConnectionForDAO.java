package com.solvd.library.dao.impl;

import com.solvd.library.util.ConnectionPool;

import java.sql.Connection;

public abstract class AbsConnectionForDAO {
    public Connection getConnect(){
        return ConnectionPool.getInstance().getConnection();
    }

    public void returnConnect(Connection conn){
        ConnectionPool.getInstance().returnConnection(conn);
    }
}
