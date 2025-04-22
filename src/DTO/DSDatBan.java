
package DTO;

import java.util.ArrayList;

public class DSDatBan {
    ArrayList<DatBan> dsdb = new ArrayList();
    
    public DSDatBan(){
    }
    public DSDatBan(DSDatBan dsdb){ 
        this.dsdb.addAll(dsdb.getDSDB());
    }
    public ArrayList<DatBan> getDSDB() {
        return dsdb;
    }
    public void themTT(DatBan db){ 
        dsdb.add(db);
    }    
}
