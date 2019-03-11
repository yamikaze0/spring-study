package org.yamikaze.spring.study.tx;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author yamikaze
 * @date 2018/2/22
 */
public class JdbcTx {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =  DriverManager.getConnection("jdbc:mysql//localhost:3306/junit");
        //关闭自动事务
        connection.setAutoCommit(false);

        try {


            //code
            connection.commit();
        } catch (Exception e) {
            //发生异常回滚事务
            connection.rollback();
        }


    }
}
