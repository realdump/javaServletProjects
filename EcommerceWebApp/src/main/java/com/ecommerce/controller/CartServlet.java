package com.ecommerce.controller;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;



public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDAO dao = new ProductDAO();
        Product product = dao.getProductById(productId); // You’ll create this method

        HttpSession session = request.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        CartItem item = cart.get(productId);
        if (item == null) {
            cart.put(productId, new CartItem(product, 1));
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
        session.setAttribute("cart", cart);

        response.sendRedirect("cart.jsp");
        
    }
}
