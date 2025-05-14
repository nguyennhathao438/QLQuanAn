package DTO;

import java.util.ArrayList;
import DTO.Ban;
public class BanManager {
    public static final int soluongban = 20;
    public static Ban[] dsBan = new Ban[soluongban];
    public static DSMonAnBan[] dsmab = new DSMonAnBan[soluongban];
    public static DSDatBan[] dsdb = new DSDatBan[soluongban];
    static{
        for(int i = 0 ; i < soluongban ; i++){
           dsBan[i] = new Ban();
           dsBan[i].setTrangthai("Trống");
           dsmab[i] = new DSMonAnBan();
           dsdb[i] = new DSDatBan();
        }
    }
    public static int getsoluongban(){
        return soluongban;
    }
    public static void taoDon(int soban){
        dsBan[soban].setTrangthai("Đang Dùng");
    }
    public static void DatBan(int soban){
        dsBan[soban].setTrangthai("Đã Đặt");
    }
    public static boolean isTrongBan(int soban){
        return dsBan[soban].getTrangthai().equalsIgnoreCase("Trống");
    }
    public static void themTT(int soban,DatBan db){
        dsdb[soban].themTT(db);
    }
    public static DSDatBan layTT(int soban){
        return dsdb[soban];
    }
    public static void XoaDatTruoc(int soban){
        dsdb[soban] = new DSDatBan();
    }
    public static void themMon(int soban,MonAnBan mab){
        dsmab[soban].themMA(mab);
    }
    public static DSMonAnBan laydsmon(int soban){
        return dsmab[soban];
    }
    public static void thanhtoan(int soban){
        dsmab[soban] = new DSMonAnBan();
    }
    public static void Capnhattt(int soban,String trangthai){
        if(soban >= 0 && soban < dsBan.length){
            dsBan[soban].setTrangthai(trangthai);
        }
    }
}
