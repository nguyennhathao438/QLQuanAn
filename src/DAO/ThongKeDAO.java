
package DAO;

import DTO.DSMonAn;
import DTO.ThongKeThuChi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectedDatabase;

public class ThongKeDAO {
    public Connection getConnection(){ 
        return ConnectedDatabase.getConnectedDB();
    }
    public ArrayList<ThongKeThuChi> thongKeChiThang(String nam){ 
        ArrayList<ThongKeThuChi> dstk = new ArrayList();
        String query = "SELECT MONTH(ngayNhap) AS thang,SUM(CTHOADONNH.gia) AS tong_tien FROM HOADONNH JOIN CTHOADONNH ON HOADONNH.maHDNH =CTHOADONNH.maHDNH WHERE YEAR(ngayNhap) = ? GROUP BY MONTH(ngayNhap) ORDER BY thang ";
        try(Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)){ 
            stmt.setString(1,nam);
            ResultSet rs = stmt.executeQuery();
            ThongKeThuChi tk ;
            while(rs.next()){ 
                tk= new ThongKeThuChi();
                tk.setThoiGian(rs.getInt("thang"));
                tk.setSoTien(rs.getDouble("tong_tien"));
                dstk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstk;
    }
    public ArrayList<ThongKeThuChi> thongKeThuThang(String nam){ 
        ArrayList<ThongKeThuChi> dstk = new ArrayList();
        String query = "SELECT MONTH(thoiGian)as thang,SUM(thanhTien) as tong_tien FROM HOADON WHERE YEAR(thoiGian)=? GROUP BY MONTH(thoiGian) ORDER BY thang";
        try(Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)){ 
            stmt.setString(1,nam);
            ResultSet rs = stmt.executeQuery();
            ThongKeThuChi tk ;
            while(rs.next()){ 
                tk= new ThongKeThuChi();
                tk.setThoiGian(rs.getInt("thang"));
                tk.setSoTien(rs.getDouble("tong_tien"));
                dstk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstk;
    }
    public ArrayList<ThongKeThuChi> thongKeChiQuy(String nam){ 
        ArrayList<ThongKeThuChi> dstk = new ArrayList();
        String query = "SELECT DATEPART(QUARTER,ngayNhap) AS quy,SUM(CTHOADONNH.gia) AS tong_tien FROM HOADONNH JOIN CTHOADONNH ON HOADONNH.maHDNH =CTHOADONNH.maHDNH WHERE YEAR(ngayNhap) =? GROUP BY DATEPART(QUARTER,ngayNhap) ORDER BY quy";
        try(Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)){ 
            stmt.setString(1,nam);
            ResultSet rs = stmt.executeQuery();
            ThongKeThuChi tk ;
            while(rs.next()){ 
                tk= new ThongKeThuChi();
                tk.setThoiGian(rs.getInt("quy"));
                tk.setSoTien(rs.getDouble("tong_tien"));
                dstk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstk;
    }
    public ArrayList<ThongKeThuChi> thongKeThuQuy(String nam){ 
        ArrayList<ThongKeThuChi> dstk = new ArrayList();
        String query = "SELECT DATEPART(QUARTER,thoiGian) AS quy,SUM(thanhTien) AS tong_tien FROM HOADON  WHERE YEAR(thoiGian) = ? GROUP BY DATEPART(QUARTER,thoiGian) ORDER BY quy";
        try(Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)){ 
            stmt.setString(1,nam);
            ResultSet rs = stmt.executeQuery();
            ThongKeThuChi tk ;
            while(rs.next()){ 
                tk= new ThongKeThuChi();
                tk.setThoiGian(rs.getInt("quy"));
                tk.setSoTien(rs.getDouble("tong_tien"));
                dstk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstk;
    }
    public ArrayList<ThongKeThuChi> thongKeLuongThang(String nam){ 
        ArrayList<ThongKeThuChi> dstk = new ArrayList();
        String query = "SELECT thangChamCong as thang,SUM(Luong.ThucLanh) AS tong_tien FROM ChamCong JOIN LUONG ON Luong.maBCC=ChamCong.maBCC WHERE namChamCong = ? GROUP BY thangChamCong ORDER BY thangChamCong ASC";
        try(Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)){ 
            stmt.setString(1,nam);
            ResultSet rs = stmt.executeQuery();
            ThongKeThuChi tk ;
            while(rs.next()){ 
                tk= new ThongKeThuChi();
                tk.setThoiGian(rs.getInt("thang"));
                tk.setSoTien(rs.getDouble("tong_tien"));
                dstk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstk;
    }
    public ArrayList<ThongKeThuChi> thongKeDoanhThuThang(String nam){ 
        ArrayList<ThongKeThuChi> dstk = new ArrayList();
        String query = "SELECT thangChamCong as thang , ( ISNULL((SELECT SUM(thanhTien) FROM HOADON WHERE MONTH(thoiGian) = cc.thangChamCong AND YEAR(thoiGian)= cc.namChamCong ),0 ) - ISNULL((SELECT SUM(gia) FROM CTHOADONNH JOIN HOADONNH ON CTHOADONNH.maHDNH=HOADONNH.maHDNH WHERE MONTH(HOADONNH.ngayNhap) = cc.thangChamCong AND YEAR(HOADONNH.ngayNhap)= cc.namChamCong ),0) -ISNULL((SELECT SUM(thucLanh) FROM Luong JOIN ChamCong cc1 ON Luong.maBCC =cc1.maBCC WHERE cc1.thangChamCong = cc.thangChamCong AND cc1.namChamCong=cc.namChamCong),0) )as doanh_thu FROM ChamCong cc WHERE namChamCong = ? ORDER BY thang ASC";
        try(Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)){ 
            stmt.setString(1,nam);
            ResultSet rs = stmt.executeQuery();
            ThongKeThuChi tk ;
            while(rs.next()){ 
                tk= new ThongKeThuChi();
                tk.setThoiGian(rs.getInt("thang"));
                tk.setSoTien(rs.getDouble("doanh_thu"));
                dstk.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dstk;
    }
    
}
