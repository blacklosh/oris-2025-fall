package ru.itis.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class ErrorsClearingFilter implements Filter {

    private static final List<String> ALLOWED_ERRORS = List.of("/sign-in", "/sign-up");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        String mapping = rq.getRequestURI();
        if(!ALLOWED_ERRORS.contains(mapping)) {
            rq.getSession(true).setAttribute("errors", null);
        }
        chain.doFilter(request, response);
    }
}
