
package DTO;

import java.util.ArrayList;


public class LICHSUBAN {
    ArrayList<HoaDon> lsb = new ArrayList();
    
    public ArrayList<HoaDon> getLSB(){
        return lsb;
    }
    public void ThemHDB(HoaDon hdb){
        lsb.add(hdb);
    }
}
