/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class CongViecDTO {
    private int maCV;
    private String tenCV;
    private double luongCoBan;
    private double phuCap;
    private double heSoLuong;
    public CongViecDTO(){}
    public CongViecDTO(int maCV,String tenCV,double luongCoBan,double phuCap,double heSoLuong){
        this.maCV=maCV;
        this.tenCV=tenCV;
        this.luongCoBan=luongCoBan;
        this.phuCap=phuCap;
        this.heSoLuong=heSoLuong;
    }
    public CongViecDTO(String tenCV,double luongCoBan,double phuCap,double heSoLuong){
        this.tenCV=tenCV;
        this.luongCoBan=luongCoBan;
        this.phuCap=phuCap;
        this.heSoLuong=heSoLuong;
    }
    public int getMaCV(){
        return this.maCV;
    }
    public void setMaCV(int maCV){
        this.maCV=maCV;
    }
    public String getTenCV(){
        return this.tenCV;
    }
    public void setTenCV(String tenCV){
        this.tenCV=tenCV;
    }
    public double getLuongCoBan(){
        return this.luongCoBan;
    }
    public void setLuongCoBan(double luongCoBan){
        this.luongCoBan=luongCoBan;
    }
    public double getPhuCap(){
        return this.phuCap;
    }
    public void setPhuCap(double phuCap){
        this.phuCap=phuCap;
    }
    public double getHeSoLuong(){
        return this.heSoLuong;
    }
    public void setHeSoLuong(double heSoLuong){
        this.heSoLuong=heSoLuong;
    }
}
