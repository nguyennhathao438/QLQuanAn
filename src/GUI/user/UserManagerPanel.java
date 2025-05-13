/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.user;

import DAO.USerDAO1;
import DTO.User;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class UserManagerPanel extends javax.swing.JPanel {
    DefaultTableModel model;
    USerDAO1 dao = new USerDAO1();
    Func_class func=new Func_class();
    List<User> listUserTemp=new ArrayList<>();
    public UserManagerPanel() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        setIcon();
        setUpTable();
        setUpJTF();
        setUpBtn();
        setTextHidden();
        setMouseClick();
        fillComBoBOx();
        setCursorPoiter();
    }
    public void setCursorPoiter(){
        func.cursorPointer(jlabel_add);
        func.cursorPointer(jlabel_update);
        func.cursorPointer(jlabel_delete);
    }
    public void setUpBtn(){
        func.setUpBtn(btn_look, Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_refresh, Color.WHITE,new Color(220,220,220));
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find);
        PromptSupport.setForeground(Color.GRAY, jtf_find);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find);
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_find);
    }
    public void setUpTable(){
        loadUsers(dao.getAllUsers());
        func.centerTable(table_user);
        func.setUpTable(table_user,jScrollPane1);
    }
    public void setIcon() {
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg", 0.06f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.9f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.8f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.25f));
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.6f));
    }
    public void fillComBoBOx() {
        String[] cbbs = {"Tất cả","Tài khoản", "Tên USER", "Vai trò"};
        func.setUpComBoBox(jComboBox1);
        for (String item : cbbs) {
            jComboBox1.addItem(item);
        }
    }
    public void setMouseClick() {
        jlabel_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Window parentWindow = SwingUtilities.getWindowAncestor(UserManagerPanel.this);
                new UserFormPanel((Frame) parentWindow, true, UserManagerPanel.this, null,"Thêm tài khoản").setVisible(true);
            }
        });

// Sự kiện sửa người dùng
        jlabel_update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table_user.getSelectedRow();
                if (row >= 0) {
                    int id = (int) model.getValueAt(row, 0);
                    User user = dao.getUserById(id);
                    Window parentWindow = SwingUtilities.getWindowAncestor(UserManagerPanel.this);
                new UserFormPanel((Frame) parentWindow, true, UserManagerPanel.this,user,"Sửa tài khoản").setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn người dùng để sửa.");
                }
            }
        });

// Sự kiện xoá người dùng
        jlabel_delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table_user.getSelectedRow();
                if (row >= 0) {
                    int id = (int) model.getValueAt(row, 0);
                    dao.voHieuHoaUser(id);
                    setUpTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn người dùng để xoá.");
                }
            }
        });
    }
    public void loadUsers(List<User> list) {
        model =new DefaultTableModel(new Object[]{"ID", "Tài khoản", "Tên","Vai trò"}, 0);
        for (User u : list) {
            if (u.getTrangThai() != 0) { // Chỉ hiện người còn hoạt động
                model.addRow(new Object[]{
                    u.getId(), u.getTaiKhoan(), u.getTen(), u.getVaiTro()
                });
            }
        }
        table_user.setModel(model);
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
        table_user = new javax.swing.JTable();
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
        jLabel5.setText("     Sửa");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("    Xóa ");

        javax.swing.GroupLayout panel_chucNangLayout = new javax.swing.GroupLayout(panel_chucNang);
        panel_chucNang.setLayout(panel_chucNangLayout);
        panel_chucNangLayout.setHorizontalGroup(
            panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_chucNangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        panel_chucNangLayout.setVerticalGroup(
            panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_chucNangLayout.createSequentialGroup()
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        table_user.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_user);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_find, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jComboBox1)
                    .addComponent(jtf_find))
                .addContainerGap(24, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        jtf_find.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lookActionPerformed
        String find_text = jtf_find.getText().toLowerCase();
        String choose_cbb = jComboBox1.getSelectedItem().toString();
        List<User> listUser = dao.getAllUsers();
        listUserTemp.clear();
        for (User u : listUser) {
            String id = String.valueOf(u.getId()).toLowerCase();
            if (choose_cbb.equals("Tất cả")) {
                if (id.contains(find_text) || u.getTaiKhoan().toLowerCase().contains(find_text)
                        || u.getTen().toLowerCase().contains(find_text) || u.getVaiTro().toLowerCase().contains(find_text)) {
                    listUserTemp.add(u);
                }
            } else if (choose_cbb.equals("Tài khoản")) {
                if (u.getTaiKhoan().toLowerCase().contains(find_text)) {
                    listUserTemp.add(u);
                }
            } else if (choose_cbb.equals("Tên USER")) {
                if (u.getTen().toLowerCase().contains(find_text)) {
                    listUserTemp.add(u);
                }
            } else {
                if (u.getVaiTro().toLowerCase().contains(find_text)) {
                    listUserTemp.add(u);
                }
            }
        }
        loadUsers(listUserTemp);
        func.centerTable(table_user);
        func.setUpTable(table_user, jScrollPane1);
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
    private javax.swing.JTable table_user;
    // End of variables declaration//GEN-END:variables
}
