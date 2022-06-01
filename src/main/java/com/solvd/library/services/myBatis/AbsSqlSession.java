package com.solvd.library.services.myBatis;

import com.solvd.library.util.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public abstract class AbsSqlSession {

    public SqlSession sqlSession(){
        Reader e = null;
        try {
            e = Resources.getResourceAsReader(Constants.MY_BATIS_CONFIG);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
        SqlSession session =sql.openSession();
        return session;


    }
}
