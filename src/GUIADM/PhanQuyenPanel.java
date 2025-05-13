/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUIADM;

import DAO.RolePermissionDAO;
import DTO.RolePermissionDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PhanQuyenPanel extends javax.swing.JPanel {

    DefaultTableModel model;
    RolePermissionDAO dao = new RolePermissionDAO();
    Func_class func = new Func_class();
    List<RolePermissionDTO> listRoleTemp = new ArrayList<>();

    public PhanQuyenPanel() {
        initComponents();
        model = new DefaultTableModel(new String[]{"Mã Vai Trò", "Tên Vai Trò", "Tên Quyền"}, 0);
        table.setModel(model);
        khoiTao();
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

    }

    public void khoiTao() {
        setIcon();
        setUpTable();
        setUpJTF();
        setUpBtn();
        setTextHidden();
        setMouseClick();
        fillComBoBOx();
        setCursorPoiter();
    }

    public void setCursorPoiter() {
        func.cursorPointer(jlabel_add);
        func.cursorPointer(jlabel_update);
        func.cursorPointer(jlabel_delete);
    }

    public void setUpBtn() {
        func.setUpBtn(btn_look, Color.WHITE, new Color(220, 220, 220));
        func.setUpBtn(btn_refresh, Color.WHITE, new Color(220, 220, 220));
    }

    public void setTextHidden() {
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find);
        PromptSupport.setForeground(Color.GRAY, jtf_find);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find);
    }

    public void setUpJTF() {
        func.setUpJTF(jtf_find);
    }

    public void setUpTable() {
        loadData(dao.getAllRolePermissions());
        func.centerTable(table);
        table.setBackground(Color.WHITE);
        table.setGridColor(new Color(230, 230, 230)); // Đường kẻ nhẹ
        table.setShowGrid(true);
        table.setFillsViewportHeight(true);
        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);
        // Màu nền xen kẽ các dòng và màu khi chọn
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(245, 245, 245) : Color.WHITE); // xen kẽ
                } else {
                    c.setBackground(new Color(173, 216, 230)); // màu khi chọn
                }
                return c;
            }
        });
        if (jScrollPane1 != null) {
            jScrollPane1.setBorder(null);
            JScrollBar verticalBar = jScrollPane1.getVerticalScrollBar();
            verticalBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
            verticalBar.setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = new Color(180, 180, 180);  // Màu thanh kéo
                    this.trackColor = new Color(245, 245, 245);  // Màu nền rãnh
                }

                @Override
                protected JButton createDecreaseButton(int orientation) {
                    return createZeroButton();
                }

                @Override
                protected JButton createIncreaseButton(int orientation) {
                    return createZeroButton();
                }

                private JButton createZeroButton() {
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(0, 0));
                    button.setMinimumSize(new Dimension(0, 0));
                    button.setMaximumSize(new Dimension(0, 0));
                    return button;
                }
            });
        }
    }

    public void setIcon() {
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg", 0.055f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.25f));
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.6f));
    }

    public void fillComBoBOx() {
        String[] cbbs = {"Tất cả", "Mã vai trò", "Tên vai trò", "Tên quyền"};
        func.setUpComBoBox(jComboBox1);
        for (String item : cbbs) {
            jComboBox1.addItem(item);
        }
    }

    public void setMouseClick() {
        jlabel_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PhanQuyenDialog dialog = new PhanQuyenDialog((Frame) SwingUtilities.getWindowAncestor(PhanQuyenPanel.this), false, null, null);
                dialog.setVisible(true);
                loadData(dao.getAllRolePermissions());
                //setUpTable();
            }
        });

        jlabel_delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    String maVT = (String) model.getValueAt(row, 0);
                    String tenVT = (String) model.getValueAt(row, 1);
                    int confirm = JOptionPane.showConfirmDialog(null, "Xóa vai trò \"" + tenVT + "\"?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dao.deleteRole(maVT);
                        JOptionPane.showMessageDialog(null, "Xóa thành công.");
                        loadData(dao.getAllRolePermissions());
                        //setUpTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn vai trò cần xóa.");
                }
            }
        });

        jlabel_update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    String maVT = (String) model.getValueAt(row, 0);
                    String tenVT = (String) model.getValueAt(row, 1);
                    PhanQuyenDialog dialog = new PhanQuyenDialog((Frame) SwingUtilities.getWindowAncestor(PhanQuyenPanel.this), true, maVT, tenVT);
                    dialog.setVisible(true);
                    loadData(dao.getAllRolePermissions());
                    // setUpTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn vai trò cần sửa.");
                }
            }
        });

    }

    private void loadData(List<RolePermissionDTO> list) {
        model.setRowCount(0);

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
            if (sb.length() > 0) {
                sb.append("<br>");
            }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_chucNang = new javax.swing.JPanel();
        jlabel_add = new javax.swing.JLabel();
        jlabel_update = new javax.swing.JLabel();
        jlabel_delete = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panel_timKiem = new javax.swing.JPanel();
        jtf_find = new javax.swing.JTextField();
        btn_look = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        panel_chucNang.setBackground(new java.awt.Color(217, 217, 217));
        panel_chucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("  Thêm");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("    Sửa");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("    Xóa ");

        javax.swing.GroupLayout panel_chucNangLayout = new javax.swing.GroupLayout(panel_chucNang);
        panel_chucNang.setLayout(panel_chucNangLayout);
        panel_chucNangLayout.setHorizontalGroup(
            panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_chucNangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        panel_chucNangLayout.setVerticalGroup(
            panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_chucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(panel_chucNangLayout.createSequentialGroup()
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        panel_timKiem.setBackground(new java.awt.Color(217, 217, 217));
        panel_timKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        btn_look.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lookActionPerformed(evt);
            }
        });

        btn_refresh.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Tìm kiếm theo");

        javax.swing.GroupLayout panel_timKiemLayout = new javax.swing.GroupLayout(panel_timKiem);
        panel_timKiem.setLayout(panel_timKiemLayout);
        panel_timKiemLayout.setHorizontalGroup(
            panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_timKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_timKiemLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_timKiemLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_timKiemLayout.setVerticalGroup(
            panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_timKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_look, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jtf_find)
                    .addComponent(jComboBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_chucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_chucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        jtf_find.setText("");
        loadData(dao.getAllRolePermissions());
        func.centerTable(table);
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lookActionPerformed
        String find_text = jtf_find.getText().toLowerCase();
        String choose_cbb = jComboBox1.getSelectedItem().toString();
        List<RolePermissionDTO> listRole = dao.getAllRolePermissions();
        listRoleTemp.clear();
        for (RolePermissionDTO u : listRole) {
            if (choose_cbb.equals("Tất cả")) {
                if (u.getMaVT().toLowerCase().contains(find_text) || u.getTenVT().toLowerCase().contains(find_text)
                        || u.getTenQuyen().toLowerCase().contains(find_text)) {
                    listRoleTemp.add(u);
                }
            } else if (choose_cbb.equals("Mã vai trò")) {
                if (u.getMaVT().toLowerCase().contains(find_text)) {
                    listRoleTemp.add(u);
                }
            } else if (choose_cbb.equals("Tên vai trò")) {
                if (u.getTenVT().toLowerCase().contains(find_text)) {
                    listRoleTemp.add(u);
                }
            } else {
                if (u.getTenQuyen().toLowerCase().contains(find_text)) {
                    listRoleTemp.add(u);
                }
            }
        }
        loadData(listRoleTemp);
        func.centerTable(table);
    }//GEN-LAST:event_btn_lookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_look;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JTextField jtf_find;
    private javax.swing.JPanel panel_chucNang;
    private javax.swing.JPanel panel_timKiem;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
