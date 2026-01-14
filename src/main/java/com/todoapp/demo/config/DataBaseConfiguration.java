package com.todoapp.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver}")
    String driver;

    @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(10);//máximo de 10 conexões.
        config.setMinimumIdle(1);//mínimo de conexões liberadas
        config.setPoolName("library-db-pool");//nome do tubo de conexão
        config.setMaxLifetime(600000);//tempo máximo de uma conexão
        config.setConnectionTimeout(100000);//tempo gasto para obter uma conexão, se demorar retorna time-out
        config.setConnectionTestQuery("select 1");//verificar se está conectando com o banco de dados

        return new HikariDataSource(config);
    }
}
