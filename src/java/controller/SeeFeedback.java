/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import dal.FeedbackDAOS;
import java.util.List;
/**
 *
 * @author PHONG
 */
@WebServlet(name = "SeeFeedback", urlPatterns = {"/seefeedback"})
public class SeeFeedback extends HttpServlet {

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
            out.println("<title>Servlet SeeFeedback</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SeeFeedback at " + request.getContextPath() + "</h1>");
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
        FeedbackDAOS dao = new FeedbackDAOS();
        int odid = Integer.parseInt(request.getParameter("orderdetailid"));
        Feedback myfeedback = dao.getFeedbackById(odid);
        OrderDetail orderdetail = dao.getOrderDetail(odid);
        Image productimage = dao.getImageByProductDetailId(orderdetail.getProductDetail().getId());
        String message=null;
        if (orderdetail.getOrder().getOrderStatus().compareToIgnoreCase("done") != 0){
            message="You cannot give feedback when the order has not been delivered successfully!";
        }
        if (myfeedback!=null){
        List<Feedback> listreply = dao.getListReplyFeedback(myfeedback.getId());
        request.setAttribute("listreply", listreply);
        request.setAttribute("number", listreply.size());
        }
        
        
        request.setAttribute("orderdetail", orderdetail);
        request.setAttribute("myfeedback", myfeedback);
        request.setAttribute("productimage", productimage);
        request.setAttribute("message", message);
        
        request.getRequestDispatcher("feedback.jsp").forward(request, response);
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
}
