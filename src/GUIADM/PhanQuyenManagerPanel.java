package GUIADM;

import DAO.RolePermissionDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class PhanQuyenManagerPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private RolePermissionDAO dao = new RolePermissionDAO();

    public PhanQuyenManagerPanel() {
        setLayout(new BorderLayout());

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

        PhanQuyenDialog dialog = new PhanQuyenDialog((Frame) SwingUtilities.getWindowAncestor(this), isEdit, maVT, tenVT);
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

    // Chạy thử nghiệm bằng JFrame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Phân quyền");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 400);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new PhanQuyenManagerPanel());
            frame.setVisible(true);
        });
    }
}
