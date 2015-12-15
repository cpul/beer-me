package com.pulsinelli.lcbo.controller;

import com.pulsinelli.lcbo.LcboApiService;
import com.pulsinelli.lcbo.domain.LcboResponse;
import com.pulsinelli.lcbo.domain.Product;
import com.pulsinelli.lcbo.model.User;
import com.pulsinelli.lcbo.services.BeerService;
import com.pulsinelli.lcbo.util.LcboUtil;
import retrofit.RetrofitError;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private BeerService beerService;
    private LcboApiService lcboApiService;

    public HomeController() {
        beerService = new BeerService();
        lcboApiService = LcboUtil.getLcboApiService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get their rated beers
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            // user needs to login... send them outta here
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(req.getContextPath()+"/logout");
            dispatcher.forward(req, resp);
        }

        User user = (User) session.getAttribute("user");

        req.setAttribute("user", user);
        ArrayList<Integer> triedBeerIds =  beerService.getProductIdsOfTriedBeers(user);
        ArrayList<Product> triedBeers = getBeersForProductIds(triedBeerIds);
        req.setAttribute("triedBeers", triedBeers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }

    private ArrayList<Product> getBeersForProductIds(ArrayList<Integer> lcboProductIds) {
        ArrayList<Product> beers = new ArrayList<Product>();

        for (int i = 0; i < lcboProductIds.size(); i++) {
            int bid = lcboProductIds.get(i);
            int productId = beerService.getLcboProductIdForBeerId(bid);
            LcboResponse<Product> response = lcboApiService.getProductById(productId);
            Product p = response.result;
            beers.add(p);
        }
        return beers;
    }

}
