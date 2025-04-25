package com.example.servlet;

import com.example.dao.ProductDAO;
import com.example.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class CartServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Product p : productDAO.getAllProducts()) {
                if (p.getId() == id) cart.add(p);
            }
            session.setAttribute("cart", cart);
            response.sendRedirect("cart");
            return;
        }

        request.setAttribute("cart", cart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }
}
