/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.quankho;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DTO.CTHOADONNH;
import DTO.DSNCC;
import DTO.DSNguyenLieu;
import DTO.HOADONNHAPHANG;
import DAO.QuanKhoDAO;
import DAO.UserDAO;
import DTO.LICHSUNH;
import DTO.NGUYENLIEU;
import DTO.NHACUNGCAP;
import DTO.NLNhap;
import java.awt.Color;
import java.awt.Font;
import util.Func_class;

/**
 *
 * @author ADMIN
 */
public class HDNHDialog extends javax.swing.JDialog {
DefaultListModel<NHACUNGCAP> dlm=new DefaultListModel();
    QuanKhoDAO kn=new QuanKhoDAO();
    LICHSUNH dshd = new LICHSUNH();
    QKHDNHJPanel quankhoPanel;
    DSNCC dsncc ;
    DSNguyenLieu dsnl ;
    LICHSUNH lsnh;
    DefaultTableModel dtm =new DefaultTableModel();
    String dsmaNL[] =new String[100];
    ArrayList<NLNhap> dsnlnhap=new ArrayList();
    int index=0;
    Func_class func=new Func_class();
    public HDNHDialog(java.awt.Frame parent, boolean modal,QKHDNHJPanel quankhoPanel) {
        super(parent, modal);
        initComponents();
        this.quankhoPanel=quankhoPanel;
        dsncc = new DSNCC();
        lsnh = new LICHSUNH();
        kn.layNCC(dsncc);
        kn.layHDNH(lsnh);
        for (NHACUNGCAP a : dsncc.getDSNCC()) {
            tenNCC.addItem(a.getTenNCC());
        }
        khoiTao();
        this.setTitle("Nhập hàng");
        setLocationRelativeTo(null);
    }
    public void khoiTao(){
        setUpTable();
        design();
    }
    public void setUpTable(){
        setData();
        func.centerTable(bangNL);
        func.setUpTable(bangNL);
    }
    public void design(){
       func.setUpBtnTwo(addNL, Color.GREEN, Color.GREEN, Color.WHITE, 14);
       func.setUpBtnTwo(clear, Color.ORANGE, Color.ORANGE, Color.WHITE, 14);
       func.setUpBtnTwo(confirm, Color.CYAN, Color.CYAN, Color.WHITE, 14);
       func.setUpComBoBox(tenNCC);
       func.notAllowText(gia);
       func.notAllowText(soLuong);
    }
    public void setData() {
        dsnl = new DSNguyenLieu();
        kn.layNL(dsnl);
        dtm.setRowCount(0);
        if (dtm.getColumnCount() == 0) {
            dtm.addColumn("Mã NL");
            dtm.addColumn("Loại NL");
            dtm.addColumn("Tên TL");

        }
        for (NGUYENLIEU nl : dsnl.getDSNL()) {
            if (nl.getTrangThai() != 0) {
                dtm.addRow(new Object[]{nl.getMaNL(), kn.layTenLoaiNL(nl.getMaLoaiNL()), nl.getTenNL()});
            }
        }

        bangNL.setModel(dtm);
    }

    public void setTextArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hoá đơn nhập hàng").append("\n\n");
        sb.append(String.format("%-5s %-15s %-7s %-10s\n", "STT", "Tên NL", "SL", "Giá thành"));
        sb.append("--------------------------------------------------------\n");
        int i = 0;
        for (NLNhap a : dsnlnhap) {
            sb.append(String.format("%-5d %-15s %-7.1f %-10.1f\n",
                    i + 1, a.getMaNL(), a.getSoLuong(), a.getGia()));
            i++;
        }
        hdnh.setFont(new Font("Monospaced", Font.PLAIN, 13));

