
package DTO;

import java.util.ArrayList;

public class LICHSUNH {
    ArrayList<HOADONNHAPHANG> lsnh = new ArrayList();

    public ArrayList<HOADONNHAPHANG> getLSNH() {
        return lsnh;
    }
    public void themHDNH(HOADONNHAPHANG a){ 
        lsnh.add(a);
    }
}
