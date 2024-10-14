/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Order;
import java.util.List;
import model.Order;
import model.ProductDetail;
import model.User;
import model.Voucher;
import model.OrderDetail;

/**
 *
 * @author ADMIN
 */
public class OderDAO extends DBContext {

    public void insertOrderOfCODNoVoucher(int uid, String name, String address, String phone,
            LocalDateTime odate, int totalAmountBeFore, int totalAmountAfter, String paymentMethod, String note) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([UserId]\n"
                + "           ,[Name]\n"
                + "           ,[Address]\n"
                + "           ,[Phone]\n"
                + "           ,[OrderDate]\n"
                + "           ,[TotalAmountBefore]\n"
                + "           ,[TotalAmountAfter]\n"
                + "           ,[PaymentMethod]\n"
                + "           ,[OrderStatus]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?, ?, 'wait', ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, name);
            st.setString(3, address);
            st.setString(4, phone);
            st.setObject(5, odate);
            st.setInt(6, totalAmountBeFore);
            st.setInt(7, totalAmountAfter);
            st.setString(8, paymentMethod);
            st.setString(9, note);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void insertOrderOfCOD(int uid, String name, String address, String phone,
            LocalDateTime odate, int voucherID, int totalAmountBeFore, int discountAmount,
            int totalAmountAfter, String paymentMethod, String note) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([UserId]\n"
                + "           ,[Name]\n"
                + "           ,[Address]\n"
                + "           ,[Phone]\n"
                + "           ,[OrderDate]\n"
                + "           ,[VoucherId]\n"
                + "           ,[TotalAmountBefore]\n"
                + "           ,[DiscountAmount]\n"
                + "           ,[TotalAmountAfter]\n"
                + "           ,[PaymentMethod]\n"
                + "           ,[OrderStatus]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'wait', ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, name);
            st.setString(3, address);
            st.setString(4, phone);
            st.setObject(5, odate);
            st.setObject(6, voucherID);
            st.setInt(7, totalAmountBeFore);
            st.setInt(8, discountAmount);
            st.setInt(9, totalAmountAfter);
            st.setString(10, paymentMethod);
            st.setString(11, note);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void insertOrderOfPaymentNoVoucher(int uid, String name, String address, String phone,
            LocalDateTime odate, int totalAmountBeFore, int totalAmountAfter,
            String paymentMethod, String VnPayId, String note) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([UserId]\n"
                + "           ,[Name]\n"
                + "           ,[Address]\n"
                + "           ,[Phone]\n"
                + "           ,[OrderDate]\n"
                + "           ,[TotalAmountBefore]\n"
                + "           ,[TotalAmountAfter]\n"
                + "           ,[PaymentMethod]\n"
                + "           ,[PaymentStatus]\n"
                + "           ,[VnPayTransactionId]\n"
                + "           ,[OrderStatus]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?, ?, 'pending', ?,'wait', ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, name);
            st.setString(3, address);
            st.setString(4, phone);
            st.setObject(5, odate);
            st.setInt(6, totalAmountBeFore);
            st.setInt(7, totalAmountAfter);
            st.setString(8, paymentMethod);
            st.setString(9, VnPayId);
            st.setString(10, note);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void insertOrderOfPayment(int uid, String name, String address, String phone,
            LocalDateTime odate, int voucherID, int totalAmountBeFore,
            int discountAmount, int totalAmountAfter,
            String paymentMethod, String VnPayId, String note) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([UserId]\n"
                + "           ,[Name]\n"
                + "           ,[Address]\n"
                + "           ,[Phone]\n"
                + "           ,[OrderDate]\n"
                + "           ,[VoucherId]\n"
                + "           ,[TotalAmountBefore]\n"
                + "           ,[DiscountAmount]\n"
                + "           ,[TotalAmountAfter]\n"
                + "           ,[PaymentMethod]\n"
                + "           ,[PaymentStatus]\n"
                + "           ,[VnPayTransactionId]\n"
                + "           ,[OrderStatus]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'pending', ?,'wait', ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setString(2, name);
            st.setString(3, address);
            st.setString(4, phone);
            st.setObject(5, odate);
            st.setInt(6, voucherID);
            st.setInt(7, totalAmountBeFore);
            st.setInt(8, discountAmount);
            st.setInt(9, totalAmountAfter);
            st.setString(10, paymentMethod);
            st.setString(11, VnPayId);
            st.setString(12, note);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public int getIdOfOrderNewest() {
        String sql = "SELECT TOP(1) Id FROM [Order] ORDER BY Id DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                return oid;
            }

        } catch (Exception e) {
        }
        return -1;
    }

    public void insertOrderDetail(int oid, int pid, int qlt, int unitPrice) {
        String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                + "           ([OrderId]\n"
                + "           ,[ProductDetailId]\n"
                + "           ,[Quantity]\n"
                + "           ,[UnitPrice])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, oid);
            st.setInt(2, pid);
            st.setInt(3, qlt);
            st.setInt(4, unitPrice);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Order getOneOrderNewest(int uid) {
        String sql = "SELECT TOP(1) * FROM [Order] WHERE UserId = ? ORDER BY Id DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                UserDAO uDAO = new UserDAO();
                VoucherDAO vDAO = new VoucherDAO();
                LocalDateTime endDate = rs.getTimestamp("EndDate") != null ? rs.getTimestamp("EndDate").toLocalDateTime() : null;
                Order o = new Order(rs.getInt("Id"),
                        uDAO.getUserByIdD(rs.getInt("UserID")),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getTimestamp("OrderDate").toLocalDateTime(),
                        vDAO.getVoucherByID(rs.getInt("VoucherID")),
                        rs.getInt("TotalAmountBefore"),
                        rs.getInt("DiscountAmount"),
                        rs.getInt("TotalAmountAfter"),
                        rs.getString("PaymentMethod"),
                        rs.getString("PaymentStatus"),
                        rs.getString("VnPayTransactionId"),
                        endDate,
                        rs.getString("OrderStatus"));
                return o;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean updateNewestOrderContactInfo(int userId, String newPhone, String newAddress, String newUsername) {
        String sql = "UPDATE [Order] "
                + "SET Phone = ?, Address = ?, Name = ? "
                + "WHERE Id = (SELECT TOP(1) Id FROM [Order] WHERE UserId = ? ORDER BY Id DESC)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newPhone);    // Đặt giá trị cho Phone
            st.setString(2, newAddress);  // Đặt giá trị cho Address
            st.setString(3, newUsername); // Đặt giá trị cho Name (username)
            st.setInt(4, userId);         // Đặt giá trị cho UserId

            int rowsUpdated = st.executeUpdate();

            if (rowsUpdated > 0) {
                return true; // Cập nhật thành công
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Cập nhật thất bại
    }


    public List<Order> getAllOrder() {
        String sql = "SELECT * FROM [Order]";
        List<Order> listOrder = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                UserDAO uDAO = new UserDAO();
                VoucherDAO vDAO = new VoucherDAO();
                LocalDateTime endDate = rs.getTimestamp("EndDate") != null ? rs.getTimestamp("EndDate").toLocalDateTime() : null;
                Order o = new Order(rs.getInt("Id"),
                        uDAO.getUserByIdD(rs.getInt("UserID")),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getTimestamp("OrderDate").toLocalDateTime(),
                        vDAO.getVoucherByID(rs.getInt("VoucherID")),
                        rs.getInt("TotalAmountBefore"),
                        rs.getInt("DiscountAmount"),
                        rs.getInt("TotalAmountAfter"),
                        rs.getString("PaymentMethod"),
                        rs.getString("PaymentStatus"),
                        rs.getString("VnPayTransactionId"),
                        endDate,
                        rs.getString("OrderStatus"),
                        rs.getString("Note"));
                listOrder.add(o);
            }

        } catch (Exception e) {
        }
        return listOrder;
    }

    public void changePaymentStatus(String op, int id) {
        String sql = "UPDATE [dbo].[Order] SET[PaymentStatus] = ? WHERE Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, op);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void changeOrderStatus(String op, int id) {
        String sql = "UPDATE [dbo].[Order] SET[OrderStatus] = ? WHERE Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, op);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Order getOrderByID(int id) {
        String sql = "SELECT * FROM [Order] WHERE Id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                UserDAO uDAO = new UserDAO();
                VoucherDAO vDAO = new VoucherDAO();
                LocalDateTime endDate = rs.getTimestamp("EndDate") != null ? rs.getTimestamp("EndDate").toLocalDateTime() : null;
                Order o = new Order(rs.getInt("Id"),
                        uDAO.getUserByIdD(rs.getInt("UserID")),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getTimestamp("OrderDate").toLocalDateTime(),
                        vDAO.getVoucherByID(rs.getInt("VoucherID")),
                        rs.getInt("TotalAmountBefore"),
                        rs.getInt("DiscountAmount"),
                        rs.getInt("TotalAmountAfter"),
                        rs.getString("PaymentMethod"),
                        rs.getString("PaymentStatus"),
                        rs.getString("VnPayTransactionId"),
                        endDate,
                        rs.getString("OrderStatus"),
                        rs.getString("Note"));
                return o;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<OrderDetail> getAllOrdetailByID(int id) {
        String sql = "SELECT * FROM OrderDetail WHERE OrderId = ?";
        List<OrderDetail> listODetail = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                OderDAO oDAO = new OderDAO();
                ProductDAOS pDAO = new ProductDAOS();
                OrderDetail odt = new OrderDetail(
                        rs.getInt("Id"),
                        oDAO.getOrderByID(rs.getInt("OrderID")),
                        pDAO.getProductDetailByID(rs.getInt("ProductDetailID")),
                        rs.getInt("Quantity"),
                        rs.getInt("UnitPrice"));
                listODetail.add(odt);
            }
        } catch (Exception e) {
        }
        return listODetail;
    }

    public List<Order> getOrderByOrderStatus(String status) {
        String sql = "SELECT * FROM [Order] WHERE [OrderStatus] = ?";
        List<Order> listOrder = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserDAO uDAO = new UserDAO();
                VoucherDAO vDAO = new VoucherDAO();
                LocalDateTime endDate = rs.getTimestamp("EndDate") != null ? rs.getTimestamp("EndDate").toLocalDateTime() : null;
                Order o = new Order(rs.getInt("Id"),
                        uDAO.getUserByIdD(rs.getInt("UserID")),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getTimestamp("OrderDate").toLocalDateTime(),
                        vDAO.getVoucherByID(rs.getInt("VoucherID")),
                        rs.getInt("TotalAmountBefore"),
                        rs.getInt("DiscountAmount"),
                        rs.getInt("TotalAmountAfter"),
                        rs.getString("PaymentMethod"),
                        rs.getString("PaymentStatus"),
                        rs.getString("VnPayTransactionId"),
                        endDate,
                        rs.getString("OrderStatus"),
                        rs.getString("Note"));
                listOrder.add(o);
            }
        } catch (Exception e) {
        }
        return listOrder;
    }

    public void updateEnddate(LocalDateTime endDate, int id) {
        String sql = "UPDATE [dbo].[Order] SET [EndDate] = ?   WHERE Id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setTimestamp(1, Timestamp.valueOf(endDate));
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        OderDAO o = new OderDAO();

        List<OrderDetail> l = o.getAllOrdetailByID(2);
        System.out.println(l);
        
        //o.updateEnddate(LocalDateTime.now(), 27);

    }
}
