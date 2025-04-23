/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.user;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author kiman
 */
public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jf = new JFrame("Quản lý người dùng");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            UserManagerPanel panel = new UserManagerPanel(); // Đây là lớp JPanel bạn đã tạo
            jf.setContentPane(panel); // Đưa panel vào JFrame

            jf.pack(); // Tự động căn chỉnh kích thước theo nội dung
            jf.setLocationRelativeTo(null); // Hiển thị giữa màn hình
            jf.setVisible(true); // Hiển thị JFrame
        });
    }
}
