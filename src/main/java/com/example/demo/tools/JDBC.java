package com.example.demo.tools;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    public static final int XE = 1;

    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    static {
        DATA_SOURCE.setUsername("sa");
        DATA_SOURCE.setDriverClassName("org.h2.Driver");
        DATA_SOURCE.setUrl("jdbc:h2:mem:AZ;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        DATA_SOURCE.setDriverClassName("org.h2.Driver");
    }

    public static Connection getConnection() throws Exception {
        return DATA_SOURCE.getConnection();
    }
}
