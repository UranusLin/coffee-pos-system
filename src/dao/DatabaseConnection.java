package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://167.179.93.64:3306/Morris?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "morris-mysql-pw";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("資料庫連線成功！");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("找不到 MySQL 驅動程式：" + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("連線失敗：" + e.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("資料庫連線已關閉！");
            } catch (SQLException e) {
                System.out.println("關閉連線失敗：" + e.getMessage());
            }
        }
    }
}