package DTO;

import java.util.Date;

public class HoaDon {
    private String maHoaDon ;
    private Date thoiGian ;
    private double thanhTien ;
    private String maKH;
    public HoaDon() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    
    public HoaDon(String maHoaDon, Date thoiGian, double thanhTien,String maKH) {
        this.maHoaDon = maHoaDon;
        this.thoiGian = thoiGian;
        this.thanhTien = thanhTien;
        this.maKH = maKH;
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