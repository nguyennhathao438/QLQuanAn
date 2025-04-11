
package DTO;

import java.util.Date;

public class NLNhap {
    private Float soLuong;
    private Double gia;
    private Date hsd;
    private String tenNL;

    public NLNhap() {
    }
    
    public NLNhap(Float soLuong, Double gia, Date hsd, String maNL) {
        this.soLuong = soLuong;
        this.gia = gia;
        this.hsd = hsd;
        this.tenNL = maNL;
    }

    public Float getSoLuong() {
        return soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public Date getHsd() {
        return hsd;
    }

    public String getMaNL() {
        return tenNL;
    }

    public void setSoLuong(Float soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }

    public void setMaNL(String maNL) {
        this.tenNL = maNL;
    }
    
}
