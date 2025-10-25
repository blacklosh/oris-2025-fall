package ru.itis.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebFilter("/*")
public class AuthFilter implements Filter {
    private static final List<String> PRIVATE_MAPPINGS = List.of("/profile", "/logout");
    private static final List<String> NOT_ALLOWED_FOR_AUTHENTICATED_MAPPINGS = List.of("/sign-in", "/sign-up");
    private static final String DEFAULT_AUTH_REDIRECT = "/profile";
    private static final String DEFAULT_NO_AUTH_REDIRECT = "/sign-in";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;

        String email = (String) rq.getSession(true).getAttribute("email");
        String mapping = rq.getRequestURI();

        if(Objects.isNull(email)) {
            // Обрабатываем НЕ залогиненного пользователя
            if(PRIVATE_MAPPINGS.contains(mapping)) {
                // он лезет куда нельзя
                rs.sendRedirect(DEFAULT_NO_AUTH_REDIRECT);
            } else {
                // ему можно
                chain.doFilter(request, response);
            }
        } else {
            // Обратываем залогиненного пользователя
            if(NOT_ALLOWED_FOR_AUTHENTICATED_MAPPINGS.contains(mapping)) {
                // он лезет куда нельзя
                rs.sendRedirect(DEFAULT_AUTH_REDIRECT);
            } else {
                // ему можно
                rq.setAttribute("email", email);
                chain.doFilter(request, response);
            }
        }
    }
}
