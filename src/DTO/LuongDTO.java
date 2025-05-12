/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class LuongDTO {

    private int maLuong;
    private int maBCC;
    private double luongThucTe;
    private double cacKhoanTru;
    private double thucLanh;

    public LuongDTO() {
    }

    public LuongDTO(int maLuong, int maBCC, double luongThucTe, double cacKhoanTru, double thucLanh) {
        this.maLuong = maLuong;
        this.maBCC = maBCC;
        this.luongThucTe = luongThucTe;
        this.cacKhoanTru = cacKhoanTru;
        this.thucLanh = thucLanh;
    }
    public LuongDTO(int maBCC, double luongThucTe, double cacKhoanTru, double thucLanh) {
        this.maBCC = maBCC;
        this.luongThucTe = luongThucTe;
        this.cacKhoanTru = cacKhoanTru;
        this.thucLanh = thucLanh;
    }

    public int getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(int maLuong) {
        this.maLuong = maLuong;
    }

    public int getMaBCC() {
        return maBCC;
    }

    public void setMaBCC(int maBCC) {
        this.maBCC = maBCC;
    }


    public double getLuongThucTe() {
        return luongThucTe;
    }

    public void setLuongThucTe(double luongThucTe) {
        this.luongThucTe = luongThucTe;
    }

    public double getCacKhoanTru() {
        return cacKhoanTru;
    }

    public void setCacKhoanTru(double cacKhoanTru) {
        this.cacKhoanTru = cacKhoanTru;
    }

    public double getThucLanh() {
        return thucLanh;
    }

    public void setThucLanh(double thucLanh) {
        this.thucLanh = thucLanh;
    }
}
