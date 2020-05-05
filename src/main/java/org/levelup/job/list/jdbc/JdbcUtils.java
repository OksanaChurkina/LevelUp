package org.levelup.job.list.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    //DriverManager
    //java.sql.Driver
//    static {
//        try{
//            Class.forName("org.postgresql.Driver");
//        }catch (ClassNotFoundException e){
//            throw new RuntimeException(e);
//        }
//    }

    public static Connection getConnection() throws SQLException {

        //url
        //jdbc:<vendor name>://<host (IP address)>: <port>/ <db name>
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/job_list",
                "postgres",
                "root"
        );


        return connection;
    }
}
