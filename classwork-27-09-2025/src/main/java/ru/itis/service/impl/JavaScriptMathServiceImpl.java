package ru.itis.service.impl;

import ru.itis.service.MathService;

public class JavaScriptMathServiceImpl implements MathService {
    @Override
    public int sum(int a, int b) {
        return Integer.parseInt(a + "" + b);
    }
}
