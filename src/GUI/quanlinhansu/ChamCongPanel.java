package GUI.quanlinhansu;

import DAO.ChamCongDAO;
import DAO.NhanVienDAO;
import DTO.ChamCongDTO;
import DTO.NhanVienDTO;
import GUI.quanlinhansu.AddChamCongDialog;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.DropShadowBorder;
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
        setIconForJLabel();
        setUpTable();
        BorderForJPanel();
        setFocusForButton();
        setCursorPointer();
        setTextHidden();
    }
    public void setCursorPointer(){
        func.cursorPointer(jlabel_look);
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
    public void BorderForJPanel(){
        jpanel_chucNang2.setBorder(new DropShadowBorder(1,Color.BLACK));
    }
    public void setIconForJLabel(){
        jlabel_look.setIcon(new FlatSVGIcon("./resources/icon/find.svg",0.25f));
        btn_them_chamCong.setIcon(new FlatSVGIcon("./resources/icon/add.svg",0.25f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.2f));
    }
    public void setUpPanelThongTinChamCong() {
        jpanel_chiTietChamCong.setLayout(new BorderLayout());
        jpanel_chiTietChamCong.setPreferredSize(new Dimension(600, 120));

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
        resetTableChamCong();
        func.setUpTable(table_chamCong);
    }
    public void loadDataChamCong(ArrayList<ChamCongDTO> listCC) {
        String[] colNames = {"Mã BCC", "Nhân viên", "Tháng Năm", "Ngày làm", "Ngày nghỉ", "Ngày trễ", "Số giờ tăng ca"};
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
        jLabel5 = new javax.swing.JLabel();
        jpanel_chiTietChamCong = new javax.swing.JPanel();
        jpanel_chucNang2 = new javax.swing.JPanel();
        btn_them_chamCong = new javax.swing.JButton();
        jtf_find = new javax.swing.JTextField();
        jlabel_look = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
            .addGap(0, 125, Short.MAX_VALUE)
        );

        btn_them_chamCong.setText("Chấm Công");
        btn_them_chamCong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_them_chamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_them_chamCongMouseClicked(evt);
            }
        });

        jlabel_look.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_lookMouseClicked(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang2Layout = new javax.swing.GroupLayout(jpanel_chucNang2);
        jpanel_chucNang2.setLayout(jpanel_chucNang2Layout);
        jpanel_chucNang2Layout.setHorizontalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                .addComponent(btn_them_chamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jpanel_chucNang2Layout.setVerticalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them_chamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanel_chucNang2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel_look, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpanel_chiTietChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jlabel_lookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_lookMouseClicked
        String text = jtf_find.getText().toLowerCase();
        listChamCongFilter.clear();
        for (ChamCongDTO chamcong : chamcongDao.listChamCong()) {
            String maBCC = String.valueOf(chamcong.getMaBCC()).toLowerCase();
            int maNV = chamcong.getMaNV();
            String maNVStr = String.valueOf(maNV).toLowerCase();
            String tenNV = null;
            for (NhanVienDTO nv: nvDao.listNV()) {
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
            if ((thang + "/" + nam).contains(text) || (maNVStr + "-" + tenNV).contains(text) || soGioTangCa.contains(text) || soNgayDiTre.contains(text) || soNgayLamViec.contains(text) || soNgayNghi.contains(text) || maBCC.contains(text)) {
                listChamCongFilter.add(chamcong);
            }
        }
        loadDataChamCong(listChamCongFilter);
        func.centerTable(table_chamCong);
    }//GEN-LAST:event_jlabel_lookMouseClicked

    private void btn_them_chamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_them_chamCongMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddChamCongDialog((Frame) parentWindow,true,this).setVisible(true);
    }//GEN-LAST:event_btn_them_chamCongMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        jtf_find.setText("");
        resetTableChamCong();
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_them_chamCong;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel_look;
    private javax.swing.JPanel jpanel_chiTietChamCong;
    private javax.swing.JPanel jpanel_chucNang2;
    private javax.swing.JTextField jtf_find;
    private javax.swing.JTable table_chamCong;
    // End of variables declaration//GEN-END:variables
}
