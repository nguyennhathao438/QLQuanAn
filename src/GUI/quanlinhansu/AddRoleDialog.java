/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.quanlinhansu;

import DAO.NhanVienDAO;
import DAO.USerDAO1;
import DTO.User;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class AddRoleDialog extends javax.swing.JDialog {
    USerDAO1 userDao = new USerDAO1();
    NhanVienDAO nvDao=new NhanVienDAO();
    NhanVienPanel nvPanel;
    int maNV;
    Func_class func=new Func_class();
    public AddRoleDialog(java.awt.Frame parent, boolean modal, int maNV, NhanVienPanel nvPanel) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm vai trò");
        this.nvPanel = nvPanel;
        this.maNV = maNV;
        khoiTao();
    }
    public void khoiTao() {
        setUpTable();
        setUpBtn();
    }
    public void setUpTable(){
        loadUsers(userDao.getAllUsers());
        func.centerTable(table_TK);
        func.setUpTable(table_TK);
    }
    public void setUpBtn(){
        func.setUpBtn(btn_capTK,Color.WHITE,Color.GRAY);
        func.setUpBtn(btn_exit,Color.WHITE,Color.GRAY);
    }
    public void loadUsers(List<User> listUSER) {
        String[] colNames={"Mã tài khoản","Tài khoản","Tên","Vai trò","Trạng thái tài khoản"};
        Object[][] rows=new Object[listUSER.size()][colNames.length];
        for(int i=0;i<listUSER.size();i++){
            rows[i][0]=listUSER.get(i).getId();
            rows[i][1]=listUSER.get(i).getTaiKhoan();
            rows[i][2]=listUSER.get(i).getTen();
            rows[i][3]=listUSER.get(i).getVaiTro();
            if(listUSER.get(i).getTrangThai()==0){
                rows[i][4]="Đã khóa";
            }
            if(listUSER.get(i).getTrangThai()==1){
                rows[i][4]="Chưa được cấp";
            }
            if(listUSER.get(i).getTrangThai()==2){
                rows[i][4]="Đã được cấp";
            }
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table_TK.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_TK = new javax.swing.JTable();
        btn_capTK = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table_TK.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_TK);

        btn_capTK.setBackground(new java.awt.Color(51, 255, 51));
        btn_capTK.setText("Cấp tài khoản");
        btn_capTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capTKActionPerformed(evt);
            }
        });

        btn_exit.setBackground(new java.awt.Color(255, 0, 0));
        btn_exit.setText("Hủy bỏ");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH TÀI KHOẢN HIỆN TẠI TRONG HỆ THỐNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btn_capTK)
                        .addGap(66, 66, 66)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_capTK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_capTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capTKActionPerformed
        int vitriRow=table_TK.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn tài khoản","Error",0);
            return;
        }
        int idUser=Integer.parseInt(table_TK.getValueAt(vitriRow,0).toString());
        String statusTK=table_TK.getValueAt(vitriRow,4).toString();
        if(statusTK.equals("Chưa được cấp")){
            nvDao.setTaiKhoanNV(idUser, maNV);
            setUpTable();
            nvPanel.setUpTable();
        }
        if(statusTK.equals("Đã khóa")){
            JOptionPane.showMessageDialog(null,"Tài khoản đã bị khóa không thể cấp","Error",0);
            return;
        }
        if(statusTK.equals("Đã được cấp")){
            JOptionPane.showMessageDialog(null,"Tài khoản đã được cấp","Error",0);
            return;
        }
    }//GEN-LAST:event_btn_capTKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capTK;
    private javax.swing.JButton btn_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_TK;
    // End of variables declaration//GEN-END:variables
}
