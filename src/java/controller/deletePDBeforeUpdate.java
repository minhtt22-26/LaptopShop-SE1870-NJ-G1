/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.ProductDetail;

/**
 *
 * @author ADMIN
 */
public class deletePDBeforeUpdate extends HttpServlet {

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
            out.println("<title>Servlet deletePDBeforeUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deletePDBeforeUpdate at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        int id1 = 0;
        try {
            id1 = Integer.parseInt(id);
        } catch (Exception e) {
            // Log lỗi nếu cần thiết
        }

// Lấy productId từ session
        int productId = (int) session.getAttribute("productId");

// Lấy danh sách ProductDetail hiện tại
        ProductDetailDAO pD = new ProductDetailDAO();
        ArrayList<ProductDetail> pDList = pD.getAllProductDetailById(productId);

// Kiểm tra nếu chỉ còn 1 sản phẩm thì không cho phép xóa
        if (pDList.size() <= 1) {
            // Nếu chỉ còn 1 sản phẩm, không cho phép xóa và chuyển hướng lại trang với thông báo lỗi
            session.setAttribute("errorMessage", "You cannot delete the last product variant.");
            response.sendRedirect("inputProductDetail.jsp");
        } else {
            // Nếu có nhiều hơn 1 sản phẩm, thực hiện hành động xóa
            ProductDetailDAO dao = new ProductDetailDAO();
            dao.deletePDBeforeUpdate(id1);

            // Xóa danh sách cũ và cập nhật danh sách mới sau khi xóa
            session.removeAttribute("pDList");
            ArrayList<ProductDetail> updatedPDList = pD.getAllProductDetailById(productId);
            session.setAttribute("pDList", updatedPDList);

            // Chuyển hướng lại trang
            response.sendRedirect("inputProductDetail.jsp");
        }

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