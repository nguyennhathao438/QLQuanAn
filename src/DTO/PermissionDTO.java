/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author THANH HIEU
 */
public class PermissionDTO {
    private String maQuyen;
    private String tenQuyen;
    private boolean duocCap;

    public PermissionDTO(String maQuyen, String tenQuyen, boolean duocCap) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.duocCap = duocCap;
    }

    public String getMaQuyen() { return maQuyen; }
    public String getTenQuyen() { return tenQuyen; }
    public boolean isDuocCap() { return duocCap; }
}
