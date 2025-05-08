
package GUI.quanlibanhang;



import DAO.QuanHangDAO;
import DTO.DSKhach;
import DTO.khachDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

public class KH_Panel extends javax.swing.JPanel {
    Func_class fc = new Func_class();
    QuanHangDAO qh = new QuanHangDAO();
    DefaultTableModel dtm = new DefaultTableModel();
    DSKhach dsk = new DSKhach();
    public KH_Panel() {
        initComponents();
        BangKh.setModel(dtm);
        khoiTao();
        fc.setUpTable(BangKh);
        fc.centerTable(BangKh);
    }
    public void khoiTao(){
        setData();
        setTextHidden();
        setIcon();
        setUpBtn();
        setUpJTF();
        setUpCursorPointer();
    }
    public void setUpCursorPointer(){
        fc.cursorPointer(jlabel_add);
        fc.cursorPointer(jlabel_delete);
        fc.cursorPointer(jlabel_update);
    }
    public void setUpBtn(){
        fc.setUpBtn(btn_Refresh, Color.WHITE,new Color(220,220,220));
        fc.setUpBtn(btn_ok, Color.WHITE, new  Color(220,220,220));
    }
    public void setUpJTF(){
        fc.setUpJTF(search);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", search);
        PromptSupport.setForeground(Color.GRAY, search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, search);
    }
    public void setIcon(){
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg",0.055f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update_1.svg",0.06f));
        btn_Refresh.setIcon(new FlatSVGIcon("./resources/icon/Refresh_1.svg",0.04f));
        btn_ok.setIcon(new FlatSVGIcon("./resources/icon/look.svg",0.65f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg",0.75f));
    }
    public void setData() {
        dsk = new DSKhach();
        qh.LayKH(dsk);
        dtm.setRowCount(0);
        if (dtm.getColumnCount() == 0) {
            dtm.addColumn("Mã Khách Hàng");
            dtm.addColumn("Tên khách hàng");
            dtm.addColumn("Loại khách hàng");
            dtm.addColumn("SĐT");
            dtm.addColumn("Địa chỉ");
        }
        for (khachDTO a : dsk.getDSK()) {
            dtm.addRow(new Object[]{a.getMaKH(), a.getTenkhach(), a.getLoaiKhach(), a.getSDT(), a.getDiachi()});
        }
        TableColumnModel columnModel = BangKh.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(4).setPreferredWidth(200);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlabel_add = new javax.swing.JLabel();
        jlabel_update = new javax.swing.JLabel();
        jlabel_delete = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        btn_ok = new javax.swing.JButton();
        btn_Refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangKh = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        jLabel7.setText("  Thêm");

        jLabel8.setText("    Xóa");

        jLabel9.setText("    Sửa");

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

        jlabel_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_deleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        btn_Refresh.setText("Làm mới");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BangKh.setModel(new javax.swing.table.DefaultTableModel(
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
        BangKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangKhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BangKh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void BangKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangKhMouseClicked
        int rows = BangKh.getSelectedRow();
        if(rows != -1){
            String maKH = BangKh.getValueAt(rows, 0).toString();
            String TenKH = BangKh.getValueAt(rows, 1).toString();
            String LoaiKH = BangKh.getValueAt(rows, 2).toString();
        }
    }//GEN-LAST:event_BangKhMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        dtm.setRowCount(0);
        for (khachDTO a : dsk.getDSK()) {
        dtm.addRow(new Object[]{a.getMaKH(), a.getTenkhach(), a.getLoaiKhach(), a.getSDT(),a.getDiachi()});
        }
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        String text = search.getText().toLowerCase();
        dtm.setRowCount(0);
        for(khachDTO a: dsk.getDSK()){
            if(String.valueOf(a.getMaKH()).toLowerCase().contains(text) || String.valueOf(a.getTenkhach()).toLowerCase().contains(text) || String.valueOf(a.getLoaiKhach()).toLowerCase().contains(text) || String.valueOf(a.getSDT()).toLowerCase().contains(text) || String.valueOf(a.getDiachi()).toLowerCase().contains(text)){
                dtm.addRow(new Object[]{a.getMaKH(),a.getTenkhach(),a.getLoaiKhach(),a.getSDT(),a.getDiachi()});
            }
        }
    }//GEN-LAST:event_btn_okActionPerformed

    private void jlabel_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_addMouseClicked
        Window parenWindow = SwingUtilities.getWindowAncestor(this);
        AddKhachHangDialog add = new AddKhachHangDialog((Frame) parenWindow, true);
        add.setLocationRelativeTo(null);
        add.setVisible(true);
        setData();
    }//GEN-LAST:event_jlabel_addMouseClicked

    private void jlabel_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_deleteMouseClicked
        int rows = BangKh.getSelectedRow();
        if (rows == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách để xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không");
            if (confirm == JOptionPane.YES_OPTION) {
                String makh = String.valueOf(BangKh.getValueAt(rows, 0));
                try {
                    qh.xoaKH(makh);
                } catch (SQLException ex) {
                    Logger.getLogger(KH_Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
                setData();
            }
        }
    }//GEN-LAST:event_jlabel_deleteMouseClicked

    private void jlabel_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_updateMouseClicked
        int row = BangKh.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để xem chi tiết!");
            return;
        }
        String maKH = dtm.getValueAt(row, 0).toString();
        EditKhachHangDialog dialog = new EditKhachHangDialog((Frame) SwingUtilities.getWindowAncestor(this), true, maKH);
        dialog.setVisible(true);
        setData();
    }//GEN-LAST:event_jlabel_updateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangKh;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
