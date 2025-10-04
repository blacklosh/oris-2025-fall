package ru.itis.servlets;

import ru.itis.dto.FieldErrorDto;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.AuthResponse;
import ru.itis.service.AuthService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

    private AuthService authService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        authService = (AuthService) config.getServletContext().getAttribute("authService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.nonNull(req.getSession().getAttribute("email"))) {
            resp.sendRedirect("/profile");
        } else {
            List<FieldErrorDto> errors = (List<FieldErrorDto>) req.getSession().getAttribute("errors");
            if(Objects.nonNull(errors)) {
                req.setAttribute("errors", errors);
            }
            req.getRequestDispatcher("/jsp/sign-up.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpRequest request = SignUpRequest.builder()
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .nickname(req.getParameter("nickname"))
                .build();
        AuthResponse authResponse = authService.signUp(request);
        if(!authResponse.isSuccess()) {
            req.getSession(true).setAttribute("errors", authResponse.getErrors());
            resp.sendRedirect("/sign-up");
        } else {
            req.getSession(true).setAttribute("errors", null);
            resp.sendRedirect("/sign-in");
        }
    }
}
