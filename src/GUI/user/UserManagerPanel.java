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
import util.DropShadowBorder;
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
        setBorder();
        setUpJTF();
        setUpBtn();
        setTextHidden();
        setMouseClick();
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
    public void setBorder(){
        panel_chucNang.setBorder(new DropShadowBorder(1,Color.BLACK));
        panel_timKiem.setBorder(new DropShadowBorder(1,Color.BLACK));
    }
    public void setUpTable(){
        loadUsers(dao.getAllUsers());
        func.centerTable(table_user);
        func.setUpTable(table_user);
    }
    public void setIcon() {
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg", 0.055f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.3f));
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/find.svg", 0.35f));
    }
    public void setMouseClick() {
        jlabel_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Window parentWindow = SwingUtilities.getWindowAncestor(UserManagerPanel.this);
                new UserFormPanel((Frame) parentWindow, true, UserManagerPanel.this, null).setVisible(true);
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
                new UserFormPanel((Frame) parentWindow, true, UserManagerPanel.this, user).setVisible(true);
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

        jLabel4.setText("  Thêm");

        jLabel5.setText("    Sửa");

        jLabel6.setText("    Xóa ");

        javax.swing.GroupLayout panel_chucNangLayout = new javax.swing.GroupLayout(panel_chucNang);
        panel_chucNang.setLayout(panel_chucNangLayout);
        panel_chucNangLayout.setHorizontalGroup(
            panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_chucNangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        panel_chucNangLayout.setVerticalGroup(
            panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_chucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_chucNangLayout.createSequentialGroup()
                        .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_chucNangLayout.createSequentialGroup()
                        .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_chucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        btn_look.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lookActionPerformed(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_timKiemLayout = new javax.swing.GroupLayout(panel_timKiem);
        panel_timKiem.setLayout(panel_timKiemLayout);
        panel_timKiemLayout.setHorizontalGroup(
            panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_timKiemLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panel_timKiemLayout.setVerticalGroup(
            panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_timKiemLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_find)
                    .addComponent(btn_look, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panel_chucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_chucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        jtf_find.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lookActionPerformed
        String find_text = jtf_find.getText().toLowerCase();
        List<User> listUser = dao.getAllUsers();
        listUserTemp.clear();
        for (User u : listUser) {
            String id = String.valueOf(u.getId()).toLowerCase();
            if (id.contains(find_text) || u.getTaiKhoan().toLowerCase().contains(find_text)
                    || u.getTen().toLowerCase().contains(find_text) || u.getVaiTro().toLowerCase().contains(find_text)) {
                listUserTemp.add(u);
            }
        }
        loadUsers(listUserTemp);
        func.centerTable(table_user);
        func.setUpTable(table_user);
    }//GEN-LAST:event_btn_lookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_look;
    private javax.swing.JButton btn_refresh;
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
