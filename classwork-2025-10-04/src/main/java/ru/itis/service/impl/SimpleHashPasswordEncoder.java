package ru.itis.service.impl;

import ru.itis.service.PasswordEncoder;

import java.util.Objects;

public class SimpleHashPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String rawPassword) {
        return "HASH" + Objects.hashCode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String hashPassword) {
        return encode(rawPassword).equals(hashPassword);
    }
}
