/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author asus
 */
public class NLNhapDTO {
    private String maNL;
    private String tenNL;
    private String loaiNL;
    private double soluong;
    private double gia;
    private int ngayNhap;

    public NLNhapDTO() {
    }

    public NLNhapDTO(String maNL, String tenNL, String loaiNL,double soluong, double gia, int ngayNhap) {
        this.maNL= maNL;
        this.tenNL = tenNL;
        this.loaiNL= loaiNL;
        this.soluong=soluong;
        this.gia = gia;
        this.ngayNhap = ngayNhap;
    }

    public String getMaNL() {
        return maNL;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }
    

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public String getLoaiNL() {
        return loaiNL;
    }

    public void setLoaiNL(String loaiNL) {
        this.loaiNL = loaiNL;
    }

    public double getSoluong() {
        return soluong;
    }

    public void setSoluong(double soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(int ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
}
