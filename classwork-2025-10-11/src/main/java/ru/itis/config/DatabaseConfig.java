package ru.itis.config;

import lombok.experimental.UtilityClass;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@UtilityClass
public class DatabaseConfig {

    public final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

    private static DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/oris-fall-2025");
        dataSource.setUser("postgres");
        dataSource.setPassword("qwerty");
        return dataSource;
    }
}
