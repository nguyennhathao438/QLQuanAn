/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.user;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author THANH HIEU
 */
public class TestUserManagement {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Quản lý người dùng");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 500);
            frame.setLocationRelativeTo(null);

            // Thêm UserManagerPanel
            UserManagerPanel userPanel = new UserManagerPanel();
            frame.setContentPane(userPanel);

            frame.setVisible(true);
        });
    }
}