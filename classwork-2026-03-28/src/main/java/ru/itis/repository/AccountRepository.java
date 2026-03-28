package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
