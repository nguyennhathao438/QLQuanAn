
package GUI.quankho;

import DTO.NGUYENLIEU;
import DAO.QuanKhoDAO;
import DTO.DSNguyenLieu;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;


public class QKNLJPanel extends javax.swing.JPanel {

    DSNguyenLieu dsnl = new DSNguyenLieu();
    QuanKhoDAO kn = new QuanKhoDAO();
    Func_class func = new Func_class();
    DefaultTableModel dtm = new DefaultTableModel();

    public QKNLJPanel() throws SQLException {
        initComponents();
        setData();
        bangNL.setModel(dtm);
        bangNL.setComponentPopupMenu(putableNL);
        func.centerTable(bangNL);
        func.setUpTable(bangNL,jScrollPane4);
        design();
    }
    public void design(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", search);
        PromptSupport.setForeground(Color.GRAY, search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,search);
        jButton6.setIcon(new FlatSVGIcon("./resources/icon/look.svg",0.6f));
        label_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg",0.06f));
        label_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg",0.85f));
        label_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg",0.75f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.25f));
        label_xuattonkho.setIcon(new FlatSVGIcon("./resources/icon/xuathoadon.svg",0.45f));
        func.cursorPointer(label_add);
        func.cursorPointer(label_update);
        func.cursorPointer(label_delete);
        func.cursorPointer(label_xuattonkho);
        func.setUpBtn(jButton6, Color.WHITE, new Color(220,220,220));
        func.setUpBtn(btn_refresh, Color.WHITE, new Color(220,220,220));
        func.setUpJTF(search);
        func.setUpComBoBox(locNL);
    }
    public void setData() throws SQLException{ 
        dsnl=new DSNguyenLieu();
        kn.layNL(dsnl);
        dtm.setRowCount(0);
        if(dtm.getColumnCount() == 0){
            dtm.addColumn("Mã NL");
            dtm.addColumn("Loại NL");
            dtm.addColumn("Tên NL");
            dtm.addColumn("Tổng Số Lượng");
            dtm.addColumn("Mô Tả");
            
        }        
        for(NGUYENLIEU nl:dsnl.getDSNL()){ 
            if(nl.getTrangThai()!=0)
            dtm.addRow(new Object[]{nl.getMaNL(),kn.layTenLoaiNL(nl.getMaLoaiNL()),nl.getTenNL(),nl.getTongSoLuong(),nl.getMoTa()});

        }     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        putableNL = new javax.swing.JPopupMenu();
        deleteNL = new javax.swing.JMenuItem();
        editNL = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bangNL = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label_add = new javax.swing.JLabel();
        label_delete = new javax.swing.JLabel();
        label_update = new javax.swing.JLabel();
        label_xuattonkho = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        locNL = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        deleteNL.setText("Xoá");
        deleteNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNLActionPerformed(evt);
            }
        });
        putableNL.add(deleteNL);

        editNL.setText("Sửa");
        editNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNLActionPerformed(evt);
            }
        });
        putableNL.add(editNL);

        bangNL.setModel(new javax.swing.table.DefaultTableModel(
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
        bangNL.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        bangNL.setRowHeight(30);
        bangNL.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bangNL.setShowGrid(false);
        jScrollPane4.setViewportView(bangNL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel2.setText("Thêm");

        jLabel3.setText("Xoá");

        jLabel4.setText("Sửa");

        jLabel6.setText("Xuất tồn kho");

        label_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_addMouseClicked(evt);
            }
        });

        label_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_deleteMouseClicked(evt);
            }
        });

        label_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_updateMouseClicked(evt);
            }
        });

        label_xuattonkho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_xuattonkhoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(label_add, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(label_xuattonkho, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_add, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(label_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_xuattonkho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(217, 217, 217));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        locNL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không chọn", "Lọc theo loại nguyên liệu", "Số lượng nguyên liệu" }));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Lọc theo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(locNL, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(locNL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNLActionPerformed
        
    }//GEN-LAST:event_deleteNLActionPerformed

    private void editNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNLActionPerformed
        int row=bangNL.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        String a = (String) bangNL.getValueAt(row, 0);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new NguyenLieuDialog((Frame) parentWindow,true,a,this).setVisible(true);
    }//GEN-LAST:event_editNLActionPerformed
             
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String text= search.getText();
        dtm.setRowCount(0);
        DSNguyenLieu dssearch=boLoc();
        for(NGUYENLIEU a:dssearch.getDSNL()){ 
                if(a.getTenNL().toLowerCase().contains(text) ||  a.getMaNL().toLowerCase().contains(text) || a.getMoTa().toLowerCase().contains(text) ){
                    if(a.getTrangThai()==1)
                    dtm.addRow(new Object[]{a.getMaNL(),kn.layTenLoaiNL(a.getMaLoaiNL()),a.getTenNL(),a.getTongSoLuong(),a.getMoTa()});
                }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void label_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_addMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new NguyenLieuDialog((Frame) parentWindow,true,this).setVisible(true);
    }//GEN-LAST:event_label_addMouseClicked

    private void label_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_deleteMouseClicked
        int row = bangNL.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa ? ");
        if (confirm == JOptionPane.YES_OPTION) {
            String maNL = String.valueOf(bangNL.getValueAt(row, 0));

            try {
                kn.xoaNL(maNL);
            } catch (SQLException ex) {
                Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                setData();
            } catch (SQLException ex) {
                Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_label_deleteMouseClicked

    private void label_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_updateMouseClicked
        int row = bangNL.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        String a = (String) bangNL.getValueAt(row, 0);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new NguyenLieuDialog((Frame) parentWindow, true, a, this).setVisible(true);
    }//GEN-LAST:event_label_updateMouseClicked

    private void label_xuattonkhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_xuattonkhoMouseClicked
        try {
            func.exportJTableToExcel(bangNL);
        } catch (IOException ex) {
            Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_label_xuattonkhoMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        search.setText("");
        dtm.setRowCount(0);
        for (NGUYENLIEU a : dsnl.getDSNL()) {
            if (a.getTrangThai() == 1) {
                dtm.addRow(new Object[]{a.getMaNL(), kn.layTenLoaiNL(a.getMaLoaiNL()), a.getTenNL(), a.getTongSoLuong(), a.getMoTa()});
            }
        }

    }//GEN-LAST:event_btn_refreshActionPerformed
    private DSNguyenLieu boLoc() {
        String select = (String) locNL.getSelectedItem();
        DSNguyenLieu dscopy = new DSNguyenLieu(dsnl);
        int n = dscopy.getDoDai();
        if (select.equals("Lọc theo loại nguyên liệu")) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (dscopy.getDSNL().get(i).getMaLoaiNL().compareTo(dscopy.getDSNL().get(j).getMaLoaiNL()) > 0) {
                        NGUYENLIEU temp = dscopy.getDSNL().get(i);
                        dscopy.getDSNL().set(i, dscopy.getDSNL().get(j));
                        dscopy.getDSNL().set(j, temp);

                    }
                }
            }
        } else if (select.equals("Số lượng nguyên liệu")) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (dscopy.getDSNL().get(i).getTongSoLuong() < dscopy.getDSNL().get(j).getTongSoLuong()) {
                        NGUYENLIEU temp = dscopy.getDSNL().get(i);
                        dscopy.getDSNL().set(i, dscopy.getDSNL().get(j));
                        dscopy.getDSNL().set(j, temp);
                    }
                }
            }
        }
        return dscopy;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangNL;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JMenuItem deleteNL;
    private javax.swing.JMenuItem editNL;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_add;
    private javax.swing.JLabel label_delete;
    private javax.swing.JLabel label_update;
    private javax.swing.JLabel label_xuattonkho;
    private javax.swing.JComboBox<String> locNL;
    private javax.swing.JPopupMenu putableNL;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
