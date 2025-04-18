/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.quankho;

import DTO.LICHSUNH;
import DAO.QuanKhoDAO;
import DTO.HOADONNHAPHANG;
import export_file.XuatPhieuNhap;
import java.awt.Frame;
import java.awt.Window;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import util.Func_class;

public class QKHDNHJPanel extends javax.swing.JPanel {
    QuanKhoDAO kn=new QuanKhoDAO();
    LICHSUNH dshd ;
    DefaultTableModel dtm=new DefaultTableModel();
    Func_class func = new Func_class();
    public QKHDNHJPanel() {
        initComponents();
        bangLSHDNH.setModel(dtm);
        setData();
        setTable();
    }
    public void setData(){ 
        DecimalFormat df = new DecimalFormat("#,###");
        dshd=new LICHSUNH();
        kn.layHDNH(dshd);
        dtm.setRowCount(0);
        if(dtm.getColumnCount()==0){ 
            dtm.addColumn("Mã hoá đơn");
            dtm.addColumn("Nhà cung cấp");
            dtm.addColumn("Ngày Nhập");
            dtm.addColumn("Giá ");
        }
         for(HOADONNHAPHANG a:dshd.getLSNH()){ 
            String formattedGia = df.format(a.getThanhTien());
            dtm.addRow(new Object[]{a.getMaHDNH(),a.getTenNCC(),a.getNgayNhap(),formattedGia});
        }   

    }
    public void setTable(){ 
        //set độ rộng
        bangLSHDNH.getColumnModel().getColumn(0).setPreferredWidth(80);
        bangLSHDNH.getColumnModel().getColumn(1).setPreferredWidth(150);
        bangLSHDNH.getColumnModel().getColumn(2).setPreferredWidth(150);
        bangLSHDNH.getColumnModel().getColumn(3).setPreferredWidth(200);
        //Can giua
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//Can giữa tẽt
for (int i = 0; i < 4; i++) {
    bangLSHDNH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
}
         func.centerTable(bangLSHDNH);
        func.setUpTable(bangLSHDNH);
    }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangLSHDNH = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 244, 244));

        bangLSHDNH.setModel(new javax.swing.table.DefaultTableModel(
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
        bangLSHDNH.setRowHeight(30);
        bangLSHDNH.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(bangLSHDNH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cart-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/View-Details-icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export-icon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nhập hàng");

        jLabel2.setText("Xem chi tiết");

        jLabel3.setText("Xuất hoá đơn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(112, 112, 112)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                Window parentWindow = SwingUtilities.getWindowAncestor(this);
                new HDNHDialog((Frame) parentWindow, true).setVisible(true);
        }// GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                int row = bangLSHDNH.getSelectedRow();
                if (row == -1) {
                        JOptionPane.showMessageDialog(this, "Click vào hoá đơn ");
                } else {
                        String a = (String) bangLSHDNH.getValueAt(row, 0);
                        Window parentWindow = SwingUtilities.getWindowAncestor(this);
                        new CTHDNHDialog((Frame) parentWindow, true, a).setVisible(true);
                }
        }// GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
                int row = bangLSHDNH.getSelectedRow();
                if (row == -1) {
                        JOptionPane.showMessageDialog(this, "Vui lòng chọn hoá đơn");
                        return;
                } else {
                        XuatPhieuNhap export = new XuatPhieuNhap();
                        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc xuất lại hoá đơn ");
                        if (confirm == JOptionPane.YES_OPTION) {
                                export.XuatPDF((String) bangLSHDNH.getValueAt(row, 0));
                        } else {
                                return;
                        }
                }
        }// GEN-LAST:event_jButton3ActionPerformed
        private JTextField txtQuy;
        private JTextField txtNam;


        private boolean isThangSelected = false;
        private boolean isQuySelected = false;

        private void ThangButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ThangButtonActionPerformed

       
    }

        // GEN-LAST
        public ArrayList<HOADONNHAPHANG> thongKeTheoThang(int thangfrom, int namfrom, int thangto, int namto) {
                ArrayList<HOADONNHAPHANG> result = new ArrayList<>();

                // Khởi tạo thời gian bắt đầu (đầu tháng from)
                Calendar calFrom = Calendar.getInstance();
                calFrom.set(namfrom, thangfrom - 1, 1); // Lưu ý: tháng tính từ 0

                // Khởi tạo thời gian kết thúc (cuối tháng to)
                Calendar calTo = Calendar.getInstance();
                calTo.set(namto, thangto - 1, 1);
                calTo.set(Calendar.DAY_OF_MONTH, calTo.getActualMaximum(Calendar.DAY_OF_MONTH)); // Lấy ngày cuối cùng
                                                                                                 // của tháng

                for (HOADONNHAPHANG cthd : dshd.getLSNH()) {
                        java.util.Date ngayNhap = new java.util.Date(cthd.getNgayNhap().getTime());
                        if (ngayNhap != null && !ngayNhap.before(calFrom.getTime())
                                        && !ngayNhap.after(calTo.getTime())) {
                                result.add(cthd);
                        }
                }

                return result;
        }

        public ArrayList<HOADONNHAPHANG> thongKeTheoQuy(int quy, int nam) {

                ArrayList<HOADONNHAPHANG> result = new ArrayList<>();
                for (HOADONNHAPHANG cthd : dshd.getLSNH()) {
                        String maHDNH;
                        java.util.Date ngayNhap = new java.util.Date(cthd.getNgayNhap().getTime());
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(ngayNhap);
                        int month = cal.get(Calendar.MONTH) + 1;
                        int year = cal.get(Calendar.YEAR);

                        if (year == nam && ((quy - 1) * 3 + 1 <= month && month <= quy * 3)) {
                                result.add(cthd);
                        }

                }
                return result;
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangLSHDNH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
