package com.ecommerce.controller;

import com.ecommerce.model.CartItem;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart != null && cart.containsKey(productId)) {
            if ("update".equals(action)) {
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                if (quantity > 0) {
                    cart.get(productId).setQuantity(quantity);
                } else {
                    cart.remove(productId); // zero = remove
                }
            } else if ("remove".equals(action)) {
                cart.remove(productId);
            }
        }

        response.sendRedirect("cart.jsp");
    }
}
