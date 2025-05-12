/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.quanlinhansu;

import DAO.CongViecDAO;
import DAO.NhanVienDAO;
import DTO.CongViecDTO;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class AddNhanVienDialog extends javax.swing.JDialog {
    NhanVienPanel nvPanel;
    Func_class func=new Func_class();
    HashMap<String,Integer> mapCV;
    NhanVienDAO nvDao=new NhanVienDAO();
    CongViecDAO cvDao=new CongViecDAO();
    public AddNhanVienDialog(java.awt.Frame parent, boolean modal,NhanVienPanel nvPanel) {
        super(parent, modal);
        this.nvPanel=nvPanel;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm mới nhân viên");
        khoiTao();
    }
    public void khoiTao(){
        khoiTaoButtuonGroup();
        khoiTaoComboboxCongViec();
        setUpEnable();
    }
    public void setUpEnable(){
        func.notAllowNumber(jtf_name_nv);
        func.notAllowText(jtf_sdt_nv);
    }
    public void khoiTaoButtuonGroup(){
        ButtonGroup btnGr=new ButtonGroup();
        btnGr.add(jradio_nam);
        btnGr.add(jradio_nu);
    }
    public void khoiTaoComboboxCongViec(){
        ArrayList<CongViecDTO> listCV = cvDao.listCV();
        func.setUpComBoBox(combobox_cv);
        for(CongViecDTO cv :listCV){
            combobox_cv.addItem(cv.getTenCV());
        }
    }
    public int check_add_nhanVien(){
        if(jtf_name_nv.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Bạn chưa nhập tên nhân viên","Error",0);
            return 0;
        }
        if(jtf_sdt_nv.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Bạn chưa nhập số điện thoại nhân viên","Error",0);
            return 0;
        }
        if(jdatechooser_ngaySinh.getDate()==null){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn ngày sinh","Error",0);
            return 0;
        }
        if(!jradio_nam.isSelected()&&!jradio_nu.isSelected()){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn giới tính","Error",0);
            return 0;
        }
        return 1;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_name_nv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_sdt_nv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_add_nv = new javax.swing.JButton();
        btn_exit_nv = new javax.swing.JButton();
        combobox_cv = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jradio_nam = new javax.swing.JRadioButton();
        jradio_nu = new javax.swing.JRadioButton();
        jdatechooser_ngaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Thêm Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        btn_add_nv.setBackground(new java.awt.Color(51, 255, 51));
        btn_add_nv.setText("Thêm");
        btn_add_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_nvMouseClicked(evt);
            }
        });

        btn_exit_nv.setBackground(new java.awt.Color(255, 0, 0));
        btn_exit_nv.setText("Hủy bỏ");
        btn_exit_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exit_nvMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Công việc");

        jradio_nam.setText("Nam");

        jradio_nu.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtf_name_nv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jradio_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jradio_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtf_sdt_nv, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addComponent(btn_add_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jdatechooser_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_exit_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(combobox_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_name_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_sdt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdatechooser_ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jradio_nu)
                    .addComponent(jradio_nam))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_nvMouseClicked
        if (check_add_nhanVien() == 1) {
            String tenNV = jtf_name_nv.getText();
            String sdt = jtf_sdt_nv.getText();
            if (sdt.length() != 10 || sdt.charAt(0) != '0') {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Error", 0);
                return;
            }
            mapCV = cvDao.mapCV();
            int maCV = mapCV.get(combobox_cv.getSelectedItem().toString());
            Date ngaySinh = jdatechooser_ngaySinh.getDate();
            java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinh.getTime());
            String gioiTinh = null;
            if (jradio_nam.isSelected()) {
                gioiTinh = jradio_nam.getText();
            } else {
                gioiTinh = jradio_nu.getText();
            }
            nvDao.insertNhanVien(new NhanVienDTO(tenNV, ngaySinhSQL, gioiTinh, sdt, maCV));
            nvPanel.setUpTable();
            this.dispose();
        }
    }//GEN-LAST:event_btn_add_nvMouseClicked

    private void btn_exit_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exit_nvMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exit_nvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_nv;
    private javax.swing.JButton btn_exit_nv;
    private javax.swing.JComboBox<String> combobox_cv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdatechooser_ngaySinh;
    private javax.swing.JRadioButton jradio_nam;
    private javax.swing.JRadioButton jradio_nu;
    private javax.swing.JTextField jtf_name_nv;
    private javax.swing.JTextField jtf_sdt_nv;
    // End of variables declaration//GEN-END:variables
}