        hdnh.setText(sb.toString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gia = new javax.swing.JTextField();
        tenNL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        soLuong = new javax.swing.JTextField();
        hansudung = new com.toedter.calendar.JDateChooser();
        tenNCC = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        addNL = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangNL = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        hdnh = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo Hoá Đơn"));

        jLabel1.setText("Số Lượng");

        jLabel2.setText("Ngày Hết Hạn");

        jLabel3.setText("Giá Thành");

        jLabel4.setText("Chọn nhà cung cấp");

        jLabel5.setText("Tên Nguyên Liệu");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(hansudung, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(tenNL))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(gia, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soLuong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hansudung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addNL.setText("Thêm");
        addNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNLActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        confirm.setText("Xác Nhận");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(addNL, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
        bangNL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangNLMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangNL);

        hdnh.setColumns(20);
        hdnh.setRows(5);
        jScrollPane3.setViewportView(hdnh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNLActionPerformed
        if(!kiemTra()){
            return;
        }
        int row=bangNL.getSelectedRow();
        boolean kt=false;int i;
        for( i=0;i<index;i++){ 
            if(bangNL.getValueAt(row, 0).equals(dsmaNL[i])){ 
                kt=true;
                break;
            }
        }
        if(kt==false){
            NLNhap nln=new NLNhap();
            nln.setGia(Double.valueOf(gia.getText()));
            SimpleDateFormat format = new SimpleDateFormat("d/M/y");
            Date hsd = hansudung.getDate();
            nln.setHsd(hsd);
                    nln.setSoLuong(Float.parseFloat(soLuong.getText()));
                    nln.setMaNL(tenNL.getText());
                    dsnlnhap.add(nln);
                    dsmaNL[index]=(String) bangNL.getValueAt(row, 0);
                    index++;
        }else{ 
            float sLuong=dsnlnhap.get(i).getSoLuong();
            sLuong+=Float.parseFloat(soLuong.getText());
            NLNhap nln=dsnlnhap.get(i);
            nln.setSoLuong(sLuong);
            dsnlnhap.set(i, nln);           
        }
        setTextArea();
        tenNL.setText("");
        soLuong.setText("");
        gia.setText("");
        hansudung.setDate(null);
    }//GEN-LAST:event_addNLActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        dsnlnhap.clear();
        for(int i=0;i<index;i++)
        dsmaNL[i]="";
        index=0;
        setTextArea();
    }//GEN-LAST:event_clearActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        if(index == 0){
            JOptionPane.showMessageDialog(rootPane, "Vui long them nguyen lieu");
            return ;
        }
        UserDAO us = new UserDAO();
        CTHOADONNH cthd=new CTHOADONNH();
        cthd.setDsnlnhap(dsnlnhap);
        cthd.setMangLam(us.getIDUserLogin());
        String mahoadon=layMaHD();
        cthd.setMaHDNH(mahoadon);
        Date ngay =new Date();
        cthd.setNgayNhap(ngay);
        String ten=(String) tenNCC.getSelectedItem();
        kn.themHDNH(cthd, changeTentoMaNCC(ten), dsmaNL);
        kn.layHDNH(dshd);
        quankhoPanel.setData(dshd.getLSNH());
        func.centerTable(quankhoPanel.getTable());
        this.dispose();
    }//GEN-LAST:event_confirmActionPerformed

    private void bangNLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangNLMouseClicked
        int row =bangNL.getSelectedRow();
        tenNL.setText((String) bangNL.getValueAt(row, 2));
    }//GEN-LAST:event_bangNLMouseClicked

    
    private String layMaHD(){ 
        kn.layHDNH(lsnh);
        String prefix="HDNH";
        int temp=0;
        for(HOADONNHAPHANG a:lsnh.getLSNH()){
            System.out.println(a.getMaHDNH());
            String maHD=a.getMaHDNH();
            if (maHD.startsWith(prefix) && maHD.length() > 4){
            int number=Integer.parseInt(maHD.substring(4));
            if(number>temp){ 
                temp=number;
            }
            }
        }
        temp++;
        return String.format("%s%03d",prefix,temp);       
    }
    private String changeTentoMaNCC(String ten){ 
        for(NHACUNGCAP a: dsncc.getDSNCC()){ 
            if(ten.equals(a.getTenNCC()))
                return a.getMaNCC();
        }
        return "";
    }
    private boolean kiemTra(){ 
        int row=bangNL.getSelectedRow();
        if(row == -1){ 
            JOptionPane.showMessageDialog(this, "Vui long click vao nguyen lieu");
            return false;
        }else{ 
            if(gia.getText() == ""){ 
               JOptionPane.showMessageDialog(this, "Vui long nhap gia");
               return false;
            }  
            if(hansudung.getDate() == null){ 
                JOptionPane.showMessageDialog(this, "Vui long nhap ngay het han");
               return false;
            }
            Date today= new Date();
            
            if(!hansudung.getDate().after(today)){ 
                JOptionPane.showMessageDialog(this, "Hạn sử dụng phải sau ngày hiện tại");
               return false;
            }
            if(soLuong.getText() == ""){ 
                JOptionPane.showMessageDialog(this, "Vui long nhap so luong");
               return false;
            }
            
            if(!kt(gia.getText())){ 
                JOptionPane.showMessageDialog(this, "Gia khong hop le");
               return false;
            }
            if(!kt(soLuong.getText())){ 
                JOptionPane.showMessageDialog(this, "So luong khong hop le");
               return false;
            }
        }
        return true;
    }
    private boolean kt(String str){ 
        String regex = "^[+-]?([0-9]*[.])?[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(!matcher.matches()){ 
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNL;
    private javax.swing.JTable bangNL;
    private javax.swing.JButton clear;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField gia;
    private com.toedter.calendar.JDateChooser hansudung;
    private javax.swing.JTextArea hdnh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField soLuong;
    private javax.swing.JComboBox<String> tenNCC;
    private javax.swing.JTextField tenNL;
    // End of variables declaration//GEN-END:variables
}
