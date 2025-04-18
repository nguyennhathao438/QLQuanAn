package DTO;

import java.util.ArrayList;

public class DSKhach {
    ArrayList<khachDTO> dsk = new ArrayList();
    
    public DSKhach(){
    }
    public DSKhach(DSKhach ds){
        dsk.addAll(ds.getDSK());
    }
    public ArrayList<khachDTO> getDSK(){
        return dsk;
    }
    public void themKhach(khachDTO kh){
        dsk.add(kh);
    }
    public int getK(){
        return dsk.size();
    }
}
