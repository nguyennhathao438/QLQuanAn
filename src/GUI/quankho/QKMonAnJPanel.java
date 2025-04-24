 
package GUI.quankho;

import DTO.MONAN;
import DTO.DSMonAn;
import DAO.QuanKhoDAO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;



public class QKMonAnJPanel extends javax.swing.JPanel {
    QuanKhoDAO kn =new QuanKhoDAO();
    DSMonAn dsma;
    DefaultTableModel dtm =new DefaultTableModel();
    Func_class func=new Func_class();
    public QKMonAnJPanel() {
        initComponents();
        bangMA.setModel(dtm);
        bangMA.setComponentPopupMenu(pubangMA);
        setTextHidden();
        setData();
        setTable();
        locMA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        locMA.setBackground(new Color(230, 230, 250)); // màu nền nhạt
        locMA.setForeground(Color.DARK_GRAY); // màu chữ
        setIcon();
        setUp();
    }
    public void setUp(){
        func.setUpBtn(jButton6, Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_refresh, Color.WHITE,new Color(220,220,220));
        func.cursorPointer(jlabel_add);
        func.cursorPointer(jlabel_update);
        func.cursorPointer(jlabel_delete);
        func.cursorPointer(jlabel_lapCongThuc);
        func.setUpJTF(searchText);
    }
    public void setIcon(){
        jButton6.setIcon(new FlatSVGIcon("./resources/icon/find.svg",0.35f));
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg",0.06f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg",0.85f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg",0.75f));
        jlabel_lapCongThuc.setIcon(new FlatSVGIcon("./resources/icon/lapCongThuc.svg",0.45f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.25f));
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", searchText);
        PromptSupport.setForeground(Color.GRAY, searchText);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,searchText);
    }
    public void setTable() {
        bangMA.getColumnModel().getColumn(0).setPreferredWidth(50);
        bangMA.getColumnModel().getColumn(1).setPreferredWidth(100);
        bangMA.getColumnModel().getColumn(2).setPreferredWidth(130);
        bangMA.getColumnModel().getColumn(3).setPreferredWidth(200);
        bangMA.getColumnModel().getColumn(4).setPreferredWidth(100);
        //Can giua
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//Can giữa tẽt
        for (int i = 0; i < 6; i++) {
            bangMA.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        func.centerTable(bangMA);
        func.setUpTable(bangMA);
    }
    public void setData() {
        dsma = new DSMonAn();
        kn.layDSMonAn(dsma);
        dtm.setRowCount(0);
        if (dtm.getColumnCount() == 0) {
            dtm.addColumn("Mã");
            dtm.addColumn("Loại Món Ăn");
            dtm.addColumn("Tên Món Ăn");
            dtm.addColumn("Mô Tả");
            dtm.addColumn("Giá");
            dtm.addColumn("Trạng Thái");
        }
        for (MONAN a : dsma.getDSMA()) {
            if (a.getTrangThai() != 0) {
                dtm.addRow(new Object[]{a.getMaMA(), a.getLoaiMA(), a.getTenMA(), a.getMoTa(), a.getGia(), setTT(a.getTrangThai())});

            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pubangMA = new javax.swing.JPopupMenu();
        editMA = new javax.swing.JMenuItem();
        deleteMA = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlabel_add = new javax.swing.JLabel();
        jlabel_delete = new javax.swing.JLabel();
        jlabel_update = new javax.swing.JLabel();
        jlabel_lapCongThuc = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchText = new javax.swing.JTextField();
        locMA = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangMA = new javax.swing.JTable();

        editMA.setText("Sửa");
        editMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMAActionPerformed(evt);
            }
        });
        pubangMA.add(editMA);

        deleteMA.setText("Xoá");
        deleteMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMAActionPerformed(evt);
            }
        });
        pubangMA.add(deleteMA);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("   Thêm");

        jLabel2.setText("    Xoá");

        jLabel4.setText(" Sửa");

        jLabel5.setText("Lập công thức");

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

        jlabel_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_updateMouseClicked(evt);
            }
        });

        jlabel_lapCongThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_lapCongThucMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jlabel_lapCongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlabel_lapCongThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        searchText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        locMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không chọn", "Loại nguyên liệu", "Giá tăng dần", "Giá giảm dần" }));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(locMA, 0, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(locMA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bangMA.setModel(new javax.swing.table.DefaultTableModel(
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
        bangMA.setRowHeight(35);
        bangMA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bangMA.setShowGrid(false);
        jScrollPane1.setViewportView(bangMA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMAActionPerformed
        int row = bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this,"Click vào món ăn");
        }else{ 
            String a= (String) bangMA.getValueAt(row,0);
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new MonAnDiaLog((Frame) parentWindow,true,a,this).setVisible(true);
        }
    }//GEN-LAST:event_editMAActionPerformed

    private void deleteMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMAActionPerformed
        int row=bangMA.getSelectedRow();
        if(row == -1 ){ 
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        int confirm= JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa ? ");
        if(confirm == JOptionPane.YES_OPTION){ 
                String maMA=String.valueOf(bangMA.getValueAt(row, 0));
                
                kn.xoaMonAn(maMA);
                    setData();                
            }
    }//GEN-LAST:event_deleteMAActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String stext = searchText.getText().toLowerCase();
        boolean kt = false;
        DSMonAn dssearch = boLoc();
        dtm.setRowCount(0);
        for (MONAN a : dssearch.getDSMA()) {
            String gia=String.valueOf(a.getGia().toString().toLowerCase());
            if (a.getLoaiMA().toLowerCase().contains(stext)||gia.contains(stext)||a.getMoTa().toLowerCase().contains(stext)||(a.getTenMA().toLowerCase().contains(stext) || a.getMaMA().toLowerCase().contains(stext) && a.getTrangThai() != 0)) {
                dtm.addRow(new Object[]{a.getMaMA(), a.getLoaiMA(), a.getTenMA(), a.getMoTa(), a.getGia(), setTT(a.getTrangThai())});
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jlabel_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_addMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new MonAnDiaLog((Frame) parentWindow,true,this).setVisible(true);
    }//GEN-LAST:event_jlabel_addMouseClicked

    private void jlabel_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_deleteMouseClicked
        int row = bangMA.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa");
        if (confirm == JOptionPane.YES_OPTION) {
            String maMA = String.valueOf(bangMA.getValueAt(row, 0));
            kn.xoaMonAn(maMA);
            setData();
        }
    }//GEN-LAST:event_jlabel_deleteMouseClicked

    private void jlabel_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_updateMouseClicked
        int row = bangMA.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn món ăn");
        } else {
            String a = (String) bangMA.getValueAt(row, 0);
            System.out.println(a);
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
            new MonAnDiaLog((Frame) parentWindow, true, a, this).setVisible(true);
        }
    }//GEN-LAST:event_jlabel_updateMouseClicked

    private void jlabel_lapCongThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_lapCongThucMouseClicked
        int row = bangMA.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn món ăn ");
        } else {
            MONAN hao = new MONAN();
            String text = (String) bangMA.getValueAt(row, 0);
            for (MONAN ma : dsma.getDSMA()) {
                if (text.equals(ma.getMaMA())) {
                    hao = ma;
                    break;
                }
            }
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
            new ThanhPhanDialog((Frame) parentWindow, true, hao, setTTtoInt((String) bangMA.getValueAt(row, 5)), this).setVisible(true);
        }
    }//GEN-LAST:event_jlabel_lapCongThucMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        searchText.setText("");
        setData();
        func.centerTable(bangMA);
        func.setUpTable(bangMA);
    }//GEN-LAST:event_btn_refreshActionPerformed
    private String setTT(int n){ 
        if(n==1){ 
            return "Đã set tp";
        }
        return "Chưa set";
    }
    private int setTTtoInt(String str){ 
        if(str.equals("Đã set tp"))
            return 1;
        return 2;
    }
    private DSMonAn boLoc(){ 
        String text=(String) locMA.getSelectedItem();
        DSMonAn dscopy =new DSMonAn(dsma);
        int n=dscopy.getN();
        if(text.equals("Loại nguyên liệu")){ 
            for(int i=0;i<n-1;i++){ 
                for(int j=i+1;j<n;j++){ 
                    if(dscopy.getDSMA().get(i).getLoaiMA().compareTo(dscopy.getDSMA().get(j).getLoaiMA())>0){ 
                        MONAN temp = dscopy.getDSMA().get(i);
                        dscopy.getDSMA().set(i, dscopy.getDSMA().get(j));
                        dscopy.getDSMA().set(j, temp);
                    }
                }
            }
        }else if(text.equals("Giá tăng dần")){ 
            for(int i=0;i<n-1;i++){ 
                for(int j=i+1;j<n;j++){ 
                    if(dscopy.getDSMA().get(i).getGia()> dscopy.getDSMA().get(j).getGia()){ 
                       MONAN temp = dscopy.getDSMA().get(i);
                        dscopy.getDSMA().set(i, dscopy.getDSMA().get(j));
                        dscopy.getDSMA().set(j, temp); 
                    }
                }
            }
        }
        else if(text.equals("Giá giảm dần "))  { 
                for(int i=0;i<n-1;i++){ 
                for(int j=i+1;j<n;j++){ 
                    if(dscopy.getDSMA().get(i).getGia()<dscopy.getDSMA().get(j).getGia()){ 
                       MONAN temp = dscopy.getDSMA().get(i);
                        dscopy.getDSMA().set(i, dscopy.getDSMA().get(j));
                        dscopy.getDSMA().set(j, temp); 
                    }
                }
            }
                }  
        return dscopy;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangMA;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JMenuItem deleteMA;
    private javax.swing.JMenuItem editMA;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_lapCongThuc;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JComboBox<String> locMA;
    private javax.swing.JPopupMenu pubangMA;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
