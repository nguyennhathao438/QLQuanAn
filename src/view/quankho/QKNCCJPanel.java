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
        jButton1 = new javax.swing.JButton();
        editNCC = new javax.swing.JButton();
        deleteNCC = new javax.swing.JButton();
        sdtNCC = new javax.swing.JTextField();

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Mã NCC");

        jLabel2.setText("Tên NCC");

        jLabel3.setText("Số điện thoại (Cách nhau bởi dấu phẩy)");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        editNCC.setText("Sửa");
        editNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNCCActionPerformed(evt);
            }
        });

        deleteNCC.setText("Xoá");
        deleteNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNCCActionPerformed(evt);
            }
        });

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
                    .addComponent(sdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(maNCC)
                            .addComponent(tenNCC))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(editNCC)
                            .addComponent(deleteNCC))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteNCC)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed
     
    private void deleteNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNCCActionPerformed
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
    }//GEN-LAST:event_deleteNCCActionPerformed

    private void editNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNCCActionPerformed
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
    }//GEN-LAST:event_editNCCActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangNCC;
    private javax.swing.JButton deleteNCC;
    private javax.swing.JButton editNCC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maNCC;
    private javax.swing.JTextField sdtNCC;
    private javax.swing.JTextField tenNCC;
    // End of variables declaration//GEN-END:variables
}
