
package DTO;

import java.util.ArrayList;

public class DSMonAnBan {
    ArrayList<MonAnBan> dsmab = new ArrayList();
    
    public DSMonAnBan(){
    }
    public DSMonAnBan(DSMonAnBan ds){ 
        dsmab.addAll(ds.getDSMAB());
    }
    public ArrayList<MonAnBan> getDSMAB() {
        return dsmab;
    }
    public void themMA(MonAnBan ma){ 
        dsmab.add(ma);
    }
    public void xoaMA(MonAnBan ma){
        dsmab.remove(ma);
    }
    public int getSL(){ 
        return dsmab.size();
    }
}
