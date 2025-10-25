package ru.itis.service;

import ru.itis.dto.request.SignInRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse signUp(SignUpRequest request);

    AuthResponse signIn(SignInRequest request);
}
