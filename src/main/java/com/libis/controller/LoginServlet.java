package com.libis.controller;

import com.libis.model.LibisData;
import com.libis.model.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/process-login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<Member> members = LibisData.getMembers();
        Member foundMember = null;

        for (int i = 0; i < members.size(); i++) {
            Member m = members.get(i);
            if (m.getEmail().equals(email) && m.getPassword().equals(password)) {
                foundMember = m;
            }
        }

        if (foundMember != null) {
            HttpSession session = request.getSession();
            request.changeSessionId();
            session.setAttribute("member", foundMember);
            session.setAttribute("books", LibisData.getBooks());
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
            request.setAttribute("errorMessage", "Wrong email or password.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}