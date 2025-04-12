
package DTO;

public class MonAnBan {
    private String maMA;
    private float soLuong ;

    public MonAnBan(String maMA, float soLuong) {
        this.maMA = maMA;
        this.soLuong = soLuong;
    }

    public String getMaMA() {
        return maMA;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }
    
}
