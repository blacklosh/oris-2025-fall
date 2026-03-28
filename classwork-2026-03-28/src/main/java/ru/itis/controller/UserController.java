package ru.itis.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.dto.rq.AccountRequest;
import ru.itis.service.AccountService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final AccountService service;

    @GetMapping
    public String allUsersPage(Model model) {
        model.addAttribute("users", service.findAll());
        return "users_page";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("accountRequest", new AccountRequest());
        return "register_page";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid AccountRequest request, BindingResult result) {
        if(result.hasErrors()) {
            model.addAttribute("accountRequest", request);
            return "register_page";
        }
        return "redirect:/users";
    }
}
