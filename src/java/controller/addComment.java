/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CommentDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Comment;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "addComment", urlPatterns = {"/addComment"})
public class addComment extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addComment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addComment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("sale");
        String commentContent = request.getParameter("commentContent");
        String productId = request.getParameter("productId");
        int productId1 = Integer.parseInt(productId);
        if (!isCommentLengthValid(commentContent)) {

            ProductDAO pDAO = new ProductDAO();
            CommentDAO c = new CommentDAO();
            ArrayList<Comment> cList = c.readAllComment();
            ProductDAO p = new ProductDAO();
            ArrayList pList = p.getAllProduct();
            request.setAttribute("msg", "Please enter comment length < 200 character");
            request.setAttribute("pList", pList);
            request.setAttribute("commentList", cList);
            request.getRequestDispatcher("manageComment.jsp").forward(request, response);
            return;
        }
        CommentDAO c = new CommentDAO();
        boolean flag = c.insertComment(u, commentContent, productId1);
        if (flag) {

           ProductDAO pDAO = new ProductDAO();
            
            ArrayList<Comment> cList = c.readAllComment();
            ProductDAO p = new ProductDAO();
            ArrayList pList = p.getAllProduct();
            request.setAttribute("success", "Added comment");
            request.setAttribute("pList", pList);
            request.setAttribute("commentList", cList);
            request.getRequestDispatcher("manageComment.jsp").forward(request, response);
        }
    }

    public boolean isCommentLengthValid(String commentContent) {
        if (commentContent != null) {
            int length = commentContent.length();
            return length > 0 && length <= 200;
        }
        return false;
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