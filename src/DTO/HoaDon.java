package DTO;

import java.util.Date;

public class HoaDon {
    private String maHoaDon ;
    private Date thoiGian ;
    private double thanhTien ;
    private String maKH;
    private int TenUser;
    public HoaDon() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getTenUser() {
        return TenUser;
    }

    public void setTenUser(int TenUser) {
        this.TenUser = TenUser;
    }

    
    public HoaDon(String maHoaDon, Date thoiGian, double thanhTien,String maKH,int TenUser) {
        this.maHoaDon = maHoaDon;
        this.thoiGian = thoiGian;
        this.thanhTien = thanhTien;
        this.maKH = maKH;
        this.TenUser = TenUser;
    }
    
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}