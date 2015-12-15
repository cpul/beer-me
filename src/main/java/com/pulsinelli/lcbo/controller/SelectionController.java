package com.pulsinelli.lcbo.controller;

import com.pulsinelli.lcbo.model.User;
import com.pulsinelli.lcbo.services.BeerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/select")
public class SelectionController extends HttpServlet {

    private BeerService beerService;

    public SelectionController() {
        beerService = new BeerService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            // user needs to login... send them outta here
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/logout");
            dispatcher.forward(req, resp);
        }

        User user = (User) session.getAttribute("user");
        Integer lcboProductId = Integer.parseInt(req.getParameter("bid"));
        Integer bid = beerService.getBeerIdForBeerProductId(lcboProductId);
        if (!beerService.hasBeerBeenTriedBefore(user, bid)) {
            beerService.setBeerUserTried(user, bid, null, new Date());    // TODO: ask users for ratings
        }

        beerService.getBeerIdForBeerProductId(lcboProductId);

        resp.sendRedirect(req.getContextPath()+"/home");


    }
}
