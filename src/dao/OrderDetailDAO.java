package dao;

import enums.ProductStatusEnum;
import model.OrderDetail;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailDAO implements DAO<OrderDetail> {
    @Override
    public boolean insert(OrderDetail orderDetail) throws SQLException {
        String sql = "INSERT INTO order_detail (order_id, product_id, quantity, create_at, update_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderDetail.getProductId());
            pstmt.setInt(2, orderDetail.getProductId());
            pstmt.setInt(3, orderDetail.getQuantity());
            pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
            pstmt.setTimestamp(5, new Timestamp(new Date().getTime()));
            pstmt.executeUpdate();
            System.out.println("成功新增訂單內容：" + orderDetail);
            return true;
        } catch (SQLException e) {
            System.out.println("新增訂單內容失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws SQLException {
        String sql = "UPDATE order_detail SET order_id = ?, product_id = ?, quantity = ?, update_at = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderDetail.getOrderId());
            pstmt.setInt(2, orderDetail.getProductId());
            pstmt.setInt(3, orderDetail.getQuantity());
            pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
            pstmt.setInt(5, orderDetail.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("成功更新 訂單 資料，訂單 ID: " + orderDetail.getId());
                return true;
            } else {
                System.out.println("找不到 訂單 ID: " + orderDetail.getId());
                return false;
            }
        } catch (SQLException e) {
            System.out.println("更新 訂單 資料失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public OrderDetail get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<OrderDetail> getAll() throws SQLException {
        List<OrderDetail> ordersList = new ArrayList<>();
        String sql = "SELECT * FROM order_detail";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                ordersList.add(new OrderDetail(rs.getInt("id"), rs.getInt("order_id")
                        , rs.getInt("product_id"), rs.getInt("quantity"), rs.getTimestamp("create_at")
                        ,rs.getTimestamp("update_at")));
            }
            return ordersList;
        } catch (SQLException e) {
            System.out.println("查詢 訂單 資料失敗：" + e.getMessage());
            return null;
        }
    }
}
