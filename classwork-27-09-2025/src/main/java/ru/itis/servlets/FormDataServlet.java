package ru.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/form-data")
public class FormDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.getRequestDispatcher("/jsp/form.jsp").forward(rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String query = rq.getParameter("query");
        System.out.println("NEW DATA: " + query);
        rs.setCharacterEncoding(StandardCharsets.UTF_8.name());
        rs.sendRedirect("https://ya.ru/search?text=" + query);
    }
}
