package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import ru.itis.dto.FieldErrorDto;
import ru.itis.dto.request.SignInRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.AuthResponse;
import ru.itis.model.UserEntity;
import ru.itis.repository.UserRepository;
import ru.itis.service.AuthDataValidationService;
import ru.itis.service.AuthService;
import ru.itis.service.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthDataValidationService validationService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signUp(SignUpRequest request) {
        List<FieldErrorDto> errors = new ArrayList<>();
        errors.addAll(validationService.validateEmail(request.getEmail()));
        errors.addAll(validationService.validatePassword(request.getPassword()));
        errors.addAll(validationService.validateNickname(request.getNickname()));

        if(!errors.isEmpty()) return fail(errors);

        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            errors.add(new FieldErrorDto("email", "Email taken"));
            return fail(errors);
        }

        userRepository.save(UserEntity.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
        return ok();
    }

    @Override
    public AuthResponse signIn(SignInRequest request) {
        List<FieldErrorDto> errors = new ArrayList<>();
        errors.addAll(validationService.validateEmail(request.getEmail()));
        errors.addAll(validationService.validatePassword(request.getPassword()));

        if(!errors.isEmpty()) return fail(errors);

        Optional<UserEntity> optionalUser = userRepository.findByEmail(request.getEmail());
        if(optionalUser.isEmpty()) {
            errors.add(new FieldErrorDto("email", "Email not found"));
            return fail(errors);
        }
        if(!passwordEncoder.matches(request.getPassword(), optionalUser.get().getPassword())) {
            errors.add(new FieldErrorDto("password", "Password incorrect"));
            return fail(errors);
        }
        return ok();
    }

    private AuthResponse fail(List<FieldErrorDto> errors) {
        return AuthResponse.builder()
                .success(false)
                .errors(errors)
                .build();
    }

    private AuthResponse ok() {
        return AuthResponse.builder()
                .success(true)
                .build();
    }
}
