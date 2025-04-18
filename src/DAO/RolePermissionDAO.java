package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DTO.PermissionDTO;
import util.ConnectedDatabase;

public class RolePermissionDAO {
    public Connection getConnection() {
        return ConnectedDatabase.getConnectedDB();
    }

    public List<PermissionDTO> getAllPermissionsWithRole(String maVT) {
        List<PermissionDTO> list = new ArrayList<>();
        String sql = "SELECT p.maQuyen, p.tenQuyen, " +
                     "CASE WHEN rp.maVT IS NULL THEN 0 ELSE 1 END AS duocCap " +
                     "FROM PERMISSION p " +
                     "LEFT JOIN ROLEPERMISSION rp ON p.maQuyen = rp.maQuyen AND rp.maVT = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maVT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maQuyen = rs.getString("maQuyen");
                String tenQuyen = rs.getString("tenQuyen");
                boolean duocCap = rs.getInt("duocCap") == 1;
                list.add(new PermissionDTO(maQuyen, tenQuyen, duocCap));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void capQuyen(String maVT, String maQuyen) {
        String sql = "IF NOT EXISTS (SELECT * FROM ROLEPERMISSION WHERE maVT = ? AND maQuyen = ?) " +
                     "INSERT INTO ROLEPERMISSION (maVT, maQuyen) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maVT);
            stmt.setString(2, maQuyen);
            stmt.setString(3, maVT);
            stmt.setString(4, maQuyen);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoaQuyen(String maVT, String maQuyen) {
        String sql = "DELETE FROM ROLEPERMISSION WHERE maVT = ? AND maQuyen = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maVT);
            stmt.setString(2, maQuyen);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
