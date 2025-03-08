
package model;

import java.util.ArrayList;

public class THANHPHAN {
    private String maMA;
    private String maNL[];
    private Float soLuong[];
    private int n=0;
    public THANHPHAN() {
        if(n==0){
            maNL=new String[10];
            soLuong=new Float[10];
        }
    }
    public String getMaMA() {
        return maMA;
    }

    public String[] getMaNL() {
        return maNL;
    }

    public Float[] getSoLuong() {
        return soLuong;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public void setMaNL(String[] maNL) {
        this.maNL = maNL;
    }

    public void setSoLuong(Float[] soLuong) {
        this.soLuong = soLuong;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }
    public void clearTP(){ 
        maNL=new String[10];
            soLuong=new Float[10];
    }  
    
}
