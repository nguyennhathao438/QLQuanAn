
package DAO;
import DTO.CTHOADONNH;
import DTO.DSMonAn;
import DTO.DSNCC;
import DTO.DSNguyenLieu;
import DTO.HOADONNHAPHANG;
import DTO.LICHSUNH;
import DTO.MONAN;
import DTO.NGUYENLIEU;
import DTO.NHACUNGCAP;
import DTO.NLNhap;
import DTO.THANHPHAN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectedDatabase;
public class QuanKhoDAO {
    ConnectedDatabase kn = new ConnectedDatabase();
    public Connection getConnection(){ 
        return ConnectedDatabase.getConnectedDB();
    }
    public void layNL(DSNguyenLieu dsnl){ 
        String query ="SELECT maNL,LOAINL.maLoaiNL,tenNL,tongSoLuong,moTa,LOAINL.donVi,trangThai FROM NGUYENLIEU,LOAINL WHERE NGUYENLIEU.maLoaiNL=LOAINL.maLoaiNL";
        try(Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){ 
            while(rs.next()){ 
                String maNL=rs.getString("maNL");
                String loaiNL=rs.getString("maLoaiNL");
                String tenNL=rs.getString("tenNL");
                Float tongSoLuong =rs.getFloat("tongSoLuong");
                String moTa = rs.getString("moTa");
                String donVi=rs.getString("donVi");
                int trangThai=rs.getInt("trangThai");
                dsnl.themNL(new NGUYENLIEU(maNL,loaiNL,tenNL,tongSoLuong,moTa,donVi,trangThai));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public void themNL(NGUYENLIEU nl) throws SQLException{ 
        String query="INSERT INTO NGUYENLIEU(maNL,maLoaiNL,tenNL,tongSoLuong,moTa,trangThai) VALUES (?,?,?,0,?,1)" ; 
        
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
                ) {
            stmt.setString(1,nl.getMaNL());
            stmt.setString(2,nl.getMaLoaiNL());
            stmt.setString(3,nl.getTenNL());
            stmt.setString(4,nl.getMoTa());
             stmt.executeUpdate();
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }         
    }  
    public void xoaNL(String maNL) throws SQLException{ 
      
        String sql="UPDATE NGUYENLIEU SET trangThai = 0 WHERE maNL = ?;";
        try(Connection conn =getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){ 
            stmt.setString(1,maNL);
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    public void suaNL(NGUYENLIEU nl) throws SQLException{ 
            String sql="UPDATE NGUYENLIEU SET maLoaiNL=?,tenNL=?,moTa=? WHERE maNL=?;";
        try(Connection conn =getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){            
            stmt.setString(1,nl.getMaLoaiNL());
            stmt.setString(2,nl.getTenNL());
            stmt.setString(3,nl.getMoTa());
            stmt.setString(4,nl.getMaNL());
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    public String layTenLoaiNL(String ma){ 
        String query="SELECT loaiNL FROM LOAINL WHERE maLoaiNL=?";
        String tenLoaiNL = "";
        try(
        Connection conn=getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);){
        stmt.setString(1,ma);
             ResultSet rs = stmt.executeQuery();
             rs.next();
             tenLoaiNL = rs.getString("loaiNL");
             } catch (SQLException ex) { 
            Logger.getLogger(QuanKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenLoaiNL ;
    }
    public String layMaLoaiNL(String loaiNL){ 
        String query=" SELECT maLoaiNL FROM LOAINL WHERE loaiNL=?";
        String maLoaiNL="";
        try(Connection conn=getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);){
        
        stmt.setString(1,loaiNL);
             ResultSet rs = stmt.executeQuery();
             if(rs.next()){
             maLoaiNL = rs.getString("maLoaiNL");
             return maLoaiNL;
             }
        } catch (SQLException ex) {
            Logger.getLogger(QuanKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maLoaiNL;
    }
    //Nha cung cap
    public void layNCC(DSNCC dsncc){ 
        String query="SELECT NHACUNGCAP.maNCC, NHACUNGCAP.tenNCC, STUFF((SELECT ', ' + NCC_SDT.soDienThoai FROM NCC_SDT WHERE NCC_SDT.maNCC = NHACUNGCAP.maNCC FOR XML PATH('')), 1, 2, '') AS soDienThoai FROM NHACUNGCAP WHERE trangThai=1;";
        try(Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){ 
            while(rs.next()){ 
                String maNCC=rs.getString("maNCC");
                String tenNCC=rs.getString("TenNCC");
                String sdt=rs.getString("soDienThoai");
                dsncc.themNCC(new NHACUNGCAP(maNCC,tenNCC,sdt));
            }
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public void themNCC(NHACUNGCAP ncc){ 
         String queryNCC = "INSERT INTO NHACUNGCAP (maNCC, tenNCC, trangThai) VALUES (?, ?, 1)"; 
         String querySDT = "INSERT INTO NCC_SDT (maNCC, soDienThoai) VALUES (?, ?)";
         try(Connection conn = getConnection();
            PreparedStatement stmtncc = conn.prepareStatement(queryNCC);
                 PreparedStatement stmtsdt = conn.prepareStatement(querySDT)) {
            stmtncc.setString(1,ncc.getMaNCC());
            stmtncc.setString(2,ncc.getTenNCC());
             stmtncc.executeUpdate();
             String listSDT[]=ncc.getSdt().split(",");
             for(String sdt: listSDT){ 
                 stmtsdt.setString(1,ncc.getMaNCC());
                 stmtsdt.setString(2,sdt);
                 stmtsdt.executeUpdate();
             }
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }
    }
    public void xoaNCC(String mancc) throws SQLException {
        String query = "UPDATE NHACUNGCAP SET trangThai = 0 WHERE maNCC = ?;";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, mancc);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suaNCC(NHACUNGCAP ncc) throws SQLException {
        String query = "UPDATE NHACUNGCAP SET tenNCC = ? WHERE maNCC = ?";
        String queryxoasdt = "DELETE FROM NCC_SDT WHERE maNCC = ?";
        String querythemsdt = "INSERT INTO NCC_SDT (maNCC, soDienThoai) VALUES (?, ?)";
        try (
                Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query); PreparedStatement stmtxsdt = conn.prepareStatement(queryxoasdt); PreparedStatement stmttsdt = conn.prepareStatement(querythemsdt);) {

            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getMaNCC());
            stmt.executeUpdate();
            stmtxsdt.setString(1, ncc.getMaNCC());
            stmtxsdt.executeUpdate();
            String sdt[] = ncc.getSdt().split(",");
            for (String a : sdt) {
                stmttsdt.setString(1, ncc.getMaNCC());
                stmttsdt.setString(2, a);
                stmttsdt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Hoa Don Nhap Hang
    public void layHDNH(LICHSUNH lsnh){ 
       String query="SELECT hd.maHDNH, hd.ngayNhap,hd.userID, ncc.tenNCC, SUM(cthd.soLuong * cthd.gia) AS tongThanhTien FROM HOADONNH hd JOIN NHACUNGCAP ncc ON hd.maNCC = ncc.maNCC JOIN CTHOADONNH cthd ON hd.maHDNH = cthd.maHDNH WHERE hd.trangThai = 1 GROUP BY hd.maHDNH, hd.ngayNhap, ncc.tenNCC,hd.userID ORDER BY hd.maHDNH;";
        try(Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){ 
            while (rs.next()) {
            
            lsnh.themHDNH(new HOADONNHAPHANG(
                rs.getString("maHDNH"),
                rs.getDate("ngayNhap"),
                rs.getDouble("tongThanhTien"),
                rs.getString("tenNCC"),
                rs.getInt("userID")
            )
            );
        }            
        }catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public CTHOADONNH chitietHDNH(String mahd){ 
        CTHOADONNH cthd =new CTHOADONNH();
        String query="SELECT hd.maHDNH, hd.ngayNhap, ncc.tenNCC, nl.tenNL, cthd.soLuong, cthd.gia, cthd.hsd, (cthd.soLuong * cthd.gia) AS thanhTien FROM HOADONNH hd JOIN NHACUNGCAP ncc ON hd.maNCC = ncc.maNCC JOIN CTHOADONNH cthd ON hd.maHDNH = cthd.maHDNH JOIN NGUYENLIEU nl ON cthd.maNL = nl.maNL WHERE hd.maHDNH = ?;";
        try(Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ){
            stmt.setString(1,mahd);
            
       
            double tongThanhTien =0;
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<NLNhap> dsnl =new ArrayList();
            while (rs.next()) {
                
            if(dsnl.isEmpty()){ 
                cthd.setMaHDNH(rs.getString("maHDNH"));
            cthd.setNgayNhap(rs.getDate("ngayNhap"));
            cthd.setTenNCC(rs.getString("tenNCC"));
            
            
            }
               dsnl.add(new NLNhap(rs.getFloat("soLuong"),rs.getDouble("thanhTien"),rs.getDate("hsd"),rs.getString("tenNL")));
               tongThanhTien +=rs.getDouble("thanhTien");
        }  
            cthd.setDsnlnhap(dsnl);
            cthd.setThanhTien(tongThanhTien);
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return cthd;
    }
    public void themHDNH(CTHOADONNH hdnh, String maNCC, String[] maNL) {
        String queryHD = "INSERT INTO HOADONNH (maHDNH,ngayNhap,trangThai,maNCC,userID) VALUES(?,?,1,?,?) ";
        String queryCTHD = "INSERT INTO CTHOADONNH (maHDNH,maNL,soLuong,gia,hsd) VALUES(?,?,?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement stmthd = conn.prepareStatement(queryHD); PreparedStatement stmtcthd = conn.prepareStatement(queryCTHD)) {
            stmthd.setString(1, hdnh.getMaHDNH());
            stmthd.setDate(2, new java.sql.Date(hdnh.getNgayNhap().getTime()));
            stmthd.setString(3, maNCC);
            stmthd.setInt(4, hdnh.getMangLam());
            stmthd.executeUpdate();
            int i = 0;
            for (NLNhap a : hdnh.getDsnlnhap()) {
                stmtcthd.setString(1, hdnh.getMaHDNH());
                stmtcthd.setString(2, maNL[i]);
                stmtcthd.setFloat(3, a.getSoLuong());
                stmtcthd.setDouble(4, a.getGia());
                stmtcthd.setDate(5, new java.sql.Date(a.getHsd().getTime()));
                stmtcthd.addBatch();
                i++;
            }
            stmtcthd.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Mon An
    public void layDSMonAn(DSMonAn dsma) {
        String query = "SELECT *FROM MONAN";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                MONAN ma = new MONAN();
                ma.setMaMA(rs.getString("maMA"));
                ma.setTenMA(rs.getString("tenMA"));
                ma.setLoaiMA(rs.getString("loaiMA"));
                ma.setMoTa(rs.getString("moTa"));
                ma.setGia(rs.getDouble("gia"));
                ma.setTrangThai(rs.getInt("trangThai"));
                dsma.themMA(ma);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String getLoaiMAByMaMA(String maMA) {
        String query = "SELECT loaiMA FROM MONAN WHERE maMA = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maMA);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("loaiMA");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy hoặc có lỗi
    }
    public void layMonAnDcBan(DSMonAn dsma) {
        String query = "SELECT MONAN.maMA,tenMA,loaiMA,MONAN.moTa,gia,MONAN.trangThai ,MIN(FLOOR(NGUYENLIEU.tongSoLuong / THANHPHAN.soLuongNL)) AS soLuongCoTheBan\n"
                + "FROM MONAN \n"
                + "JOIN THANHPHAN ON MONAN.maMA= THANHPHAN.maMA\n"
                + "JOIN NGUYENLIEU ON THANHPHAN.maNL = NGUYENLIEU.maNL\n"
                + "GROUP BY MONAN.maMA ,MONAN.maMA,tenMA,loaiMA,MONAN.moTa,gia,MONAN.trangThai ";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                MONAN ma = new MONAN(
                        rs.getString("maMA"),
                        rs.getString("tenMA"),
                        rs.getString("loaiMA"),
                        rs.getString("moTa"),
                        rs.getDouble("gia"),
                        rs.getInt("trangThai"),
                        rs.getInt("soLuongCoTheBan")
                );
                dsma.themMA(ma);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void themMonAn(MONAN ma){ 
        String query="INSERT INTO MONAN(maMA,tenMA,loaiMA,moTa,gia,trangThai) VALUES (?,?,?,?,?,2)" ;
        
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,ma.getMaMA());
            stmt.setString(2,ma.getTenMA());
            stmt.setString(3,ma.getLoaiMA());
            stmt.setString(4,ma.getMoTa());
            stmt.setDouble(5,ma.getGia());
             stmt.executeUpdate();
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }  
    }
    public void xoaMonAn(String maMA){ 
        String sql="UPDATE MONAN SET trangThai = 0 WHERE maMA = ?;";
        try(Connection conn =getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){ 
            stmt.setString(1,maMA);
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    public void suaMonAn(MONAN ma){ 
            String sql="UPDATE MONAN SET tenMA=?,loaiMA=?,moTa=?,gia=? WHERE maMA=?;";
        try(Connection conn =getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){            
            stmt.setString(1,ma.getTenMA());
            stmt.setString(2,ma.getLoaiMA());
            stmt.setString(3,ma.getMoTa());
            stmt.setDouble(4,ma.getGia());
            stmt.setString(5,ma.getMaMA());
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    //THANH PHAN
    public void layTP(String maMonAn,THANHPHAN tp){ 
        String query="SELECT maNL,soLuongNL FROM THANHPHAN WHERE maMA=?";
        try(Connection conn =getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ){
            stmt.setString(1,maMonAn);
            String maNL[]=new String[10];
            Float slNL[]=new Float[10];
            int i=0;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               maNL[i]=rs.getString("maNL");
               slNL[i]=rs.getFloat("soLuongNL");
               i++;
        }  
            tp.setMaMA(maMonAn);
            tp.setMaNL(maNL);
            tp.setSoLuong(slNL);
            tp.setN(i);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }
    public void themTP(THANHPHAN tp){ 
        String query="INSERT INTO THANHPHAN(maMA,maNL,soLuongNL) VALUES (?,?,?)" ;
        String queryU="UPDATE MONAN SET trangThai = 1 WHERE maMA = ?;";
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
                PreparedStatement stmtU = conn.prepareStatement(queryU)) {
            stmtU.setString(1,tp.getMaMA());
            stmtU.executeUpdate();
            for(int i=0;i<tp.getN();i++){
            stmt.setString(1,tp.getMaMA());
            stmt.setString(2,tp.getMaNL()[i]);            
            stmt.setFloat(3,tp.getSoLuong()[i]);
             stmt.addBatch();
            }
            stmt.executeBatch();
        }catch(SQLException ex){ 
            ex.printStackTrace();
        } 
    }
    public void suaTP(THANHPHAN tp){ 
        String queryd = "DELETE FROM THANHPHAN WHERE maMA = ?";
        String querya="INSERT INTO THANHPHAN(maMA,maNL,soLuongNL) VALUES (?,?,?)";
        try(Connection conn =getConnection();
            PreparedStatement stmta = conn.prepareStatement(querya);
               PreparedStatement stmtd = conn.prepareStatement(queryd) ) {
            conn.setAutoCommit(false); 
            stmtd.setString(1,tp.getMaMA());
            stmtd.executeUpdate();
            for(int i=0;i<tp.getN();i++){
                if(tp.getSoLuong()[i]==null || tp.getMaNL()[i]==null) continue;
            stmta.setString(1,tp.getMaMA());
            stmta.setString(2,tp.getMaNL()[i]);            
            stmta.setFloat(3,tp.getSoLuong()[i]);
            
             stmta.addBatch();
            }
            stmta.executeBatch();
            stmta.clearBatch();
            conn.commit();
        }catch(SQLException ex){ 
            ex.printStackTrace();
            try (Connection conn = getConnection()) {
            conn.rollback(); // Hủy bỏ nếu có lỗi
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        } 
    }
    public void setTTTP(String maMA){ 
            String sql="UPDATE MONAN SET trangThai=2 WHERE maMA=?;";
        try(Connection conn =getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){                      
            stmt.setString(1,maMA);
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
     public boolean kiemTraTrungMaNCC(String maNCC) {
    String sql = "SELECT COUNT(*) FROM NHACUNGCAP WHERE maNCC = ?";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, maNCC);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu đã tồn tại
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}
