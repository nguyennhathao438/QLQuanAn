/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIADM;

import DAO.RolePermissionDAO;
import DTO.PermissionDTO;
import DAO.RolePermissionDAO;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PhanQuyenDialog extends JDialog {
    private JTextField txtMaVT, txtTenVT;
    private JPanel checkboxPanel;
    private JButton btnSave;
    private boolean isEdit;
    private RolePermissionDAO dao = new RolePermissionDAO();
    private List<String> allPermissions;
    private List<JCheckBox> checkBoxes = new ArrayList<>();

    public PhanQuyenDialog(Frame parent, boolean isEdit, String maVTEdit, String tenVTEdit) {
        super(parent, isEdit ? "Sửa phân quyền" : "Thêm phân quyền", true);
        this.isEdit = isEdit;

        txtMaVT = new JTextField(20);
        txtTenVT = new JTextField(20);

        if (isEdit) {
            txtMaVT.setText(maVTEdit);
            txtMaVT.setEditable(false);
            txtTenVT.setText(tenVTEdit);
            txtTenVT.setEditable(false);
        }

        allPermissions = dao.getAllTenQuyen();

        checkboxPanel = new JPanel(new GridLayout(0, 2));
        for (String perm : allPermissions) {
            JCheckBox cb = new JCheckBox(perm);
            checkBoxes.add(cb);
            checkboxPanel.add(cb);
        }

        btnSave = new JButton("Lưu");
        btnSave.addActionListener(e -> savePermissions());

        JPanel top = new JPanel(new GridLayout(2, 2));
        top.add(new JLabel("Mã vai trò:"));
        top.add(txtMaVT);
        top.add(new JLabel("Tên vai trò:"));
        top.add(txtTenVT);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(checkboxPanel), BorderLayout.CENTER);
        add(btnSave, BorderLayout.SOUTH);

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
        if (maVT.isEmpty() || tenVT.isEmpty()) {
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
            dao.deleteByRole(maVT);
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




    



