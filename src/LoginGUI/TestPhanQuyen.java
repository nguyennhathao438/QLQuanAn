/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginGUI;

import javax.swing.JFrame;
import DAO.RolePermissionDAO;
import LoginGUI.PhanQuyenDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author THANH HIEU
 */
public class TestPhanQuyen {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PhanQuyenDialog("nvbanhang").setVisible(true);
        });
    }
}
