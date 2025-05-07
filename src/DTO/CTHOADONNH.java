
package DTO;

import java.util.ArrayList;
import java.util.Date;

public class CTHOADONNH extends HOADONNHAPHANG{
    ArrayList<NLNhap> dsnlnhap =new ArrayList();

    public CTHOADONNH() {
    }
    
    public void setDsnlnhap(ArrayList<NLNhap> dsnlnhap) {
        this.dsnlnhap = dsnlnhap;
    }

    public ArrayList<NLNhap> getDsnlnhap() {
        return dsnlnhap;
    }
    
     
}
