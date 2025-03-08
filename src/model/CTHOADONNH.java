
package model;

import java.util.ArrayList;
import java.util.Date;

public class CTHOADONNH extends HOADONNHAPHANG{
    ArrayList<NLNhap> dsnlnhap =new ArrayList();

    public CTHOADONNH() {
    }
    public CTHOADONNH(String maHDNH, Date ngayNhap, double thanhTien, String tenNCC,ArrayList<NLNhap> dsnlnhap ) {
        super(maHDNH,ngayNhap,thanhTien,tenNCC);
        this.dsnlnhap=dsnlnhap;
    }
    public void setDsnlnhap(ArrayList<NLNhap> dsnlnhap) {
        this.dsnlnhap = dsnlnhap;
    }

    public ArrayList<NLNhap> getDsnlnhap() {
        return dsnlnhap;
    }
    
     
}
