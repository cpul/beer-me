package com.pulsinelli.lcbo.controller;

import com.pulsinelli.lcbo.LcboApiService;
import com.pulsinelli.lcbo.domain.Inventory;
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
import java.util.Random;

@WebServlet("/try-me")
public class SuggestionController extends HttpServlet {

    private BeerService beerService;
    private LcboApiService lcboApiService;
    private Random random;

    public SuggestionController() {
        beerService = new BeerService();
        lcboApiService = LcboUtil.getLcboApiService();
        random = new Random();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            // user needs to login... send them outta here
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/logout");
            dispatcher.forward(req, resp);
        }

        User user = (User)session.getAttribute("user");

        ArrayList<Integer> idsOfBeersNotYetTried = beerService.getLcboBeerIdsNotYetTried(user);

        Integer lcboBeerIdToTry = null;
        Integer indexToTry = null;
        LcboResponse<Inventory> inventoryLcboResponse;
        Inventory inventory = null;
        do {
            if (indexToTry != null) {
                idsOfBeersNotYetTried.remove(indexToTry);
            }
            indexToTry = new Random().nextInt(idsOfBeersNotYetTried.size());
            lcboBeerIdToTry = idsOfBeersNotYetTried.get(indexToTry);
            try {
                inventoryLcboResponse = lcboApiService.getProductInventoryForStore(lcboBeerIdToTry, 511);
                inventory = inventoryLcboResponse.result;
            } catch (RetrofitError re) {
                // TODO: do something...
                idsOfBeersNotYetTried.remove(indexToTry);
                indexToTry = null;
                continue;
            }
        } while (inventory == null || idsOfBeersNotYetTried.size() > 0 && (inventory.getIsDead() || inventory.getQuantity() < 1));

        LcboResponse<Product> response = lcboApiService.getProductById(lcboBeerIdToTry);
        Product tryThisBeer = response.result;

        req.setAttribute("beer", tryThisBeer);
        req.setAttribute("quantity", inventory.getQuantity());

        req.getRequestDispatcher("/try-this.jsp").forward(req, resp);

    }
}
