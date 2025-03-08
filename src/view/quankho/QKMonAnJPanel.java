
package view.quankho;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        themMA = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        setTP = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();

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
        bangMA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(bangMA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        themMA.setText("Them");
        themMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMAActionPerformed(evt);
            }
        });

        refresh.setText("Cập Nhật");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        setTP.setText("Set Thành Phần");
        setTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTPActionPerformed(evt);
            }
        });

        searchBtn.setText("Tìm Kiếm");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(themMA)
                .addGap(18, 18, 18)
                .addComponent(refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setTP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(searchBtn)
                .addGap(104, 104, 104))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refresh)
                    .addComponent(themMA)
                    .addComponent(setTP))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void themMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMAActionPerformed
        new MonAnJFrame().setVisible(true);
    }//GEN-LAST:event_themMAActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        setData();
    }//GEN-LAST:event_refreshActionPerformed

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

    private void setTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTPActionPerformed
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
    }//GEN-LAST:event_setTPActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
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
    }//GEN-LAST:event_searchBtnActionPerformed
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
    private javax.swing.JTable bangMA;
    private javax.swing.JMenuItem deleteMA;
    private javax.swing.JMenuItem editMA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu pubangMA;
    private javax.swing.JButton refresh;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchText;
    private javax.swing.JButton setTP;
    private javax.swing.JButton themMA;
    // End of variables declaration//GEN-END:variables
}
