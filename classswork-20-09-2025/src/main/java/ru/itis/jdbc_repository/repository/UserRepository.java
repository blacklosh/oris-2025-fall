package ru.itis.jdbc_repository.repository;

import ru.itis.jdbc_repository.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    List<UserEntity> findByName(String name);
    UserEntity save(UserEntity entity);
    UserEntity updateById(UserEntity entity, Long id);
    boolean deleteById(Long id);
}
