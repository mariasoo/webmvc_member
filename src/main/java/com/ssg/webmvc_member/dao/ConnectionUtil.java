package com.ssg.webmvc_member.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil { // 싱글톤으로 만들겠단 뜻

    INSTANCE;

    private HikariDataSource dataSource;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts","true");
        config.addDataSourceProperty("prepStmtCacheSize","250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

       dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception{
        return dataSource.getConnection(); //Connection.INSTANCE.getConnection();
    }
}
