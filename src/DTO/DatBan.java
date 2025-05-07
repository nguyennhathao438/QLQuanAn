
package DTO;

import java.util.Date;

public class DatBan {
    private String tenkhach;
    private String SDT;
    private Date thoigian;

    public DatBan() {
    }

    public DatBan(String tenkhach, String SDT, Date thoigian) {
        this.tenkhach = tenkhach;
        this.SDT = SDT;
        this.thoigian = thoigian;
    }

    public String getTenkhach() {
        return tenkhach;
    }

    public void setTenkhach(String tenkhach) {
        this.tenkhach = tenkhach;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }
    
}
