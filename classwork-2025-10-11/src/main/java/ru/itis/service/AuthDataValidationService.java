package ru.itis.service;

import ru.itis.dto.FieldErrorDto;

import java.util.List;

public interface AuthDataValidationService {

    List<FieldErrorDto> validateEmail(String email);
    List<FieldErrorDto> validatePassword(String password);
    List<FieldErrorDto> validateNickname(String nickname);

}
