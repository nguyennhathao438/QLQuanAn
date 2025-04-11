/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HOADONNHAPHANG {
     private String maHDNH;
    private Date ngayNhap;
    private double thanhTien;
    private String tenNCC;

    public HOADONNHAPHANG() {
    }

    public HOADONNHAPHANG(String maHDNH, Date ngayNhap, double thanhTien, String tenNCC) {
        this.maHDNH = maHDNH;
        this.ngayNhap = ngayNhap;
        this.thanhTien = thanhTien;
        this.tenNCC = tenNCC;
    }
    
    public String getMaHDNH() {
        return maHDNH;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setMaHDNH(String maHDNH) {
        this.maHDNH = maHDNH;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    
}
