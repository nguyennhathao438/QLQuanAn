
package model;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
public class KetNoiDataBase {
    SQLServerDataSource ds=new SQLServerDataSource();
    public void ketNoiDB(){ 
        var server = "DESKTOP-SAC9NS5";
        var user = "sa";
        var password = "quencmnr";
        var db = "QLQuanAn";
        var port = 1433;

        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setTrustServerCertificate(true);
    }
    public void layNL(DSNguyenLieu dsnl){ 
        ketNoiDB();
        String query ="SELECT maNL,LOAINL.maLoaiNL,tenNL,tongSoLuong,moTa,LOAINL.donVi,trangThai FROM NGUYENLIEU,LOAINL WHERE NGUYENLIEU.maLoaiNL=LOAINL.maLoaiNL";
        try(Connection conn = ds.getConnection();
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
        ketNoiDB();
        String query="INSERT INTO NGUYENLIEU(maNL,maLoaiNL,tenNL,tongSoLuong,moTa,trangThai) VALUES (?,?,?,0,?,1)" ; 
        
        try(Connection conn = ds.getConnection();
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
        ketNoiDB();
        String sql="UPDATE NGUYENLIEU SET trangThai = 0 WHERE maNL = ?;";
        try(Connection conn =ds.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){ 
            stmt.setString(1,maNL);
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    public void suaNL(NGUYENLIEU nl) throws SQLException{ 
        ketNoiDB();
            String sql="UPDATE NGUYENLIEU SET maLoaiNL=?,tenNL=?,moTa=? WHERE maNL=?;";
        try(Connection conn =ds.getConnection();
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
    public String layTenLoaiNL(String ma) throws SQLServerException, SQLException{ 
        String query="SELECT loaiNL FROM LOAINL WHERE maLoaiNL=?";
        Connection conn=ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,ma);
             ResultSet rs = stmt.executeQuery();
             rs.next();
             String tenLoaiNL = rs.getString("loaiNL");
             return tenLoaiNL;
        
    }
    public String layMaLoaiNL(String loaiNL) throws SQLServerException, SQLException{ 
        String query=" SELECT maLoaiNL FROM LOAINL WHERE loaiNL=?";
        Connection conn=ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,loaiNL);
             ResultSet rs = stmt.executeQuery();
             rs.next();
             String maLoaiNL = rs.getString("maLoaiNL");
             return maLoaiNL;
        
    }
    //Nha cung cap
    public void layNCC(DSNCC dsncc){ 
        ketNoiDB();
        String query="SELECT NHACUNGCAP.maNCC, NHACUNGCAP.tenNCC, STUFF((SELECT ', ' + NCC_SDT.soDienThoai FROM NCC_SDT WHERE NCC_SDT.maNCC = NHACUNGCAP.maNCC FOR XML PATH('')), 1, 2, '') AS soDienThoai FROM NHACUNGCAP WHERE trangThai=1;";
        try(Connection conn = ds.getConnection();
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
        ketNoiDB();
         String queryNCC = "INSERT INTO NHACUNGCAP (maNCC, tenNCC, trangThai) VALUES (?, ?, 1)"; 
         String querySDT = "INSERT INTO NCC_SDT (maNCC, soDienThoai) VALUES (?, ?)";
         try(Connection conn = ds.getConnection();
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
    public void xoaNCC(String mancc) throws SQLException{ 
        ketNoiDB();
        String query ="UPDATE NHACUNGCAP SET trangThai = 0 WHERE maNCC = ?;";   
        try(Connection conn= ds.getConnection();
                PreparedStatement stmt=conn.prepareStatement(query)){ 
         stmt.setString(1,mancc);
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    public void suaNCC(NHACUNGCAP ncc) throws SQLException{ 
        ketNoiDB();
        String query="UPDATE NHACUNGCAP SET tenNCC = ? WHERE maNCC = ?";
        String queryxoasdt="DELETE FROM NCC_SDT WHERE maNCC = ?";
        String querythemsdt="INSERT INTO NCC_SDT (maNCC, soDienThoai) VALUES (?, ?)";
        try(
        Connection conn=ds.getConnection();
        PreparedStatement stmt=conn.prepareStatement(query);
        PreparedStatement stmtxsdt=conn.prepareStatement(queryxoasdt);
        PreparedStatement stmttsdt=conn.prepareStatement(querythemsdt);){
         
        stmt.setString(1,ncc.getTenNCC());
        stmt.setString(2,ncc.getMaNCC());
        stmt.executeUpdate();
        stmtxsdt.setString(1, ncc.getMaNCC());
        stmtxsdt.executeUpdate();
        String sdt[]=ncc.getSdt().split(",");
        for(String a:sdt){ 
            stmttsdt.setString(1,ncc.getMaNCC());
            stmttsdt.setString(2, a);
            stmttsdt.executeUpdate();
        }
    }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    //Hoa Don Nhap Hang
    public void layHDNH(LICHSUNH lsnh){ 
        ketNoiDB();
       String query="SELECT hd.maHDNH, hd.ngayNhap, ncc.tenNCC, SUM(cthd.soLuong * cthd.gia) AS tongThanhTien FROM HOADONNH hd JOIN NHACUNGCAP ncc ON hd.maNCC = ncc.maNCC JOIN CTHOADONNH cthd ON hd.maHDNH = cthd.maHDNH WHERE hd.trangThai = 1 GROUP BY hd.maHDNH, hd.ngayNhap, ncc.tenNCC ORDER BY hd.maHDNH;";
        try(Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){ 
            while (rs.next()) {
            
            lsnh.themHDNH(new HOADONNHAPHANG(
                rs.getString("maHDNH"),
                rs.getDate("ngayNhap"),
                rs.getDouble("tongThanhTien"),
                rs.getString("tenNCC")
            )
            );
        }            
        }catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public void chitietHDNH(String mahd,CTHOADONNH cthd){ 
        ketNoiDB();
        String query="SELECT hd.maHDNH, hd.ngayNhap, ncc.tenNCC, nl.tenNL, cthd.soLuong, cthd.gia, cthd.hsd, (cthd.soLuong * cthd.gia) AS thanhTien FROM HOADONNH hd JOIN NHACUNGCAP ncc ON hd.maNCC = ncc.maNCC JOIN CTHOADONNH cthd ON hd.maHDNH = cthd.maHDNH JOIN NGUYENLIEU nl ON cthd.maNL = nl.maNL WHERE hd.maHDNH = ?;";
        try(Connection conn = ds.getConnection();
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
    }
    public void themHDNH(CTHOADONNH hdnh,String maNCC,String[] maNL){ 
        ketNoiDB();
         String queryHD = "INSERT INTO HOADONNH (maHDNH,ngayNhap,trangThai,maNCC) VALUES(?,?,1,?) "; 
         String queryCTHD = "INSERT INTO CTHOADONNH (maHDNH,maNL,soLuong,gia,hsd) VALUES(?,?,?,?,?)";
         try(Connection conn = ds.getConnection();
            PreparedStatement stmthd = conn.prepareStatement(queryHD);
                 PreparedStatement stmtcthd = conn.prepareStatement(queryCTHD)) {
            stmthd.setString(1,hdnh.getMaHDNH());
            stmthd.setDate(2, new java.sql.Date(hdnh.getNgayNhap().getTime()));
            stmthd.setString(3,maNCC);
             stmthd.executeUpdate();
             int i=0;
             for(NLNhap a:hdnh.getDsnlnhap()){ 
                 stmtcthd.setString(1,hdnh.getMaHDNH());
                 stmtcthd.setString(2,maNL[i]);
                 stmtcthd.setFloat(3,a.getSoLuong() );
                 stmtcthd.setDouble(4, a.getGia());
                 stmtcthd.setDate(5, new java.sql.Date(a.getHsd().getTime()));
                 stmtcthd.addBatch();
                 i++;
             }
             stmtcthd.executeBatch();
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }
    }
    //Mon An
    public void layMonAn(DSMonAn dsma){ 
        ketNoiDB();
        String query="SELECT maMA,tenMA,moTa,gia,trangThai FROM MONAN";
        try(Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){ 
            while (rs.next()) {
                  MONAN ma=new MONAN(
                          rs.getString("maMA"),
                  rs.getString("tenMA"),
                  rs.getString("moTa"),
                  rs.getDouble("gia"),
                  rs.getInt("trangThai")
                  );
            dsma.themMA(ma);  
           
        }            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    public void themMonAn(MONAN ma){ 
        ketNoiDB();
        String query="INSERT INTO MONAN(maMA,tenMA,moTa,gia,trangThai) VALUES (?,?,?,?,2)" ;
        
        try(Connection conn = ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,ma.getMaMA());
            stmt.setString(2,ma.getTenMA());
            stmt.setString(3,ma.getMoTa());
            stmt.setDouble(4,ma.getGia());
             stmt.executeUpdate();
        }catch(SQLException ex){ 
            ex.printStackTrace();
        }  
    }
    public void xoaMonAn(String maMA){ 
        ketNoiDB();
        String sql="UPDATE MONAN SET trangThai = 0 WHERE maMA = ?;";
        try(Connection conn =ds.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){ 
            stmt.setString(1,maMA);
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    public void suaMonAn(MONAN ma){ 
        ketNoiDB();
            String sql="UPDATE MONAN SET tenMA=?,moTa=?,gia=? WHERE maMA=?;";
        try(Connection conn =ds.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){            
            stmt.setString(1,ma.getTenMA());
            stmt.setString(2,ma.getMoTa());
            stmt.setDouble(3,ma.getGia());
            stmt.setString(4,ma.getMaMA());
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    //THANH PHAN
    public void layTP(String maMonAn,THANHPHAN tp){ 
        ketNoiDB();
        String query="SELECT maNL,soLuongNL FROM THANHPHAN WHERE maMA=?";
        try(Connection conn = ds.getConnection();
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
        ketNoiDB();
        String query="INSERT INTO THANHPHAN(maMA,maNL,soLuongNL) VALUES (?,?,?)" ;
        String queryU="UPDATE MONAN SET trangThai = 1 WHERE maMA = ?;";
        try(Connection conn = ds.getConnection();
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
        ketNoiDB();
        String queryd = "DELETE FROM THANHPHAN WHERE maMA = ?";
        String querya="INSERT INTO THANHPHAN(maMA,maNL,soLuongNL) VALUES (?,?,?)";
        try(Connection conn = ds.getConnection();
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
            try (Connection conn = ds.getConnection()) {
            conn.rollback(); // Hủy bỏ nếu có lỗi
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        } 
    }
    public void setTTTP(String maMA){ 
        ketNoiDB();
            String sql="UPDATE MONAN SET trangThai=2 WHERE maMA=?;";
        try(Connection conn =ds.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql)){                      
            stmt.setString(1,maMA);
            stmt.executeUpdate();
        }catch(SQLException e){ 
            e.printStackTrace();
        }
    }
}
