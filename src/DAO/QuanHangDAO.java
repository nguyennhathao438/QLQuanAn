package DAO;

import DTO.CTHOADON;
import DTO.DSKhach;
import DTO.DSMonAn;
import DTO.DSMonAnBan;
import DTO.HoaDon;
import DTO.LICHSUBAN;
import DTO.MonAnBan;
import DTO.khachDTO;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectedDatabase;
public class QuanHangDAO {
    ConnectedDatabase qh = new ConnectedDatabase();
    public Connection getConnection(){
        return ConnectedDatabase.getConnectedDB();
    }
    // lam viec voi Khach Hang
    public void LayKH(DSKhach dsk){
        String query = "SELECT maKH,tenKH,loaiKH,soDienThoai,diaChi FROM KHACHHANG WHERE trangThai = 1";
        try(Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()) {
                khachDTO kh = new khachDTO(
                            rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("loaiKH"),
                        rs.getString("soDienThoai"),
                        rs.getString("diaChi")
                );
                dsk.themKhach(kh);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void themKH(khachDTO kh){
        String query="INSERT INTO KHACHHANG(maKH,tenKH,loaiKH,soDienThoai,diaChi,trangThai) VALUES (?,?,?,?,?,1)" ;
        
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,kh.getMaKH());
            stmt.setString(2,kh.getTenkhach());
            stmt.setString(3,kh.getLoaiKhach());
            stmt.setString(4,kh.getSDT());
            stmt.setString(5,kh.getDiachi());
             stmt.executeUpdate();
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }
    }
    public void suaKH(khachDTO kh){
        String sql="UPDATE KHACHHANG SET tenKH=?,loaiKH=?,soDienThoai=?,diaChi=? WHERE maKH=?;";
        try(Connection conn =getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){            
            stmt.setString(1,kh.getTenkhach());
            stmt.setString(2,kh.getLoaiKhach());
            stmt.setString(3,kh.getSDT());
            stmt.setString(4,kh.getDiachi());
            stmt.setString(5,kh.getMaKH());
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    public void xoaKH(String maKH) throws SQLException{
        String query ="UPDATE KHACHHANG SET trangThai = 0 WHERE maKH = ?;";
                try(Connection con = getConnection();
                        PreparedStatement stmt = con.prepareStatement(query)){
                    stmt.setString(1, maKH);
                    stmt.executeUpdate();
                } catch(SQLException e){
                    e.printStackTrace();
                }
    }
    // Hoa Don
    public void themCTHDBH(MonAnBan mab,String soban){ 
        String maHDtam ="HDBAN"+soban;
        String query ="INSERT INTO CTHOADON (maHD,maMA,soLuongMA) VALUES(?,?,?)";
        try(Connection conn = getConnection();
             PreparedStatement pscthd = conn.prepareStatement(query);
                ){ 
                pscthd.setString(1, maHDtam);
                pscthd.setString(2, mab.getMaMA());
                pscthd.setInt(3, mab.getSoluong());
                pscthd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    // 700 -`100 -100 +200 -100 600 -100 
    public void themHDBH(CTHOADON hdbh,String maKH,String soban){
        String maHDtam ="HDBAN"+soban;
        String query = "DELETE FROM CTHOADON WHERE maHD=?";
        String queryHD = "INSERT INTO HOADON (maHD,thoiGian,thanhTien,maKH,userID) VALUES(?,?,?,?,?) "; 
        String queryCTHD = "INSERT INTO CTHOADON (maHD,maMA,soLuongMA) VALUES(?,?,?)";
        try(Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(query);
            PreparedStatement pshd = con.prepareStatement(queryHD);
            PreparedStatement pscthd = con.prepareStatement(queryCTHD)) {
            stmt.setString(1,maHDtam);
            stmt.executeUpdate();
            pshd.setString(1, hdbh.getMaHoaDon());
            pshd.setDate(2, new java.sql.Date(hdbh.getThoiGian().getTime()));
            pshd.setDouble(3, hdbh.getThanhTien());
            pshd.setString(4, hdbh.getMaKH());
            pshd.setInt(5, hdbh.getTenUser());
            pshd.executeUpdate();
            int i = 0;
            for(MonAnBan a:hdbh.getDsma()){
                pscthd.setString(1, hdbh.getMaHoaDon());
                pscthd.setString(2, a.getMaMA());
                pscthd.setInt(3, a.getSoluong());
                pscthd.addBatch();
                i++;
            }
            pscthd.executeBatch();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    public void LayHDBH(LICHSUBAN lsb){
        String query = "SELECT hd.maHD, hd.thoiGian, hd.thanhTien, kh.tenKH, hd.userID FROM HOADON hd LEFT JOIN KHACHHANG kh ON hd.maKH = kh.maKH WHERE maHD LIKE 'HD___'";
        try(Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {
                lsb.ThemHDB(new HoaDon(
                        rs.getString("maHD"),
                        rs.getDate("thoiGian"),
                        rs.getDouble("thanhTien"),
                        rs.getString("tenKH"),
                        rs.getInt("userID")
                )
                );
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public CTHOADON LayHD(String maHD){
        CTHOADON ct =new CTHOADON();
        String query = "SELECT * FROM HOADON,CTHOADON,MONAN WHERE HOADON.maHD=CTHOADON.maHD AND CTHOADON.maMA=MONAN.maMA AND HOADON.maHD =?";
        try(Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {
           stmt.setString(1,maHD);
           ResultSet rs= stmt.executeQuery();
           ArrayList<MonAnBan> dsma = new ArrayList();
           MonAnBan ma;
            if(rs.next()){ 
                ct.setMaHoaDon(maHD);
                ct.setMaKH(rs.getString("maKH"));
                ct.setThanhTien(rs.getDouble("thanhTien"));
                ct.setThoiGian( new java.sql.Date(rs.getDate("thoiGian").getTime()));
                ma = new MonAnBan();
                ma.setMaMA(rs.getString("maMA"));
                ma.setTenMA(rs.getString("tenMA"));
                ma.setSoluong(rs.getInt("soLuongMA"));
                ma.setThanhtien(rs.getDouble("gia"));
                dsma.add(ma);
            }
           while(rs.next()){ 
               ma = new MonAnBan();
                ma.setMaMA(rs.getString("maMA"));
                ma.setTenMA(rs.getString("tenMA"));
                ma.setSoluong(rs.getInt("soLuongMA"));
                ma.setThanhtien(rs.getDouble("gia"));
                dsma.add(ma);
           }
           ct.setDsma(dsma);
        }catch (SQLException ex) {
            Logger.getLogger(QuanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct ;
    }
    public CTHOADON LayCTHDBH(String hd){
        CTHOADON cthdbh = new CTHOADON();
        String query = "SELECT hd.maHD, ma.tenMA, cthd.soLuongMA, ma.gia ,(ma.gia * cthd.soLuongMA) AS thanhtien "
                + "FROM HOADON hd "
                + "JOIN CTHOADON cthd ON hd.maHD = cthd.maHD "
                + "JOIN MONAN ma ON cthd.maMA = ma.maMA "
                + "WHERE hd.maHD = ?;";
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query);){
            ps.setString(1, hd);
            
            ResultSet rs = ps.executeQuery();

            ArrayList<MonAnBan> dsmab = new ArrayList();
            while(rs.next()){
                if(dsmab.isEmpty()){
                    cthdbh.setMaHoaDon(rs.getString("maHD"));
                }
                String maMA = rs.getString("tenMA");
                String tenMA = rs.getString("tenMA");
                int soluong = rs.getInt("soLuongMA");
                double gia = rs.getDouble("gia");
                double thanhtien = rs.getDouble("thanhtien");
                
                MonAnBan mab = new MonAnBan(maMA, tenMA, soluong, gia);
                
                mab.setThanhtien(thanhtien);
                dsmab.add(mab);
            }
            cthdbh.setDsma(dsmab);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cthdbh;
    }
    public String taoMaHoaDonMoi() {
    String prefix = "HD";
    String query = "SELECT MAX(maHD) as maxMa FROM HOADON WHERE maHD LIKE 'HD___'";
    try (Connection con = getConnection();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next() && rs.getString("maxMa") != null) {
            String maxMa = rs.getString("maxMa"); // ví dụ: "HD005"
            int so = Integer.parseInt(maxMa.substring(2)); // lấy số 5
            so++; // tăng lên 6
            return String.format("%s%03d", prefix, so); // HD006
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    // Nếu không có mã nào -> bắt đầu từ HD001
    return "HD001";
}
    public String taomaKH(){
        String ma = "KH";
        String query = "SELECT MAX(maKH) as maxMa FROM KHACHHANG WHERE maKH LIKE 'KH___'";
        try(Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            if (rs.next() && rs.getString("maxMa") != null) {
                String maxMa = rs.getString("maxMa");
                int so = Integer.parseInt(maxMa.substring(2));
                so++;
                return String.format("%s%03d", ma, so);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "KH001";
    }
    public boolean kiemTraTonTaiKH(String maKH){
    String query = "SELECT COUNT(*) FROM KHACHHANG WHERE maKH = ? AND trangThai = 1";
    try(Connection con = getConnection(); 
        PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, maKH);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return rs.getInt(1) > 0;
        }
    } catch(SQLException ex){
        ex.printStackTrace();
    }
    return false;
}

}
