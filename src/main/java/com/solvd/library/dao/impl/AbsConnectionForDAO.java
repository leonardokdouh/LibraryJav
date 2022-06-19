package com.solvd.library.dao.impl;

import com.solvd.library.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbsConnectionForDAO {

    private final static Logger LOG = LogManager.getLogger(AbsConnectionForDAO.class);

    public Connection getConnect() {
        return ConnectionPool.getInstance().getConnection();
    }

    public void returnConnect(Connection conn) {
        ConnectionPool.getInstance().returnConnection(conn);
    }

    public static void closeAllResources(PreparedStatement pr, ResultSet rs) {
        try {
            if (pr != null) {
                pr.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOG.error("There was a problem while closing the resources", e);
            throw new RuntimeException(e);
        }
    }

    public static void closeAllResources(PreparedStatement pr) {
        try {
            if (pr != null) {
                pr.close();
            }
        } catch (SQLException e) {
            LOG.error("There was a problem while closing the resources", e);
        }
    }


}
