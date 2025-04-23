/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChamCongDTO;
import util.ConnectedDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
public class ChamCongDAO {

    public int insertChamCong(ChamCongDTO cc) {
        try {
            String sqlAddCC = "INSERT INTO ChamCong(maNV, thangChamCong, namChamCong, soNgayLamViec, soNgayNghi, soNgayTre, soGioLamThem, chiTiet, trangThai) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddCC);
            ps.setInt(1, cc.getMaNV());
            ps.setInt(2, cc.getThangChamCong());
            ps.setInt(3, cc.getNamChamCong());
            ps.setInt(4, cc.getSoNgayLamViec());
            ps.setInt(5, cc.getSoNgayNghi());
            ps.setInt(6, cc.getSoNgayTre());
            ps.setInt(7, cc.getSoGioLamThem());
            ps.setString(8, cc.getChiTiet());
            ps.setString(9, cc.getTrangThai());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm chấm công thành công", "Success", 1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteChamCong(int maBCC) {
        String sqlDelete = "DELETE ChamCong WHERE maBCC=? ";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1, maBCC);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Success", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy đối tượng chấm công theo mã BCC
    public ChamCongDTO getChamCongTheoMaBCC(int maBCC) {
        String sqlDelete = "SELECT * FROM ChamCong WHERE maBCC=? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1, maBCC);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new ChamCongDTO(
                        rs.getInt("maNV"),
                        rs.getInt("thangChamCong"),
                        rs.getInt("namChamCong"),
                        rs.getInt("soNgayLamViec"),
                        rs.getInt("soNgayNghi"),
                        rs.getInt("soNgayTre"),
                        rs.getInt("soGioLamThem"),
                        rs.getString("chiTiet"),
                        rs.getString("trangThai")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateChamCong(ChamCongDTO cc) {
        String sqlUpdate = "UPDATE ChamCong "
                + "SET maNV=?, thangChamCong=?, namChamCong=?, soNgayLamViec=?, soNgayNghi=?, soNgayTre=?, soGioLamThem=?, chiTiet=?, trangThai=? "
                + "WHERE maBCC=?";
        PreparedStatement ps;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setInt(1, cc.getMaNV());
            ps.setInt(2, cc.getThangChamCong());
            ps.setInt(3, cc.getNamChamCong());
            ps.setInt(4, cc.getSoNgayLamViec());
            ps.setInt(5, cc.getSoNgayNghi());
            ps.setInt(6, cc.getSoNgayTre());
            ps.setInt(7, cc.getSoGioLamThem());
            ps.setString(8, cc.getChiTiet());
            ps.setString(9, cc.getTrangThai());
            ps.setInt(10, cc.getMaBCC());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật chấm công thành công", "Success", 1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    //Lấy đối tượng chấm công theo maNV,thang,nam
    public ChamCongDTO getChamCongTheoThangNam(int maNV, int thang, int nam) {
        String sql = "SELECT * FROM ChamCong WHERE maNV=? AND thangChamCong=? AND namChamCong=?";
        try {
            PreparedStatement ps =ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maNV);
            ps.setInt(2, thang);
            ps.setInt(3, nam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ChamCongDTO(
                        rs.getInt("maNV"),
                        rs.getInt("thangChamCong"),
                        rs.getInt("namChamCong"),
                        rs.getInt("soNgayLamViec"),
                        rs.getInt("soNgayNghi"),
                        rs.getInt("soNgayTre"),
                        rs.getInt("soGioLamThem"),
                        rs.getString("chiTiet"),
                        rs.getString("trangThai")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Lấy danh sách đã được chấm công theo tháng năm
    public ArrayList<ChamCongDTO> listChamCongTheoThangNam(int month,int year) {
        ArrayList<ChamCongDTO> listChamCong = new ArrayList<ChamCongDTO>();
        String sqlSelectAll = "SELECT * FROM ChamCong WHERE thangChamCong=? AND namChamCong=? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelectAll);
            ps.setInt(1,month);
            ps.setInt(2, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maBCC = rs.getInt("maBCC");
                int maNV = rs.getInt("maNV");
                int thangChamCong = rs.getInt("thangChamCong");
                int namChamCong = rs.getInt("namChamCong");
                int soNgayLamViec = rs.getInt("soNgayLamViec");
                int soNgayNghi = rs.getInt("soNgayNghi");
                int soNgayTre = rs.getInt("soNgayTre");
                int soGioLamThem = rs.getInt("soGioLamThem");
                String chiTiet = rs.getString("chiTiet");
                String trangThai = rs.getString("trangThai");
                ChamCongDTO chamCong = new ChamCongDTO();
                chamCong.setMaBCC(maBCC);
                chamCong.setMaNV(maNV);
                chamCong.setThangChamCong(thangChamCong);
                chamCong.setNamChamCong(namChamCong);
                chamCong.setSoNgayLamViec(soNgayLamViec);
                chamCong.setSoNgayNghi(soNgayNghi);
                chamCong.setSoNgayTre(soNgayTre);
                chamCong.setSoGioLamThem(soGioLamThem);
                chamCong.setChiTiet(chiTiet);
                chamCong.setTrangThai(trangThai);
                listChamCong.add(chamCong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChamCong;
    }

    public ArrayList<ChamCongDTO> listChamCong() {
        ArrayList<ChamCongDTO> listChamCong = new ArrayList<ChamCongDTO>();
        String sqlSelectAll = "SELECT * FROM ChamCong ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelectAll);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maBCC = rs.getInt("maBCC");
                int maNV = rs.getInt("maNV");
                int thangChamCong = rs.getInt("thangChamCong");
                int namChamCong = rs.getInt("namChamCong");
                int soNgayLamViec = rs.getInt("soNgayLamViec");
                int soNgayNghi = rs.getInt("soNgayNghi");
                int soNgayTre = rs.getInt("soNgayTre");
                int soGioLamThem = rs.getInt("soGioLamThem");
                String chiTiet = rs.getString("chiTiet");
                String trangThai = rs.getString("trangThai");
                ChamCongDTO chamCong = new ChamCongDTO();
                chamCong.setMaBCC(maBCC);
                chamCong.setMaNV(maNV);
                chamCong.setThangChamCong(thangChamCong);
                chamCong.setNamChamCong(namChamCong);
                chamCong.setSoNgayLamViec(soNgayLamViec);
                chamCong.setSoNgayNghi(soNgayNghi);
                chamCong.setSoNgayTre(soNgayTre);
                chamCong.setSoGioLamThem(soGioLamThem);
                chamCong.setChiTiet(chiTiet);
                chamCong.setTrangThai(trangThai);

                listChamCong.add(chamCong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChamCong;
    }
    public HashMap<Integer, Integer> mapChamCong() {
        HashMap<Integer, Integer> mapChamCong = new HashMap<>();
        String sql = "SELECT maBCC, maNV FROM ChamCong";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maBCC = rs.getInt("maBCC");
                int maNV = rs.getInt("maNV");
                mapChamCong.put(maBCC,maNV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapChamCong;
    }
}
