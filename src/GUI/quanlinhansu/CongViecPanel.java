/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.quanlinhansu;

import DAO.CongViecDAO;
import DTO.CongViecDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.DropShadowBorder;
import util.Func_class;


public class CongViecPanel extends javax.swing.JPanel {
    Func_class func=new Func_class();
    CongViecDAO cvDao=new CongViecDAO();
    ArrayList<CongViecDTO> listCVFilter = new ArrayList<>();
    public CongViecPanel() {
        initComponents();
        khoiTao();
    }
    public void khoiTao() {
        setIconJLabel();
        setUpJTF();
        setUpBtn();
        setUpTable();
        setCursorPointer();
        setTextHidden();
        fillComBoBOx();
    }
    public void fillComBoBOx(){
        String[] cbbs = {"Tất cả","Tên công việc","Lương cơ bản","Phụ cấp","Hệ số lương"};
        func.setUpComBoBox(cbb_choose);
        for(String item : cbbs){
            cbb_choose.addItem(item);
        }
    }
    public void setUpBtn(){
        func.setUpBtn(btn_lamMoi,Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_look,Color.WHITE,new Color(220,220,220));
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_find_congViec);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find_congViec);
        PromptSupport.setForeground(Color.GRAY, jtf_find_congViec);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find_congViec);
    }
    public JTable getTableCongViec(){
        return table_cv;
    }
    public void setIconJLabel(){
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/look.svg",0.6f));
        btn_lamMoi.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.25f));
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg",0.06f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg",0.85f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg",0.75f));
        jlabel_chiTietCV.setIcon(new FlatSVGIcon("./resources/icon/details.svg",0.45f));
    }
    public void setCursorPointer(){
        func.cursorPointer(jlabel_add);
        func.cursorPointer(jlabel_chiTietCV);
        func.cursorPointer(jlabel_delete);
        func.cursorPointer(jlabel_update);
    }
    public void setUpTable(){
        resetTableCongViec();
        func.setUpTable(table_cv,jScrollPane1);
    }
    public void loadDataCongViec(ArrayList<CongViecDTO> list) {
        String[] colNames = {"Mã công việc", "Tên công việc", "Lương cơ bản", "Phụ cấp", "Hệ số lương"};
        Object[][] rows = new Object[list.size()][colNames.length];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getMaCV();
            rows[i][1] = list.get(i).getTenCV();
            rows[i][2] = String.format("%,.0f", list.get(i).getLuongCoBan());
            rows[i][3] = String.format("%,.0f", list.get(i).getPhuCap());
            rows[i][4] = list.get(i).getHeSoLuong();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_cv.setModel(model);
        table_cv.getColumnModel().getColumn(0).setPreferredWidth(60);   // Mã công việc nhỏ lại
        table_cv.getColumnModel().getColumn(1).setPreferredWidth(200);  // Tên công việc dài ra
        table_cv.getColumnModel().getColumn(2).setPreferredWidth(120);  // Lương cơ bản
        table_cv.getColumnModel().getColumn(3).setPreferredWidth(100);  // Phụ cấp
        table_cv.getColumnModel().getColumn(4).setPreferredWidth(100);  // Hệ số lương
    }
    public void resetTableCongViec(){
        loadDataCongViec(cvDao.listCV());
        func.centerTable(table_cv);
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_cv = new javax.swing.JTable();
        jpanel_chucNang1 = new javax.swing.JPanel();
        jlabel_delete = new javax.swing.JLabel();
        jlabel_add = new javax.swing.JLabel();
        jlabel_update = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlabel_chiTietCV = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jpanel_chucNang2 = new javax.swing.JPanel();
        btn_lamMoi = new javax.swing.JButton();
        cbb_choose = new javax.swing.JComboBox<>();
        jtf_find_congViec = new javax.swing.JTextField();
        btn_look = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        table_cv.setModel(new javax.swing.table.DefaultTableModel(
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
        table_cv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_cv);

        jpanel_chucNang1.setBackground(new java.awt.Color(217, 217, 217));
        jpanel_chucNang1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jlabel_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_deleteMouseClicked(evt);
            }
        });

        jlabel_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_addMouseClicked(evt);
            }
        });

        jlabel_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_updateMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("  Thêm");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("    Sửa");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("   Xóa");

        jlabel_chiTietCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTietCVMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Chi tiết");

        javax.swing.GroupLayout jpanel_chucNang1Layout = new javax.swing.GroupLayout(jpanel_chucNang1);
        jpanel_chucNang1.setLayout(jpanel_chucNang1Layout);
        jpanel_chucNang1Layout.setHorizontalGroup(
            jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                        .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlabel_chiTietCV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jpanel_chucNang1Layout.setVerticalGroup(
            jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_chiTietCV, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanel_chucNang2.setBackground(new java.awt.Color(217, 217, 217));
        jpanel_chucNang2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        btn_lamMoi.setText("Làm mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        btn_look.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lookActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("Tìm kiếm theo");

        javax.swing.GroupLayout jpanel_chucNang2Layout = new javax.swing.GroupLayout(jpanel_chucNang2);
        jpanel_chucNang2.setLayout(jpanel_chucNang2Layout);
        jpanel_chucNang2Layout.setHorizontalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addComponent(cbb_choose, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_find_congViec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpanel_chucNang2Layout.setVerticalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbb_choose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_find_congViec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanel_chucNang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table_cvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cvMouseClicked

    }//GEN-LAST:event_table_cvMouseClicked

    private void jlabel_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_deleteMouseClicked
        int vitriRow = table_cv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn công việc để xóa", "Error", 0);
            return;
        }
        int maCV = Integer.parseInt(table_cv.getValueAt(vitriRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa", "Xóa công việc",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            cvDao.deleteCongViec(maCV);
            resetTableCongViec();
        }
    }//GEN-LAST:event_jlabel_deleteMouseClicked

    private void jlabel_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_addMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddCongViecDialog((Frame) parentWindow,true,this).setVisible(true);
    }//GEN-LAST:event_jlabel_addMouseClicked

    private void jlabel_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_updateMouseClicked
        int vitriRow=table_cv.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn công việc để chỉnh sửa","Error",0);
            return;
        }
        int maCV=Integer.parseInt(table_cv.getValueAt(vitriRow,0).toString());
        String tenCV=table_cv.getValueAt(vitriRow,1).toString();
        double luongCoBan=Double.parseDouble(table_cv.getValueAt(vitriRow,2).toString().replaceAll(",",""));
        double phuCap=Double.parseDouble(table_cv.getValueAt(vitriRow,3).toString().replaceAll(",",""));
        double heSoLuong=Double.parseDouble(table_cv.getValueAt(vitriRow,4).toString());
        CongViecDTO cv=new CongViecDTO(maCV,tenCV,luongCoBan,phuCap, heSoLuong);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditCongViecDialog((Frame) parentWindow,true,this,cv).setVisible(true);
    }//GEN-LAST:event_jlabel_updateMouseClicked

    private void jlabel_chiTietCVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTietCVMouseClicked
        int vitriRow=table_cv.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn công việc","Error",0);
            return;
        }
        int maCV=Integer.parseInt(table_cv.getValueAt(vitriRow,0).toString());
        String tenCV=table_cv.getValueAt(vitriRow,1).toString();
        double luongCoBan=Double.parseDouble(table_cv.getValueAt(vitriRow,2).toString().replaceAll(",",""));
        double phuCap=Double.parseDouble(table_cv.getValueAt(vitriRow,3).toString().replaceAll(",",""));
        double heSoLuong=Double.parseDouble(table_cv.getValueAt(vitriRow, 4).toString());
        CongViecDTO cv=new CongViecDTO(tenCV, luongCoBan, phuCap, heSoLuong);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsCongViecDialog((Frame) parentWindow,true,cv).setVisible(true);
    }//GEN-LAST:event_jlabel_chiTietCVMouseClicked

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        jtf_find_congViec.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lookActionPerformed
        String text = jtf_find_congViec.getText().toLowerCase();
        String cbb = cbb_choose.getSelectedItem().toString();
        listCVFilter.clear();
        for (CongViecDTO cv : cvDao.listCV()) {
            String maCV = String.valueOf(cv.getMaCV());
            String tenCV = cv.getTenCV().toLowerCase();
            String luongCoBan = String.format("%.1f",cv.getLuongCoBan()).toLowerCase();
            String phuCap = String.format("%.1f",cv.getPhuCap()).toLowerCase();
            String heSoLuong = String.valueOf(cv.getHeSoLuong()).toLowerCase();
            if (cbb.equals("Tất cả")) {
                if (maCV.contains(text) || tenCV.contains(text) || luongCoBan.contains(text) || phuCap.contains(text) || heSoLuong.contains(text)) {
                    listCVFilter.add(cv);
                }
            } else if (cbb.equals("Tên công việc")) {
                if (tenCV.contains(text)) {
                    listCVFilter.add(cv);
                }
            } else if (cbb.equals("Lương cơ bản")) {
                if (luongCoBan.contains(text)) {
                    listCVFilter.add(cv);
                }
            } else if (cbb.equals("Phụ cấp")) {
                if (phuCap.contains(text)) {
                    listCVFilter.add(cv);
                }
            } else if (cbb.equals("Hệ số lương")) {
                if (heSoLuong.contains(text)) {
                    listCVFilter.add(cv);
                }
            }
        }
        loadDataCongViec(listCVFilter);
        func.centerTable(table_cv);
    }//GEN-LAST:event_btn_lookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_look;
    private javax.swing.JComboBox<String> cbb_choose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_chiTietCV;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JPanel jpanel_chucNang1;
    private javax.swing.JPanel jpanel_chucNang2;
    private javax.swing.JTextField jtf_find_congViec;
    private javax.swing.JTable table_cv;
    // End of variables declaration//GEN-END:variables
}
