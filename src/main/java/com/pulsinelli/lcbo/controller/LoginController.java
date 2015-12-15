package com.pulsinelli.lcbo.controller;

import com.pulsinelli.lcbo.model.User;
import com.pulsinelli.lcbo.services.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserService userService;

    public LoginController() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath()+"/home");
            return;
        }

        if (!userService.isUsernameAlreadyRegistered(username)) {
            req.setAttribute("error", "Could not find user " + username + ". Check its spelling or register if you aren't registered yet.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        else {
            User user = userService.getUser(username);
            if (!BCrypt.checkpw(password, user.getPassword())) {
                req.setAttribute("error", "Could not sign you in. Please check your username and password.");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
            // these are the droids we are looking for
            session = req.getSession(true); // creates a new session if no session available
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath()+"/home");
        }
    }
}
