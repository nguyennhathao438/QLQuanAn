
package util;


import java.sql.Connection; 
import java.sql.DriverManager;
public class ConnectedDatabase {
    public static Connection getConnectedDB() {
        Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-SAC9NS5:1433;databaseName=QuanLyQuanAn;encrypt=false;characterEncoding=UTF-8";
            String username = "sa";
            String password = "quencmnr";
            c = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ket noi co so du lieu that bai");
        }
        return c;
    }

    public static void closeConnectedDB(Connection c) {
        try {
            if (c != null) {
                c.close();
                System.out.println("Đóng thành công !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể đóng ");
        }
    }

    public static com.sun.jdi.connect.spi.Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}