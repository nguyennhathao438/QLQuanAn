/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIADM;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author kiman
 */
public class test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Quản lý người dùng");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(850, 600);
            frame.setLocationRelativeTo(null);

            // Thêm UserManagerPanel
            PhanQuyenPanel userPanel = new PhanQuyenPanel();
            frame.setContentPane(userPanel);

            frame.setVisible(true);
        });
    }
}
