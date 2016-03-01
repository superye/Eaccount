package com.eaccount.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by spzn on 16-1-9.
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("com/eaccount/config/configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return  sqlSession;
    }

    public void GetLog() {
        //org.apache.ibatis.logging.LogFactory.useSlf4jLogging();
        //org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        //org.apache.ibatis.logging.LogFactory.useJdkLogging();
        //org.apache.ibatis.logging.LogFactory.useCommonsLogging();
        org.apache.ibatis.logging.LogFactory.useStdOutLogging();
    }
}
