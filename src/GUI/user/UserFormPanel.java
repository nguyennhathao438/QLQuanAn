/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.user;

/**
 *
 * @author THANH HIEU
 */
import DAO.USerDAO1;
import DTO.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class UserFormPanel extends JPanel {
    private JTextField txtTaiKhoan = new JTextField(20);
    private JPasswordField txtMatKhau = new JPasswordField(20);
    private JTextField txtTen = new JTextField(20);
    private JComboBox<String> comboVaiTro = new JComboBox<>();
    private JCheckBox chkTrangThai = new JCheckBox("Hoạt động");

    private User user;
    private USerDAO1 dao = new USerDAO1();
    private UserManagerPanel parent;
    private JDialog dialog;

    
   public UserFormPanel(UserManagerPanel parent, JDialog dialog, User user) {
    this.parent = parent;
    this.dialog = dialog;
    this.user = user;

    initUI();
    loadVaiTro();
    if (user != null) {
        fillForm(); // sửa
    } else {
        chkTrangThai.setSelected(true);     // Thêm mới: mặc định hoạt động
        chkTrangThai.setEnabled(false);     // Không cho chỉnh
    }
}

    private void initUI() {
        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        formPanel.add(new JLabel("Tài khoản:")); formPanel.add(txtTaiKhoan);
        formPanel.add(new JLabel("Mật khẩu:")); formPanel.add(txtMatKhau);
        formPanel.add(new JLabel("Tên:"));      formPanel.add(txtTen);
        formPanel.add(new JLabel("Vai trò:"));  formPanel.add(comboVaiTro);
        formPanel.add(new JLabel(""));          formPanel.add(chkTrangThai);

        JButton btnLuu = new JButton("Lưu");
        JButton btnHuy = new JButton("Huỷ");

        btnLuu.addActionListener(e -> luuThongTin());
        btnHuy.addActionListener(e -> dialog.dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnLuu);
        buttonPanel.add(btnHuy);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void fillForm() {
        txtTaiKhoan.setText(user.getTaiKhoan());
        txtTaiKhoan.setEnabled(false);
        txtMatKhau.setText(user.getMatKhau());
        txtTen.setText(user.getTen());
        comboVaiTro.setSelectedItem(user.getVaiTro());
        chkTrangThai.setSelected(user.getTrangThai() == 1);
    }

    private void loadVaiTro() {
        comboVaiTro.removeAllItems();
        List<String> roles = dao.getAllTenVaiTro();
        for (String r : roles) comboVaiTro.addItem(r);
    }

    private void luuThongTin() {
        if (txtTaiKhoan.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tài khoản và Tên không được để trống!");
            return;
        }

        User u = (user == null) ? new User() : user;
        u.setTaiKhoan(txtTaiKhoan.getText().trim());
        u.setMatKhau(new String(txtMatKhau.getPassword()));
        u.setTen(txtTen.getText().trim());
        u.setVaiTro(comboVaiTro.getSelectedItem().toString());
        u.setTrangThai(chkTrangThai.isSelected() ? 1 : 0);

        String maVT = dao.getMaVaiTro(u.getVaiTro());
        if (user == null) {
            if (!dao.themUser(u, maVT)) {
                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            dao.suaUser(u, maVT);
        }

        parent.loadUsers();
        dialog.dispose();
    }
}