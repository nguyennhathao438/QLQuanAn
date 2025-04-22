/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.quanlibanhang;

import DAO.QuanHangDAO;
import DAO.QuanKhoDAO;
import DTO.BanManager;
import DTO.DSMonAn;
import DTO.DSMonAnBan;
import DTO.MONAN;
import DTO.MonAnBan;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

/**
 *
 * @author phant
 */
public class ThucDonDiaLog extends javax.swing.JDialog {
    Func_class fc = new Func_class();
    QuanKhoDAO qk = new QuanKhoDAO();
    QuanHangDAO qh = new QuanHangDAO();
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
//        setTable();
        bangMenu.setModel(dtm);
        bangCTMenu.setModel(dtmCT);
        setData();
        LoadBanCTMenu();
        setTextHidden();
        setIcon();
        fc.setUpTable(bangMenu);
        fc.centerTable(bangMenu);
        fc.setUpTable(bangCTMenu);
        fc.centerTable(bangCTMenu);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Nhập số lượng", jTextField1);
        PromptSupport.setForeground(Color.GRAY, jTextField1);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextField1);
    }
    public void setIcon(){
        btn_luuMA.setIcon(new FlatSVGIcon("./resources/icon/basket.svg",0.05f));
        addMA.setIcon(new FlatSVGIcon("./resources/icon/cart.svg",0.05f));
        deleteMA.setIcon(new FlatSVGIcon("./resources/icon/delete.svg",0.55f));
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
        addMA = new javax.swing.JButton();
        deleteMA = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangMenu = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_luuMA = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

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

        jLabel1.setText("Tên món:");

        jLabel3.setText("Loại món:");

        addMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMAActionPerformed(evt);
            }
        });

        deleteMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMAActionPerformed(evt);
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

        jLabel6.setText("Menu");

        jLabel7.setText("Chi tiết Menu");

        jLabel8.setText("Giá:");

        jLabel4.setText("Số lượng:");

        jLabel10.setText("Thành tiền:");

        btn_luuMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuMAActionPerformed(evt);
            }
        });

        jLabel12.setText("Thêm");

        jLabel13.setText("Xác nhận");

        jLabel14.setText("Xóa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_luuMA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(20, 20, 20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(addMA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(deleteMA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addMA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteMA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_luuMA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
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
            jLabel2.setText(tenmon);
            jLabel5.setText(loaimon);
            jLabel9.setText(gia);
        }
    }//GEN-LAST:event_bangMenuMouseClicked

    public int checksanpham(){
        int selectedRow = bangMenu.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn món ăn để thêm vào","Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập số lượng để thêm","Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }
    private void addMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMAActionPerformed
        int result = checksanpham();
        int selectedrows = bangMenu.getSelectedRow();
        if(result == 1){
            if(Integer.parseInt(jTextField1.getText()) > (int) bangMenu.getValueAt(selectedrows, 4)){ 
                JOptionPane.showMessageDialog(this, "Số lượng không thể lớn hơn hiện có");
                return ;
            }
            String maMA = bangMenu.getValueAt(selectedrows, 0).toString();
            String tenMA = bangMenu.getValueAt(selectedrows, 1).toString();
            double gia = Double.parseDouble(bangMenu.getValueAt(selectedrows, 3).toString());
            int soluong;
            boolean found = false;
            try{
                soluong = Integer.parseInt(jTextField1.getText().trim());
                if(soluong < 0){
                    JOptionPane.showMessageDialog(null, "So luong khong hop le","Errol",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException n){
                JOptionPane.showMessageDialog(null,"Vui long nhap so","Errol",JOptionPane.ERROR_MESSAGE);
                return;
            }
            for(MonAnBan a:dsmab.getDSMAB()){
                if(a.getMaMA().equals(maMA)){
                    a.setSoluong(a.getSoluong()+ soluong);
                    a.getThanhtien();
                    found = true;
                    break;
                }
            }
            if(!found){
            MonAnBan mab = new MonAnBan(maMA, tenMA, soluong, gia);
            dsmab.themMA(mab);
            }
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
        MonAnBan mab=new MonAnBan();
        mab.setMaMA((String) bangMenu.getValueAt(selectedrows,0));
        mab.setSoluong(Integer.parseInt(jTextField1.getText()));
        qh.themCTHDBH(mab,String.valueOf(soban));
        qk.layMonAnDcBan(dsma);
        setData();
        
    }//GEN-LAST:event_addMAActionPerformed

    private void bangCTMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangCTMenuMouseClicked
        int rows = bangCTMenu.getSelectedRow();
        if(rows != -1){
            String tenmon = bangCTMenu.getValueAt(rows, 1).toString();
            String soluong = bangCTMenu.getValueAt(rows, 2).toString();
            String gia = bangCTMenu.getValueAt(rows, 3).toString();
            String thanhtien = bangCTMenu.getValueAt(rows, 4).toString();
            // gan dl vao jlabel
            jLabel2.setText(tenmon);
            jTextField1.setText(soluong);
            jLabel9.setText(gia);
            jLabel11.setText(thanhtien);
        }
    }//GEN-LAST:event_bangCTMenuMouseClicked

    private void deleteMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMAActionPerformed
        int rows = bangCTMenu.getSelectedRow();
        int result = XoacheckCTMN();
        if(result == 1){
            String maMA = bangCTMenu.getValueAt(rows, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(null,"Ban co chac chan xoa mon an nay", "Xoa Mon An", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
            boolean kt = false;
            for(MonAnBan a:dsmab.getDSMAB()){
                if(a.getMaMA().equals(maMA)){
                   dsmab.xoaMA(a);
                   kt = true;
                   break;
                }
            }
            // cap nhat lai bang sau khi xoa
            dtmCT.setRowCount(0);
            for(MonAnBan a:dsmab.getDSMAB()){
                dtmCT.addRow(new Object[]{a.getMaMA(),a.getTenMA(),a.getSoluong(),a.getGia(),a.getThanhtien()});
                }
            }
        }
    }//GEN-LAST:event_deleteMAActionPerformed

    private void btn_luuMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuMAActionPerformed
        if(dsmab.getDSMAB().isEmpty()){
            JOptionPane.showMessageDialog(null,"Chưa có món nào được thêm","Errol", JOptionPane.ERROR_MESSAGE);
            return;
        }

        isOrdered = true;
        
        JOptionPane.showMessageDialog(null, "Lưu món thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        BanManager.taoDon(soban);
        dispose();
    }//GEN-LAST:event_btn_luuMAActionPerformed
    @Override
    public void dispose(){
        super.dispose();
        if(dsmab.getDSMAB().isEmpty()){
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
    private javax.swing.JButton addMA;
    private javax.swing.JTable bangCTMenu;
    private javax.swing.JTable bangMenu;
    private javax.swing.JButton btn_luuMA;
    private javax.swing.JButton deleteMA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
