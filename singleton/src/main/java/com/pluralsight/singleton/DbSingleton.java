package com.pluralsight.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
    // Thread safe
    private static volatile DbSingleton instance;
    private static volatile Connection conn;

    private DbSingleton() {
        try {
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            // as of version 10.15.2.0:
            DriverManager.registerDriver(new org.apache.derby.iapi.jdbc.AutoloadedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(conn != null) {
            throw new RuntimeException("Use getConnection() method to create");
        }

        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized(DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }

        return instance;
    }

    /**
     * GetConnection is not static!
     * You got to have an instance of the singleton.
     * @return
     */
    public Connection getConnection() {
        if(conn == null) {
            synchronized (DbSingleton.class) {
                if(conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return conn;
    }

}
