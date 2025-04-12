
package GUI.quankho;

import controller.Bean;
import controller.ChuyenTrangQK;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class QKMainJFrame extends javax.swing.JFrame {

    public QKMainJFrame() {
        initComponents();
        setTitle("Quản Kho Quán Ăn");
        ChuyenTrangQK ct =new ChuyenTrangQK(jpnView);
        ct.setTrang(jpnMonAn,jlbMonAn);
        ArrayList<Bean> menu =new ArrayList<>();
        menu.add(new Bean("MonAn",jpnMonAn,jlbMonAn));
        menu.add(new Bean("NguyenLieu",jpnNguyenLieu,jlbNL));
        menu.add(new Bean("HDNH",jpnHDNH,jlbHDNH));
        menu.add(new Bean("NCC",jpnNCC,jlbNCC));
        menu.add(new Bean("ThongKe",jpnThongKe,jlbThongKe));
        ct.setEvent(menu);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnMonAn = new javax.swing.JPanel();
        jlbMonAn = new javax.swing.JLabel();
        jpnNguyenLieu = new javax.swing.JPanel();
        jlbNL = new javax.swing.JLabel();
        jpnHDNH = new javax.swing.JPanel();
        jlbHDNH = new javax.swing.JLabel();
        jpnNCC = new javax.swing.JPanel();
        jlbNCC = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setBackground(new java.awt.Color(35, 27, 18));
        jpnRoot.setPreferredSize(new java.awt.Dimension(200, 400));

        jPanel3.setBackground(new java.awt.Color(245, 108, 87));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN KHO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jpnMonAn.setBackground(new java.awt.Color(247, 118, 4));

        jlbMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbMonAn.setForeground(new java.awt.Color(204, 255, 255));
        jlbMonAn.setText("Món ăn");

        javax.swing.GroupLayout jpnMonAnLayout = new javax.swing.GroupLayout(jpnMonAn);
        jpnMonAn.setLayout(jpnMonAnLayout);
        jpnMonAnLayout.setHorizontalGroup(
            jpnMonAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMonAnLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jlbMonAn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMonAnLayout.setVerticalGroup(
            jpnMonAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMonAnLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jlbMonAn)
                .addGap(23, 23, 23))
        );

        jpnNguyenLieu.setBackground(new java.awt.Color(247, 118, 4));

        jlbNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbNL.setForeground(new java.awt.Color(204, 255, 255));
        jlbNL.setText("Nguyên Liệu");

        javax.swing.GroupLayout jpnNguyenLieuLayout = new javax.swing.GroupLayout(jpnNguyenLieu);
        jpnNguyenLieu.setLayout(jpnNguyenLieuLayout);
        jpnNguyenLieuLayout.setHorizontalGroup(
            jpnNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNguyenLieuLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jlbNL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNguyenLieuLayout.setVerticalGroup(
            jpnNguyenLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNguyenLieuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlbNL)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jpnHDNH.setBackground(new java.awt.Color(247, 118, 4));
        jpnHDNH.setPreferredSize(new java.awt.Dimension(270, 70));

        jlbHDNH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbHDNH.setForeground(new java.awt.Color(204, 255, 255));
        jlbHDNH.setText("Hoá Đơn Nhập Hàng");

        javax.swing.GroupLayout jpnHDNHLayout = new javax.swing.GroupLayout(jpnHDNH);
        jpnHDNH.setLayout(jpnHDNHLayout);
        jpnHDNHLayout.setHorizontalGroup(
            jpnHDNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDNHLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jlbHDNH)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jpnHDNHLayout.setVerticalGroup(
            jpnHDNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDNHLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlbHDNH)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jpnNCC.setBackground(new java.awt.Color(247, 118, 4));
        jpnNCC.setPreferredSize(new java.awt.Dimension(270, 70));

        jlbNCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbNCC.setForeground(new java.awt.Color(204, 255, 255));
        jlbNCC.setText("Nhà Cung Cấp");

        javax.swing.GroupLayout jpnNCCLayout = new javax.swing.GroupLayout(jpnNCC);
        jpnNCC.setLayout(jpnNCCLayout);
        jpnNCCLayout.setHorizontalGroup(
            jpnNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNCCLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jlbNCC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNCCLayout.setVerticalGroup(
            jpnNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNCCLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlbNCC)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jpnThongKe.setBackground(new java.awt.Color(247, 118, 4));

        jlbThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(204, 255, 255));
        jlbThongKe.setText("Thống kê");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jlbThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jlbThongKe)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton1.setText("Đăng xuất");

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnNguyenLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnHDNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jpnMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnHDNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jpnView.setPreferredSize(new java.awt.Dimension(700, 0));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QKMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QKMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QKMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QKMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QKMainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlbHDNH;
    private javax.swing.JLabel jlbMonAn;
    private javax.swing.JLabel jlbNCC;
    private javax.swing.JLabel jlbNL;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JPanel jpnHDNH;
    private javax.swing.JPanel jpnMonAn;
    private javax.swing.JPanel jpnNCC;
    private javax.swing.JPanel jpnNguyenLieu;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
