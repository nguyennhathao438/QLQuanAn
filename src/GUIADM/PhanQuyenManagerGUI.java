/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIADM;

import DAO.RolePermissionDAO;
import DTO.PermissionDTO;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANH HIEU
 */
public class PhanQuyenManagerGUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private RolePermissionDAO dao = new RolePermissionDAO();

    public PhanQuyenManagerGUI() {
        setTitle("Phân quyền");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        model = new DefaultTableModel(new String[]{"Mã vai trò", "Tên vai trò", "Tên quyền"}, 0);
        table = new JTable(model);
        loadData();

        JScrollPane scroll = new JScrollPane(table);
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xoá");

        btnAdd.addActionListener(e -> openDialog(false));
        btnEdit.addActionListener(e -> openDialog(true));
        btnDelete.addActionListener(e -> deleteRole());

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);

        add(scroll, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    private void loadData() {
        model.setRowCount(0);
        Map<String, List<String>> map = dao.getAllPermissions();
        for (String key : map.keySet()) {
            String[] split = key.split(" - ", 2);
            String maVT = split[0];
            String tenVT = split.length > 1 ? split[1] : "";
            String quyen = String.join(", ", map.get(key));
            model.addRow(new Object[]{maVT, tenVT, quyen});
        }
    }

    private void openDialog(boolean isEdit) {
        int row = table.getSelectedRow();
        if (isEdit && row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn vai trò để sửa");
            return;
        }

        String maVT = isEdit ? model.getValueAt(row, 0).toString() : "";
        String tenVT = isEdit ? model.getValueAt(row, 1).toString() : "";

        PhanQuyenDialog dialog = new PhanQuyenDialog(this, isEdit, maVT, tenVT);
        dialog.setVisible(true);
        loadData();
    }

    private void deleteRole() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn vai trò để xoá");
            return;
        }
        String maVT = model.getValueAt(row, 0).toString();
        dao.deleteRole(maVT);
        JOptionPane.showMessageDialog(this, "Xoá thành công!");
        loadData();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhanQuyenManagerGUI().setVisible(true));
    }
}


