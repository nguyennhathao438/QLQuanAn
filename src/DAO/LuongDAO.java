/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.LuongDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LuongDAO {
    public int insertLuong(LuongDTO luong) {
        try {
            String sqlAddLuong = "INSERT INTO Luong(maBCC, luongThucTe, cacKhoanTru, thucLanh) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddLuong);
            ps.setInt(1, luong.getMaBCC());
            ps.setDouble(2, luong.getLuongThucTe());
            ps.setDouble(3, luong.getCacKhoanTru());
            ps.setDouble(4, luong.getThucLanh());

            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateLuong(LuongDTO luong) {
        String sqlUpdate = "UPDATE Luong "
                + "SET maBCC=?, luongThucTe=?, cacKhoanTru=?, thucLanh=? WHERE maLuong=?";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setInt(1, luong.getMaBCC());
            ps.setDouble(2, luong.getLuongThucTe());
            ps.setDouble(3, luong.getCacKhoanTru());
            ps.setDouble(4, luong.getThucLanh());
            ps.setInt(5, luong.getMaLuong());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật lương nhân viên thành công", "Success", 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int deleteLuong(String maLuong) {
        String sqlDelete = "DELETE Luong WHERE maLuong=?";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setString(1,maLuong);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa Lương thành công","Sucess",1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public ArrayList<LuongDTO> listLuong(int month, int year) {
        ArrayList<LuongDTO> listLuong = new ArrayList<LuongDTO>();
        String sqlSelectAll = "SELECT l.* FROM Luong l "
                + "INNER JOIN ChamCong c ON l.maBCC = c.maBCC "
                + "WHERE c.thangChamCong = ? AND c.namChamCong = ?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelectAll);
            ps.setInt(1, month);  // Set tháng
            ps.setInt(2, year);   // Set năm
            rs = ps.executeQuery();

            while (rs.next()) {
                int maLuong = rs.getInt("maLuong");
                int maBCC = rs.getInt("maBCC");
                double luongThucTe = rs.getDouble("luongThucTe");
                double cacKhoanTru = rs.getDouble("cacKhoanTru");
                double thucLanh = rs.getDouble("thucLanh");

                LuongDTO luongDTO = new LuongDTO(maLuong, maBCC, luongThucTe, cacKhoanTru, thucLanh);

                // Thêm đối tượng LuongDTO vào danh sách kết quả
                listLuong.add(luongDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Trả về danh sách lương đã lọc theo tháng và năm
        return listLuong;
    }
    public boolean checkLuongExists(int maBCC) {
        String sqlCheckExists = "SELECT COUNT(*) FROM Luong WHERE maBCC = ?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlCheckExists);
            ps.setInt(1, maBCC);  // Set giá trị maBCC vào câu truy vấn
            rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;  // Nếu có kết quả thì trả về true
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Nếu không có kết quả thì trả về false
    }
    
    //Lấy lương cơ bản từ bảng công việc
    public double getLuongCoBanByMaLuong(int maLuong) {
        String sql = "SELECT cv.luongCoBan "
                + "FROM Luong l "
                + "JOIN ChamCong cc ON l.maBCC = cc.maBCC "
                + "JOIN NhanVien nv ON cc.maNV = nv.maNV "
                + "JOIN CongViec cv ON nv.maCV = cv.maCV "
                + "WHERE l.maLuong = ?";
        try (
            PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql)) {
            ps.setInt(1, maLuong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("luongCoBan"); // đổi từ BigDecimal sang double
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0; // hoặc -1 nếu muốn báo lỗi logic
    }
    
}
