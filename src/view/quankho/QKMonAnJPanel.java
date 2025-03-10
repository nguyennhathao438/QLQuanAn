
package view.quankho;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import model.*;

public class QKMonAnJPanel extends javax.swing.JPanel {
    KetNoiDataBase kn =new KetNoiDataBase();
    DSMonAn dsma;
    DefaultTableModel dtm =new DefaultTableModel();
    public QKMonAnJPanel() {
        initComponents();
        bangMA.setModel(dtm);
        bangMA.setComponentPopupMenu(pubangMA);
        setData();
        setTable();
    }
    public void setTable(){ 
        //set độ rộng
        bangMA.getColumnModel().getColumn(0).setPreferredWidth(50);
        bangMA.getColumnModel().getColumn(1).setPreferredWidth(150);
        bangMA.getColumnModel().getColumn(2).setPreferredWidth(300);
        bangMA.getColumnModel().getColumn(3).setPreferredWidth(100);
        //Can giua
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//Can giữa tẽt
for (int i = 0; i < 5; i++) {
    bangMA.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
}
//Can giua tieu de
 JTableHeader header = bangMA.getTableHeader();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        header.setDefaultRenderer(headerRenderer);
    }
    public void setData(){ 
        dsma =new DSMonAn();
        kn.layMonAn(dsma);
        dtm.setRowCount(0);
        if(dtm.getColumnCount() == 0){
        dtm.addColumn("Mã Món Ăn");
        dtm.addColumn("Tên Món Ăn");
        dtm.addColumn("Mô Tả");
        dtm.addColumn("Giá");
        dtm.addColumn("Trạng Thái");
        }
        for(MONAN a:dsma.getDSMA()){ 
            if(a.getTrangThai()!=0){
            dtm.addRow(new Object[]{a.getMaMA(),a.getTenMA(),a.getMoTa(),a.getGia(),setTT(a.getTrangThai())});
            
            }
        }     
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pubangMA = new javax.swing.JPopupMenu();
        editMA = new javax.swing.JMenuItem();
        deleteMA = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangMA = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        congthuc = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchText = new javax.swing.JTextField();
        search = new javax.swing.JLabel();

        editMA.setText("Sửa");
        editMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMAActionPerformed(evt);
            }
        });
        pubangMA.add(editMA);

        deleteMA.setText("Xoá");
        deleteMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMAActionPerformed(evt);
            }
        });
        pubangMA.add(deleteMA);

        bangMA.setModel(new javax.swing.table.DefaultTableModel(
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
        bangMA.setRowHeight(35);
        bangMA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bangMA.setShowGrid(true);
        jScrollPane1.setViewportView(bangMA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức Năng"));

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconthem.png"))); // NOI18N
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-icon.png"))); // NOI18N
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit-icon.png"))); // NOI18N
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });

        congthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/set-tp-icon.png"))); // NOI18N
        congthuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                congthucMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(add)
                .addGap(40, 40, 40)
                .addComponent(delete)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(edit)
                .addGap(40, 40, 40)
                .addComponent(congthuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(congthuc, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(127, 127, 127))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        searchText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMAActionPerformed
        int row = bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this,"Click vào món ăn");
        }else{ 
            new MonAnJFrame((String) bangMA.getValueAt(row, 0)).setVisible(true);
        }
    }//GEN-LAST:event_editMAActionPerformed

    private void deleteMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMAActionPerformed
        int row=bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        int confirm= JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa");
        if(confirm == JOptionPane.YES_OPTION){ 
                String maMA=String.valueOf(bangMA.getValueAt(row, 0));
                
                kn.xoaMonAn(maMA);
                    setData();                    
                
            }
    }//GEN-LAST:event_deleteMAActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        new MonAnJFrame().setVisible(true);
    }//GEN-LAST:event_addMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        int row=bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        int confirm= JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa");
        if(confirm == JOptionPane.YES_OPTION){ 
                String maMA=String.valueOf(bangMA.getValueAt(row, 0));
                
                kn.xoaMonAn(maMA);
                    setData();                    
                
            }
    }//GEN-LAST:event_deleteMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        setData();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        int row = bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this,"Click vào món ăn");
        }else{ 
            new MonAnJFrame((String) bangMA.getValueAt(row, 0)).setVisible(true);
        }
    }//GEN-LAST:event_editMouseClicked

    private void congthucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_congthucMouseClicked
        int row =bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Click vào món ăn ");
        }else{ 
            MONAN hao=new MONAN();
            String text=(String) bangMA.getValueAt(row, 0);
            for(MONAN ma:dsma.getDSMA()){ 
                if(text.equals(ma.getMaMA())){ 
                    hao=ma;
                    break;
                }
            }
            new ThanhPhanJFrame(hao,setTTtoInt((String) bangMA.getValueAt(row, 4))).setVisible(true);
        }
    }//GEN-LAST:event_congthucMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        String stext=searchText.getText();
        DSMonAn dsmasearch=new DSMonAn();
        boolean kt =false;
        for(MONAN a:dsma.getDSMA()){ 
            if(a.getTenMA().toLowerCase().contains(stext.toLowerCase()) || a.getMaMA().toLowerCase().contains(stext.toLowerCase())){
                dsmasearch.themMA(a);
                kt=true;
                        }
        }
        if(kt==true){ 
            dtm.setRowCount(0);
            for(MONAN a:dsmasearch.getDSMA()){ 
                if(a.getTrangThai()!=0){
            dtm.addRow(new Object[]{a.getMaMA(),a.getTenMA(),a.getMoTa(),a.getGia(),setTT(a.getTrangThai())});
            
            }
            }
        }else{ 
            JOptionPane.showMessageDialog(searchText, "Không tìm thấy");
        }
    }//GEN-LAST:event_searchMouseClicked
    private String setTT(int n){ 
        if(n==1){ 
            return "Đã set tp";
        }
        return "Chưa set";
    }
    private int setTTtoInt(String str){ 
        if(str.equals("Đã set tp"))
            return 1;
        return 2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JTable bangMA;
    private javax.swing.JLabel congthuc;
    private javax.swing.JLabel delete;
    private javax.swing.JMenuItem deleteMA;
    private javax.swing.JLabel edit;
    private javax.swing.JMenuItem editMA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu pubangMA;
    private javax.swing.JLabel search;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
