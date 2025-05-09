/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.quankho;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import DTO.DSMonAn;
import DAO.QuanKhoDAO;
import DTO.MONAN;
import java.awt.Color;
import util.Func_class;

/**
 *
 * @author ADMIN
 */
public class MonAnDiaLog extends javax.swing.JDialog {
QuanKhoDAO kn=new QuanKhoDAO();
    DSMonAn dsma=new DSMonAn(); 
    String maMonAn="";
   QKMonAnJPanel panel;
    Func_class fc = new Func_class();
    public MonAnDiaLog(java.awt.Frame parent, boolean modal , QKMonAnJPanel panel) {
        super(parent, modal);
        this.panel = panel;
        initComponents();
        kn.layDSMonAn(dsma);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        fc.notAllowNumber(tenMA);
        fc.notAllowText(gia);
        fc.setUpBtnTwo(submit, Color.GREEN, Color.GREEN, Color.WHITE, 14);
        fc.setUpComBoBox(loaiMA);
    }
    public MonAnDiaLog(java.awt.Frame parent, boolean modal, String maMon, QKMonAnJPanel panel) {
        super(parent, modal);
        this.panel = panel;
        initComponents();
        this.maMonAn = maMon;
        kn.layDSMonAn(dsma);
        maMA.setEnabled(false);
        fc.setUpComBoBox(loaiMA);
        fc.setUpBtnTwo(submit, Color.GREEN, Color.GREEN, Color.WHITE, 14);
        for (MONAN a : dsma.getDSMA()) {
            if (maMonAn.equals(a.getMaMA())) {
                maMA.setText(a.getMaMA());
                loaiMA.setSelectedItem(a.getLoaiMA());
                tenMA.setText(a.getTenMA());
                gia.setText(Double.toString(a.getGia()));
                moTa.setText(a.getMoTa());
            }
        }
        setLocationRelativeTo(null);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        maMA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tenMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        moTa = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        gia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        loaiMA = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Món Ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setText("Mã Món Ăn");

        jLabel2.setText("Tên Món Ăn");

        jLabel3.setText("Giá Bán");

        moTa.setColumns(20);
        moTa.setRows(5);
        jScrollPane1.setViewportView(moTa);

        jLabel4.setText("Mô Tả");

        jLabel5.setText("Loại Món Ăn");

        loaiMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kho", "Hấp", "Xào", "Chiên", "Nướng", "Nước", "Tráng Miệng", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maMA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(tenMA, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(loaiMA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(maMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loaiMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        submit.setText("Xác nhận");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String text = maMA.getText().trim();
        String ten = tenMA.getText().trim();
        String mo = moTa.getText().trim();
        String g = gia.getText().trim();
        // Kiểm tra các trường bắt buộc
        if (text.equals("") || ten.equals("") || g.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
            return;
        }
        // Kiểm tra định dạng giá
        if (!kt()) {
            return;
        }
        double giaTien = Double.parseDouble(g);
        if (giaTien <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Không để giá nhỏ hơn hoặc bằng 0");
            return;
        }

        MONAN ma = new MONAN();
        ma.setMaMA(text);
        ma.setLoaiMA((String) loaiMA.getSelectedItem());
        ma.setTenMA(ten);
        ma.setMoTa(mo);
        ma.setGia(giaTien);

        boolean kt = false;

        if (maMonAn.isEmpty()) {
            for (MONAN a : dsma.getDSMA()) {
                if (a.getMaMA().equals(text)) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại");
                    return;
                }
            }
            kt = true;
        }

        if (kt == true) {
            kn.themMonAn(ma);
        } else {
            kn.suaMonAn(ma);
        }

        panel.setData();
        this.dispose();
    }//GEN-LAST:event_submitActionPerformed
    private boolean kt() {
        String regex = "^[+-]?([0-9]*[.])?[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(gia.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Giá tiền không hợp lệ ");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField gia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> loaiMA;
    private javax.swing.JTextField maMA;
    private javax.swing.JTextArea moTa;
    private javax.swing.JButton submit;
    private javax.swing.JTextField tenMA;
    // End of variables declaration//GEN-END:variables
}
