package com.solvd.library.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OneStepCloser {

    PreparedStatement ps=null;
    ResultSet rs= null;

    public OneStepCloser(PreparedStatement ps){
        this.ps=ps;
    }
    public OneStepCloser(PreparedStatement ps, ResultSet rs){
        this.ps=ps;
        this.rs=rs;
    }


    public void theCloser(PreparedStatement ps){
        if( ps != null){
            try{
                ps.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Error in SQL query", e);
            }
        }
    }
    public void twoCloser(PreparedStatement ps, ResultSet rs){
        if( rs != null && ps != null){
            try{
                ps.close();
                rs.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Error in SQL query", e);
            }
        }
    }

}
