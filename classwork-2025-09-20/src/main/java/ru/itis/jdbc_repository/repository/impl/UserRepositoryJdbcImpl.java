package ru.itis.jdbc_repository.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.jdbc_repository.config.JdbcConfig;
import ru.itis.jdbc_repository.model.UserEntity;
import ru.itis.jdbc_repository.repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {

    private static final JdbcTemplate jdbcTemplate = JdbcConfig.getTemplate();
    private static final UserRowMapper rowMapper = new UserRowMapper();
    private static final String SQL_SELECT_ALL = "select * from user_entity";
    private static final String SQL_SELECT_BY_ID = "select * from user_entity where id = ?";
    private static final String SQL_SELECT_BY_NAME = "select * from user_entity where name = ?";
    private static final String SQL_INSERT = "insert into user_entity(\"name\") values (?)";
    private static final String SQL_UPDATE = "update user_entity set name = ? where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from user_entity where id = ?";

    @Override
    public List<UserEntity> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, rowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<UserEntity> findByName(String name) {
        return jdbcTemplate.query(SQL_SELECT_BY_NAME, rowMapper, name);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(SQL_INSERT, new String[]{"id"});
            ps.setString(1, entity.getName());
            return ps;
        }, keyHolder);
        long generatedId = keyHolder.getKey().longValue();
        return findById(generatedId).get();
    }

    @Override
    public UserEntity updateById(UserEntity entity, Long id) {
        Optional<UserEntity> optionalUserEntity = findById(id);
        if(optionalUserEntity.isPresent()) {
            jdbcTemplate.update(SQL_UPDATE, entity.getName(), id);
            return findById(id).get();
        }
        throw new IllegalArgumentException("No id!");
    }

    @Override
    public boolean deleteById(Long id) {
        return jdbcTemplate.update(SQL_DELETE_BY_ID, id) == 1;
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
