package ru.itis.servlets;

import ru.itis.service.MathService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/math")
public class MathServlet extends HttpServlet {

    private MathService mathService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        mathService = (MathService) config.getServletContext().getAttribute("mathService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("p1"));
        int b = Integer.parseInt(req.getParameter("p2"));
        resp.getWriter().println("<h1>Your result: " + mathService.sum(a, b) + "</h1>");
    }

}
