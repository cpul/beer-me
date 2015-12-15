package com.pulsinelli.lcbo.controller;

import com.pulsinelli.lcbo.services.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {

    private static final String LOGIN_PAGE = "/login.jsp";
    private static final String REGISTER_PAGE = "/register.jsp";

    private UserService userService;

    public RegistrationController() {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        boolean isError = false;
        if (userService.isUsernameAlreadyRegistered(username)) {
            req.setAttribute("message", "Username already exists. Please try another username.");
            isError = true;
        }

        if (!isError && userService.isEmailAlreadyRegistered(email)) {
            req.setAttribute("message", "Email is already registered. Please try to login instead.");
            isError = true;
        }

        if(!isError) {
            // get the bcrypt hash
            String passHash = BCrypt.hashpw(password, BCrypt.gensalt(10));
            InputStream passStream = new ByteArrayInputStream(passHash.getBytes(StandardCharsets.UTF_8));

            userService.insertUser(username, email, passStream, passHash.length());
        }
        if (!isError) {
            req.setAttribute("register_message", "Please log in to finish the registration process");
            req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
        } else {
            req.getRequestDispatcher(REGISTER_PAGE).forward(req, resp);
        }
    }
}
