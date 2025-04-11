/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.quanlinhansu;

import DAO.ChamCongDAO;
import DAO.NhanVienDAO;
import DTO.ChamCongDTO;
import DTO.NhanVienDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class ChamCongPanel extends javax.swing.JPanel {
    private Func_class func = new Func_class();
    private ArrayList<ChamCongDTO> listChamCong;
    private ArrayList<NhanVienDTO> listNV;
    private ArrayList<ChamCongDTO> listChamCongFilter=new ArrayList<>();
    private JPanel jpanel_title;
    private JPanel jpanel_chiTietNoiDung;
    private HashMap<String,Integer> mapNV;
    public ChamCongPanel() {
        initComponents();
        setUpPanelThongTinChamCong();
        setIcon();
        setUpTable();
    }
    public JTable getTableChamCong(){
        return this.table_chamCong;
    }
    public void setUpPanelThongTinChamCong() {
        jpanel_chiTietChamCong.setLayout(new BorderLayout());
        jpanel_chiTietChamCong.setPreferredSize(new Dimension(600, 100));

        // Tiêu đề
        jpanel_title = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_title = new JLabel("THÔNG TIN CHI TIẾT");
        label_title.setFont(new Font("Arial", Font.BOLD, 14));
        jpanel_title.add(label_title);
        jpanel_chiTietChamCong.add(jpanel_title, BorderLayout.NORTH);

        // Panel chi tiết nội dung (khởi tạo rỗng)
        jpanel_chiTietNoiDung = new JPanel();
        jpanel_chiTietNoiDung.setLayout(new GridLayout(0, 4, 5, 5));
        jpanel_chiTietNoiDung.setBackground(new Color(230, 230, 235));
        jpanel_chiTietChamCong.add(jpanel_chiTietNoiDung, BorderLayout.CENTER);
    }
    public void setUpTable(){
        listChamCong=new ChamCongDAO().listChamCong();
        func.loadDataChamCong(listChamCong,table_chamCong);
        func.centerTable(table_chamCong);
        func.setUpTable(table_chamCong);
    }
    public void setIcon(){
        jlabel_look.setIcon(new FlatSVGIcon("./resources/icon/find.svg",0.35f));
        btn_them_chamCong.setIcon(new FlatSVGIcon("./resources/icon/add.svg",0.3f));
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_chamCong = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jpanel_chiTietChamCong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_them_chamCong = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jlabel_look = new javax.swing.JLabel();
        jtf_find = new javax.swing.JTextField();

        table_chamCong.setModel(new javax.swing.table.DefaultTableModel(
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
        table_chamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_chamCongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_chamCong);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("DANH SÁCH BẢNG CHẤM CÔNG");

        jpanel_chiTietChamCong.setBackground(new java.awt.Color(230, 230, 235));

        javax.swing.GroupLayout jpanel_chiTietChamCongLayout = new javax.swing.GroupLayout(jpanel_chiTietChamCong);
        jpanel_chiTietChamCong.setLayout(jpanel_chiTietChamCongLayout);
        jpanel_chiTietChamCongLayout.setHorizontalGroup(
            jpanel_chiTietChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanel_chiTietChamCongLayout.setVerticalGroup(
            jpanel_chiTietChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_them_chamCong.setText("Thêm Chấm Công");
        btn_them_chamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_them_chamCongMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(211, 217, 211));

        jlabel_look.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_lookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_find, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_look, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_find, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_them_chamCong)
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them_chamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jpanel_chiTietChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanel_chiTietChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table_chamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_chamCongMouseClicked
        int vitriRow = table_chamCong.getSelectedRow();
        if (vitriRow != -1) {
            int maBCC = Integer.parseInt(table_chamCong.getValueAt(vitriRow, 0).toString());
            ChamCongDTO cc = new ChamCongDAO().getChamCongTheoMaBCC(maBCC);

            // Làm sạch panel nội dung cũ
            jpanel_chiTietNoiDung.removeAll();

            // Tách nội dung chi tiết theo ngày
            String chiTiet = cc.getChiTiet(); // VD: "09/04/2025: Đi trễ 10/04/2025: Tăng ca ..."
            String[] arrChiTiet = chiTiet.split("(?=\\d{2}/\\d{2}/\\d{4})");

            for (String ct : arrChiTiet) {
                if (!ct.trim().isEmpty()) {
                    JLabel lbl = new JLabel(ct.trim());
                    lbl.setFont(new Font("Arial", Font.PLAIN, 12));
                    jpanel_chiTietNoiDung.add(lbl);
                }
            }

            // Cập nhật lại giao diện
            jpanel_chiTietNoiDung.revalidate();
            jpanel_chiTietNoiDung.repaint();
        }
    }//GEN-LAST:event_table_chamCongMouseClicked

    private void btn_them_chamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_them_chamCongMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddChamCongDialog((Frame) parentWindow,true,this).setVisible(true);
    }//GEN-LAST:event_btn_them_chamCongMouseClicked

    private void jlabel_lookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_lookMouseClicked
        String text = jtf_find.getText().toLowerCase();
        listChamCong = new ChamCongDAO().listChamCong();
        listNV = new NhanVienDAO().listNV();
        listChamCongFilter.clear();
        for (ChamCongDTO chamcong : listChamCong) {
            String maBCC = String.valueOf(chamcong.getMaBCC()).toLowerCase();
            int maNV = chamcong.getMaNV();
            String maNVStr = String.valueOf(maNV).toLowerCase();
            String tenNV = null;
            for (int i = 0; i < listNV.size(); i++) {
                if (maNV == listNV.get(i).getMaNV()) {
                    tenNV = listNV.get(i).getHoTen().toLowerCase();
                }
            }
            String thang = String.valueOf(chamcong.getThangChamCong()).toLowerCase();
            String nam = String.valueOf(chamcong.getNamChamCong()).toLowerCase();
            String soNgayLamViec = String.valueOf(chamcong.getSoNgayLamViec()).toLowerCase();
            String soGioTangCa = String.valueOf(chamcong.getSoGioLamThem()).toLowerCase();
            String soNgayNghi = String.valueOf(chamcong.getSoNgayNghi()).toLowerCase();
            String soNgayDiTre = String.valueOf(chamcong.getSoNgayTre()).toLowerCase();
            if ((thang + "/" + nam).contains(text) || (maNVStr + "-" + tenNV).contains(text) || soGioTangCa.contains(text) || soNgayDiTre.contains(text) || soNgayLamViec.contains(text) || soNgayNghi.contains(text) || maBCC.contains(text)) {
                listChamCongFilter.add(chamcong);
            }
        }

        func.loadDataChamCong(listChamCongFilter, table_chamCong);
        func.centerTable(table_chamCong);
    }//GEN-LAST:event_jlabel_lookMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_them_chamCong;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel_look;
    private javax.swing.JPanel jpanel_chiTietChamCong;
    private javax.swing.JTextField jtf_find;
    private javax.swing.JTable table_chamCong;
    // End of variables declaration//GEN-END:variables
}
