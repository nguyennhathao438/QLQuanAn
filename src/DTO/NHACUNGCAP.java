/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


/**
 *
 * @author ADMIN
 */
public class NHACUNGCAP {
    private String maNCC;
    private String tenNCC;
    private String sdt;
  
    public NHACUNGCAP() {
    }
   
    public NHACUNGCAP(String maNCC, String tenNCC,String sdt) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt=sdt;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return tenNCC;
    }   
}
