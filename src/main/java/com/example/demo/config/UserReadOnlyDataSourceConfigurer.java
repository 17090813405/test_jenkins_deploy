package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author daizhichao
 * @date 2018/11/19
 */
@Configuration
public class UserReadOnlyDataSourceConfigurer extends AbstractDataSourceConfigurer {
    @Value("${koala.user-read-only.datasource.username}")
    private String username;

    @Value("${koala.user-read-only.datasource.password}")
    private String password;

    @Value("${koala.user-read-only.datasource.url}")
    private String url;

    @Bean("userReadOnlyJdbcTemplate")
    public JdbcTemplate userReadOnlyJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(super.createDataSource(url, username, password));
        return jdbcTemplate;
    }
}
