/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.quankho;

import DTO.NHACUNGCAP;
import DTO.DSNCC;
import DAO.QuanKhoDAO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

public class QKNCCJPanel extends javax.swing.JPanel {
    QuanKhoDAO kn = new QuanKhoDAO();
    DSNCC dsncc;
    DefaultTableModel dtm = new DefaultTableModel();
    Func_class func = new Func_class();

    public QKNCCJPanel() {
        initComponents();
        bangNCC.setModel(dtm);
        setData();
        setTable();
        setTextHidden();
        setIcon();
        setUp();
    }

    public void setData() {
        dsncc = new DSNCC();
        kn.layNCC(dsncc);
        dtm.setRowCount(0);
        if (dtm.getColumnCount() == 0) {
            dtm.addColumn("Mã NCC");
            dtm.addColumn("Tên NCC");
            dtm.addColumn("Số điện thoại ");
        }
        for (NHACUNGCAP a : dsncc.getDSNCC()) {
            dtm.addRow(new Object[]{a.getMaNCC(), a.getTenNCC(), a.getSdt()});
        }
    }
    public void setUp(){
        func.setUpBtn(jButton4, Color.WHITE,new Color(220,220,220));
        func.setUpJTF(search);
        func.setUpBtn(btn_refresh, Color.WHITE,new Color(220,220,220));
         func.cursorPointer(jlabel_add);
        func.cursorPointer(jlabel_update);
        func.cursorPointer(jlabel_delete);
    }
    public void setTextHidden() {
        PromptSupport.setPrompt("Tìm kiếm nhanh", search);
        PromptSupport.setForeground(Color.GRAY, search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, search);
    }

    public void setTable() {
        bangNCC.getColumnModel().getColumn(0).setPreferredWidth(80);
        bangNCC.getColumnModel().getColumn(1).setPreferredWidth(200);
        bangNCC.getColumnModel().getColumn(2).setPreferredWidth(300);
        //Can giua
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//Can giữa tẽt
        for (int i = 0; i < 3; i++) {
            bangNCC.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        func.centerTable(bangNCC);
        func.setUpTable(bangNCC);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlabel_add = new javax.swing.JLabel();
        jlabel_delete = new javax.swing.JLabel();
        jlabel_update = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangNCC = new javax.swing.JTable();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("  Thêm");

        jLabel2.setText("    Xoá");

        jLabel3.setText("    Sửa");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bangNCC.setModel(new javax.swing.table.DefaultTableModel(
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
        bangNCC.setRowHeight(30);
        bangNCC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bangNCC.setShowGrid(false);
        bangNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangNCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangNCC);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bangNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangNCCMouseClicked

    }//GEN-LAST:event_bangNCCMouseClicked

    public void setIcon() {
        jButton4.setIcon(new FlatSVGIcon("./resources/icon/find.svg", 0.35f));
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg", 0.06f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.25f));
    }  
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String text = search.getText();
        dtm.setRowCount(0);
        for (NHACUNGCAP a : dsncc.getDSNCC()) {
            if (a.getMaNCC().toLowerCase().contains(text) || a.getTenNCC().toLowerCase().contains(text) || String.valueOf(a.getSdt()).toLowerCase().contains(text)) {
                dtm.addRow(new Object[]{a.getMaNCC(), a.getTenNCC(), a.getSdt()});
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jlabel_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_addMouseClicked
        NhaCungCapDialog dialog = new NhaCungCapDialog((Frame) SwingUtilities.getWindowAncestor(this), "Thêm NCC", null);
        dialog.setVisible(true);
        if (dialog.isSucceeded()) {
            NHACUNGCAP ncc = dialog.getNhaCungCap();
            kn.themNCC(ncc); // Gọi DAO thêm NCC
            setData(); // Load lại bảng
        }
    }//GEN-LAST:event_jlabel_addMouseClicked

    private void jlabel_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_deleteMouseClicked
        int row = bangNCC.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "click vao ncc can xoa", "Loi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon xoa");
            if (confirm == JOptionPane.YES_OPTION) {
                String maNCC = String.valueOf(bangNCC.getValueAt(row, 0));
                try {
                    kn.xoaNCC(maNCC);
                } catch (SQLException ex) {
                    Logger.getLogger(QKNCCJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                setData();
            }
        }
    }//GEN-LAST:event_jlabel_deleteMouseClicked

    private void jlabel_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_updateMouseClicked
        int selectedRow = bangNCC.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        // Lấy dữ liệu từ bảng
        String ma = bangNCC.getValueAt(selectedRow, 0).toString();
        String ten = bangNCC.getValueAt(selectedRow, 1).toString();
        String sdt = bangNCC.getValueAt(selectedRow, 2).toString();
        NHACUNGCAP selectedNCC = new NHACUNGCAP(ma, ten, sdt);
        // Mở dialog sửa
        NhaCungCapDialog dialog = new NhaCungCapDialog((Frame) SwingUtilities.getWindowAncestor(this), "Sửa Nhà Cung Cấp", selectedNCC);
        dialog.setVisible(true);
        // Lấy kết quả sau khi sửa
        NHACUNGCAP result = dialog.getNhaCungCap();
        if (result != null) {
            try {
                kn.suaNCC(result);
                setData(); // Load lại bảng
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            } catch (SQLException ex) {
                Logger.getLogger(QKNCCJPanel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }
    }//GEN-LAST:event_jlabel_updateMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        search.setText("");
        setData();
        func.centerTable(bangNCC);
        func.setUpTable(bangNCC);
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangNCC;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
