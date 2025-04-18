package GUI.quanlibanhang;

import javax.swing.JFrame;

public class mainquanhang {
    public static void main(String[] args) {
        // Tạo frame
        JFrame frame = new JFrame("Quản lý Bàn");
        // Gắn JPanel của bạn vào frame
//        frame.setContentPane(new BanJPanel());
        frame.setContentPane(new HoaDonPanel());

        // Cấu hình frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700); // Kích thước cửa sổ
        frame.setLocationRelativeTo(null); // Canh giữa màn hình
        frame.setVisible(true); // Hiển thị frame
    }
}
