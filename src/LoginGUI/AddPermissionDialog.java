/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginGUI;

import DAO.RolePermissionDAO;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author THANH HIEU
 */
public class AddPermissionDialog extends JDialog {
    private JTextField txtMa, txtTen;
    private RolePermissionDAO dao = new RolePermissionDAO();

    public AddPermissionDialog(JFrame parent) {
        super(parent, "Thêm quyền mới", true);
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(parent);

        add(new JLabel("Mã quyền:"));
        txtMa = new JTextField();
        add(txtMa);

        add(new JLabel("Tên quyền:"));
        txtTen = new JTextField();
        add(txtTen);

        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(e -> {
            if (dao.addPermission(txtMa.getText(), txtTen.getText())) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại hoặc quyền đã tồn tại!");
            }
        });
        add(btnThem);

        JButton btnHuy = new JButton("Huỷ");
        btnHuy.addActionListener(e -> dispose());
        add(btnHuy);
    }
}