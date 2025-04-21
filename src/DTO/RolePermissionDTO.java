/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author THANH HIEU
 */
public class RolePermissionDTO {
    private String maVT;
    private String tenVT;
    private String tenQuyen;

    public RolePermissionDTO() {
    }

    public RolePermissionDTO(String maVT, String tenVT, String tenQuyen) {
        this.maVT = maVT;
        this.tenVT = tenVT;
        this.tenQuyen = tenQuyen;
    }

    public String getMaVT() {
        return maVT;
    }

    public void setMaVT(String maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }
}


