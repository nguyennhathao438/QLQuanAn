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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.*;
import java.awt.*;

public class QKHDNHJPanel extends javax.swing.JPanel {
        QuanKhoDAO kn = new QuanKhoDAO();
        LICHSUNH dshd = new LICHSUNH();
        
        ArrayList<HOADONNHAPHANG> lsnh = dshd.getLSNH();
        DefaultTableModel dtm = new DefaultTableModel();

        public QKHDNHJPanel() {
                kn.layHDNH(dshd);

                initComponents();
                bangLSHDNH.setModel(dtm);
                setData(lsnh);
                setTable();

        }

        public void setData(ArrayList<HOADONNHAPHANG> lsnh) {
                DecimalFormat df = new DecimalFormat("#,###");
                dtm.setRowCount(0);


                // Tạo lại model mới hoàn toàn mỗi lần gọi
                dtm = new DefaultTableModel();
                dtm.addColumn("Mã hoá đơn");
                dtm.addColumn("Nhà cung cấp");
                dtm.addColumn("Ngày Nhập");
                dtm.addColumn("Giá ");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Format đẹp

                for (HOADONNHAPHANG a : lsnh) {
                        if (a == null) {
                                System.out.println("Rỗng");

                        } else {
                                String formattedGia = df.format(a.getThanhTien());
                                String formattedDate = sdf.format(a.getNgayNhap());
                                dtm.addRow(new Object[] { a.getMaHDNH(), a.getTenNCC(), formattedDate, formattedGia });

                        }
                }

                bangLSHDNH.setModel(dtm); // Gán lại sau khi set xong
        }

        public void setTable() {
                // set độ rộng
                bangLSHDNH.getColumnModel().getColumn(0).setPreferredWidth(80);
                bangLSHDNH.getColumnModel().getColumn(1).setPreferredWidth(150);
                bangLSHDNH.getColumnModel().getColumn(2).setPreferredWidth(150);
                bangLSHDNH.getColumnModel().getColumn(3).setPreferredWidth(200);
                // Can giua
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                // Can giữa tẽt
                for (int i = 0; i < 4; i++) {
                        bangLSHDNH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
                // Can giua tieu de
                JTableHeader header = bangLSHDNH.getTableHeader();
                DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
                headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                header.setDefaultRenderer(headerRenderer);
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
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
        jPanel4 = new javax.swing.JPanel();
        TimeFrom = new com.toedter.calendar.JDateChooser();
        ThangButton = new javax.swing.JCheckBox();
        TimeTo = new com.toedter.calendar.JDateChooser();
        QuyButton = new javax.swing.JCheckBox();
        FromText = new javax.swing.JLabel();
        ToText = new javax.swing.JLabel();
        ThongkeButton = new javax.swing.JButton();

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
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(44, 44, 44))
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        jPanel4.setPreferredSize(new java.awt.Dimension(324, 133));

        ThangButton.setText("Theo tháng");
        ThangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThangButtonActionPerformed(evt);
            }
        });

        QuyButton.setText("Theo quý");
        QuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuyButtonActionPerformed(evt);
            }
        });

        FromText.setText("Từ :");

        ToText.setText("Đến :");

        ThongkeButton.setText("Thống kê");
        ThongkeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongkeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ThangButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(QuyButton)
                .addGap(86, 86, 86))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FromText)
                    .addComponent(ToText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TimeTo, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(TimeFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ThongkeButton)
                .addGap(51, 51, 51))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThangButton)
                    .addComponent(QuyButton))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(FromText))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ToText)
                            .addComponent(TimeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ThongkeButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        private JPanel quyPanel;
        private void ThongkeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ThongkeButtonActionPerformed
                // TODO add your handling code here:
                if (ThangButton.isEnabled() && QuyButton.isEnabled()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng chọn kiểu thống kê: Tháng hoặc Quý.");
                        return;
                } else if (isThangSelected) {

                        java.util.Date utilDate = TimeFrom.getDate();
                        java.util.Date toDate = TimeTo.getDate();

                        if (utilDate == null && toDate == null) {
                                bangLSHDNH.setModel(dtm);
                                
                                setData(lsnh);
                                setTable();
                        } else {
                                Calendar calfrom = Calendar.getInstance();
                                calfrom.setTime(utilDate);
                                int thangfrom = calfrom.get(Calendar.MONTH) + 1;
                                int namfrom = calfrom.get(Calendar.YEAR);
                                Calendar calto = Calendar.getInstance();
                                calto.setTime(toDate);
                                int thangto = calto.get(Calendar.MONTH) + 1;
                                int namto = calto.get(Calendar.YEAR);
                                ArrayList<HOADONNHAPHANG> ls = thongKeTheoThang(thangfrom, namfrom, thangto, namto);
                                bangLSHDNH.setModel(dtm);
                                setData(ls);
                                setTable();

                        }
                } else if (isQuySelected) {
                        int quy = Integer.parseInt(txtQuy.getText());
                        int nam = Integer.parseInt(txtNam.getText());

                        if (quy < 1 || quy > 4) {
                                JOptionPane.showMessageDialog(this, "Quý phải từ 1 đến 4!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }

                        ArrayList<HOADONNHAPHANG> ls = thongKeTheoQuy(quy, nam);
                        bangLSHDNH.setModel(dtm);
                        setData(ls);
                        setTable();

                }
        }// GEN-LAST:event_ThongkeButtonActionPerformed

        private boolean isThangSelected = false;
        private boolean isQuySelected = false;

        private void ThangButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ThangButtonActionPerformed

        if (ThangButton.isSelected()) {
            QuyButton.setSelected(false); // Bỏ chọn checkbox quý
            // Hiện input ngày tháng (JDateChooser)
            TimeFrom.setVisible(true);
            TimeTo.setVisible(true);
            FromText.setVisible(true);
            ToText.setVisible(true);

            // Ẩn input quý nếu có
            if (quyPanel != null) {
                quyPanel.setVisible(false);
            }
        }
    }

        // GEN-LAST:event_ThangButtonActionPerformed

        private void QuyButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_QuyButtonActionPerformed
            if (QuyButton.isSelected()) {
            ThangButton.setSelected(false); // Bỏ chọn checkbox tháng
            // Ẩn input ngày tháng
            TimeFrom.setVisible(false);
            TimeTo.setVisible(false);
            FromText.setVisible(false);
            ToText.setVisible(false);

            // Hiện input nhập quý và năm
            if (quyPanel != null) {
                quyPanel.setVisible(true);
            }
             }
                JPanel quyPanel = new JPanel(new GridLayout(2, 2, 5, 5));
                quyPanel.add(new JLabel("Nhập quý (1-4):"));
                txtQuy = new JTextField();
                quyPanel.add(txtQuy);
                quyPanel.add(new JLabel("Nhập năm:"));
                txtNam = new JTextField();
                quyPanel.add(txtNam);

                int result = JOptionPane.showConfirmDialog(this, quyPanel, "Thống kê theo quý",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result != JOptionPane.OK_OPTION) {
                        // Nếu người dùng bấm Cancel hoặc đóng dialog
                        isQuySelected = false;
                        ThangButton.setEnabled(true);
                }
        }// GEN-LAST:event_QuyButtonActionPerformed

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
    private javax.swing.JLabel FromText;
    private javax.swing.JCheckBox QuyButton;
    private javax.swing.JCheckBox ThangButton;
    private javax.swing.JButton ThongkeButton;
    private com.toedter.calendar.JDateChooser TimeFrom;
    private com.toedter.calendar.JDateChooser TimeTo;
    private javax.swing.JLabel ToText;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
