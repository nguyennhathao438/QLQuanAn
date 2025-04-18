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
        setIcon();
        setUpJPanelChucNang();
        setUpTable();
        setCursorPointer();
        setTextHidden();
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find_congViec);
        PromptSupport.setForeground(Color.GRAY, jtf_find_congViec);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find_congViec);
    }
    public JTable getTableCongViec(){
        return table_cv;
    }
    public void setUpJPanelChucNang(){
        jpanel_chucNang1.setBorder(new DropShadowBorder(1,Color.BLACK));
        jpanel_chucNang2.setBorder(new DropShadowBorder(1,Color.BLACK));
    }
    public void setIcon(){
        jlabel_look_congViec.setIcon(new FlatSVGIcon("./resources/icon/find.svg",0.35f));
        jlabel_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.41f));
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
        func.cursorPointer(jlabel_refresh);
        func.cursorPointer(jlabel_look_congViec);
    }
    public void setUpTable(){
        resetTableCongViec();
        func.setUpTable(table_cv);
    }
    public void loadDataCongViec(ArrayList<CongViecDTO> list){
        String[] colNames={"Mã công việc","Tên công việc","Lương cơ bản","Phụ cấp","Hệ số lương"};
        Object[][] rows=new Object[list.size()][colNames.length];
        for(int i=0;i<list.size();i++){
            rows[i][0]=list.get(i).getMaCV();
            rows[i][1]=list.get(i).getTenCV();
            rows[i][2]=String.format("%,.0f",list.get(i).getLuongCoBan());
            rows[i][3]=String.format("%,.0f",list.get(i).getPhuCap());
            rows[i][4]=list.get(i).getHeSoLuong();
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table_cv.setModel(model);
    }
    public void resetTableCongViec(){
        loadDataCongViec(cvDao.listCV());
        func.centerTable(table_cv);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        jPanel3 = new javax.swing.JPanel();
        jtf_find_congViec = new javax.swing.JTextField();
        jlabel_look_congViec = new javax.swing.JLabel();
        jlabel_refresh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Công Việc");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(341, 341, 341))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

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

        jLabel3.setText(" Thêm");

        jLabel4.setText("    Sửa");

        jLabel5.setText("    Xóa");

        jlabel_chiTietCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTietCVMouseClicked(evt);
            }
        });

        jLabel8.setText(" Chi tiết");

        javax.swing.GroupLayout jpanel_chucNang1Layout = new javax.swing.GroupLayout(jpanel_chucNang1);
        jpanel_chucNang1.setLayout(jpanel_chucNang1Layout);
        jpanel_chucNang1Layout.setHorizontalGroup(
            jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                        .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlabel_chiTietCV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpanel_chucNang1Layout.setVerticalGroup(
            jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jlabel_chiTietCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(211, 217, 211));

        jlabel_look_congViec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_look_congViecMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_find_congViec, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look_congViec, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_find_congViec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_look_congViec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jlabel_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_refreshMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Làm mới");

        javax.swing.GroupLayout jpanel_chucNang2Layout = new javax.swing.GroupLayout(jpanel_chucNang2);
        jpanel_chucNang2.setLayout(jpanel_chucNang2Layout);
        jpanel_chucNang2Layout.setHorizontalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(16, 16, 16))
        );
        jpanel_chucNang2Layout.setVerticalGroup(
            jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpanel_chucNang2Layout.createSequentialGroup()
                        .addComponent(jlabel_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanel_chucNang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_chucNang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jlabel_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_refreshMouseClicked
        jtf_find_congViec.setText("");
        resetTableCongViec();
    }//GEN-LAST:event_jlabel_refreshMouseClicked

    private void jlabel_look_congViecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_congViecMouseClicked
        String text = jtf_find_congViec.getText().toLowerCase();
        listCVFilter.clear();
        for (CongViecDTO cv : cvDao.listCV()) {
            String maCV = String.valueOf(cv.getMaCV());
            String tenCV = cv.getTenCV().toLowerCase();
            String luongCoBan = String.valueOf(cv.getLuongCoBan()).toLowerCase();
            String phuCap = String.valueOf(cv.getPhuCap()).toLowerCase();
            String heSoLuong = String.valueOf(cv.getHeSoLuong()).toLowerCase();
            if (maCV.contains(text) || tenCV.contains(text) || luongCoBan.contains(text) || phuCap.contains(text) || heSoLuong.contains(text)) {
                listCVFilter.add(cv);
            }
        }
        loadDataCongViec(listCVFilter);
        func.centerTable(table_cv);
    }//GEN-LAST:event_jlabel_look_congViecMouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_chiTietCV;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_look_congViec;
    private javax.swing.JLabel jlabel_refresh;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JPanel jpanel_chucNang1;
    private javax.swing.JPanel jpanel_chucNang2;
    private javax.swing.JTextField jtf_find_congViec;
    private javax.swing.JTable table_cv;
    // End of variables declaration//GEN-END:variables
}
