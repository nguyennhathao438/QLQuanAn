
package model;

import java.util.ArrayList;

public class DSMonAn {
    ArrayList<MONAN> dsma=new ArrayList();

    public DSMonAn() {
    }

    public ArrayList<MONAN> getDSMA() {
        return dsma;
    }
    public void themMA(MONAN ma){ 
        dsma.add(ma);
    }
}
