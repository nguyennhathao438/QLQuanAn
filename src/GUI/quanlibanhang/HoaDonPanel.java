package GUI.quanlibanhang;

import DAO.QuanHangDAO;
import DAO.UserDAO;
import DTO.CTHOADON;
import DTO.HoaDon;
import DTO.LICHSUBAN;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import export_file.XuatHoaDonBan;
import java.awt.Color;
import java.awt.Frame;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

public class HoaDonPanel extends javax.swing.JPanel {
    Func_class fc = new Func_class();
    QuanHangDAO qh = new QuanHangDAO();
    CTHOADON cthd;
    LICHSUBAN lsb = new LICHSUBAN();
    DefaultTableModel dtm = new DefaultTableModel();
    UserDAO us = new UserDAO();
    public HoaDonPanel() {
        initComponents();
        bangHoaDon.setModel(dtm);
        setData();
        setIcon();
        setTextHidden();
        fc.setUpTable(bangHoaDon);
        fc.centerTable(bangHoaDon);
    }
    public void setIcon(){
        btn_check.setIcon(new FlatSVGIcon("./resources/icon/find.svg",0.35f));
        btn_Reset.setIcon(new FlatSVGIcon("./resources/icon/Refresh_1.svg",0.04f));
        label_chiTiet.setIcon(new FlatSVGIcon("./resources/icon/details.svg",0.45f));
        label_pdf.setIcon(new FlatSVGIcon("./resources/icon/PDF.svg",0.06f));
        fc.cursorPointer(label_chiTiet);
        fc.cursorPointer(label_pdf);
        fc.setUpBtn(btn_Reset, Color.WHITE, new Color(220,220,220));
        fc.setUpBtn(btn_check, Color.WHITE, new Color(220,220,220));
        fc.setUpJTF(search);
        fc.setUpComBoBox(Giacb);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", search);
        PromptSupport.setForeground(Color.GRAY, search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, search);
    }
    public void setData(){
        DecimalFormat df = new DecimalFormat("#,###");
        Giacb.removeAllItems();
        Giacb.addItem("--Select Giá--");
        Giacb.addItem("Tăng dần");
        Giacb.addItem("Giảm dần");
        Giacb.setSelectedIndex(0);
        lsb = new LICHSUBAN();
        qh.LayHDBH(lsb);
        dtm.setRowCount(0);
        if(dtm.getColumnCount() == 0){
            dtm.addColumn("Mã hóa đơn");
            dtm.addColumn("Tên khách hàng");
            dtm.addColumn("Tên User");
            dtm.addColumn("Thời gian");
            dtm.addColumn("Tổng Tiền");
        }
        for(HoaDon a:lsb.getLSB()){
            String formatTongtien = df.format(a.getThanhTien());
            dtm.addRow(new Object[]{a.getMaHoaDon(),a.getMaKH(),us.getTenUserByID(a.getTenUser()),a.getThoiGian(),formatTongtien});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_chiTiet = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_pdf = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        btn_Reset = new javax.swing.JButton();
        Giacb = new javax.swing.JComboBox<>();
        btn_check = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangHoaDon = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        label_chiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_chiTietMouseClicked(evt);
            }
        });

        jLabel10.setText(" Chi tiết");

        label_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_pdfMouseClicked(evt);
            }
        });

        jLabel9.setText("Xuất PDF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_chiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_pdf, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(label_chiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(196, 196, 196))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        btn_Reset.setText("Làm mới");
        btn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetActionPerformed(evt);
            }
        });

        Giacb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Giacb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiacbActionPerformed(evt);
            }
        });

        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_check, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Giacb, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search)
                    .addComponent(Giacb)
                    .addComponent(btn_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bangHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        bangHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void bangHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangHoaDonMouseClicked
        int rows = bangHoaDon.getSelectedRow();
        if(rows != -1){
            String maHD = bangHoaDon.getValueAt(rows, 0).toString();
            Object kh = bangHoaDon.getValueAt(rows, 1);
            String maKH = Objects.toString(kh, "");
            String thoigian = bangHoaDon.getValueAt(rows, 2).toString();
            String ThanhTien = bangHoaDon.getValueAt(rows, 3).toString();
        }
    }//GEN-LAST:event_bangHoaDonMouseClicked

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        DecimalFormat df = new DecimalFormat("#,###");
        String text = search.getText();
        dtm.setRowCount(0);
        for(HoaDon a:lsb.getLSB()){
            String formatTong = df.format(a.getThanhTien());
            if(String.valueOf(a.getMaHoaDon()).toLowerCase().contains(text) || String.valueOf(a.getMaKH()).toLowerCase().contains(text) ||String.valueOf(us.getTenUserByID(a.getTenUser())).toLowerCase().contains(text) || formatTong.contains(text)){
                dtm.addRow(new Object[]{a.getMaHoaDon(),a.getMaKH(),us.getTenUserByID(a.getTenUser()),a.getThoiGian(),formatTong});
            }
        }
    }//GEN-LAST:event_btn_checkActionPerformed

    private void GiacbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiacbActionPerformed
        if (Giacb.getSelectedItem() == null) {
            return;
        }
        String selected = Giacb.getSelectedItem().toString().trim();
        if (selected.equals("--Select Giá--")) {
            DecimalFormat df = new DecimalFormat("#,###");
            dtm.setRowCount(0);
            for (HoaDon hd : lsb.getLSB()) {
                String formatTien = df.format(hd.getThanhTien());
                dtm.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKH(),us.getTenUserByID(hd.getTenUser()), hd.getThoiGian(), formatTien});
            }
            return;
        }
        ArrayList<HoaDon> dshd = new ArrayList(lsb.getLSB());
        if (selected.equals("Tăng dần")) {
            dshd.sort(Comparator.comparingDouble(HoaDon::getThanhTien));
        } else if (selected.equals("Giảm dần")) {
            dshd.sort(Comparator.comparingDouble(HoaDon::getThanhTien).reversed());
        }
        DecimalFormat df = new DecimalFormat("#,###");
        dtm.setRowCount(0);
        for (HoaDon hd : dshd) {
            String formatTien = df.format(hd.getThanhTien());
            dtm.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKH(),us.getTenUserByID(hd.getTenUser()), hd.getThoiGian(), formatTien});
        }
    }//GEN-LAST:event_GiacbActionPerformed

    private void btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetActionPerformed
        DecimalFormat df = new DecimalFormat("#,###");
        dtm.setRowCount(0);
        for (HoaDon hd : lsb.getLSB()) {
            String formatTien = df.format(hd.getThanhTien());
            dtm.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKH(),us.getTenUserByID(hd.getTenUser()), hd.getThoiGian(), formatTien});
        }
    }//GEN-LAST:event_btn_ResetActionPerformed

    private void label_chiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_chiTietMouseClicked
        int row = bangHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để xem chi tiết!");
            return;
        }
        String maHD = dtm.getValueAt(row, 0).toString();
        CTHOADONDiaLog dialog = new CTHOADONDiaLog((Frame) SwingUtilities.getWindowAncestor(this), true, maHD);
        dialog.setVisible(true);
    }//GEN-LAST:event_label_chiTietMouseClicked

    private void label_pdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_pdfMouseClicked
        int row = bangHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "vui lòng chọn hóa đơn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            XuatHoaDonBan export = new XuatHoaDonBan();
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xuất hóa đơn không?");
            if (confirm == JOptionPane.YES_OPTION) {
                export.XuatPDFBan((String) bangHoaDon.getValueAt(row, 0));
            } else {
                return;
            }
        }
    }//GEN-LAST:event_label_pdfMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Giacb;
    private javax.swing.JTable bangHoaDon;
    private javax.swing.JButton btn_Reset;
    private javax.swing.JButton btn_check;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_chiTiet;
    private javax.swing.JLabel label_pdf;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
