package DAO;

import DTO.CTHOADON;
import DTO.DSKhach;
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
        String query = "SELECT maKH,tenKH,loaiKH,soDienThoai,diaChi FROM KHACHHANG";
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
        String query="INSERT INTO KHACHHANG(maKH,tenKH,loaiKH,soDienThoai,diaChi) VALUES (?,?,?,?,?)" ;
        
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
    // Hoa Don
    public void themHDBH(CTHOADON hdbh,String maKH){
        String queryHD = "INSERT INTO HOADON (maHD,thoiGian,thanhTien,maKH) VALUES(?,?,?,?) "; 
        String queryCTHD = "INSERT INTO CTHOADON (maHD,maMA,soLuongMA) VALUES(?,?,?)";
        try(Connection con = getConnection();
            PreparedStatement pshd = con.prepareStatement(queryHD);
            PreparedStatement pscthd = con.prepareStatement(queryCTHD)) {
            pshd.setString(1, hdbh.getMaHoaDon());
            pshd.setDate(2, new java.sql.Date(hdbh.getThoiGian().getTime()));
            pshd.setDouble(3, hdbh.getThanhTien());
            pshd.setString(4, hdbh.getMaKH());
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
        String query = "SELECT maHD, thoiGian, thanhTien,maKH FROM HOADON";
        try(Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {
                lsb.ThemHDB(new HoaDon(
                        rs.getString("maHD"),
                        rs.getDate("thoiGian"),
                        rs.getDouble("thanhTien"),
                        rs.getString("maKH")
                )
                );
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
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
    String query = "SELECT MAX(maHD) as maxMa FROM HOADON";
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
    public boolean kiemTraTonTaiKH(String maKH){
    String query = "SELECT COUNT(*) FROM KHACHHANG WHERE maKH = ?";
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
