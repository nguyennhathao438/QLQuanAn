
package DTO;

import java.util.ArrayList;
import java.util.Date;

public class CTHOADON extends HoaDon{
    ArrayList<MonAnBan> dsma =new ArrayList();
    public CTHOADON(String maHoaDon, Date thoiGian, double thanhTien, String maKH, String tenKH) {
        super(maHoaDon, thoiGian, thanhTien, maKH, tenKH);
    }

    public ArrayList<MonAnBan> getDsma() {
        return dsma;
    }

    public void setDsma(ArrayList<MonAnBan> dsma) {
        this.dsma = dsma;
    }
    
}
