/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CartDAOS;
import dal.ImageDAOS;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.CartItem;
import model.Image;
import model.User;

/**
 *
 * @author ADMIN
 */
//@WebServlet(name="LoadProductCart", urlPatterns={"/loadProductCart"})
public class LoadProductCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        CartDAOS cartDAO = new CartDAOS();
        Cart cartUser = cartDAO.getCartByUserID(user.getId());


        if (cartUser == null) {
            cartDAO.addToCart(user.getId());
            cartUser = cartDAO.getCartByUserID(user.getId());
        }
        
        
        List<CartItem> listCartItem = cartDAO.getAllProductOfCartItem(cartUser.getId());

        ImageDAOS iDAO = new ImageDAOS();

        List<Image> listImages = new ArrayList<>();

        for (int i = 0; i < listCartItem.size(); i++) {
            int productDetailId = listCartItem.get(i).getProductdetail().getId();
            Image image = iDAO.getOneImageByProductDetailID(productDetailId);
            listImages.add(image); // Thêm hình ảnh vào danh sách
        }

        request.setAttribute("listImages", listImages);
        request.setAttribute("listCartItem", listCartItem);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
