
package DTO;

import java.util.ArrayList;

public class DSNCC {
    ArrayList<NHACUNGCAP> dsncc=new ArrayList();
    public void themNCC(NHACUNGCAP ncc){ 
        dsncc.add(ncc);
    }
    public ArrayList<NHACUNGCAP> getDSNCC() {
        return dsncc;
    }
    
}
