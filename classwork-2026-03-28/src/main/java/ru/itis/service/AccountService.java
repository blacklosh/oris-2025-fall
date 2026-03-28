package ru.itis.service;

import ru.itis.dto.rs.AccountResponse;

import java.util.List;

public interface AccountService {

    List<AccountResponse> findAll();

}
