
package GUI.quankho;

import DTO.NGUYENLIEU;
import DAO.QuanKhoDAO;
import DTO.DSNguyenLieu;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;


public class QKNLJPanel extends javax.swing.JPanel {
    DSNguyenLieu dsnl=new DSNguyenLieu();
   QuanKhoDAO kn=new QuanKhoDAO();
   Func_class func = new Func_class();
   DefaultTableModel dtm=new DefaultTableModel(); ;
    public QKNLJPanel() throws SQLException {
        initComponents();
        setData();
        bangNL.setModel(dtm);
        bangNL.setComponentPopupMenu(putableNL);
        locNL.setFont(new Font("Segoe UI", Font.PLAIN, 14));
locNL.setBackground(new Color(230, 230, 250)); // màu nền nhạt
locNL.setForeground(Color.DARK_GRAY); // màu chữ
        setTextHidden();
         func.centerTable(bangNL);
        func.setUpTable(bangNL);   
        setIcon();
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", search);
        PromptSupport.setForeground(Color.GRAY, search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,search);
    }
    public void setIcon(){
        jButton6.setIcon(new FlatSVGIcon("./resources/icon/find.svg",0.35f));
        jButton1.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg",0.06f));
        jButton3.setIcon(new FlatSVGIcon("./resources/icon/update.svg",0.85f));
        jButton2.setIcon(new FlatSVGIcon("./resources/icon/delete.svg",0.75f));
        
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        locNL = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();

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
            .addComponent(jScrollPane4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export-icon.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("Thêm");

        jLabel3.setText("Xoá");

        jLabel4.setText("Sửa");

        jLabel6.setText("Xuất tồn kho");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        locNL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không chọn", "Lọc theo loại nguyên liệu", "Số lượng nguyên liệu" }));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(locNL, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton6)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(locNL, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(search))))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new NguyenLieuDialog((Frame) parentWindow,true,this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row=bangNL.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        String a = (String) bangNL.getValueAt(row, 0);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new NguyenLieuDialog((Frame) parentWindow,true,a,this).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất hoá đơn ");
          if(confirm ==JOptionPane.YES_OPTION){
        String filePath="C:\\Users\\ADMIN\\Documents\\oop\\QLQuanAn\\exportfile\\tonkho.xlsx";
        Workbook workbook =new XSSFWorkbook();
        Sheet sheet = (Sheet) workbook.createSheet("Danh sách tồn kho");
        Row headerRow= sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã NL");
        headerRow.createCell(1).setCellValue("Loại NL");
        headerRow.createCell(2).setCellValue("Tên NL");
        headerRow.createCell(3).setCellValue("Mô tả");
        headerRow.createCell(4).setCellValue("Số lượng");
        headerRow.createCell(5).setCellValue("Đơn vị");
        int rowCount =1;
        for(NGUYENLIEU nl :dsnl.getDSNL()){ 
            if(nl.getTrangThai()!=0 && nl.getTongSoLuong()> 0){ 
                Row dataRow = sheet.createRow(rowCount++);
        dataRow.createCell(0).setCellValue(nl.getMaNL());
                    dataRow.createCell(1).setCellValue(kn.layTenLoaiNL(nl.getMaLoaiNL()));
                
        dataRow.createCell(2).setCellValue(nl.getTenNL());
        dataRow.createCell(3).setCellValue(nl.getMoTa());
        dataRow.createCell(4).setCellValue(nl.getTongSoLuong());
        dataRow.createCell(5).setCellValue(nl.getDonVi());

            }
        }
        try (FileOutputStream output=new FileOutputStream(new File(filePath))){
            workbook.write(output);
            JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(QKNLJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
          else{ 
              return ;
          }
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private javax.swing.JTable bangNL;
    private javax.swing.JMenuItem deleteNL;
    private javax.swing.JMenuItem editNL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JComboBox<String> locNL;
    private javax.swing.JPopupMenu putableNL;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
