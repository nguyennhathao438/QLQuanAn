
package DTO;

import java.util.ArrayList;
import java.util.Date;

public class CTHOADON extends HoaDon{
    ArrayList<MonAnBan> dsma =new ArrayList();
    
    public CTHOADON(){
        
    }
    public CTHOADON(String maHoaDon, Date thoiGian, double thanhTien,String maKH, ArrayList<MonAnBan> dsma) {
        super(maHoaDon, thoiGian, thanhTien,maKH);
        this.dsma = dsma;
    }

    public ArrayList<MonAnBan> getDsma() {
        return dsma;
    }

    public void setDsma(ArrayList<MonAnBan> dsma) {
        this.dsma = dsma;
    }
    
}