package ru.itis.listeners;

import ru.itis.config.DatabaseConfig;
import ru.itis.repository.UserRepository;
import ru.itis.repository.impl.UserRepositoryImpl;
import ru.itis.service.AuthDataValidationService;
import ru.itis.service.AuthService;
import ru.itis.service.PasswordEncoder;
import ru.itis.service.impl.AuthServiceImpl;
import ru.itis.service.impl.RegexpAuthDataValidationServiceImpl;
import ru.itis.service.impl.SimpleHashPasswordEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ProjectStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        UserRepository userRepository = new UserRepositoryImpl(DatabaseConfig.jdbcTemplate);
        AuthDataValidationService validationService = new RegexpAuthDataValidationServiceImpl();
        PasswordEncoder passwordEncoder = new SimpleHashPasswordEncoder();

        AuthService authService = new AuthServiceImpl(userRepository, validationService, passwordEncoder);
        context.setAttribute("authService", authService);
    }
}
