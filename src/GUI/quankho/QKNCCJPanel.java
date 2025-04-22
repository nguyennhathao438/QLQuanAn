/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.quankho;

import DTO.NHACUNGCAP;
import DTO.DSNCC;
import DAO.QuanKhoDAO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

public class QKNCCJPanel extends javax.swing.JPanel {
    QuanKhoDAO kn=new QuanKhoDAO();
    DSNCC dsncc ;
    DefaultTableModel dtm =new DefaultTableModel();
    Func_class func = new Func_class();
    public QKNCCJPanel() {
        initComponents();
        bangNCC.setModel(dtm);
        setData();
        setTable();
        setTextHidden();
        setIcon();
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
        for(NHACUNGCAP a:dsncc.getDSNCC()){ 
            dtm.addRow(new Object[]{a.getMaNCC(),a.getTenNCC(),a.getSdt()});
        }
             
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", search);
        PromptSupport.setForeground(Color.GRAY, search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,search);
    }
    public void setTable(){        
        bangNCC.getColumnModel().getColumn(0).setPreferredWidth(80);
        bangNCC.getColumnModel().getColumn(1).setPreferredWidth(200);
        bangNCC.getColumnModel().getColumn(2).setPreferredWidth(300);
        //Can giua
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//Can giữa tẽt
for (int i = 0; i < 3; i++) {
    bangNCC.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
}
            func.centerTable(bangNCC);
        func.setUpTable(bangNCC);
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangNCC = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

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
        bangNCC.setRowHeight(30);
        bangNCC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bangNCC.setShowGrid(false);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Thêm");

        jLabel2.setText("Xoá");

        jLabel3.setText("Sửa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)))
                .addGap(145, 145, 145)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)))
                .addGap(152, 152, 152))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void bangNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangNCCMouseClicked

    }//GEN-LAST:event_bangNCCMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       NhaCungCapDialog dialog = new NhaCungCapDialog((Frame) SwingUtilities.getWindowAncestor(this), "Thêm NCC", null);
dialog.setVisible(true);

        if (dialog.isSucceeded()) {
    NHACUNGCAP ncc = dialog.getNhaCungCap();
    kn.themNCC(ncc); // Gọi DAO thêm NCC
    setData(); // Load lại bảng
    
}
    }//GEN-LAST:event_jButton1ActionPerformed
    public void setIcon(){
        jButton4.setIcon(new FlatSVGIcon("./resources/icon/find.svg",0.35f));
        jButton1.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg",0.06f));
        jButton3.setIcon(new FlatSVGIcon("./resources/icon/update.svg",0.85f));
        jButton2.setIcon(new FlatSVGIcon("./resources/icon/delete.svg",0.75f));
        
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int selectedRow = bangNCC.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
        return;
    }

    // Lấy dữ liệu từ bảng
    String ma = bangNCC.getValueAt(selectedRow, 0).toString();
    String ten = bangNCC.getValueAt(selectedRow, 1).toString();
    String sdt = bangNCC.getValueAt(selectedRow, 2).toString();

    NHACUNGCAP selectedNCC = new NHACUNGCAP(ma, ten, sdt);

    // Mở dialog sửa
    NhaCungCapDialog dialog = new NhaCungCapDialog((Frame) SwingUtilities.getWindowAncestor(this), "Sửa Nhà Cung Cấp", selectedNCC);
    dialog.setVisible(true);

    // Lấy kết quả sau khi sửa
    NHACUNGCAP result = dialog.getNhaCungCap();
    if (result != null) {
        try {
            kn.suaNCC(result);
            setData(); // Load lại bảng
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } catch (SQLException ex) {
            Logger.getLogger(QKNCCJPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         String text = search.getText();
        dtm.setRowCount(0);
        for(NHACUNGCAP a:dsncc.getDSNCC()){ 
            if(a.getMaNCC().toLowerCase().contains(text) || a.getTenNCC().toLowerCase().contains(text) || String.valueOf(a.getSdt()).toLowerCase().contains(text)){ 
                dtm.addRow(new Object[]{a.getMaNCC(),a.getTenNCC(),a.getSdt()});
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangNCC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
