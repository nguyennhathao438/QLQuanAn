/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIADM;

import DTO.PermissionDTO;
import DAO.RolePermissionDAO;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author THANH HIEU
 */
public class PhanQuyenDialog extends JDialog {
    JTextField txtMaVT, txtTenVT;
    JPanel checkboxPanel;
    JButton btnSave;
    boolean isEdit;

    RolePermissionDAO dao = new RolePermissionDAO();
    List<JCheckBox> checkBoxes = new ArrayList<>();

    public PhanQuyenDialog(Frame parent, boolean isEdit, String maVTEdit, String tenVTEdit) {
        super(parent, isEdit ? "Sửa phân quyền" : "Thêm phân quyền", true);
        this.isEdit = isEdit;

        // --- Init input fields
        txtMaVT = new JTextField(20);
        txtTenVT = new JTextField(20);

        if (isEdit) {
            txtMaVT.setText(maVTEdit);
            txtTenVT.setText(tenVTEdit);
            txtMaVT.setEditable(false);
            txtTenVT.setEditable(false);
        }

        // --- Lấy danh sách tất cả quyền
        List<String> allPermissions = dao.getAllTenQuyen();

        // --- Tạo checkbox cho mỗi quyền
        checkboxPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        for (String tenQuyen : allPermissions) {
            JCheckBox cb = new JCheckBox(tenQuyen);
            checkBoxes.add(cb);
            checkboxPanel.add(cb);
        }

        // --- Nút Lưu
        btnSave = new JButton("Lưu");
        btnSave.addActionListener(e -> savePermissions());

        // --- Panel trên: nhập mã và tên vai trò
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Mã vai trò:"));
        inputPanel.add(txtMaVT);
        inputPanel.add(new JLabel("Tên vai trò:"));
        inputPanel.add(txtTenVT);

        // --- Layout chính
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(checkboxPanel), BorderLayout.CENTER);
        add(btnSave, BorderLayout.SOUTH);

        // --- Nếu là sửa thì load quyền đã phân
        if (isEdit) {
            loadPermissions(maVTEdit);
        }

        pack();
        setLocationRelativeTo(parent);
    }

    private void loadPermissions(String maVT) {
        List<String> currentPermissions = dao.getPermissionsByRole(maVT);
        for (JCheckBox cb : checkBoxes) {
            cb.setSelected(currentPermissions.contains(cb.getText()));
        }
    }

    private void savePermissions() {
        String maVT = txtMaVT.getText().trim();
        String tenVT = txtTenVT.getText().trim();

        if (maVT.isEmpty() || (!isEdit && tenVT.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã và tên vai trò.");
            return;
        }

        if (!isEdit && dao.isRoleExists(maVT)) {
            JOptionPane.showMessageDialog(this, "Mã vai trò đã tồn tại.");
            return;
        }

        if (!isEdit) {
            dao.insertRole(maVT, tenVT);
        } else {
            dao.deleteByRole(maVT); // xoá toàn bộ quyền cũ
        }

        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                dao.insert(new PermissionDTO(maVT, cb.getText()));
            }
        }

        JOptionPane.showMessageDialog(this, "Lưu thành công!");
        dispose();
    }
}





    



