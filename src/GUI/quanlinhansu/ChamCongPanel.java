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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.Func_class;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author kiman
 */
public class ChamCongPanel extends javax.swing.JPanel {
    Func_class func = new Func_class();
    ChamCongDAO chamcongDao=new ChamCongDAO();
    NhanVienDAO nvDao=new NhanVienDAO();
    ArrayList<ChamCongDTO> listChamCongFilter=new ArrayList<>();
    JPanel jpanel_title;
    JPanel jpanel_chiTietNoiDung;
    public ChamCongPanel() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        setUpPanelThongTinChamCong();
        setUpJTF();
        setUpBtn();
        setIconForJLabel();
        setUpTable();
        setFocusForButton();
        setTextHidden();
        fillCbb();
    }
    public void fillCbb(){
        String[] months={"Tháng","Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        String[] years={"Năm","2020","2021","2022","2023","2024","2025","2026","2027"};
        func.setUpComBoBox(cbb_nam);
        func.setUpComBoBox(cbb_thang);
        for(String m : months)
            cbb_thang.addItem(m);
        for(String n : years)
            cbb_nam.addItem(n);
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_find);
    }
    public void setUpBtn(){
        func.setUpBtn(btn_refresh,Color.WHITE,new Color(220,220,220));
        func.setUpBtnTwo(btn_them_chamCong,Color.ORANGE,Color.ORANGE,Color.WHITE,14);
        func.setUpBtnTwo(btn_excel,Color.ORANGE,Color.ORANGE,Color.WHITE,14);
        func.setUpBtn(btn_look, Color.WHITE, new Color(220,220,220));
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find);
        PromptSupport.setForeground(Color.GRAY, jtf_find);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find);
    }
    public JTable getTableChamCong(){
        return this.table_chamCong;
    }
    public void setFocusForButton(){
        btn_them_chamCong.setFocusPainted(false);
        btn_refresh.setFocusPainted(false);
    }
    public void setIconForJLabel(){
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/look.svg",0.6f));
        btn_them_chamCong.setIcon(new FlatSVGIcon("./resources/icon/add.svg",0.25f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.25f));
        btn_excel.setIcon(new FlatSVGIcon("./resources/icon/export.svg",0.25f));
    }
    public void setUpPanelThongTinChamCong() {
        jpanel_chiTietChamCong.setLayout(new BorderLayout());
        jpanel_chiTietChamCong.setPreferredSize(new Dimension(600, 140));

        // Tiêu đề
        jpanel_title = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_title = new JLabel("THÔNG TIN CHI TIẾT");
        label_title.setFont(new Font("Arial", Font.BOLD, 15));
        jpanel_title.add(label_title);
        jpanel_chiTietChamCong.add(jpanel_title, BorderLayout.NORTH);

        // Panel chi tiết nội dung (khởi tạo rỗng)
        jpanel_chiTietNoiDung = new JPanel();
        jpanel_chiTietNoiDung.setLayout(new GridLayout(0, 4, 5, 5));
        jpanel_chiTietNoiDung.setBackground(new Color(230, 230, 235));
        jpanel_chiTietChamCong.add(jpanel_chiTietNoiDung, BorderLayout.CENTER);
    }
    public void setUpTable(){
        resetTableChamCong();
        func.setUpTable(table_chamCong,jScrollPane2);
    }
    public void loadDataChamCong(ArrayList<ChamCongDTO> listCC) {
        String[] colNames = {"Mã BCC","ID-Tên NV", "Tháng Năm", "Ngày làm", "Ngày nghỉ", "Ngày trễ", "Số giờ tăng ca"};
        Object[][] rows = new Object[listCC.size()][colNames.length];
        ArrayList<NhanVienDTO> listNV = nvDao.listNV();
        for (int i = 0; i < listCC.size(); i++) {
            rows[i][0] = listCC.get(i).getMaBCC();
            int maNV = listCC.get(i).getMaNV();
            String tenNV = null;
            for (int j = 0; j < listNV.size(); j++) {
                if (maNV == listNV.get(j).getMaNV()) {
                    tenNV = listNV.get(j).getHoTen();
                }
            }
            rows[i][1] = maNV + "-" + tenNV;
            rows[i][2] = listCC.get(i).getThangChamCong() + "/" + listCC.get(i).getNamChamCong();
            rows[i][3] = listCC.get(i).getSoNgayLamViec();
            rows[i][4] = listCC.get(i).getSoNgayNghi();
            rows[i][5] = listCC.get(i).getSoNgayTre();
            rows[i][6] = listCC.get(i).getSoGioLamThem();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_chamCong.setModel(model);
        table_chamCong.getColumnModel().getColumn(0).setPreferredWidth(45);
        table_chamCong.getColumnModel().getColumn(1).setPreferredWidth(150);
    }
    public void resetTableChamCong(){
        loadDataChamCong(chamcongDao.listChamCong());
        func.centerTable(table_chamCong);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_chamCong = new javax.swing.JTable();
        jpanel_chiTietChamCong = new javax.swing.JPanel();
        jpanel_chucNang2 = new javax.swing.JPanel();
        btn_them_chamCong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbb_nam = new javax.swing.JComboBox<>();
        cbb_thang = new javax.swing.JComboBox<>();
        jtf_find = new javax.swing.JTextField();
        btn_look = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        btn_excel = new javax.swing.JButton();

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

        jpanel_chiTietChamCong.setBackground(new java.awt.Color(230, 230, 235));

        javax.swing.GroupLayout jpanel_chiTietChamCongLayout = new javax.swing.GroupLayout(jpanel_chiTietChamCong);
        jpanel_chiTietChamCong.setLayout(jpanel_chiTietChamCongLayout);
        jpanel_chiTietChamCongLayout.setHorizontalGroup(
            jpanel_chiTietChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanel_chiTietChamCongLayout.setVerticalGroup(
            jpanel_chiTietChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        btn_them_chamCong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_them_chamCong.setText("Thêm");
        btn_them_chamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_them_chamCongMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Danh sách bảng chấm công");

        btn_look.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lookActionPerformed(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_excel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_excel.setText("Excel");
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang2Layout = new javax.swing.GroupLayout(jpanel_chucNang2);
        jpanel_chucNang2.setLayout(jpanel_chucNang2Layout);
        jpanel_chucNang2Layout.setHorizontalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
                        .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_them_chamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addComponent(cbb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpanel_chucNang2Layout.setVerticalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_them_chamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_excel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbb_thang, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtf_find, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_look, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbb_nam, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel_chiTietChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanel_chiTietChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        jtf_find.setText("");
        resetTableChamCong();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lookActionPerformed
        String text = jtf_find.getText().toLowerCase();
        String choose_nam = this.cbb_nam.getSelectedItem().toString();
        String choose_thang = this.cbb_thang.getSelectedItem().toString();
        listChamCongFilter.clear();
        if (choose_nam.equals("Năm") && choose_thang.equals("Tháng")) {
            for (ChamCongDTO chamcong : chamcongDao.listChamCong()) {
                String maBCC = String.valueOf(chamcong.getMaBCC()).toLowerCase();
                int maNV = chamcong.getMaNV();
                String maNVStr = String.valueOf(maNV).toLowerCase();
                String tenNV = null;
                for (NhanVienDTO nv : nvDao.listNV()) {
                    if (maNV == nv.getMaNV()) {
                        tenNV = nv.getHoTen().toLowerCase();
                    }
                }
                String thang = String.valueOf(chamcong.getThangChamCong()).toLowerCase();
                String nam = String.valueOf(chamcong.getNamChamCong()).toLowerCase();
                String soNgayLamViec = String.valueOf(chamcong.getSoNgayLamViec()).toLowerCase();
                String soGioTangCa = String.valueOf(chamcong.getSoGioLamThem()).toLowerCase();
                String soNgayNghi = String.valueOf(chamcong.getSoNgayNghi()).toLowerCase();
                String soNgayDiTre = String.valueOf(chamcong.getSoNgayTre()).toLowerCase();
                if ((thang + "-" + nam).contains(text) || (maNVStr + "-" + tenNV).contains(text) || soGioTangCa.contains(text) || soNgayDiTre.contains(text) || soNgayLamViec.contains(text) || soNgayNghi.contains(text) || maBCC.contains(text)) {
                    listChamCongFilter.add(chamcong);
                }
            }
        } else if (choose_nam.equals("Năm") && !choose_thang.equals("Tháng")) {
            String month = choose_thang.replaceAll("Tháng", "").trim();
            for (ChamCongDTO chamcong : chamcongDao.listChamCong()) {
                String maBCC = String.valueOf(chamcong.getMaBCC()).toLowerCase();
                int maNV = chamcong.getMaNV();
                String maNVStr = String.valueOf(maNV).toLowerCase();
                String tenNV = null;
                for (NhanVienDTO nv : nvDao.listNV()) {
                    if (maNV == nv.getMaNV()) {
                        tenNV = nv.getHoTen().toLowerCase();
                    }
                }
                String thang = String.valueOf(chamcong.getThangChamCong()).toLowerCase();
                String nam = String.valueOf(chamcong.getNamChamCong()).toLowerCase();
                String soNgayLamViec = String.valueOf(chamcong.getSoNgayLamViec()).toLowerCase();
                String soGioTangCa = String.valueOf(chamcong.getSoGioLamThem()).toLowerCase();
                String soNgayNghi = String.valueOf(chamcong.getSoNgayNghi()).toLowerCase();
                String soNgayDiTre = String.valueOf(chamcong.getSoNgayTre()).toLowerCase();
                if (((thang + "-" + nam).contains(text) || (maNVStr + "-" + tenNV).contains(text)
                        || soGioTangCa.contains(text) || soNgayDiTre.contains(text)
                        || soNgayLamViec.contains(text) || soNgayNghi.contains(text)
                        || maBCC.contains(text)) && thang.equals(month)) {
                    listChamCongFilter.add(chamcong);
                }
            }
        } else if (!choose_nam.equals("Năm") && choose_thang.equals("Tháng")) {
            String year = choose_nam.trim();
            for (ChamCongDTO chamcong : chamcongDao.listChamCong()) {
                String maBCC = String.valueOf(chamcong.getMaBCC()).toLowerCase();
                int maNV = chamcong.getMaNV();
                String maNVStr = String.valueOf(maNV).toLowerCase();
                String tenNV = null;
                for (NhanVienDTO nv : nvDao.listNV()) {
                    if (maNV == nv.getMaNV()) {
                        tenNV = nv.getHoTen().toLowerCase();
                    }
                }
                String thang = String.valueOf(chamcong.getThangChamCong()).toLowerCase();
                String nam = String.valueOf(chamcong.getNamChamCong()).toLowerCase();
                String soNgayLamViec = String.valueOf(chamcong.getSoNgayLamViec()).toLowerCase();
                String soGioTangCa = String.valueOf(chamcong.getSoGioLamThem()).toLowerCase();
                String soNgayNghi = String.valueOf(chamcong.getSoNgayNghi()).toLowerCase();
                String soNgayDiTre = String.valueOf(chamcong.getSoNgayTre()).toLowerCase();
                if (((thang + "-" + nam).contains(text) || (maNVStr + "-" + tenNV).contains(text)
                        || soGioTangCa.contains(text) || soNgayDiTre.contains(text)
                        || soNgayLamViec.contains(text) || soNgayNghi.contains(text)
                        || maBCC.contains(text)) && nam.equals(year)) {
                    listChamCongFilter.add(chamcong);
                }
            }
        } else {
            String month = choose_thang.replaceAll("Tháng", "").trim();
            String year = choose_nam.trim();
            for (ChamCongDTO chamcong : chamcongDao.listChamCong()) {
                String maBCC = String.valueOf(chamcong.getMaBCC()).toLowerCase();
                int maNV = chamcong.getMaNV();
                String maNVStr = String.valueOf(maNV).toLowerCase();
                String tenNV = null;
                for (NhanVienDTO nv : nvDao.listNV()) {
                    if (maNV == nv.getMaNV()) {
                        tenNV = nv.getHoTen().toLowerCase();
                    }
                }
                String thang = String.valueOf(chamcong.getThangChamCong()).toLowerCase();
                String nam = String.valueOf(chamcong.getNamChamCong()).toLowerCase();
                String soNgayLamViec = String.valueOf(chamcong.getSoNgayLamViec()).toLowerCase();
                String soGioTangCa = String.valueOf(chamcong.getSoGioLamThem()).toLowerCase();
                String soNgayNghi = String.valueOf(chamcong.getSoNgayNghi()).toLowerCase();
                String soNgayDiTre = String.valueOf(chamcong.getSoNgayTre()).toLowerCase();
                if (((thang + "-" + nam).contains(text) || (maNVStr + "-" + tenNV).contains(text)
                        || soGioTangCa.contains(text) || soNgayDiTre.contains(text)
                        || soNgayLamViec.contains(text) || soNgayNghi.contains(text)
                        || maBCC.contains(text)) && nam.equals(year) && thang.equals(month)) {
                    listChamCongFilter.add(chamcong);
                }
            }
        }
        loadDataChamCong(listChamCongFilter);
        func.centerTable(table_chamCong);
    }//GEN-LAST:event_btn_lookActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        try {
            func.exportJTableToExcel(table_chamCong);
        } catch (IOException ex) {
            Logger.getLogger(ChamCongPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_excelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_look;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_them_chamCong;
    private javax.swing.JComboBox<String> cbb_nam;
    private javax.swing.JComboBox<String> cbb_thang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanel_chiTietChamCong;
    private javax.swing.JPanel jpanel_chucNang2;
    private javax.swing.JTextField jtf_find;
    private javax.swing.JTable table_chamCong;
    // End of variables declaration//GEN-END:variables
}
