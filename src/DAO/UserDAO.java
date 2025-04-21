/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author THANH HIEU
 */
import java.sql.*;
import util.ConnectedDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
     public Connection getConnection(){ 
        return ConnectedDatabase.getConnectedDB();
    }
    public String ktraDangNhap(String taiKhoan, String matKhauNhap) {
    String sql = "SELECT USERS.id, USERS.matKhau, ROLES.maVT " +
                 "FROM USERS " +
                 "JOIN ROLES ON ROLES.maVT = USERS.maVT " +
                 "WHERE USERS.taiKhoan = ?";

    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, taiKhoan);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String mklayra = rs.getString("matKhau");
            String vaiTro = rs.getString("maVT");
       
                return vaiTro;
        }

    return ""; // Đăng nhập thất bại
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return "";
}
}
