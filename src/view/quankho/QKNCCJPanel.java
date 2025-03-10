/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.quankho;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

public class QKNCCJPanel extends javax.swing.JPanel {
    KetNoiDataBase kn=new KetNoiDataBase();
    DSNCC dsncc ;
    DefaultTableModel dtm =new DefaultTableModel();
    
    public QKNCCJPanel() {
        initComponents();
        bangNCC.setModel(dtm);
        setData();
    }
    public void setData (){ 
        dsncc=new DSNCC();
        kn.layNCC(dsncc);
    
        dtm.setRowCount(0);
        if(dtm.getColumnCount() == 0){
        dtm.addColumn("Mã NCC");
        dtm.addColumn("Tên NCC");
        dtm.addColumn("Số điện thoại ");
        
        }
        maNCC.setText("");
        tenNCC.setText("");
        sdtNCC.setText("");
        for(NHACUNGCAP a:dsncc.getDSNCC()){ 
            dtm.addRow(new Object[]{a.getMaNCC(),a.getTenNCC(),a.getSdt()});
        }
             
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangNCC = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        maNCC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tenNCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sdtNCC = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        them = new javax.swing.JLabel();
        xoa = new javax.swing.JLabel();
        sua = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        bangNCC.setModel(new javax.swing.table.DefaultTableModel(
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
        bangNCC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bangNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangNCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangNCC);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Mã NCC");

        jLabel2.setText("Tên NCC");

        jLabel3.setText("Số điện thoại (Cách nhau bởi dấu phẩy)");

        sdtNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sdtNCCFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdtNCC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addComponent(tenNCC)
                    .addComponent(maNCC))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconthem.png"))); // NOI18N
        them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themMouseClicked(evt);
            }
        });

        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-icon.png"))); // NOI18N
        xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoaMouseClicked(evt);
            }
        });

        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit-icon.png"))); // NOI18N
        sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(xoa)
                .addGap(47, 47, 47)
                .addComponent(sua)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sua)
                    .addComponent(xoa)
                    .addComponent(them))
                .addGap(73, 73, 73))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean ktsdt(String sdt){ 
        String text =  sdtNCC.getText();
        String regex = "^((\\d{10})|(\\d{11})|(\\d{12}))?(,\\s?)?((\\d{10})|(\\d{11})|(\\d{12}))*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(!(matcher.matches())){ 
            return false;
        }
        return true;
    }     
    private void sdtNCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sdtNCCFocusLost
        String text =  sdtNCC.getText();
        String regex = "^((\\d{10})|(\\d{11})|(\\d{12}))?(,\\s?)?((\\d{10})|(\\d{11})|(\\d{12}))*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(!(matcher.matches())){ 
            JOptionPane.showMessageDialog(bangNCC, "Định dạng sdt không hợp lệ");
        }
    }//GEN-LAST:event_sdtNCCFocusLost

    private void bangNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangNCCMouseClicked
        int row=bangNCC.getSelectedRow();
        maNCC.setText(String.valueOf(bangNCC.getValueAt(row, 0)));
        tenNCC.setText(String.valueOf(bangNCC.getValueAt(row, 1)));
        sdtNCC.setText(String.valueOf(bangNCC.getValueAt(row, 2)));
    }//GEN-LAST:event_bangNCCMouseClicked

    private void themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themMouseClicked
        if(!(ktsdt(sdtNCC.getText()))){ 
            JOptionPane.showMessageDialog(bangNCC, "Định dạng sdt không hợp lệ");
            return;
        }
        String text = maNCC.getText();
        for(NHACUNGCAP a:dsncc.getDSNCC()){ 
            if(a.getMaNCC().equals(text)){ 
                JOptionPane.showMessageDialog(this, "Mã NCC đã tồn tại");
                return ;
            }
        }
        NHACUNGCAP ncc =new NHACUNGCAP();
        ncc.setMaNCC(maNCC.getText());
        ncc.setTenNCC(tenNCC.getText());
        ncc.setSdt(sdtNCC.getText());
        kn.themNCC(ncc);
        setData();
    }//GEN-LAST:event_themMouseClicked

    private void xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoaMouseClicked
       int row = bangNCC.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "click vao ncc can xoa", "Loi", JOptionPane.ERROR_MESSAGE);
        }else{ 
            int confirm= JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa");
            if(confirm == JOptionPane.YES_OPTION){ 
                String maNCC=String.valueOf(bangNCC.getValueAt(row, 0));
                
                try {
                    kn.xoaNCC(maNCC);
                } catch (SQLException ex) {
                    Logger.getLogger(QKNCCJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                    setData();                    
               
            }
                   
        }
    }//GEN-LAST:event_xoaMouseClicked

    private void suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suaMouseClicked
        if(!(ktsdt(sdtNCC.getText()))){ 
            JOptionPane.showMessageDialog(bangNCC, "Định dạng sdt không hợp lệ");
            return;
        }
        String text=maNCC.getText();
        boolean kt=false;
        for(NHACUNGCAP a:dsncc.getDSNCC()){ 
            if(a.getMaNCC().equals(text)){ 
                kt=true;
                break;
            }
        }
        if(kt= true){ 
            NHACUNGCAP ncc =new NHACUNGCAP();
        ncc.setMaNCC(maNCC.getText());
        ncc.setTenNCC(tenNCC.getText());
        ncc.setSdt(sdtNCC.getText());
            try {
                kn.suaNCC(ncc);
            } catch (SQLException ex) {
                Logger.getLogger(QKNCCJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setData();
    }//GEN-LAST:event_suaMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String text = search.getText();
        dtm.setRowCount(0);
        for(NHACUNGCAP a:dsncc.getDSNCC()){ 
            if(a.getMaNCC().toLowerCase().contains(text) || a.getTenNCC().toLowerCase().contains(text) || String.valueOf(a.getSdt()).toLowerCase().contains(text)){ 
                dtm.addRow(new Object[]{a.getMaNCC(),a.getTenNCC(),a.getSdt()});
            }
        }
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maNCC;
    private javax.swing.JTextField sdtNCC;
    private javax.swing.JTextField search;
    private javax.swing.JLabel sua;
    private javax.swing.JTextField tenNCC;
    private javax.swing.JLabel them;
    private javax.swing.JLabel xoa;
    // End of variables declaration//GEN-END:variables
}
