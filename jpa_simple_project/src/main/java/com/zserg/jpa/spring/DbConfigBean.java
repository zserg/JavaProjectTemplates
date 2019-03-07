package com.zserg.jpa.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource("classpath:application.properties")
@Configuration
public class DbConfigBean {

    @Value("${db.user}")
    private String dbUser;

    @Value("${db.pass}")
    private String dbPass;

    @Value("${db.url}")
//    @Value("jdbc:sqlite:test_prj.db")
    private String dbUrl;

    @Bean
    public DataSource dataSourceSqlite() {
        Properties connProps = new Properties();
        connProps.put("autoCommit", "true");

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPass);
        dataSource.setConnectionProperties(connProps);
        return dataSource;
    }
}
