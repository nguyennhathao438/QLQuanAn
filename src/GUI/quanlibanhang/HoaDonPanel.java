package GUI.quanlibanhang;

import DAO.QuanHangDAO;
import DAO.USerDAO1;
import DAO.UserDAO;
import DTO.DSKhach;
import DTO.HoaDon;
import DTO.LICHSUBAN;
import DTO.User;
import DTO.khachDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import export_file.XuatHoaDonBan;
import java.awt.Color;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

public class HoaDonPanel extends javax.swing.JPanel {
    Func_class fc = new Func_class();
    QuanHangDAO qh = new QuanHangDAO();
    LICHSUBAN lsb = new LICHSUBAN();
    DefaultTableModel dtm = new DefaultTableModel();
    UserDAO us = new UserDAO();
    USerDAO1 us1=new USerDAO1();
    public HoaDonPanel() {
        initComponents();
        bangHoaDon.setModel(dtm);
        khoiTao();
        fc.setUpTable(bangHoaDon,jScrollPane1);
        fc.centerTable(bangHoaDon);
    }
    public void khoiTao() {
        setData();
        design();
        setTextHidden();
        fillComBoBox();
        fillCBBKH();
        fillCBBUser();
        dateChooserTu.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    filterHoaDon();
                }
            }
        });

        dateChooserDen.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    filterHoaDon();
                }
            }
        });
    }

    public void fillComBoBox() {
        fc.setUpComBoBox(jComboBox1);
        String[] cbbs = {"Tất cả", "Tên khách hàng", "Tên USER","Thời gian"};
        for (String item : cbbs) {
            jComboBox1.addItem(item);
        }
    }
    public void design(){
        btn_check.setIcon(new FlatSVGIcon("./resources/icon/look.svg",0.6f));
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
        Giacb.addItem("Tất cả");
        Giacb.addItem("Tăng dần");
        Giacb.addItem("Giảm dần");
        Giacb.setSelectedIndex(0);
        lsb = new LICHSUBAN();
        qh.LayHDBH(lsb);
        dtm.setRowCount(0);
        if(dtm.getColumnCount() == 0){
            dtm.addColumn("Mã HĐ");
            dtm.addColumn("Tên khách hàng");
            dtm.addColumn("Tên User");
            dtm.addColumn("Thời gian");
            dtm.addColumn("Tổng Tiền");
        }
        for(HoaDon a:lsb.getLSB()){
            String formatTongtien = df.format(a.getThanhTien());
            dtm.addRow(new Object[]{a.getMaHoaDon(),a.getMaKH(),us.getTenUserByID(a.getTenUser()),a.getThoiGian(),formatTongtien});
        }
        bangHoaDon.getColumnModel().getColumn(0).setPreferredWidth(25);
        bangHoaDon.getColumnModel().getColumn(1).setPreferredWidth(150);
        bangHoaDon.getColumnModel().getColumn(2).setPreferredWidth(150);
        bangHoaDon.getColumnModel().getColumn(3).setPreferredWidth(35);
    }
    public void fillCBBKH() {
        fc.setUpComBoBox(cbb_KH);
        DSKhach dsk1 = new DSKhach();
        qh.LayKH(dsk1);
        DSKhach dsk2 = new DSKhach(dsk1);
        cbb_KH.addItem("Tất cả");
        ArrayList<khachDTO> listhKH = dsk2.getDSK();
        for (khachDTO kh : listhKH) {
            cbb_KH.addItem(kh.getTenkhach());
        }
    }
    public void fillCBBUser(){
        cbb_user.addItem("Tất cả");
        fc.setUpComBoBox(cbb_user);
        List<User> listhUser = us1.getAllUsers();
        for (User u : listhUser) {
            cbb_user.addItem(u.getTen());
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
        btn_check = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        cbb_KH = new javax.swing.JComboBox<>();
        cbb_user = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateChooserTu = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dateChooserDen = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        Giacb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        label_chiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_chiTietMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText(" Chi tiết");

        label_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_pdfMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("Xuất PDF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_chiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_pdf, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(label_chiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
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

        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Tìm kiếm theo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, 152, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_check, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_check, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
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

        jPanel3.setBackground(new java.awt.Color(243, 243, 243));

        cbb_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_KHActionPerformed(evt);
            }
        });

        cbb_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_userActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Người tạo đơn");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Từ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Đến");

        Giacb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Giacb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiacbActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Giá");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbb_KH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbb_user, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooserTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooserDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Giacb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(cbb_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserTu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserDen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Giacb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void bangHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangHoaDonMouseClicked

    }//GEN-LAST:event_bangHoaDonMouseClicked

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        DecimalFormat df = new DecimalFormat("#,###");
        String choose_cbb = jComboBox1.getSelectedItem().toString();
        String text = search.getText().toLowerCase();
        dtm.setRowCount(0);
        for (HoaDon a : lsb.getLSB()) {
            String formatTong = df.format(a.getThanhTien());
            if (choose_cbb.equals("Tất cả")) {
                if (String.valueOf(a.getMaHoaDon()).toLowerCase().contains(text) || String.valueOf(a.getMaKH()).toLowerCase().contains(text) || String.valueOf(us.getTenUserByID(a.getTenUser())).toLowerCase().contains(text) || formatTong.contains(text)) {
                    dtm.addRow(new Object[]{a.getMaHoaDon(), a.getMaKH(), us.getTenUserByID(a.getTenUser()), a.getThoiGian(), formatTong});
                }
            } else if (choose_cbb.equals("Tên khách hàng")) {
                if (String.valueOf(a.getMaKH()).toLowerCase().contains(text)) {
                    dtm.addRow(new Object[]{a.getMaHoaDon(), a.getMaKH(), us.getTenUserByID(a.getTenUser()), a.getThoiGian(), formatTong});
                }
            } else if (choose_cbb.equals("Tên USER")) {
                if (String.valueOf(us.getTenUserByID(a.getTenUser())).toLowerCase().contains(text)) {
                    dtm.addRow(new Object[]{a.getMaHoaDon(), a.getMaKH(), us.getTenUserByID(a.getTenUser()), a.getThoiGian(), formatTong});
                }
            } else {
                if (String.valueOf(a.getThoiGian()  ).toLowerCase().contains(text)) {
                    dtm.addRow(new Object[]{a.getMaHoaDon(), a.getMaKH(), us.getTenUserByID(a.getTenUser()), a.getThoiGian(), formatTong});
                }
            }
        }
    }//GEN-LAST:event_btn_checkActionPerformed

    private void GiacbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiacbActionPerformed
