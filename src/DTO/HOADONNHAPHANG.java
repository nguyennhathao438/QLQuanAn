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
    private int mangLam;
    public HOADONNHAPHANG() {
    }

    public HOADONNHAPHANG(String maHDNH, Date ngayNhap, double thanhTien, String tenNCC, int mangLam) {
        this.maHDNH = maHDNH;
        this.ngayNhap = ngayNhap;
        this.thanhTien = thanhTien;
        this.tenNCC = tenNCC;
        this.mangLam = mangLam;
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

    public int getMangLam() {
        return mangLam;
    }

    public void setMangLam(int mangLam) {
        this.mangLam = mangLam;
    }
    
    
}
