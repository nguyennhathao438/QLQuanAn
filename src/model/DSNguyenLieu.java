
package model;

import java.util.ArrayList;

public class DSNguyenLieu {
    private ArrayList<NGUYENLIEU> dsnl=new ArrayList();
    public void themNL(NGUYENLIEU nl){ 
        dsnl.add(nl);
    }

    public ArrayList<NGUYENLIEU> getDSNL() {
        return dsnl;
    }
    
}
