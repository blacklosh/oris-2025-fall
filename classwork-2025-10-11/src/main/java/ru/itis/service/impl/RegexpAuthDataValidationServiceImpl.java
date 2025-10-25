package ru.itis.service.impl;

import ru.itis.dto.FieldErrorDto;
import ru.itis.service.AuthDataValidationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegexpAuthDataValidationServiceImpl implements AuthDataValidationService {

    @Override
    public List<FieldErrorDto> validateEmail(String email) {
        List<FieldErrorDto> errors = new ArrayList<>();
        if(Objects.isNull(email)) {
            errors.add(new FieldErrorDto("email", "Email is null"));
        } else {
            if(email.length() < 5) {
                errors.add(new FieldErrorDto("email", "Email too short"));
            }
            if(!email.matches("\\S+@\\S+\\.\\S+")) {
                errors.add(new FieldErrorDto("email", "Email format invalid"));
            }
        }
        return errors;
    }

    @Override
    public List<FieldErrorDto> validatePassword(String password) {
        List<FieldErrorDto> errors = new ArrayList<>();
        if(Objects.isNull(password)) {
            errors.add(new FieldErrorDto("password", "Password is null"));
        } else {
            if(password.length() < 5) {
                errors.add(new FieldErrorDto("password", "Password too short"));
            }
            if(!password.matches("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).*")) {
                errors.add(new FieldErrorDto("password", "Password format invalid"));
            }
        }
        return errors;
    }

    @Override
    public List<FieldErrorDto> validateNickname(String nickname) {
        List<FieldErrorDto> errors = new ArrayList<>();
        if(Objects.isNull(nickname)) {
            errors.add(new FieldErrorDto("nickname", "Nickname is null"));
        }
        return errors;
    }
}
