package com.tuogen.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //连接池对象
    static DataSource ds;

    static {
        long start = System.currentTimeMillis();

        System.out.println("start2="+start);
        Properties pro=new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end2="+(System.currentTimeMillis()-start));
    }

    /**
     * 获取连接池
     * @return
     * @throws SQLException
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * @param connection
     */
    public static void close(Connection connection){
        close(connection,null,null);
    }

    public static void close(Connection connection, Statement statement){
        close(connection,statement,null);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

}
