package com.solvd.library.services.myBatis;

import com.solvd.library.util.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public abstract class AbsSqlSession {

    private static final Logger LOG = LogManager.getLogger(AbsSqlSession.class);

    public SqlSession sqlSession() {
        Reader e = null;
        try {
            e = Resources.getResourceAsReader(Constants.MY_BATIS_CONFIG);
        } catch (IOException ex) {
            LOG.error("Cant open the session", ex);
        }
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(e);
        return sql.openSession();
    }
}
