package ru.itis.jdbc;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.jdbc.model.UserEntity;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MainJdbcTemplate {

    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

    private static final UserRowMapper rowMapper = new UserRowMapper();

    private static final String SQL_SELECT_ALL = "select * from user_entity";

    private static DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/oris-fall-2025");
        dataSource.setUser("postgres");
        dataSource.setPassword("qwerty");
        return dataSource;
    }


    public static void main(String[] args) {
        List<UserEntity> result = findAllUsers();

        System.out.println(result);
    }

    public static List<UserEntity> findAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    private static final class UserRowMapper implements RowMapper<UserEntity> {

        @Override
        public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return UserEntity.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .build();
        }
    }

}
