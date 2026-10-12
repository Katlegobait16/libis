package com.libis.controller;

import com.libis.model.Book;
import com.libis.model.LibisData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Only logged-in members may change books
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("member") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String action = request.getParameter("action");

        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            return;
        }

        if ("delete".equals(action)) {
            LibisData.deleteBook(id);
        } else if ("update".equals(action)) {
            Book book = LibisData.findBook(id);
            if (book != null) {
                book.setTitle(request.getParameter("title"));
                book.setAuthor(request.getParameter("author"));
                book.setGenre(request.getParameter("genre"));
                book.setSynopsis(request.getParameter("synopsis"));
                book.setAvailable(request.getParameter("available") != null);
            }
        }

        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
}
