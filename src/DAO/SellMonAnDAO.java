/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NLNhapDTO;
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

import DTO.SellMonAnDTO;

/**
 *
 * @author asus
 */
public class SellMonAnDAO {
    ConnectedDatabase kn = new ConnectedDatabase();

    public Connection getConnection() {
        return ConnectedDatabase.getConnectedDB();
    }

    public ArrayList<SellMonAnDTO> getMAMonth(String year) {
        ArrayList<SellMonAnDTO> listNLNhap = new ArrayList<>();
        String sql = "SELECT\n" +
                "MONAN.maMA,\n" +
                "loaiMA, tenMA,\n" +
                "SUM(CTHOADON.soLuongMA) AS soLuong,\n" +
                "DATEPART(MONTH,HOADON.thoiGian) AS thang\n" +
                "FROM MONAN\n" +
                "JOIN CTHOADON ON CTHOADON.maMA = MONAN.maMA\n" +
                "JOIN HOADON ON CTHOADON.maHD = HOADON.maHD\n" +
                "WHERE YEAR(HOADON.thoiGian)=?\n" +
                "GROUP BY\n" +
                "MONTH(HOADON.thoiGian),\n" +
                "MONAN.maMA, loaiMA,tenMA\n" +
                "ORDER BY\n" +
                "thang DESC;";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SellMonAnDTO cellmonan = new SellMonAnDTO();
                cellmonan.setMaMA(rs.getString("maMA"));
                cellmonan.setLoaiMA(rs.getString("loaiMA"));
                cellmonan.setTenMA(rs.getString("tenMA"));
                cellmonan.setSoLuong(rs.getInt("soLuong"));
                cellmonan.setTime(rs.getInt("thang"));

                listNLNhap.add(cellmonan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellMonAnDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNLNhap;
    }
    
     public ArrayList<SellMonAnDTO> getMAQuy(String year) {
        ArrayList<SellMonAnDTO> listNLNhap = new ArrayList<>();
        String sql = "SELECT\n" +
"MONAN.maMA,\n" +
"loaiMA, tenMA,\n" +
"SUM(CTHOADON.soLuongMA) AS soLuong,\n" +
"DATEPART(QUARTER,HOADON.thoiGian) AS quy\n" +
"FROM MONAN\n" +
"JOIN CTHOADON ON CTHOADON.maMA = MONAN.maMA\n" +
"JOIN HOADON ON CTHOADON.maHD = HOADON.maHD\n" +
"WHERE YEAR(HOADON.thoiGian)=?\n" +
"GROUP BY\n" +
"DATEPART(QUARTER,HOADON.thoiGian),\n" +
"MONAN.maMA, loaiMA,tenMA\n" +
"ORDER BY\n" +
"quy DESC;";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SellMonAnDTO cellmonan = new SellMonAnDTO();
                cellmonan.setMaMA(rs.getString("maMA"));
                cellmonan.setLoaiMA(rs.getString("loaiMA"));
                cellmonan.setTenMA(rs.getString("tenMA"));
                cellmonan.setSoLuong(rs.getInt("soLuong"));
                cellmonan.setTime(rs.getInt("quy"));

                listNLNhap.add(cellmonan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellMonAnDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNLNhap;
    }

}
