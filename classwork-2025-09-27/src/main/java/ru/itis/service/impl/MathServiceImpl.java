package ru.itis.service.impl;

import ru.itis.service.MathService;

public class MathServiceImpl implements MathService {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
