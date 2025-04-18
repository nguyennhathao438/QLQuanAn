package DTO;

public class khachDTO {
    private String MaKH;
    private String tenkhach;
    private String LoaiKhach;
    private String SDT;
    private String Diachi;

    public khachDTO(){
    }
    
    public khachDTO(String MaKH, String tenkhach, String LoaiKhach,String SDT,String Diachi) {
        this.MaKH = MaKH;
        this.tenkhach = tenkhach;
        this.LoaiKhach = LoaiKhach;
        this.SDT = SDT;
        this.Diachi = Diachi;
    }
    

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }
    public void setMaKhach(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenkhach(String tenkhach) {
        this.tenkhach = tenkhach;
    }

    public void setLoaiKhach(String LoaiKhach) {
        this.LoaiKhach = LoaiKhach;
    }
    public String getMaKH() {
        return MaKH;
    }

    public String getTenkhach() {
        return tenkhach;
    }

    public String getLoaiKhach() {
        return LoaiKhach;
    }
    
}
