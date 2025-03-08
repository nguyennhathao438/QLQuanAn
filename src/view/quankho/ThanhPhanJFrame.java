/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.quankho;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author ADMIN
 */
public class ThanhPhanJFrame extends javax.swing.JFrame {
    KetNoiDataBase kn=new KetNoiDataBase();
    DefaultTableModel dtm=new DefaultTableModel();
    DSNguyenLieu dsnl;
    String dsMaNL[]=new String[10];
    String dsTenNL[]=new String[10];
    Float dsSLNL[]=new Float[10];
    MONAN monAn;
    int index=0;
    int tinhTrang;
    public ThanhPhanJFrame(MONAN ma,int tt) {
        this.tinhTrang=tt;
        this.monAn=ma;
        initComponents();
        bangNL.setModel(dtm);
        setBangNL();
        if(tt==1){ 
            THANHPHAN tpp=new THANHPHAN();
            kn.layTP(monAn.getMaMA(),tpp);
            dsMaNL=tpp.getMaNL();
            dsSLNL=tpp.getSoLuong();
            index=tpp.getN();
            for(int i=0;i< index ;i++){ 
                System.out.println(dsMaNL[i]+" "+dsSLNL[i]);
            }
            for(int i=0;i<index;i++){ 
                for(int k=0;k<bangNL.getRowCount();k++)
                if(dsMaNL[i].equals((String) bangNL.getValueAt(k, 0)))
                    dsTenNL[i]=(String) bangNL.getValueAt(k, 1);
            }
        }
        setCongThuc();
    }
    private void setBangNL(){ 
        dsnl=new DSNguyenLieu();
        kn.layNL(dsnl);
        dtm.setRowCount(0);
        if(dtm.getColumnCount()==0){ 
            dtm.addColumn("Mã NL");
            dtm.addColumn("Tên NL");
            dtm.addColumn("Mô Tả");
        }
        int count =0;
        for(NGUYENLIEU a:dsnl.getDSNL()){ 
            dtm.addRow(new Object[]{a.getMaNL(),a.getTenNL(),a.getMoTa()});
            
        }
            
    }
    private void setCongThuc(){ 
    StringBuilder sb = new StringBuilder();
    sb.append("Công Thức: ").append(monAn.getTenMA()).append("\n\n");
    sb.append(String.format("%-5s %-20s %-1s %-5s\n", "STT", "Mã NL", "SL","Đơn vị"));
    sb.append("----------------------------------------------------\n");

    for (int i = 0; i < index; i++) { 
        if (dsMaNL[i] != null) {
            sb.append(String.format("%-5s %-20s %-10s %-5s\n", i + 1, dsTenNL[i], dsSLNL[i],"gam"));
        }
    }
    congthuc.setText(sb.toString());
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangNL = new javax.swing.JTable();
        conFirm = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tenNL = new javax.swing.JLabel();
        addNL = new javax.swing.JButton();
        slNL = new javax.swing.JFormattedTextField();
        clearNL = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        congthuc = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bangNL.setModel(new javax.swing.table.DefaultTableModel(
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
        bangNL.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bangNL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangNLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangNL);

        conFirm.setText("Xác Nhận");
        conFirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conFirmActionPerformed(evt);
            }
        });

        exit.setText("Thoat");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conFirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(conFirm)
                .addGap(15, 15, 15))
        );

        jLabel1.setText("Tên Nguyên Liệu");

        jLabel2.setText("Số Lượng");

        tenNL.setBackground(new java.awt.Color(255, 255, 255));
        tenNL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));
        tenNL.setOpaque(true);

        addNL.setText("Thêm");
        addNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNLActionPerformed(evt);
            }
        });

        slNL.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));

        clearNL.setText("Clear");
        clearNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearNLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(tenNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(slNL, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addNL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearNL)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenNL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNL)
                    .addComponent(clearNL))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        congthuc.setColumns(20);
        congthuc.setRows(5);
        jScrollPane2.setViewportView(congthuc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNLActionPerformed
        int row=bangNL.getSelectedRow();
        if(row == -1){ 
            JOptionPane.showConfirmDialog(this,"Click vao nguyen lieu ");
            return;
        }else if(slNL.getValue()==null){ 
            JOptionPane.showConfirmDialog(this,"Nhập số lượng ");
            return;
        }else{ 
            String maNL=(String) bangNL.getValueAt(row, 0);
            Float sl = ((Number) slNL.getValue()).floatValue();
            boolean kt=false;
            for(int i=0;i<index;i++){ 
            if(maNL.equals(dsMaNL[i])){ 
                dsSLNL[i]+=sl;
                kt=true;
                break;
            }
        }
           if(kt==false){ 
               dsMaNL[index]=maNL;
               dsSLNL[index]=sl;
               dsTenNL[index]=(String) bangNL.getValueAt(row, 1);
               index++;
           }
           setCongThuc();
        }
    }//GEN-LAST:event_addNLActionPerformed

    private void bangNLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangNLMouseClicked
        int row = bangNL.getSelectedRow();
        tenNL.setText((String) bangNL.getValueAt(row,1));
    }//GEN-LAST:event_bangNLMouseClicked

    private void conFirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conFirmActionPerformed
        THANHPHAN tp=new THANHPHAN();
        tp.setMaMA(monAn.getMaMA());
        tp.setMaNL(dsMaNL);
        tp.setSoLuong(dsSLNL);
        tp.setN(index);
        if(tinhTrang == 2){ 
        kn.themTP(tp);
        }else{ 
            kn.suaTP(tp);
        }
        if(index == 0 ){ 
            kn.setTTTP(tp.getMaMA());
        }
        this.dispose();       
    }//GEN-LAST:event_conFirmActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void clearNLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearNLActionPerformed
        this.dsMaNL = new String[10];
        this.dsSLNL = new Float[10];
        index =0;
        setCongThuc();
        tenNL.setText("");
        slNL.setText("");
    }//GEN-LAST:event_clearNLActionPerformed

    private boolean ktMaNL(String maNL){ 
        for(int i=0;i<dsMaNL.length;i++){ 
            if(maNL.equals(dsMaNL[i])){ 
                return true;
            }
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNL;
    private javax.swing.JTable bangNL;
    private javax.swing.JButton clearNL;
    private javax.swing.JButton conFirm;
    private javax.swing.JTextArea congthuc;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField slNL;
    private javax.swing.JLabel tenNL;
    // End of variables declaration//GEN-END:variables
}
