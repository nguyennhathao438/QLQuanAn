/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.quankho;

import DTO.LICHSUNH;
import DAO.QuanKhoDAO;
import DAO.UserDAO;
import DTO.HOADONNHAPHANG;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import export_file.XuatPhieuNhap;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import util.Func_class;

public class QKHDNHJPanel extends javax.swing.JPanel {

    QuanKhoDAO kn = new QuanKhoDAO();
    LICHSUNH dshd = new LICHSUNH();
    UserDAO us = new UserDAO();
    ArrayList<HOADONNHAPHANG> lsnh = dshd.getLSNH();
    Func_class func = new Func_class();
    DefaultTableModel dtm = new DefaultTableModel();

    public QKHDNHJPanel() {
        kn.layHDNH(dshd);
        initComponents();
        bangLSHDNH.setModel(dtm);
        setData(dshd.getLSNH());
        design();
        setupTable();
    }

    public JTable getTable() {
        return this.bangLSHDNH;
    }

    public void setupTable() {
        func.centerTable(bangLSHDNH);
        func.setUpTable(bangLSHDNH,jScrollPane1);
    }

    public void design() {
        label_nhaphang.setIcon(new FlatSVGIcon("./resources/icon/giohang.svg", 0.45f));
        jlabel_details.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        jlabel_xuathoadon.setIcon(new FlatSVGIcon("./resources/icon/xuathoadon.svg", 0.45f));
        func.cursorPointer(label_nhaphang);
        func.cursorPointer(jlabel_details);
        func.cursorPointer(jlabel_xuathoadon);
        func.setUpComBoBox(FilterCombo);
    }

    public void setData(ArrayList<HOADONNHAPHANG> lsnh) {
        DecimalFormat df = new DecimalFormat("#,###");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Tạo model mới
        DefaultTableModel newModel = new DefaultTableModel();
        newModel.addColumn("Mã hoá đơn");
        newModel.addColumn("Nhà cung cấp");
        newModel.addColumn("Tài khoản");
        newModel.addColumn("Ngày Nhập");
        newModel.addColumn("Giá ");

        for (HOADONNHAPHANG a : lsnh) {
            if (a != null) {
                String formattedGia = df.format(a.getThanhTien());
                String formattedDate = sdf.format(a.getNgayNhap());
                newModel.addRow(new Object[]{
                    a.getMaHDNH(),
                    a.getTenNCC(),
                    us.getTenUserByID(a.getMangLam()),
                    formattedDate,
                    formattedGia
                });
            }
        }

        // Gán model mới vào bảng
        bangLSHDNH.setModel(newModel);
        // Nếu bạn cần sử dụng dtm tiếp, gán lại nó:
        dtm = newModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_nhaphang = new javax.swing.JLabel();
        jlabel_details = new javax.swing.JLabel();
        jlabel_xuathoadon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TimeFrom = new com.toedter.calendar.JDateChooser();
        ThangButton = new javax.swing.JCheckBox();
        TimeTo = new com.toedter.calendar.JDateChooser();
        QuyButton = new javax.swing.JCheckBox();
        FromText = new javax.swing.JLabel();
        ToText = new javax.swing.JLabel();
        ThongkeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangLSHDNH = new javax.swing.JTable();
        FilterCombo = new javax.swing.JComboBox<>();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Nhập hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Xem chi tiết");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Xuất hoá đơn");

        label_nhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_nhaphangMouseClicked(evt);
            }
        });

        jlabel_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_detailsMouseClicked(evt);
            }
        });

        jlabel_xuathoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_xuathoadonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_nhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_details, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_xuathoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_nhaphang, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jlabel_xuathoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Chọn thời gian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongkeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(ThongkeButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        FilterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Giá: Thấp-Cao", "Giá: Cao-Thấp" }));
        FilterCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FilterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void label_nhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_nhaphangMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new HDNHDialog((Frame) parentWindow, true, this).setVisible(true);
    }//GEN-LAST:event_label_nhaphangMouseClicked

    private void jlabel_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_detailsMouseClicked
        int row = bangLSHDNH.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Click vào hoá đơn ");
        } else {
            String a = (String) bangLSHDNH.getValueAt(row, 0);
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
            new CTHDNHDialog((Frame) parentWindow, true, a).setVisible(true);
        }
    }//GEN-LAST:event_jlabel_detailsMouseClicked

    private void jlabel_xuathoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_xuathoadonMouseClicked
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
    }//GEN-LAST:event_jlabel_xuathoadonMouseClicked

    private JTextField txtQuy;
    private JTextField txtNam;
    private JPanel quyPanel;
    private ArrayList<HOADONNHAPHANG> current = lsnh;

