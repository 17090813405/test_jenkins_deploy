package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

/**
 * @author liuzhihao
 * @date 2018/4/15
 */
@Slf4j
public abstract class AbstractDataSourceConfigurer {

    DataSource createDataSource(String url, String username, String password) {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaximumPoolSize(1000);
        dataSource.setMinimumIdle(5);
        return dataSource;
    }
}
