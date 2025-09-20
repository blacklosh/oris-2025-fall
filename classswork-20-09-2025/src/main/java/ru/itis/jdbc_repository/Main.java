package ru.itis.jdbc_repository;

import ru.itis.jdbc_repository.model.UserEntity;
import ru.itis.jdbc_repository.repository.UserRepository;
import ru.itis.jdbc_repository.repository.impl.UserRepositoryJdbcImpl;

public class Main {

    public static void main(String[] args) {

        UserRepository repository = new UserRepositoryJdbcImpl();

        System.out.println(repository.findAll());
        System.out.println(repository.findById(4L));
        System.out.println(repository.findByName("Fedor"));

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.println(repository.save(UserEntity.builder().name("Fedor2").build()));
        System.out.println(repository.updateById(UserEntity.builder().name("Fedor3").build(), 7L));
        System.out.println(repository.deleteById(5L));

    }
}
