package ru.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String color = (String) session.getAttribute("color");

        req.setAttribute("color", color != null ? color : "orange");
        req.getRequestDispatcher("/jsp/session.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");

        HttpSession session = req.getSession(true);
        session.setAttribute("color", color);

        resp.sendRedirect("/session");
    }
}
