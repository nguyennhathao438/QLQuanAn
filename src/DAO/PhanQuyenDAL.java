
package DAO;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectedDatabase;

public class PhanQuyenDAL {
    public Connection getConnection(){ 
        return ConnectedDatabase.getConnectedDB();
    }
    public ArrayList<String> getDSQuyen(String role_id){ 
        ArrayList<String> dsq= new ArrayList();
        String query = "SELECT maQuyen FROM ROLEPERMISSION \n" +
"JOIN ROLES ON ROLEPERMISSION.maVT=ROLES.maVT\n" +
"WHERE ROLEPERMISSION.maVT = ? ";
        
        try(Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query) ){ 
            stmt.setString(1,role_id);
            ResultSet rs = stmt.executeQuery();
            String quyen = "";
            while(rs.next()){ 
                quyen = rs.getString("maQuyen");
                dsq.add(quyen);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhanQuyenDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsq;
    }
}
