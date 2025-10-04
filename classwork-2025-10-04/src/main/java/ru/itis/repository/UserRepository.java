package ru.itis.repository;

import ru.itis.model.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findByEmail(String email);

    void save(UserEntity entity);

}
