/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author asus
 */
public class SellMonAnDTO {
    
    private String maMA;
    private String loaiMA;
    private String tenMA;
    private int soLuong;
    private int time;

    public SellMonAnDTO() {
    }

    public SellMonAnDTO(String maMA, String loaiMA, String tenMA, int soLuong, int time) {
        this.maMA = maMA;
        this.loaiMA = loaiMA;
        this.tenMA = tenMA;
        this.soLuong = soLuong;
        this.time = time;
    }

    public String getMaMA() {
        return maMA;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public String getLoaiMA() {
        return loaiMA;
    }

    public void setLoaiMA(String loaiMA) {
        this.loaiMA = loaiMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
}
