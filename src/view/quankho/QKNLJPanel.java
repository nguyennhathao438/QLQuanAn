
package view.quankho;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.*;

public class QKNLJPanel extends javax.swing.JPanel {
    DSNguyenLieu dsnl=new DSNguyenLieu();
   KetNoiDataBase kn=new KetNoiDataBase();
   DefaultTableModel dtm=new DefaultTableModel(); ;
    public QKNLJPanel() throws SQLException {
        initComponents();
        setData();
        bangNL.setModel(dtm);
        bangNL.setComponentPopupMenu(putableNL);
    }
    public void setData() throws SQLException{ 
        dsnl=new DSNguyenLieu();
        kn.layNL(dsnl);
        dtm.setRowCount(0);
        if(dtm.getColumnCount() == 0){
            dtm.addColumn("Mã NL");
            dtm.addColumn("Loại NL");
            dtm.addColumn("Tên TL");
            dtm.addColumn("Tổng SL");
            dtm.addColumn("Mô Tả");
            
        }        
        for(NGUYENLIEU nl:dsnl.getDSNL()){ 
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
        addNL = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        refresh = new javax.swing.JLabel();
        export = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        locNL = new javax.swing.JComboBox<>();

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

        setBackground(new java.awt.Color(255, 255, 255));

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
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        addNL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconthem.png"))); // NOI18N
        addNL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNLMouseClicked(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-icon.png"))); // NOI18N
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit-icon.png"))); // NOI18N
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });

        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export-icon.png"))); // NOI18N
        export.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(addNL)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addGap(18, 18, 18)
                .addComponent(edit)
                .addGap(18, 18, 18)
                .addComponent(refresh)
                .addGap(18, 18, 18)
                .addComponent(export)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(export, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(delete)
                        .addComponent(addNL)
                        .addComponent(edit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        locNL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không chọn", "Lọc theo loại nguyên liệu", "Nguyên liệu cận date", "Số lượng nguyên liệu" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(locNL, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(locNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNLActionPerformed
        int row=bangNL.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        int confirm= JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa");
        if(confirm == JOptionPane.YES_OPTION){ 
                String maNL=String.valueOf(bangNL.getValueAt(row, 0));
                
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
    }//GEN-LAST:event_deleteNLActionPerformed

    private void editNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNLActionPerformed
        int row=bangNL.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        try {
            new NguyenLieuJFrame((String) bangNL.getValueAt(row, 0)).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editNLActionPerformed

    private void addNLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNLMouseClicked
        new NguyenLieuJFrame().setVisible(true);
    }//GEN-LAST:event_addNLMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        int row=bangNL.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        int confirm= JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa");
        if(confirm == JOptionPane.YES_OPTION){ 
                String maNL=String.valueOf(bangNL.getValueAt(row, 0));
                
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
    }//GEN-LAST:event_deleteMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        try {
            setData();
        } catch (SQLException ex) {
            Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        int row=bangNL.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        try {
            new NguyenLieuJFrame((String) bangNL.getValueAt(row, 0)).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        String text= search.getText();
     
        dtm.setRowCount(0);
        DSNguyenLieu dssearch=boLoc();
        for(NGUYENLIEU a:dssearch.getDSNL()){ 
            try {
                if(a.getTenNL().toLowerCase().contains(text) ||  a.getMaNL().toLowerCase().contains(text) || a.getMoTa().toLowerCase().contains(text) ){
                    if(a.getTrangThai()==1)
                    dtm.addRow(new Object[]{a.getMaNL(),kn.layTenLoaiNL(a.getMaLoaiNL()),a.getTenNL(),a.getTongSoLuong(),a.getMoTa()});
                }
            } catch (SQLException ex) {
                Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void exportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportMouseClicked
      
    }//GEN-LAST:event_exportMouseClicked
    private DSNguyenLieu boLoc(){ 
        String select = (String) locNL.getSelectedItem();
        DSNguyenLieu dscopy=new DSNguyenLieu(dsnl);
        int n=dscopy.getDoDai();
        if(select.equals("Lọc theo loại nguyên liệu")){ 
             for(int i=0;i<n-1;i++){ 
                 for(int j=i+1;j<n;j++){ 
                     if(dscopy.getDSNL().get(i).getMaLoaiNL().compareTo(dscopy.getDSNL().get(j).getMaLoaiNL()) > 0){ 
                         NGUYENLIEU temp=dscopy.getDSNL().get(i);
                         dscopy.getDSNL().set(i, dscopy.getDSNL().get(j));
                         dscopy.getDSNL().set(j, temp);
                     }
                 }
             }              
        }else if(select.equals("Nguyên liệu cận date")){ 
            
        }else if(select.equals("Số lượng nguyên liệu")){ 
            for(int i=0;i<n-1;i++){ 
                 for(int j=i+1;j<n;j++){ 
                     if(dscopy.getDSNL().get(i).getTongSoLuong() < dscopy.getDSNL().get(j).getTongSoLuong()){ 
                         NGUYENLIEU temp=dscopy.getDSNL().get(i);
                         dscopy.getDSNL().set(i, dscopy.getDSNL().get(j));
                         dscopy.getDSNL().set(j, temp);
                     }
                 }
             } 
        }
        return dscopy;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addNL;
    private javax.swing.JTable bangNL;
    private javax.swing.JLabel delete;
    private javax.swing.JMenuItem deleteNL;
    private javax.swing.JLabel edit;
    private javax.swing.JMenuItem editNL;
    private javax.swing.JLabel export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> locNL;
    private javax.swing.JPopupMenu putableNL;
    private javax.swing.JLabel refresh;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
