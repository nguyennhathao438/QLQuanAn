package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THANH HIEU
 */
import java.sql.*;
import java.util.*;
import DTO.User;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.swing.JOptionPane;
import util.ConnectedDatabase;

public class USerDAO1 {

    public Connection getConnection() {
        return ConnectedDatabase.getConnectedDB();
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT u.id, u.taiKhoan, u.ten, u.matKhau, r.tenVT, u.trangThai " +
                     "FROM USERS u JOIN ROLES r ON u.maVT = r.maVT";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setTaiKhoan(rs.getString("taiKhoan"));
                u.setTen(rs.getString("ten"));
                u.setMatKhau(rs.getString("matKhau"));
                u.setVaiTro(rs.getString("tenVT"));
                u.setTrangThai(rs.getInt("trangThai"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean kiemTraTaiKhoanTonTai(String taiKhoan) {
        String sql = "SELECT COUNT(*) FROM USERS WHERE taiKhoan = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, taiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themUser(User u, String maVT) {
        if (kiemTraTaiKhoanTonTai(u.getTaiKhoan())) {
            return false;
        }

        String sql = "INSERT INTO USERS (taiKhoan, matKhau, ten, maVT, trangThai) VALUES (?, ?, ?, ?, 1)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getTaiKhoan());
            ps.setString(2, u.getMatKhau());
            ps.setString(3, u.getTen());
            ps.setString(4, maVT);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void suaUser(User u, String maVT) {
        String sql = "UPDATE USERS SET ten=?, matKhau=?, trangThai=?, maVT=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getTen());
            ps.setString(2, u.getMatKhau());
            ps.setInt(3, u.getTrangThai());
            ps.setString(4, maVT);
            ps.setInt(5, u.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoaUser(int id) {
        String sql = "DELETE FROM USERS WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void voHieuHoaUser(int id) {
        String sql = "UPDATE USERS SET trangThai = 0 WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMaVaiTro(String tenVT) {
        String maVT = null;
        String sql = "SELECT maVT FROM ROLES WHERE tenVT = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenVT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maVT = rs.getString("maVT");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maVT;
    }

    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT u.*, r.tenVT FROM USERS u JOIN ROLES r ON u.maVT = r.maVT WHERE u.id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setTaiKhoan(rs.getString("taiKhoan"));
                user.setMatKhau(rs.getString("matKhau"));
                user.setTen(rs.getString("ten"));
                user.setTrangThai(rs.getInt("trangThai"));
                user.setVaiTro(rs.getString("tenVT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<String> getAllTenVaiTro() {
        List<String> dsTenVaiTro = new ArrayList<>();
        String sql = "SELECT tenVT FROM ROLES";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                dsTenVaiTro.add(rs.getString("tenVT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsTenVaiTro;
    }
}