//     private void FilterComboActionPerformed(java.awt.event.ActionEvent evt) {
//         String selected = (String) FilterCombo.getSelectedItem(); // Lấy mục được chọn
//         ArrayList<HOADONNHAPHANG> Filter = current;
//         // Gọi hàm lọc dữ liệu dựa theo lựa chọn
//         if (selected.equals("Tất cả")) {
// Collections.sort(Filter, Comparator.comparing(HOADONNHAPHANG::getMaHDNH));
// 
// 
//             setData(Filter);
    private void FilterComboActionPerformed(java.awt.event.ActionEvent evt) {
        String selected = (String) FilterCombo.getSelectedItem(); // Lấy mục được chọn
        ArrayList<HOADONNHAPHANG> Filter = current;
        if (selected.equals("Tất cả")) {
            bangLSHDNH.setModel(dtm);
            setData(dshd.getLSNH());
            setupTable();
        } else if (selected.equals("Giá: Thấp-Cao")) {
            Collections.sort(Filter, Comparator.comparingDouble(HOADONNHAPHANG::getThanhTien));
            bangLSHDNH.setModel(dtm);
            setData(Filter);
            setupTable();
        } else if (selected.equals("Giá: Cao-Thấp")) {
            Collections.sort(Filter, Comparator.comparingDouble(HOADONNHAPHANG::getThanhTien).reversed());
            bangLSHDNH.setModel(dtm);
            setData(Filter);
            setupTable();
        }
    }

    private void ThongkeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ThongkeButtonActionPerformed
        // TODO add your handling code here:
        if (!ThangButton.isSelected() && !QuyButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn kiểu thống kê: Tháng hoặc Quý.");
            return;
        } else if (isThangSelected) {
            java.util.Date utilDate = TimeFrom.getDate();
            java.util.Date toDate = TimeTo.getDate();
            if (utilDate == null && toDate == null) {
                current = lsnh;
            } else {
                Calendar calfrom = Calendar.getInstance();
                 calfrom.setTime(utilDate);
                 int ngayfrom = calfrom.get(Calendar.DAY_OF_MONTH);
                 int thangfrom = calfrom.get(Calendar.MONTH) + 1;
                 int namfrom = calfrom.get(Calendar.YEAR);
                 Calendar calto = Calendar.getInstance();
                 calto.setTime(toDate);
                 int thangto = calto.get(Calendar.MONTH) + 1;
                 int namto = calto.get(Calendar.YEAR);
                 int ngayto = calto.get(Calendar.DAY_OF_MONTH);
                 ArrayList<HOADONNHAPHANG> ls = thongKeTheoThang(ngayfrom,thangfrom, namfrom, ngayto, thangto, namto);
                current = ls;
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
            current = ls;

        }
        setData(current);
        setupTable();
    }// GEN-LAST:event_ThongkeButtonActionPerformed

    private boolean isThangSelected = false;
    private boolean isQuySelected = false;

    private void ThangButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ThangButtonActionPerformed
        isThangSelected = true;
        isQuySelected = false;

        if (ThangButton.isSelected()) {
            QuyButton.setSelected(false);

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

    private void QuyButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_QuyButtonActionPerformed
        isThangSelected = false;
        isQuySelected = true;
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
        quyPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        if (txtQuy == null) {
            txtQuy = new JTextField();
        }
        if (txtNam == null) {
            txtNam = new JTextField();
        }
        quyPanel.add(new JLabel("Nhập quý (1-4):"));
        quyPanel.add(txtQuy);
        quyPanel.add(new JLabel("Nhập năm:"));
        quyPanel.add(txtNam);
        int result = JOptionPane.showConfirmDialog(this, quyPanel, "Thống kê theo quý",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) {
            // Nếu người dùng bấm Cancel hoặc đóng dialog
            isQuySelected = false;
            ThangButton.setEnabled(true);
        }
    }// GEN-LAST:event_QuyButtonActionPerformed

    public ArrayList<HOADONNHAPHANG> thongKeTheoThang(int ngayfrom, int thangfrom, int namfrom, int ngayto, int thangto, int namto) {
        ArrayList<HOADONNHAPHANG> result = new ArrayList<>();
        for (HOADONNHAPHANG cthd : lsnh) {
            Date ngayNhap = new Date(cthd.getNgayNhap().getTime());
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngayNhap);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
            boolean inRange = false;
            if (year == namfrom && year == namto) {
                if (month == thangfrom && month == thangto) {
                    inRange = (day >= ngayfrom && day <= ngayto);
                } else if (month == thangfrom) {
                    inRange = (day >= ngayfrom);
                } else if (month == thangto) {
                    inRange = (day <= ngayto);
                } else {
                    inRange = (month > thangfrom && month < thangto);
                }
            } else if (year == namfrom) {
                if (month == thangfrom) {
                    inRange = (day >= ngayfrom);
                } else {
                    inRange = (month > thangfrom);
                }
            } else if (year == namto) {
                if (month == thangto) {
                    inRange = (day <= ngayto);
                } else {
                    inRange = (month < thangto);
                }
            } else {
                inRange = (year > namfrom && year < namto);
            }
            if (inRange) {
                result.add(cthd);
            }
        }
        return result;
    }

    public ArrayList<HOADONNHAPHANG> thongKeTheoQuy(int quy, int nam) {
        ArrayList<HOADONNHAPHANG> result = new ArrayList<>();

        for (HOADONNHAPHANG cthd : lsnh) {
            java.util.Date ngayNhap = new java.util.Date(cthd.getNgayNhap().getTime());
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngayNhap);
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
            boolean inRange = false;
            // So sánh năm và tháng theo quý
            if (year == nam) {
                if ((quy == 1 && month >= 1 && month <= 3)
                        || (quy == 2 && month >= 4 && month <= 6)
                        || (quy == 3 && month >= 7 && month <= 9)
                        || (quy == 4 && month >= 10 && month <= 12)) {
                    inRange = true;
                }
            }
            if (inRange) {
                result.add(cthd);
            }
        }

        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> FilterCombo;
    private javax.swing.JLabel FromText;
    private javax.swing.JCheckBox QuyButton;
    private javax.swing.JCheckBox ThangButton;
    private javax.swing.JButton ThongkeButton;
    private com.toedter.calendar.JDateChooser TimeFrom;
    private com.toedter.calendar.JDateChooser TimeTo;
    private javax.swing.JLabel ToText;
    private javax.swing.JTable bangLSHDNH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_details;
    private javax.swing.JLabel jlabel_xuathoadon;
    private javax.swing.JLabel label_nhaphang;
    // End of variables declaration//GEN-END:variables
}
