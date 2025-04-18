package DTO;
// note MonAnBan = DonTam
public class MonAnBan{
    private String maMA;
    private String tenMA;
    private int soluong;
    private Double gia;
    private Double thanhtien;

    public Double getThanhtien() {
        return thanhtien = gia * soluong;
    }

    public void setThanhtien(Double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public MonAnBan(String maMA, String tenMA, int soluong, Double gia) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = gia*soluong;
    }


    public MonAnBan() {
    }

    public String getMaMA() {
        return maMA;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

}
