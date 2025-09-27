package ru.itis.jdbc_repository.config;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.jdbc_repository.util.PropertyReader;

import javax.sql.DataSource;

@UtilityClass
public class JdbcConfig {

    @Getter
    private final JdbcTemplate template = new JdbcTemplate(dataSource());

    private DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(PropertyReader.getProperty("DB_URL"));
        dataSource.setUser(PropertyReader.getProperty("DB_USER"));
        dataSource.setPassword(PropertyReader.getProperty("DB_PASSWORD"));
        return dataSource;
    }

}
