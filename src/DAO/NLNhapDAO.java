 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;

import util.ConnectedDatabase;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.NLNhapDTO;

/**
 *
 * @author asus
 */
public class NLNhapDAO {
    
        ConnectedDatabase kn = new ConnectedDatabase();
    public Connection getConnection(){ 
        return ConnectedDatabase.getConnectedDB();
    }
   
    public ArrayList<NLNhapDTO> getTKMonth(String year) {
    ArrayList<NLNhapDTO> listNLNhap = new ArrayList<>();
String sql = "SELECT \n" +
"    NGUYENLIEU.maNL,\n" +
"    LOAINL.loaiNL,\n" +
"    tenNL,\n" +
"    SUM(CTHOADONNH.soLuong) AS soLuong,\n" +  // Thêm tổng số lượng
"    SUM(CTHOADONNH.gia) AS gia,\n" +          // Tổng tiền
"    DATEPART(MONTH, HOADONNH.ngayNhap) AS thang\n" +
"FROM NGUYENLIEU \n" +
"JOIN LOAINL ON NGUYENLIEU.maLoaiNL = LOAINL.maLoaiNL\n" +
"JOIN CTHOADONNH ON CTHOADONNH.maNL = NGUYENLIEU.maNL\n" +
"JOIN HOADONNH ON HOADONNH.maHDNH = CTHOADONNH.maHDNH\n" +
"WHERE YEAR(HOADONNH.ngayNhap) = ? \n" +
"GROUP BY \n" +
"    MONTH(HOADONNH.ngayNhap),\n" +
"    NGUYENLIEU.maNL,\n" +
"    LOAINL.loaiNL,\n" +
"    tenNL\n" +
"ORDER BY \n" +
"    thang,\n" +
"    gia DESC";

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
         
        ps.setString(1, year);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            NLNhapDTO nlNhap = new NLNhapDTO();
            nlNhap.setMaNL(rs.getString("maNL"));
            nlNhap.setTenNL(rs.getString("tenNL"));
            nlNhap.setLoaiNL(rs.getString("loaiNL"));
            nlNhap.setSoluong(rs.getDouble("soLuong"));
            nlNhap.setGia(rs.getDouble("gia"));
            nlNhap.setNgayNhap(rs.getInt("thang"));

            
           

            listNLNhap.add(nlNhap);
        }
    } catch (SQLException ex) {
        Logger.getLogger(NLNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return listNLNhap;
}

    public ArrayList<NLNhapDTO> getTKQuy(String year){
        ArrayList<NLNhapDTO> listNLNhap = new ArrayList<>();
String sql = "SELECT \n" +
"    NGUYENLIEU.maNL,\n" +
"    LOAINL.loaiNL,\n" +
"    tenNL,\n" +
"    SUM(CTHOADONNH.soLuong) AS soLuong,\n" +   
"    SUM(CTHOADONNH.gia) AS gia,\n" +          
"    DATEPART(QUARTER, HOADONNH.ngayNhap) AS quy\n" +
"FROM NGUYENLIEU \n" +
"JOIN LOAINL ON NGUYENLIEU.maLoaiNL = LOAINL.maLoaiNL\n" +
"JOIN CTHOADONNH ON CTHOADONNH.maNL = NGUYENLIEU.maNL\n" +
"JOIN HOADONNH ON HOADONNH.maHDNH = CTHOADONNH.maHDNH\n" +
"WHERE YEAR(HOADONNH.ngayNhap) = ? \n" +
"GROUP BY \n" +
"    DATEPART(QUARTER, HOADONNH.ngayNhap),\n" +
"    NGUYENLIEU.maNL,\n" +
"    LOAINL.loaiNL,\n" +
"    tenNL\n" +
"ORDER BY \n" +
"    quy,\n" +
"    gia DESC";
       try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
         
        ps.setString(1, year);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NLNhapDTO nlNhap = new NLNhapDTO();
                nlNhap.setMaNL(rs.getString("maNL"));
                nlNhap.setTenNL(rs.getString("tenNL"));
                nlNhap.setLoaiNL(rs.getString("loaiNL"));
                nlNhap.setSoluong(rs.getDouble("soLuong"));
                nlNhap.setGia(rs.getDouble("gia"));
                nlNhap.setNgayNhap(rs.getInt("quy"));

                listNLNhap.add(nlNhap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NLNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNLNhap;
    }
    
    
    
}