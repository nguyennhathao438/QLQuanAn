/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author THANH HIEU
 */
import DTO.User;
import util.ConnectedDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    public Connection getConnection() {
        return ConnectedDatabase.getConnectedDB();
    }
    public User ktraDangNhap(String taiKhoan, String matKhauNhap) {
        String sql = "SELECT * "
                + "FROM USERS "
                + "JOIN ROLES ON ROLES.maVT = USERS.maVT "
                + "WHERE USERS.taiKhoan = ? AND USERS.matKhau=? ";
        User user = new User();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);
              ) {
            stmt.setString(1, taiKhoan);
            stmt.setString(2,matKhauNhap);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                user.setId(id);
                user.setVaiTro(rs.getString("maVT"));
                user.setTen(rs.getString("ten"));              
                    if(toggleTrangThaiUser(id) > 0 ){ 
                        System.out.println("Đổi trạng thái thành công ");
                    }else{ 
                        System.out.println( "Đổi trạng thái thất bại");
                    }
                     return user;
                }
            // Đăng nhập thất bại
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public int toggleTrangThaiUser(int id) {
        int kt = -1;
        String queryget ="SELECT trangThai FROM USERS WHERE id =? ";
        String query = "UPDATE USERS SET trangThai = ? WHERE id = ?";
        try(Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                PreparedStatement stmtget = conn.prepareStatement(queryget);
){ 
            stmtget.setInt(1,id);
            ResultSet rs = stmtget.executeQuery();
            int trangthai = 0;
            if(rs.next()){ 
                trangthai = rs.getInt("trangThai");
            }
            if(trangthai !=3){ 
                stmt.setInt(1,3);
                stmt.setInt(2, id);
                kt = stmt.executeUpdate();
            }else if(trangthai == 3){ 
                stmt.setInt(1,2);
                stmt.setInt(2, id);
                kt = stmt.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kt;
    }
    public void dangXuat(int id){ 
         toggleTrangThaiUser(id);
    }
    
    public int getIDUserLogin() {
        int id = 0;
        String query = "SELECT id FROM USERS WHERE trangThai=3";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public String getTenUserByID(int id) {
        String query = "SELECT ten FROM USERS WHERE id = ? ";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("ten");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public String getTenTaiKhoanUserByID(int id) {
        String query = "SELECT taiKhoan FROM USERS WHERE id = ? ";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("taiKhoan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}

