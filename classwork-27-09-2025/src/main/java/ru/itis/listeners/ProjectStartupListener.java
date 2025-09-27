package ru.itis.listeners;

import ru.itis.service.MathService;
import ru.itis.service.impl.JavaScriptMathServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ProjectStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        MathService mathService = new JavaScriptMathServiceImpl();
        context.setAttribute("mathService", mathService);
    }
}
