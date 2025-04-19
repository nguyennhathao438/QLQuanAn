 
package GUI.quankho;

import DTO.MONAN;
import DTO.DSMonAn;
import DAO.QuanKhoDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;



public class QKMonAnJPanel extends javax.swing.JPanel {
    QuanKhoDAO kn =new QuanKhoDAO();
    DSMonAn dsma;
    DefaultTableModel dtm =new DefaultTableModel();
    Func_class func=new Func_class();
    public QKMonAnJPanel() {
        initComponents();
        bangMA.setModel(dtm);
        bangMA.setComponentPopupMenu(pubangMA);
        setTextHidden();
        setData();
        setTable();
        locMA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
locMA.setBackground(new Color(230, 230, 250)); // màu nền nhạt
locMA.setForeground(Color.DARK_GRAY); // màu chữ
    

    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", searchText);
        PromptSupport.setForeground(Color.GRAY, searchText);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,searchText);
    }
    public void setTable(){ 
        bangMA.getColumnModel().getColumn(0).setPreferredWidth(50);
        bangMA.getColumnModel().getColumn(1).setPreferredWidth(100);
        bangMA.getColumnModel().getColumn(2).setPreferredWidth(130);
        bangMA.getColumnModel().getColumn(3).setPreferredWidth(200);
        bangMA.getColumnModel().getColumn(4).setPreferredWidth(100);
        //Can giua
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//Can giữa tẽt
for (int i = 0; i < 6; i++) {
    bangMA.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
}
           func.centerTable(bangMA);
        func.setUpTable(bangMA);
    }
    public void setData(){ 
        dsma =new DSMonAn();
        kn.layDSMonAn(dsma);
        dtm.setRowCount(0);
        if(dtm.getColumnCount() == 0){
        dtm.addColumn("Mã");
        dtm.addColumn("Loại Món Ăn");
        dtm.addColumn("Tên Món Ăn");
        dtm.addColumn("Mô Tả");
        dtm.addColumn("Giá");
        dtm.addColumn("Trạng Thái");
        }
        for(MONAN a:dsma.getDSMA()){ 
            if(a.getTrangThai()!=0){
            dtm.addRow(new Object[]{a.getMaMA(),a.getLoaiMA(),a.getTenMA(),a.getMoTa(),a.getGia(),setTT(a.getTrangThai())});
            
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchText = new javax.swing.JTextField();
        locMA = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();

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
        bangMA.setShowGrid(false);
        jScrollPane1.setViewportView(bangMA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconthem.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit-icon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/set-tp-icon.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Thêm");

        jLabel2.setText("Xoá");

        jLabel3.setText("Cập nhật");

        jLabel4.setText("Sửa");

        jLabel5.setText("Lập công thức");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2)))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(56, 56, 56))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        searchText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        locMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không chọn", "Lọc theo loại nguyên liệu", "Giá tăng dần", "Giá giảm dần" }));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(locMA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton6)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locMA)))
                    .addComponent(jButton6))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMAActionPerformed
        int row = bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this,"Click vào món ăn");
        }else{ 
            String a= (String) bangMA.getValueAt(row,0);
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new MonAnDiaLog((Frame) parentWindow,true,a).setVisible(true);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new MonAnDiaLog((Frame) parentWindow,true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
        int row = bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this,"Click vào món ăn");
        }else{ 
            String a= (String) bangMA.getValueAt(row,0);
            System.out.println(a);
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new MonAnDiaLog((Frame) parentWindow,true,a).setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new ThanhPhanDialog((Frame) parentWindow,true,hao,setTTtoInt((String) bangMA.getValueAt(row, 5))).setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String stext=searchText.getText();     
        boolean kt =false;
        DSMonAn dssearch=boLoc();
        dtm.setRowCount(0);
        for(MONAN a:dssearch.getDSMA()){ 
            if((a.getTenMA().toLowerCase().contains(stext.toLowerCase()) || a.getMaMA().toLowerCase().contains(stext.toLowerCase())&& a.getTrangThai()!=0)){
                dtm.addRow(new Object[]{a.getMaMA(),a.getLoaiMA(),a.getTenMA(),a.getMoTa(),a.getGia(),setTT(a.getTrangThai())});
                
                        }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
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
    private DSMonAn boLoc(){ 
        String text=(String) locMA.getSelectedItem();
        DSMonAn dscopy =new DSMonAn(dsma);
        int n=dscopy.getN();
        if(text.equals("Lọc theo loại nguyên liệu")){ 
            for(int i=0;i<n-1;i++){ 
                for(int j=i+1;j<n;j++){ 
                    if(dscopy.getDSMA().get(i).getLoaiMA().compareTo(dscopy.getDSMA().get(j).getLoaiMA())>0){ 
                        MONAN temp = dscopy.getDSMA().get(i);
                        dscopy.getDSMA().set(i, dscopy.getDSMA().get(j));
                        dscopy.getDSMA().set(j, temp);
                    }
                }
            }
        }else if(text.equals("Giá tăng dần")){ 
            for(int i=0;i<n-1;i++){ 
                for(int j=i+1;j<n;j++){ 
                    if(dscopy.getDSMA().get(i).getGia()> dscopy.getDSMA().get(j).getGia()){ 
                       MONAN temp = dscopy.getDSMA().get(i);
                        dscopy.getDSMA().set(i, dscopy.getDSMA().get(j));
                        dscopy.getDSMA().set(j, temp); 
                    }
                }
            }
        }
        else if(text.equals("Giá giảm dần "))  { 
                for(int i=0;i<n-1;i++){ 
                for(int j=i+1;j<n;j++){ 
                    if(dscopy.getDSMA().get(i).getGia()<dscopy.getDSMA().get(j).getGia()){ 
                       MONAN temp = dscopy.getDSMA().get(i);
                        dscopy.getDSMA().set(i, dscopy.getDSMA().get(j));
                        dscopy.getDSMA().set(j, temp); 
                    }
                }
            }
                }  
        return dscopy;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangMA;
    private javax.swing.JMenuItem deleteMA;
    private javax.swing.JMenuItem editMA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> locMA;
    private javax.swing.JPopupMenu pubangMA;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
