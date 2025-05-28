package dao;

import enums.ProductStatusEnum;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Product> {

    @Override
    public boolean insert(Product product) throws SQLException {
        String sql = "INSERT INTO product (name, price, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            if (product.getStatus() == null) {
                pstmt.setString(3, ProductStatusEnum.NotSale.getShowName());
            } else {
                pstmt.setString(3, product.getStatus().getShowName());
            }
            pstmt.executeUpdate();
            System.out.println("成功新增產品：" + product);
            return true;
        } catch (SQLException e) {
            System.out.println("新增產品失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Product product) throws SQLException {
        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getPrice());
            pstmt.setInt(3, product.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("成功更新 產品 資料，產品 ID: " + product.getId());
                return true;
            } else {
                System.out.println("找不到 產品 ID: " + product.getId());
                return false;
            }
        } catch (SQLException e) {
            System.out.println("更新 產品 資料失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("成功刪除 產品 資料，產品 ID: " + id);
                return true;
            } else {
                System.out.println("找不到 產品 ID: " + id);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("刪除 產品 資料失敗：" + e.getMessage());
            return false;
        }
    }

    @Override
    public Product get(int id) throws SQLException {
        String sql = "SELECT * from product WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("status"));
            }
            return null;
        } catch (SQLException e) {
            System.out.println("查詢 產品 資料失敗：" + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                productList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("status")));
            }
            return productList;
        } catch (SQLException e) {
            System.out.println("查詢 產品 資料失敗：" + e.getMessage());
            return null;
        }
    }

    public List<Product> getProductByName(String name) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, '%' + name + '%');
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("status")));
            }
            return productList;
        } catch (SQLException e) {
            System.out.println("查詢 產品 資料失敗：" + e.getMessage());
            return null;
        }
    }

    public List<Product> getSaleProducts() throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE status != 'not-sale' ";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                productList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("status")));
            }
            return productList;
        } catch (SQLException e) {
            System.out.println("查詢 產品 資料失敗：" + e.getMessage());
            return null;
        }
    }
}
