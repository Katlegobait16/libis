package com.libis.controller;

import com.libis.model.LibisData;
import com.libis.model.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/process-signup")
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (firstName == null || firstName.isBlank()
                || lastName == null || lastName.isBlank()
                || email == null || !email.contains("@")
                || password == null || password.isBlank()) {
            request.setAttribute("errorMessage", "Please fill in every field.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        int newId = LibisData.getMembers().size() + 1;
        Member newMember = new Member(newId, firstName, lastName, email, password);
        LibisData.addMember(newMember);

        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}