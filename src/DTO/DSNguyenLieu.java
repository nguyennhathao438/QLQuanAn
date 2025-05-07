
package DTO;

import java.util.ArrayList;

public class DSNguyenLieu {
    private ArrayList<NGUYENLIEU> dsnl=new ArrayList();
    public DSNguyenLieu() {
    }
    
    public DSNguyenLieu(DSNguyenLieu ds) {
        dsnl.addAll(ds.getDSNL());
    }
    
    public void themNL(NGUYENLIEU nl){ 
        dsnl.add(nl);
    }
   
    public ArrayList<NGUYENLIEU> getDSNL() {
        return dsnl;
    }
    public int getDoDai(){ 
        return dsnl.size();
    }
}