//        if (Giacb.getSelectedItem() == null) {
//            return;
//        }
//        String selected = Giacb.getSelectedItem().toString().trim();
//        if (selected.equals("SẮP XẾP GIÁ")) {
//            DecimalFormat df = new DecimalFormat("#,###");
//            dtm.setRowCount(0);
//            for (HoaDon hd : lsb.getLSB()) {
//                String formatTien = df.format(hd.getThanhTien());
//                dtm.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKH(),us.getTenUserByID(hd.getTenUser()), hd.getThoiGian(), formatTien});
//            }
//            return;
//        }
//        ArrayList<HoaDon> dshd = new ArrayList(lsb.getLSB());
//        if (selected.equals("Tăng dần")) {
//            dshd.sort(Comparator.comparingDouble(HoaDon::getThanhTien));
//        } else if (selected.equals("Giảm dần")) {
//            dshd.sort(Comparator.comparingDouble(HoaDon::getThanhTien).reversed());
//        }
//        DecimalFormat df = new DecimalFormat("#,###");
//        dtm.setRowCount(0);
//        for (HoaDon hd : dshd) {
//            String formatTien = df.format(hd.getThanhTien());
//            dtm.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKH(),us.getTenUserByID(hd.getTenUser()), hd.getThoiGian(), formatTien});
//        }
        filterHoaDon();
    }//GEN-LAST:event_GiacbActionPerformed

    private void btn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetActionPerformed
        search.setText("");
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
        String tenKH;
        Object kh = bangHoaDon.getValueAt(row, 1);
        if(kh==null)
            tenKH = null ; 
        else
            tenKH = kh.toString();
        String nguoiTaoDon = bangHoaDon.getValueAt(row, 2).toString();
        String thoiGian = String.valueOf(bangHoaDon.getValueAt(row, 3).toString());
        CTHOADONDiaLog dialog = new CTHOADONDiaLog((Frame) SwingUtilities.getWindowAncestor(this), true, maHD,tenKH,nguoiTaoDon,thoiGian);
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
    private void filterHoaDon() {
        String selectedKH = cbb_KH.getSelectedItem() != null ? cbb_KH.getSelectedItem().toString() : "Tất cả";
        String selectedUser = cbb_user.getSelectedItem() != null ? cbb_user.getSelectedItem().toString() : "Tất cả";
        String selectedSort = Giacb.getSelectedItem() != null ? Giacb.getSelectedItem().toString().trim() : "Tất cả";

        DecimalFormat df = new DecimalFormat("#,###");
        dtm.setRowCount(0);

        Date tuNgay = dateChooserTu.getDate();
        Date denNgay = dateChooserDen.getDate();

        boolean useDateFilter = (tuNgay != null && denNgay != null);

        // Danh sách tạm để lọc
        ArrayList<HoaDon> filteredList = new ArrayList<>();

        for (HoaDon hd : lsb.getLSB()) {
            String tenKH = hd.getMaKH();
            String tenUser = us.getTenUserByID(hd.getTenUser());

            boolean matchKH = selectedKH.equals("Tất cả") || tenKH.equals(selectedKH);
            boolean matchUser = selectedUser.equals("Tất cả") || tenUser.equals(selectedUser);
            boolean matchDate = true;

            if (useDateFilter) {
                Date ngayHD = hd.getThoiGian();
                if (ngayHD.before(tuNgay) || ngayHD.after(denNgay)) {
                    matchDate = false;
                }
            }

            if (matchKH && matchUser && matchDate) {
                filteredList.add(hd);
            }
        }

        // Sắp xếp nếu cần
        if (selectedSort.equals("Tăng dần")) {
            filteredList.sort(Comparator.comparingDouble(HoaDon::getThanhTien));
        } else if (selectedSort.equals("Giảm dần")) {
            filteredList.sort(Comparator.comparingDouble(HoaDon::getThanhTien).reversed());
        }

        // Đổ dữ liệu vào bảng
        for (HoaDon hd : filteredList) {
            String formatTien = df.format(hd.getThanhTien());
            dtm.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKH(), us.getTenUserByID(hd.getTenUser()), hd.getThoiGian(), formatTien});
        }
    }

    private void cbb_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_KHActionPerformed
        filterHoaDon();
    }//GEN-LAST:event_cbb_KHActionPerformed

    private void cbb_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_userActionPerformed
        filterHoaDon();
    }//GEN-LAST:event_cbb_userActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Giacb;
    private javax.swing.JTable bangHoaDon;
    private javax.swing.JButton btn_Reset;
    private javax.swing.JButton btn_check;
    private javax.swing.JComboBox<String> cbb_KH;
    private javax.swing.JComboBox<String> cbb_user;
    private com.toedter.calendar.JDateChooser dateChooserDen;
    private com.toedter.calendar.JDateChooser dateChooserTu;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_chiTiet;
    private javax.swing.JLabel label_pdf;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
