
package DTO;

public class MonAnBan {
    private String maMA;
    private String tenMA;
    private float soLuong ;
    private double giaTien;

    public MonAnBan(String maMA, String tenMA, float soLuong, double giaTien) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public String getMaMA() {
        return maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    
    
}
