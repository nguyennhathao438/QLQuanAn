
package model;

import java.util.ArrayList;

public class DSMonAn {
    ArrayList<MONAN> dsma=new ArrayList();

    public DSMonAn() {
    }
    public DSMonAn(DSMonAn ds){ 
        dsma.addAll(ds.getDSMA());
    }
    public ArrayList<MONAN> getDSMA() {
        return dsma;
    }
    public void themMA(MONAN ma){ 
        dsma.add(ma);
    }
    public int getN(){ 
        return dsma.size();
    }
}
