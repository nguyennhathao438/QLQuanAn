/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author kiman
 */
public class NhanVienDTO {
    private int maNV;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String sdt;
    private int maCV;
    public NhanVienDTO(){}
    public NhanVienDTO(int maNV,String hoTen,Date ngaySinh,String gioiTinh,String sdt,int maCV){
        this.maNV=maNV;
        this.hoTen=hoTen;
        this.ngaySinh=ngaySinh;
        this.gioiTinh=gioiTinh;
        this.sdt=sdt;
        this.maCV=maCV;
    }
    public NhanVienDTO(String hoTen,Date ngaySinh,String gioiTinh,String sdt,int maCV){
        this.hoTen=hoTen;
        this.ngaySinh=ngaySinh;
        this.gioiTinh=gioiTinh;
        this.sdt=sdt;
        this.maCV=maCV;
    }
    public int getMaNV(){
        return this.maNV;
    }
    public void setMaNV(int maNV){
        this.maNV=maNV;
    }
    public String getHoTen(){
        return this.hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen=hoTen;
    }
    public Date getNgaySinh(){
        return this.ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh){
        this.ngaySinh=ngaySinh;
    }
    public String getGioiTinh(){
        return this.gioiTinh;
    }
    public void setGioiTinh(String gioiTinh){
        this.gioiTinh=gioiTinh;
    }
    public String getSDT(){
        return this.sdt;
    }
    public void setSDT(String sdt){
        this.sdt=sdt;
    }
    public int getmaCongViec(){
        return this.maCV;
    }
    public void setmaCongViec(int maCV){
        this.maCV=maCV;
    }
}
