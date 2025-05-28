package dao;

import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO implements DAO<Orders>{
    @Override
    public boolean insert(Orders orders) throws SQLException {
        String sql = "INSERT INTO orders (order_date, total_amount, create_at, update_at) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, orders.getOrderDate());
            pstmt.setInt(2, orders.getTotalAmount());
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));

            pstmt.executeUpdate();
            System.out.println("成功新增訂單：" + orders);
            return true;
        } catch (SQLException e) {
            System.out.println("新增訂單失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Orders orders) throws SQLException {
        String sql = "UPDATE orders SET order_date = ?, total_amount = ?, update_at = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, orders.getOrderDate());
            pstmt.setInt(2, orders.getTotalAmount());
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setInt(4, orders.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("成功更新 訂單 資料，訂單 ID: " + orders.getId());
                return true;
            } else {
                System.out.println("找不到 訂單 ID: " + orders.getId());
                return false;
            }
        } catch (SQLException e) {
            System.out.println("更新 訂單 資料失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("成功刪除 訂單 資料，訂單 ID: " + id);
                return true;
            } else {
                System.out.println("找不到 訂單 ID: " + id);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("刪除 訂單 資料失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public Orders get(int id) throws SQLException {
        String sql = "SELECT * from orders WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Orders(rs.getInt("id"), rs.getDate("order_date")
                        , rs.getInt("total_amount"), rs.getTimestamp("create_at")
                        ,rs.getTimestamp("update_at"));
            }
            return null;
        } catch (SQLException e) {
            System.out.println("查詢 訂單 資料失敗：" + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        List<Orders> ordersList = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                ordersList.add(new Orders(rs.getInt("id"), rs.getDate("order_date")
                        , rs.getInt("total_amount"), rs.getTimestamp("create_at")
                        ,rs.getTimestamp("update_at")));
            }
            return ordersList;
        } catch (SQLException e) {
            System.out.println("查詢 訂單 資料失敗：" + e.getMessage());
            return null;
        }
    }
}
