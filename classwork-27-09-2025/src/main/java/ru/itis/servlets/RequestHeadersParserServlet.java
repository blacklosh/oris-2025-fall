package ru.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/headers")
public class RequestHeadersParserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getHeader("X-User-Name");
        String email = req.getHeader("X-User-Email");
        resp.getWriter().println("<h1>Добро пожаловать, " + username + "!<hr>Ваш email: " + email + "</h1>");
    }
}
