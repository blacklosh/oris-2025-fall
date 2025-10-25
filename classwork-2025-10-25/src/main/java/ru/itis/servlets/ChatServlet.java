package ru.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("name", name);

        // TODO: достать уже существующие сообщения из базы
        List<String> messages = List.of("CHAT STARTED AT " + Instant.now());
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/jsp/chat.jsp").forward(req, resp);
    }
}
