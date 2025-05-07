/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CongViecDTO;
import util.ConnectedDatabase;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author kiman
 */
public class CongViecDAO {
    public int insertCongViec(CongViecDTO cv){
        try{
            String sqlAddCV="INSERT INTO CongViec(tenCV,luongCoBan,phuCap,heSoLuong,trangThai) "+
                            "VALUES (?,?,?,?,1)";
            PreparedStatement ps;
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlAddCV);
            ps.setString(1,cv.getTenCV());
            ps.setDouble(2, cv.getLuongCoBan());
            ps.setDouble(3,cv.getPhuCap());
            ps.setDouble(4,cv.getHeSoLuong());
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Thêm công việc thành công","Success",1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public int updateCongViec(CongViecDTO cv) {
        String sqlUpdate = "UPDATE CongViec "
                + "SET tenCV=?,luongCoBan=?,phuCap=?,heSoLuong=? WHERE maCV=?";
        PreparedStatement ps;
        System.out.println(cv.getMaCV());
        System.out.println(cv.getHeSoLuong());
        System.out.println(cv.getLuongCoBan());
        System.out.println(cv.getPhuCap());
        System.out.println(cv.getTenCV());
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sqlUpdate);
            ps.setString(1, cv.getTenCV());
            ps.setDouble(2, cv.getLuongCoBan());
            ps.setDouble(3, cv.getPhuCap());
            ps.setDouble(4, cv.getHeSoLuong());
            ps.setInt(5, cv.getMaCV());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null,"Cập nhật thành công","Success",1);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int deleteCongViec(int maCV){
        String sqlDelete="UPDATE CongViec SET trangThai=0 WHERE maCV=? ";
        PreparedStatement ps;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlDelete);
            ps.setInt(1,maCV);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"Xóa thành công","Success",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy lương cơ bản của nhân viên
    public double getLuongCoBanByMaNV(int maNV){
        String sql = "SELECT luongCoBan FROM CongViec "
                + "JOIN NhanVien ON CongViec.maCV=NhanVien.maCV WHERE maNV=?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1,maNV);
            rs=ps.executeQuery();
            if(rs.next()){
                double luongCoBan=rs.getDouble("luongCoBan");
                return luongCoBan;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy phụ cấp của nhân viên
    public double getPhuCap(int maNV){
        String sql = "SELECT phuCap FROM CongViec "
                + "JOIN NhanVien ON CongViec.maCV=NhanVien.maCV WHERE maNV=?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1,maNV);
            rs=ps.executeQuery();
            if(rs.next()){
                double phuCap=rs.getDouble("phuCap");
                return phuCap;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy hệ số lương
    public double getHeSoLuong(int maNV){
        String sql = "SELECT heSoLuong FROM CongViec "
                + "JOIN NhanVien ON CongViec.maCV=NhanVien.maCV WHERE maNV=?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            ps.setInt(1,maNV);
            rs=ps.executeQuery();
            if(rs.next()){
                double heSoLuong=rs.getDouble("heSoLuong");
                return heSoLuong;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //Lấy danh sách công việc
    public ArrayList<CongViecDTO> listCV(){
        ArrayList<CongViecDTO> listCV=new ArrayList<CongViecDTO>();
        String sqlSelectAll="SELECT * FROM CongViec WHERE trangThai=1 ";
            PreparedStatement ps;
            ResultSet rs;
        try {
            ps=ConnectedDatabase.getConnectedDB().prepareStatement(sqlSelectAll);
            rs=ps.executeQuery();
            while(rs.next()){
                int maCV=rs.getInt("maCV");
                double luongCoBan=rs.getDouble("luongCoBan");
                double phuCap=rs.getDouble("phuCap");
                String tenCV=rs.getString("tenCV");
                Double heSoLuong=rs.getDouble("heSoLuong");
                CongViecDTO cv=new CongViecDTO(maCV,tenCV,luongCoBan,phuCap,heSoLuong);
                listCV.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCV;
    }
    public HashMap<String, Integer> mapCV() {
        HashMap<String, Integer> mapCV = new HashMap<>();
        String sql = "SELECT * FROM CongViec WHERE trangThai=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int maCV = rs.getInt("maCV");
                String tenCV = rs.getString("tenCV");
                mapCV.put(tenCV,maCV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapCV;
    }
}
