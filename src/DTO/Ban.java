
package DTO;

public class Ban {
    private String trangthai;
    private String maKH;

    public Ban(String trangthai, String maKH) {
        this.trangthai = trangthai;
        this.maKH = maKH;
    }

    public Ban() {
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMAKH() {
        return maKH;
    }

    public void setMAKH(String maKH) {
        this.maKH = maKH;
    }
    
}
