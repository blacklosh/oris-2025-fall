package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainPageController {

    @Value("${app.hello-message}")
    private String helloMessage;

    private final MessageSource messageSource;

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("msg", helloMessage);
        return "main_page";
    }

    @GetMapping("/hello")
    public String getHelloPage(Model model, Locale locale) {
        String message = messageSource.getMessage("KEY1", new Object[]{}, locale);
        String message2 = messageSource.getMessage("KEY2", new Object[]{"Fedor"}, locale);
        model.addAttribute("msg1", message);
        model.addAttribute("msg2", message2);
        return "hello_page";
    }

    @GetMapping("/test")
    public String getTestPage() {
        return "test_page";
    }
}
