package ru.itis.filter;

import ru.itis.util.CookieSearchUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/*")
public class ColorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;

        Optional<String> optionalColor = CookieSearchUtil
                .findCookieByName(rq.getCookies(), "color");

        rq.setAttribute("color", optionalColor.orElse("green"));

        chain.doFilter(request, response);
    }
}
