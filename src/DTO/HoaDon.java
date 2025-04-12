
package DTO;

import java.util.Date;

public class HoaDon {
    private String maHoaDon ;
    private Date thoiGian ;
    private double thanhTien ;
    private  String maKH ;
    private String tenKH ;

    public HoaDon(String maHoaDon, Date thoiGian, double thanhTien, String maKH, String tenKH) {
        this.maHoaDon = maHoaDon;
        this.thoiGian = thoiGian;
        this.thanhTien = thanhTien;
        this.maKH = maKH;
        this.tenKH = tenKH;
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

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
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

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    
}
