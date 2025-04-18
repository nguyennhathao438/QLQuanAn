/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginGUI;

import DAO.RolePermissionDAO;
import DTO.PermissionDTO;
import DAO.RolePermissionDAO;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANH HIEU
 */
public class PhanQuyenDialog extends JDialog {
    private String maVT;
    private JTable table;
    private DefaultTableModel model;
    private RolePermissionDAO dao = new RolePermissionDAO();

    public PhanQuyenDialog(String maVT) {
        super((Frame) null, "Phân quyền cho vai trò: " + maVT, true);
        this.maVT = maVT;
        setSize(600, 400);
        setLocationRelativeTo(null);
        initComponents();
        loadData();
    }

    private void initComponents() {
        String[] columnNames = {"Mã quyền", "Tên quyền"};
        model = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnLuu = new JButton("Lưu phân quyền");
        btnLuu.addActionListener(e -> luuPhanQuyen());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnLuu);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadData() {
        model.setRowCount(0);
        List<PermissionDTO> list = dao.getAllPermissionsWithRole(maVT);
        for (PermissionDTO p : list) {
            model.addRow(new Object[]{p.getMaQuyen(), p.getTenQuyen()});
        }
    }

    private void luuPhanQuyen() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String maQuyen = (String) model.getValueAt(i, 0);
            boolean duocCap = (boolean) model.getValueAt(i, 2);
            if (duocCap) {
                dao.capQuyen(maVT, maQuyen);
            } else {
                dao.xoaQuyen(maVT, maQuyen);
            }
        }
        JOptionPane.showMessageDialog(this, "Lưu thành công!");
    }
}
