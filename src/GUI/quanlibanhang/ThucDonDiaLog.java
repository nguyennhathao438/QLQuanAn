/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.quanlibanhang;

import DAO.QuanHangDAO;
import DAO.QuanKhoDAO;
import DAO.UserDAO;
import DTO.BanManager;
import DTO.DSMonAn;
import DTO.DSMonAnBan;
import DTO.MONAN;
import DTO.MonAnBan;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import util.Func_class;

/**
 *
 * @author phant
 */
public class ThucDonDiaLog extends javax.swing.JDialog {
    Func_class fc = new Func_class();
    QuanKhoDAO qk = new QuanKhoDAO();
    QuanHangDAO qh = new QuanHangDAO();
    UserDAO us = new UserDAO();
    DSMonAn dsma;
    DSMonAnBan dsmab = new DSMonAnBan();
    DefaultTableModel dtm =new DefaultTableModel();
    DefaultTableModel dtmCT = new DefaultTableModel();
    private int soban;
    private boolean isOrdered = false;
    public ThucDonDiaLog(java.awt.Frame parent, boolean modal,int soban) {
        super(parent, modal);
        this.soban = soban;
        this.dsmab = BanManager.laydsmon(soban);
        initComponents();
        bangMenu.setModel(dtm);
        bangCTMenu.setModel(dtmCT);
        khoiTao();
        fc.setUpTable(bangMenu,jScrollPane3);
        fc.centerTable(bangMenu);
        fc.setUpTable(bangCTMenu,jScrollPane2);
        fc.centerTable(bangCTMenu);
        this.setTitle("Bán hàng");
        this.setLocationRelativeTo(null);
    }
    public void khoiTao(){
        setData();
        LoadBanCTMenu();
        setIcon();
        setUpBtn();
        setEdit();
        setSelectOneTable();
    }
    public void setSelectOneTable() {
        bangMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bangCTMenu.clearSelection(); // 👈 Clear bảng còn lại
            }
        });

        bangCTMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bangMenu.clearSelection(); // 👈 Clear bảng còn lại
            }
        });
    }
    public void setEdit(){
        jtf_loaiMon.setEditable(false);
        jtf_tenMon.setEditable(false);
        jtf_gia.setEditable(false);
        jTextField1.setEditable(false);
    }
    public void setIcon(){
        btn_luuMA.setIcon(new FlatSVGIcon("./resources/icon/basket.svg",0.035f));
        add.setIcon(new FlatSVGIcon("./resources/icon/cart.svg",0.03f));
    }
    public void setUpBtn(){
        fc.setUpBtnTwo(btn_luuMA, Color.ORANGE, Color.ORANGE,new Color(211,218,211),14);
        fc.setUpBtnTwo(add, Color.GREEN, Color.GREEN,new Color(211,218,211),14);
    }
    public void setTable(){
       //set độ rộng
       bangMenu.getColumnModel().getColumn(0).setPreferredWidth(50);
       bangMenu.getColumnModel().getColumn(1).setPreferredWidth(150);
       bangMenu.getColumnModel().getColumn(2).setPreferredWidth(100);
       bangMenu.getColumnModel().getColumn(3).setPreferredWidth(100);
       //Can giua
        DefaultTableCellRenderer center =new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i = 0 ; i < 6;i++){
            bangMenu.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        JTableHeader header = bangMenu.getTableHeader();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        header.setDefaultRenderer(headerRenderer);
    }
    public void setData(){
        dsma =new DSMonAn();
        qk.layMonAnDcBan(dsma);
        dtm.setRowCount(0);
        
        if(dtm.getColumnCount() == 0){
            dtm.addColumn("Mã món ăn");
            dtm.addColumn("Tên món ăn");
            dtm.addColumn("Loại món ăn");
            dtm.addColumn("Giá");
            dtm.addColumn("Có thể bán");
        }
        System.out.println(dsma.getN());
        for(MONAN a:dsma.getDSMA()) {
            if(a.getTrangThai() != 0) {
                dtm.addRow(new Object[]{a.getMaMA(),a.getTenMA(),a.getLoaiMA(),a.getGia(),a.getSoLuongConLai()});
            }
        }
    }
    public void LoadBanCTMenu(){
        dtmCT.setRowCount(0);
            if(dtmCT.getColumnCount() == 0){
            dtmCT.addColumn("Mã món ăn");
            dtmCT.addColumn("Tên món ăn");
            dtmCT.addColumn("Số lượng");
            dtmCT.addColumn("Giá");
            dtmCT.addColumn("Thành tiền");
        }
        for(MonAnBan a:dsmab.getDSMAB()) {
                dtmCT.addRow(new Object[]{a.getMaMA(),a.getTenMA(),a.getSoluong(),a.getGia(),a.getThanhtien()});
                }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        bangCTMenu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangMenu = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_soLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_luuMA = new javax.swing.JButton();
        jtf_loaiMon = new javax.swing.JTextField();
        jtf_tenMon = new javax.swing.JTextField();
        jtf_gia = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bangCTMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        bangCTMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangCTMenuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangCTMenu);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên món:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Loại món:");

        add.setText("Thêm");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        bangMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        bangMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangMenuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bangMenu);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("MENU");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Giá:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số lượng:");

        jtf_soLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_soLuongActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Thành tiền:");

        btn_luuMA.setText("Xác nhận");
        btn_luuMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuMAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_luuMA, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jtf_tenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jtf_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jtf_loaiMon, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_tenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_loaiMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtf_gia)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_luuMA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ktOrder(){
        BanManager.Capnhattt(soban, "Đang Dùng");
        isOrdered = true;
    }
    public int XoacheckCTMN(){
        int selectedRow = bangCTMenu.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn chi tiết menu món ăn để sửa","Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }
    
    private void bangMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangMenuMouseClicked
        int rows = bangMenu.getSelectedRow();
        if(rows != -1){
            String tenmon = bangMenu.getValueAt(rows, 1).toString();
            String loaimon = bangMenu.getValueAt(rows, 2).toString();
            String gia = bangMenu.getValueAt(rows, 3).toString();
            // gan dl vao jlabel
            jtf_loaiMon.setText(loaimon);
            jtf_tenMon.setText(tenmon);
            jtf_gia.setText(gia);
            jtf_soLuong.setText("");
            jTextField1.setText("");
        }
    }//GEN-LAST:event_bangMenuMouseClicked

    public int checksanpham() {
        if (jtf_soLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng để thêm", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int result = checksanpham();
        int selectedrows = bangMenu.getSelectedRow();
        if (selectedrows == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn món ăn để thêm ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (result == 1) {
            if (Integer.parseInt(jtf_soLuong.getText()) > (int) bangMenu.getValueAt(selectedrows, 4)) {
                JOptionPane.showMessageDialog(this, "Số lượng không thể lớn hơn hiện có");
                return;
            }
            String maMA = bangMenu.getValueAt(selectedrows, 0).toString();
            String tenMA = bangMenu.getValueAt(selectedrows, 1).toString();
            double gia = Double.parseDouble(bangMenu.getValueAt(selectedrows, 3).toString());
            int soluong;
            boolean found = false;
            try {
                soluong = Integer.parseInt(jtf_soLuong.getText().trim());
                if (soluong < 0) {
                    JOptionPane.showMessageDialog(null, "So luong khong hop le", "Errol", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Vui long nhap so", "Errol", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (MonAnBan a : dsmab.getDSMAB()) {
                if (a.getMaMA().equals(maMA)) {
                    a.setSoluong(a.getSoluong() + soluong);
                    a.getThanhtien();
                    found = true;
                    break;
                }
            }
            if (!found) {
                MonAnBan mab = new MonAnBan(maMA, tenMA, soluong, gia);
                dsmab.themMA(mab);
            }
            dtmCT.setRowCount(0);
            if (dtmCT.getColumnCount() == 0) {
                dtmCT.addColumn("Mã món ăn");
                dtmCT.addColumn("Tên món ăn");
                dtmCT.addColumn("Số lượng");
                dtmCT.addColumn("Giá");
                dtmCT.addColumn("Thành tiền");
            }
            for (MonAnBan a : dsmab.getDSMAB()) {
                dtmCT.addRow(new Object[]{a.getMaMA(), a.getTenMA(), a.getSoluong(), a.getGia(), a.getThanhtien()});
            }
        }
        MonAnBan mab = new MonAnBan();
        mab.setMaMA((String) bangMenu.getValueAt(selectedrows, 0));
        mab.setSoluong(Integer.parseInt(jtf_soLuong.getText()));
        qh.themCTHDBH(mab, String.valueOf(soban));
        qk.layMonAnDcBan(dsma);
        setData();
        jtf_loaiMon.setText("");
        jtf_tenMon.setText("");
        jtf_gia.setText("");
        jtf_soLuong.setText("");
    }//GEN-LAST:event_addActionPerformed

    private void bangCTMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangCTMenuMouseClicked
        int rows = bangCTMenu.getSelectedRow();
        if(rows != -1){
            String maMA = bangCTMenu.getValueAt(rows, 0).toString();
            String tenmon = bangCTMenu.getValueAt(rows, 1).toString();
            String soluong = bangCTMenu.getValueAt(rows, 2).toString();
            String gia = bangCTMenu.getValueAt(rows, 3).toString();
            String thanhtien = bangCTMenu.getValueAt(rows, 4).toString();
            String loaiMA = qk.getLoaiMAByMaMA(maMA);
            // gan dl vao jlabel
            jtf_soLuong.setText(soluong);
            jtf_loaiMon.setText(loaiMA);
            jtf_tenMon.setText(tenmon);
            jtf_gia.setText(gia);
            jTextField1.setText(thanhtien);
        }
    }//GEN-LAST:event_bangCTMenuMouseClicked

    private void btn_luuMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuMAActionPerformed
        if (dsmab.getDSMAB().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa có món nào được thêm", "Errol", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        isOrdered = true;
        
        JOptionPane.showMessageDialog(null, "Lưu món thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        BanManager.taoDon(soban);
        dispose();
    }//GEN-LAST:event_btn_luuMAActionPerformed

    private void jtf_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_soLuongActionPerformed
    @Override
    public void dispose() {
        super.dispose();
        if (dsmab.getDSMAB().isEmpty()) {
            BanManager.Capnhattt(soban, "Trống");
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int soban = 1;
                ThucDonDiaLog dialog = new ThucDonDiaLog(new javax.swing.JFrame(), true,soban);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTable bangCTMenu;
    private javax.swing.JTable bangMenu;
    private javax.swing.JButton btn_luuMA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtf_gia;
    private javax.swing.JTextField jtf_loaiMon;
    private javax.swing.JTextField jtf_soLuong;
    private javax.swing.JTextField jtf_tenMon;
    // End of variables declaration//GEN-END:variables
}
