/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.user;

import DAO.USerDAO1;
import DTO.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class UserFormPanel extends javax.swing.JDialog {
    JTextField txtTaiKhoan = new JTextField(20);
    JPasswordField txtMatKhau = new JPasswordField(20);
    JTextField txtTen = new JTextField(20);
    JComboBox<String> comboVaiTro = new JComboBox<>();
    JCheckBox chkTrangThai = new JCheckBox("Hoạt động");
    User user;
    USerDAO1 dao = new USerDAO1();
    UserManagerPanel userPanel;
    Func_class func = new Func_class();
    public UserFormPanel(java.awt.Frame parent, boolean modal,UserManagerPanel userPanel,User user,String title) {
        super(parent, modal);
        initComponents();
        this.userPanel=userPanel;
        this.user=user;
        func.setUpComBoBox(comboVaiTro);
        this.setTitle(title);
        this.setLocationRelativeTo(null);
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

        formPanel.add(new JLabel("Tài khoản:"));
        formPanel.add(txtTaiKhoan);
        formPanel.add(new JLabel("Mật khẩu:"));
        formPanel.add(txtMatKhau);
        formPanel.add(new JLabel("Tên:"));
        formPanel.add(txtTen);
        formPanel.add(new JLabel("Vai trò:"));
        formPanel.add(comboVaiTro);
        formPanel.add(new JLabel(""));
        formPanel.add(chkTrangThai);

        JButton btnLuu = new JButton("Lưu");
        JButton btnHuy = new JButton("Huỷ");

        btnLuu.addActionListener(e -> luuThongTin());
        btnHuy.addActionListener(e -> this.dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnLuu);
        buttonPanel.add(btnHuy);
        func.setUpBtnTwo(btnLuu, Color.GREEN, Color.GREEN, Color.WHITE, 14);
        func.setUpBtnTwo(btnHuy, Color.RED, Color.RED, Color.WHITE, 14);
        btnLuu.setMargin(new Insets(8, 20, 8, 20)); // top, left, bottom, right
        btnHuy.setMargin(new Insets(8, 20, 8, 20));
        btnLuu.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        btnHuy.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
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
        userPanel.setUpTable();
        this.dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
