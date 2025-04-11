
package DTO;

public class MONAN {
    private String maMA;
    private String tenMA;
    private String loaiMA;
    private String moTa;
    private Double gia;
    private int trangThai;

    public MONAN() {
    }

    public MONAN(String maMA, String tenMA, String loaiMA, String moTa, Double gia, int trangThai) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.loaiMA = loaiMA;
        this.moTa = moTa;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public String getLoaiMA() {
        return loaiMA;
    }

    public void setLoaiMA(String loaiMA) {
        this.loaiMA = loaiMA;
    }

    

    public String getMaMA() {
        return maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public String getMoTa() {
        return moTa;
    }

    public Double getGia() {
        return gia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
