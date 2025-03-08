
package model;

public class NGUYENLIEU {
    private String maNL;
    private String maLoaiNL;
    private String tenNL;
    private float tongSoLuong;
    private String moTa;
    private String donVi;
    private int trangThai;

    public NGUYENLIEU() {
    }
    
    public NGUYENLIEU(String maNL, String maLoaiNL, String tenNL, float tongSoLuong, String moTa, String donVi,int trangThai) {
        this.maNL = maNL;
        this.maLoaiNL = maLoaiNL;
        this.tenNL = tenNL;
        this.tongSoLuong = tongSoLuong;
        this.moTa = moTa;
        this.donVi = donVi;
        this.trangThai=trangThai    ;
    }

    public String getMaNL() {
        return maNL;
    }

    public String getMaLoaiNL() {
        return maLoaiNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public float getTongSoLuong() {
        return tongSoLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getDonVi() {
        return donVi;
    }

    public int getTrangThai() {
        return trangThai;
    }
    
    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setMaLoaiNL(String loaiNL) {
        this.maLoaiNL = loaiNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public void setTongSoLuong(float tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
 
    
}
