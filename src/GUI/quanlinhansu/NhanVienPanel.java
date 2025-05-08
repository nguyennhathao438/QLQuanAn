/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.quanlinhansu;

import DAO.CongViecDAO;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.DropShadowBorder;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class NhanVienPanel extends javax.swing.JPanel {
    Func_class func=new Func_class();
    HashMap<String,Integer> mapCV;
    NhanVienDAO nvDao=new NhanVienDAO();
    CongViecDAO cvDao=new CongViecDAO();
    ArrayList<NhanVienDTO> listNVFilter=new ArrayList<>();
    public NhanVienPanel() {
        initComponents();
        khoiTao();
        
    }
    public void khoiTao() {
        setUpTable();
        setUpJTF();
        setUpButton();
        setUpBorderForJPanelChucNang();
        setIcon();
        setCursorPointer();
        setTextHidden();
    }
    public void setUpTable() {
        loadDataNV(nvDao.listNV());
        func.centerTable(table_nv);
        func.setUpTable(table_nv);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find_nv);
        PromptSupport.setForeground(Color.GRAY, jtf_find_nv);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find_nv);
    }
    public void setUpBorderForJPanelChucNang() {
        jpanel_chucNang1.setBorder(new DropShadowBorder(1, Color.BLACK));
        jpanel_chucNang2.setBorder(new DropShadowBorder(1, Color.black));
    }
    public void setUpButton(){
        func.setUpBtn(btn_lamMoi,Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_themVaiTro,Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_look, Color.WHITE, new Color(220,220,220));
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_find_nv);
    }
    public void setIcon() {
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg", 0.06f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_chiTiet_nv.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/find.svg", 0.35f));
        btn_lamMoi.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.3f));
        jlabel_xuat_excel.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg", 0.9f));
        btn_themVaiTro.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.25f));
    }
    public void setCursorPointer(){
        func.cursorPointer(jlabel_add);
        func.cursorPointer(jlabel_update);
        func.cursorPointer(jlabel_delete);
        func.cursorPointer(jlabel_chiTiet_nv);
        func.cursorPointer(jlabel_xuat_excel);
    }
    public JTable getTableNhanVien() {
        return this.table_nv;
    }
    public void loadDataNV(ArrayList<NhanVienDTO> list) {
        String[] colNames = {"Mã NV", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Công việc", "Tài khoản"};
        Object[][] rows = new Object[list.size()][colNames.length];
        mapCV = cvDao.mapCV();
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getMaNV();
            rows[i][1] = list.get(i).getHoTen();
            rows[i][2] = list.get(i).getNgaySinh();
            rows[i][3] = list.get(i).getGioiTinh();
            rows[i][4] = list.get(i).getSDT();
            int maCV = list.get(i).getmaCongViec();
            rows[i][5] = func.getKey(mapCV, maCV);
            if (list.get(i).getIdUser() != 0) {
                rows[i][6] = "Đã được cấp";
            } else {
                rows[i][6] = "null";
            }
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_nv.setModel(model);
        table_nv.getColumnModel().getColumn(0).setPreferredWidth(50);
        table_nv.getColumnModel().getColumn(1).setPreferredWidth(140);
        table_nv.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_nv.getColumnModel().getColumn(3).setPreferredWidth(80);
        table_nv.getColumnModel().getColumn(4).setPreferredWidth(100);
        table_nv.getColumnModel().getColumn(5).setPreferredWidth(150);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_nv = new javax.swing.JTable();
        jpanel_chucNang1 = new javax.swing.JPanel();
        jlabel_update = new javax.swing.JLabel();
        jlabel_add = new javax.swing.JLabel();
        jlabel_delete = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlabel_chiTiet_nv = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlabel_xuat_excel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jpanel_chucNang2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtf_find_nv = new javax.swing.JTextField();
        btn_look = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        btn_themVaiTro = new javax.swing.JButton();

        table_nv.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_nv);

        jlabel_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_updateMouseClicked(evt);
            }
        });

        jlabel_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_addMouseClicked(evt);
            }
        });

        jlabel_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_deleteMouseClicked(evt);
            }
        });

        jLabel3.setText("  Thêm");

        jLabel4.setText("    Sửa");

        jLabel5.setText("    Xóa");

        jlabel_chiTiet_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTiet_nvMouseClicked(evt);
            }
        });

        jLabel6.setText(" Chi tiết");

        jlabel_xuat_excel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_xuat_excelMouseClicked(evt);
            }
        });

        jLabel7.setText("Xuất Excel");

        javax.swing.GroupLayout jpanel_chucNang1Layout = new javax.swing.GroupLayout(jpanel_chucNang1);
        jpanel_chucNang1.setLayout(jpanel_chucNang1Layout);
        jpanel_chucNang1Layout.setHorizontalGroup(
            jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_chiTiet_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jlabel_xuat_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jpanel_chucNang1Layout.setVerticalGroup(
            jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_chiTiet_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                    .addComponent(jlabel_xuat_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(211, 217, 211));

        btn_look.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_look, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_find_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_lamMoi.setText("Làm mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang2Layout = new javax.swing.GroupLayout(jpanel_chucNang2);
        jpanel_chucNang2.setLayout(jpanel_chucNang2Layout);
        jpanel_chucNang2Layout.setHorizontalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jpanel_chucNang2Layout.setVerticalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btn_themVaiTro.setText("Cấp tài khoản");
        btn_themVaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themVaiTroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpanel_chucNang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_themVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_chucNang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_themVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_updateMouseClicked
        int vitriRow = table_nv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để chỉnh sửa", "Error", 0);
            return;
        }
        int maNV =Integer.parseInt(table_nv.getValueAt(vitriRow, 0).toString());
        String hoTen = table_nv.getValueAt(vitriRow, 1).toString();
        Date ngaySinh=(Date) table_nv.getValueAt(vitriRow,2);
        String gioiTinh = table_nv.getValueAt(vitriRow, 3).toString();
        String sdt = table_nv.getValueAt(vitriRow, 4).toString();
        String tenCV = table_nv.getValueAt(vitriRow, 5).toString();
        NhanVienDTO nv;
        mapCV = cvDao.mapCV();
        int maCV = mapCV.get(tenCV);
        nv = new NhanVienDTO(maNV, hoTen, ngaySinh, gioiTinh, sdt, maCV);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditNhanVienDialog((Frame) parentWindow, true, this,nv).setVisible(true);
    }//GEN-LAST:event_jlabel_updateMouseClicked

    private void jlabel_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_addMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddNhanVienDialog((Frame) parentWindow,true,this).setVisible(true);
    }//GEN-LAST:event_jlabel_addMouseClicked

    private void jlabel_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_deleteMouseClicked
        int vitriRow = table_nv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để chỉnh xóa", "Error", 0);
            return;
        }
        int maNV = Integer.parseInt(table_nv.getValueAt(vitriRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa", "Xóa nhân viên",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            nvDao.deleteNhanVien(maNV);
            setUpTable();
        }
    }//GEN-LAST:event_jlabel_deleteMouseClicked

    private void jlabel_chiTiet_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTiet_nvMouseClicked
        int vitriRow = table_nv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để xem chi tiết", "Error", 0);
            return;
        }
        int maNV = Integer.parseInt(table_nv.getValueAt(vitriRow, 0).toString());
        NhanVienDTO nv;
        nv = nvDao.getNhanVienByMaNV(maNV);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsNhanVienDialog((Frame) parentWindow, true, nv).setVisible(true);
    }//GEN-LAST:event_jlabel_chiTiet_nvMouseClicked

    private void jlabel_xuat_excelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_xuat_excelMouseClicked
        try {
            Func_class.exportJTableToExcel(table_nv);
        } catch (IOException ex) {
            Logger.getLogger(NhanVienPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlabel_xuat_excelMouseClicked

    private void btn_themVaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themVaiTroActionPerformed
        int vitriRow=table_nv.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhân viên để cấp tài khoản","Error",0);
            return;
        }
        String trangThaiCap=table_nv.getValueAt(vitriRow,6).toString();
        if(trangThaiCap.equals("Đã được cấp")){
            JOptionPane.showMessageDialog(null,"Nhân viên đã được cấp tài khoản","Error",0);
            return;
        }
        int maNV=Integer.parseInt(table_nv.getValueAt(vitriRow,0).toString());
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddRoleDialog((Frame) parentWindow,true,maNV,this).setVisible(true);
    }//GEN-LAST:event_btn_themVaiTroActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        jtf_find_nv.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lookActionPerformed
        String find_text = jtf_find_nv.getText().toLowerCase();
        listNVFilter.clear();
        mapCV = cvDao.mapCV();
        for (NhanVienDTO nv : nvDao.listNV()) {
            String maNV=String.valueOf(nv.getMaNV()).toLowerCase();
            String hoTen = nv.getHoTen().toLowerCase();
            String sdt = nv.getSDT().toLowerCase();
            String gioiTinh = nv.getGioiTinh().toLowerCase();
            String ngaySinh = String.valueOf(nv.getNgaySinh()).toLowerCase();
            int maCV = nv.getmaCongViec();
            String tenCV = func.getKey(mapCV, maCV);
            if (tenCV == null) {
                tenCV = "";
            } else {
                tenCV = tenCV.toLowerCase();
            }
            if (maNV.contains(find_text)||hoTen.contains(find_text) || sdt.contains(find_text) || gioiTinh.contains(find_text) || ngaySinh.contains(find_text) || tenCV.contains(find_text)) {
                listNVFilter.add(nv);
            }
        }
        loadDataNV(listNVFilter);
        func.centerTable(table_nv);
    }//GEN-LAST:event_btn_lookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_look;
    private javax.swing.JButton btn_themVaiTro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_chiTiet_nv;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JLabel jlabel_xuat_excel;
    private javax.swing.JPanel jpanel_chucNang1;
    private javax.swing.JPanel jpanel_chucNang2;
    private javax.swing.JTextField jtf_find_nv;
    private javax.swing.JTable table_nv;
    // End of variables declaration//GEN-END:variables
}
