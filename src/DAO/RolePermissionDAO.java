package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DTO.PermissionDTO;
import DTO.RolePermissionDTO;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import util.ConnectedDatabase;

public class RolePermissionDAO {
    private Connection conn = ConnectedDatabase.getConnectedDB();
    public boolean isRoleExists(String maVT) {
        String sql = "SELECT 1 FROM ROLES WHERE maVT = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maVT);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void insertRole(String maVT, String tenVT) {
        String sql = "INSERT INTO ROLES(maVT, tenVT) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maVT);
            ps.setString(2, tenVT);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(PermissionDTO dto) {
        String sql = "INSERT INTO ROLEPERMISSION(maVT, maQuyen) " +
                     "SELECT ?, maQuyen FROM PERMISSION WHERE tenQuyen = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dto.getMaVT());
            ps.setString(2, dto.getTenQuyen());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByRole(String maVT) {
        String sql = "DELETE FROM ROLEPERMISSION WHERE maVT = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maVT);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getPermissionsByRole(String maVT) {
        List<String> list = new ArrayList<>();
        String sql = "SELECT tenQuyen FROM ROLEPERMISSION rp JOIN PERMISSION p ON rp.maQuyen = p.maQuyen WHERE maVT = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maVT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenQuyen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, List<String>> getAllPermissions() {
        Map<String, List<String>> map = new LinkedHashMap<>();
        String sql = "SELECT r.maVT, r.tenVT, p.tenQuyen FROM ROLEPERMISSION rp " +
                     "JOIN ROLES r ON r.maVT = rp.maVT " +
                     "JOIN PERMISSION p ON p.maQuyen = rp.maQuyen " +
                     "ORDER BY r.maVT";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maVT = rs.getString("maVT");
                String tenVT = rs.getString("tenVT");
                String tenQuyen = rs.getString("tenQuyen");
map.putIfAbsent(maVT + " - " + tenVT, new ArrayList<>());
                map.get(maVT + " - " + tenVT).add(tenQuyen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void deleteRole(String maVT) {
        String sql1 = "DELETE FROM ROLEPERMISSION WHERE maVT = ?";
        String sql2 = "DELETE FROM ROLES WHERE maVT = ?";
        try (PreparedStatement ps1 = conn.prepareStatement(sql1);
             PreparedStatement ps2 = conn.prepareStatement(sql2)) {
            ps1.setString(1, maVT);
            ps1.executeUpdate();
            ps2.setString(1, maVT);
            ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // === HÀM QUAN TRỌNG NHẤT để PhanQuyenJPanel sử dụng ===
    public List<RolePermissionDTO> getAllRolePermissions() {
        List<RolePermissionDTO> list = new ArrayList<>();
        String sql = "SELECT r.maVT, r.tenVT, p.tenQuyen FROM ROLEPERMISSION rp " +
                     "JOIN ROLES r ON rp.maVT = r.maVT " +
                     "JOIN PERMISSION p ON rp.maQuyen = p.maQuyen";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RolePermissionDTO dto = new RolePermissionDTO();
                dto.setMaVT(rs.getString("maVT"));
                dto.setTenVT(rs.getString("tenVT"));
                dto.setTenQuyen(rs.getString("tenQuyen"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<String> getAllTenQuyen() {
    List<String> list = new ArrayList<>();
    String sql = "SELECT tenQuyen FROM PERMISSION";
    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            list.add(rs.getString("tenQuyen"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

}


 






