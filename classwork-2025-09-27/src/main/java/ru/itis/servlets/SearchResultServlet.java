package ru.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/form-data/result")
public class SearchResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String q = rq.getParameter("q");
        System.out.println("QUERY " + q);
        rq.setAttribute("query1", q);
        rq.getRequestDispatcher("/jsp/results.jsp").forward(rq, rs);
    }
}
