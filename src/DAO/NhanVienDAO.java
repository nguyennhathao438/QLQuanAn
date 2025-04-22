/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection; 
import util.ConnectedDatabase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kiman
 */
public class NhanVienDAO {
    public int insertNhanVien(NhanVienDTO nv){
        try {
            String sqlAdd = "INSERT INTO NhanVien(hoTen,ngaySinh,gioiTinh,sdt,maCV,trangThai) "
                    + "VALUES (?,?,?,?,?,1)";
            PreparedStatement ps;
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlAdd);
            ps.setString(1, nv.getHoTen());
            ps.setDate(2, (Date) nv.getNgaySinh());
            ps.setString(3, nv.getGioiTinh());
            ps.setString(4, nv.getSDT());
            ps.setInt(5,nv.getmaCongViec());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int updateNhanVien(NhanVienDTO nv) {
        try {
            String sqlUpdate = "UPDATE NhanVien "
                    + "SET hoTen=?,ngaySinh=?,gioiTinh=?,sdt=?,maCV=? "
                    + "WHERE maNV=?";
            PreparedStatement ps;
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setString(1,nv.getHoTen());
            ps.setDate(2,(Date) nv.getNgaySinh() );
            ps.setString(3,nv.getGioiTinh());
            ps.setString(4,nv.getSDT());
            ps.setInt(5,nv.getmaCongViec());
            ps.setInt(6,nv.getMaNV());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Cập nhật thông tin nhân viên thành công","Success",1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int deleteNhanVien(int maNV){
        try {
            String sqlDelete="UPDATE NhanVien SET trangThai=0 "+
                             "WHERE maNV=?";
            PreparedStatement ps;
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1,maNV);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa thành công","Success",1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return 0;
    }
    public ArrayList<NhanVienDTO> listNV(){
        ArrayList<NhanVienDTO> listNV=new ArrayList<NhanVienDTO>();
        String sqlListNV="SELECT * FROM NhanVien WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlListNV);
            rs=ps.executeQuery();
            while(rs.next()){
                int maNV=rs.getInt("maNV");
                String hoTen=rs.getString("hoTen");
                Date ngaySinh=rs.getDate("ngaySinh");
                String gioiTinh=rs.getString("gioiTinh");
                String sdt=rs.getString("sdt");
                int idUser=rs.getInt("idUser");
                int maCV=rs.getInt("maCV");
                listNV.add(new NhanVienDTO(maNV, hoTen, ngaySinh, gioiTinh, sdt,idUser,maCV));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }
    public int setTaiKhoanNV(int idUser, int maNV) {
        try {
            String sql_1 = "UPDATE NhanVien SET idUser = ? WHERE maNV = ? ";
            PreparedStatement ps1;
            Connection connect = ConnectedDatabase.getConnectedDB();
            ps1 = connect.prepareStatement(sql_1);
            ps1.setInt(1, idUser);
            ps1.setInt(2, maNV);
            int result1 = ps1.executeUpdate();
            if (result1 > 0) {
                String sql_2 = "UPDATE USERS SET trangThai=2 WHERE id=? ";
                PreparedStatement ps2 = connect.prepareStatement(sql_2);
                ps2.setInt(1, idUser);
                int result2 = ps2.executeUpdate();
                if (result2 > 0) {
                    JOptionPane.showMessageDialog(null, "Cấp vai trò nhân viên thành công", "Success", 1);
                    return 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public HashMap<String, Integer> mapNV() {
        HashMap<String, Integer> mapNV = new HashMap<>();
        String sql = "SELECT * FROM NhanVien where trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maNV = rs.getInt("maNV");
                String tenNV = rs.getString("tenNV");
                mapNV.put(tenNV, maNV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapNV;
    }
    public double getHeSoLuong(String maCV) {
        double heSoLuong = 0.0;
        String sql = "SELECT heSoLuong FROM CONGVIEC WHERE maCV = ?";

        try (PreparedStatement ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql)) {
            ps.setString(1, maCV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                heSoLuong = rs.getDouble("heSoLuong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, "Lỗi lấy hệ số lương", ex);
        }
        return heSoLuong;
    }
    
    public NhanVienDTO getNhanVienByMaNV(int maNV) {
        NhanVienDTO nhanVien = null; 
        String sql = "SELECT * FROM NhanVien WHERE maNV = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1, maNV); 
            rs = ps.executeQuery();
            if (rs.next()) {
                String hoTen = rs.getString("hoTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String gioiTinh = rs.getString("gioiTinh");
                String sdt = rs.getString("sdt");
                int maCV = rs.getInt("maCV");
                nhanVien = new NhanVienDTO(maNV, hoTen, ngaySinh, gioiTinh, sdt, maCV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhanVien;
    }
}
