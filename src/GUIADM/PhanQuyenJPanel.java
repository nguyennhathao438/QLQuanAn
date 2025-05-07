/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author THANH HIEU
 */
package GUIADM;


import DAO.RolePermissionDAO;
import DTO.RolePermissionDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableCellRenderer;
import util.Func_class;



public class PhanQuyenJPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private RolePermissionDAO dao = new RolePermissionDAO();
    Func_class func=new Func_class();
    public void setUpTable(){
        func.centerTable(table);
        table.setBackground(Color.white);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setFillsViewportHeight(true);
        Font font_hearderTable=new Font("Arial",Font.BOLD,13);
        table.getTableHeader().setFont(font_hearderTable);
    }
    public PhanQuyenJPanel() {
        setLayout(new BorderLayout());

        // ==== PANEL CHỨC NĂNG ====
        JPanel panelChucNang = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        panelChucNang.setBorder(BorderFactory.createTitledBorder("Chức Năng"));

        JButton btnThem = new JButton(new ImageIcon(getClass().getResource("/img/iconthem.png")));
        btnThem.setToolTipText("Thêm");

        JButton btnXoa = new JButton(new ImageIcon(getClass().getResource("/img/delete-icon.png")));
        btnXoa.setToolTipText("Xoá");

        JButton btnSua = new JButton(new ImageIcon(getClass().getResource("/img/edit-icon.png")));
        btnSua.setToolTipText("Sửa");

        Dimension buttonSize = new Dimension(80, 80);
        for (JButton btn : new JButton[]{btnThem, btnXoa, btnSua}) {
            btn.setPreferredSize(buttonSize);
            btn.setText(null);
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        }

        panelChucNang.add(btnThem);
        panelChucNang.add(btnXoa);
        panelChucNang.add(btnSua);

        // ==== TABLE ====
        model = new DefaultTableModel(new String[]{"Mã Vai Trò", "Tên Vai Trò", "Tên Quyền"}, 0);
        table = new JTable(model);

        // Renderer HTML
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (value instanceof String && ((String) value).startsWith("<html>")) {
                    label.setVerticalAlignment(SwingConstants.TOP);
                }
                return label;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        add(panelChucNang, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadData();

        // ==== SỰ KIỆN ====
        btnThem.addActionListener(e -> {
            PhanQuyenDialog dialog = new PhanQuyenDialog((Frame) SwingUtilities.getWindowAncestor(this), false, null, null);
            dialog.setVisible(true);
            loadData();
            setUpTable();
        });

        btnXoa.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                String maVT = (String) model.getValueAt(row, 0);
                String tenVT = (String) model.getValueAt(row, 1);
                int confirm = JOptionPane.showConfirmDialog(this, "Xóa vai trò \"" + tenVT + "\"?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dao.deleteRole(maVT);
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    loadData();
                    setUpTable();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn vai trò cần xóa.");
            }
        });

        btnSua.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                String maVT = (String) model.getValueAt(row, 0);
                String tenVT = (String) model.getValueAt(row, 1);
                PhanQuyenDialog dialog = new PhanQuyenDialog((Frame) SwingUtilities.getWindowAncestor(this), true, maVT, tenVT);
                dialog.setVisible(true);
                loadData();
                setUpTable();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn vai trò cần sửa.");
            }
        });
        setUpTable();
    }

    private void loadData() {
        model.setRowCount(0);
        List<RolePermissionDTO> list = dao.getAllRolePermissions();

        // Gom quyền theo vai trò
        Map<String, StringBuilder> mapMaVTToQuyen = new LinkedHashMap<>();
        Map<String, String> mapMaVTToTenVT = new LinkedHashMap<>();

        for (RolePermissionDTO dto : list) {
            String maVT = dto.getMaVT();
            String tenVT = dto.getTenVT();
            String tenQuyen = dto.getTenQuyen();

            mapMaVTToTenVT.put(maVT, tenVT);
            mapMaVTToQuyen.putIfAbsent(maVT, new StringBuilder());

            StringBuilder sb = mapMaVTToQuyen.get(maVT);
            if (sb.length() > 0) sb.append("<br>");
            sb.append(tenQuyen);
        }

        int rowIndex = 0;
        for (String maVT : mapMaVTToQuyen.keySet()) {
            String tenVT = mapMaVTToTenVT.get(maVT);
            String quyenHTML = "<html>" + mapMaVTToQuyen.get(maVT).toString() + "</html>";

            model.addRow(new Object[]{maVT, tenVT, quyenHTML});

            int quyenCount = mapMaVTToQuyen.get(maVT).toString().split("<br>").length;
            int rowHeight = Math.max(40, quyenCount * 20);
            table.setRowHeight(rowIndex, rowHeight);
            rowIndex++;
        }
    }
}


