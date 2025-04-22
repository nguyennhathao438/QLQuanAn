/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import java.sql.Connection; 
import java.sql.DriverManager;
public class ConnectedDatabase {
    public static Connection getConnectedDB() {
        Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://LAPTOP-2EA7CM4Q:1433;databaseName=QuanLyQuanAn;encrypt=false;characterEncoding=UTF-8";
            String username = "sa";
            String password = "123456789";
            c = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
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