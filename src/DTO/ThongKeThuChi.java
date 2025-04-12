
package DTO;


public class ThongKeThuChi {
    private int thoiGian ;
    private double soTien;

    public ThongKeThuChi() {
    }
    
    public ThongKeThuChi(int thoiGian, double soTien) {
        this.thoiGian = thoiGian;
        this.soTien = soTien;
    }
    public int getThoiGian() {
        return thoiGian;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
    
}
