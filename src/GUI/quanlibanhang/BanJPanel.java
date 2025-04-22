package GUI.quanlibanhang;

import DAO.QuanHangDAO;
import DTO.BanManager;
import DTO.CTHOADON;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import DTO.MonAnBan;
import java.text.DecimalFormat;
import java.util.Date;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;


public class BanJPanel extends javax.swing.JPanel {
    private JButton[] btnBan = new JButton[BanManager.getsoluongban()];
    private int bandangchon = -1; // luu ban dang chon
    Func_class func=new Func_class();
    public BanJPanel() {
        initComponents();
        Jpanel_Khuvuc.setLayout(new GridLayout(5,4));
        initbtnBan();
        setTextHidden();
        setIcon();
        setUpBtn();
        setUpCursorPointer();
        setUpJTF();
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Nhập số tiền", jTextField1);
        PromptSupport.setForeground(Color.GRAY, jTextField1);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextField1);
        PromptSupport.setPrompt("Nhập tên khách hàng", jTextField2);
        PromptSupport.setForeground(Color.GRAY, jTextField2);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextField2);
    }
    public void setUpJTF(){
        func.setUpJTF(jTextField1);
        func.setUpJTF(jTextField2);
    }
    public void setUpBtn(){
        func.setUpBtn(btn_thanhtoan,Color.WHITE,Color.GREEN);
    }
    public void setUpCursorPointer(){
        func.cursorPointer(jlabel_datBan);
        func.cursorPointer(jlabel_donBan);
        func.cursorPointer(jlabel_taoDon);
    }
    public void setIcon(){
        jlabel_taoDon.setIcon(new FlatSVGIcon("./resources/icon/List_order.svg",0.09f));
        btn_thanhtoan.setIcon(new FlatSVGIcon("./resources/icon/Pay.svg",0.05f));
        jlabel_donBan.setIcon(new FlatSVGIcon("./resources/icon/clear.svg",0.08f));
        jlabel_datBan.setIcon(new FlatSVGIcon("./resources/icon/order.svg",0.08f));
    }
    public void moDialogthucdon(){
         Window parentWindow = SwingUtilities.getWindowAncestor(BanJPanel.this);
        ThucDonDiaLog dialog = new ThucDonDiaLog((Frame) parentWindow, true, bandangchon);
        dialog.setLocationRelativeTo(BanJPanel.this);
        dialog.setVisible(true);
    }
    public void moDialogDatBan(){
        Window parentWindow = SwingUtilities.getWindowAncestor(BanJPanel.this);
        DatBanDialog dialog = new DatBanDialog((Frame) parentWindow, true, bandangchon);
        dialog.setLocationRelativeTo(BanJPanel.this);
        dialog.setVisible(true);
    }
    public void capnhatbutton(int i){
        String trangthai = BanManager.dsBan[i].getTrangthai();
        if("Trống".equals(trangthai)){
            btnBan[i].setBackground(new Color(107, 142, 35));
            btnBan[i].setText("<html>Bàn "+i+"<br> Trống</html>");
        }
        else if("Đang Dùng".equals(trangthai)){
            btnBan[i].setBackground(Color.RED);
            btnBan[i].setText("<html>Bàn "+i+"<br> Đang Dùng</html>");
        }
    }
    private void capnhattongtien(int i){
        DecimalFormat df = new DecimalFormat("#,###");
        double Tong = 0;
        for(MonAnBan mab:BanManager.dsmab[bandangchon].getDSMAB()){
            Tong += mab.getThanhtien();
        }
        jLabel4.setText(df.format(Tong)+ ".0 VNĐ");
        
        try{
          double tiendu;
          double tienkhach = Double.parseDouble(jTextField1.getText().trim());
          jLabel6.setText(df.format(tienkhach) + " VNĐ");
          tiendu = tienkhach - Tong;
          
          if(tienkhach < Tong){
              jLabel8.setText("0.0 VNĐ");
          }
          else if(Tong == 0){
              jLabel8.setText("0.0 VNĐ");
          }
          else{
          jLabel8.setText(df.format(tiendu) + " VNĐ");
          }
        } catch (NumberFormatException ex) {
            jLabel8.setText("0.0 VNĐ");
            jLabel6.setText("0.0 VNĐ");
        }
    }

    private void initbtnBan(){
        for(int i = 0 ; i < BanManager.getsoluongban() ; i++){
            final int index = i;
            btnBan[i] = new JButton();
            btnBan[i].setIcon(new FlatSVGIcon("./resources/icon/table.svg", 0.4f));
            btnBan[i].setPreferredSize(new Dimension(150,150));
            btnBan[i].setHorizontalTextPosition(SwingConstants.RIGHT);
            btnBan[i].setVerticalTextPosition(SwingConstants.CENTER);
            btnBan[i].setIconTextGap(1);
            capnhatbutton(i);  
            // Thêm ActionListener để cập nhật bandangchon
            btnBan[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bandangchon = index; // Cập nhật bàn đã chọn
                double tongtien = 0;
                System.out.println("Bàn " + (index + 1) + " đã được chọn");
                jLabel2.setText(""+(index)+"");
                capnhattongtien(index);
            }
        });
            Jpanel_Khuvuc.add(btnBan[i]);
        }
    }
    
     private void btn_donbanActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(bandangchon == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn để reset", "Errol", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn reset bàn "+ (bandangchon) + "không", "thông báo", JOptionPane.YES_NO_OPTION);
        if(chon == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Bàn đã được đặt lại trạng thái ban đầu");
            BanManager.thanhtoan(bandangchon);
            BanManager.Capnhattt(bandangchon, "Trống");
            capnhatbutton(bandangchon);
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel_Khuvuc = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlabel_donBan = new javax.swing.JLabel();
        jlabel_datBan = new javax.swing.JLabel();
        jlabel_taoDon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_thanhtoan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        Jpanel_Khuvuc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        javax.swing.GroupLayout Jpanel_KhuvucLayout = new javax.swing.GroupLayout(Jpanel_Khuvuc);
        Jpanel_Khuvuc.setLayout(Jpanel_KhuvucLayout);
        Jpanel_KhuvucLayout.setHorizontalGroup(
            Jpanel_KhuvucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        Jpanel_KhuvucLayout.setVerticalGroup(
            Jpanel_KhuvucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nhập số tiền:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nhập khách hàng:");

        jLabel10.setText("   Order");

        jLabel12.setText("     Clear");

        jLabel13.setText("   Đặt bàn");

        jlabel_donBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_donBanMouseClicked(evt);
            }
        });

        jlabel_taoDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_taoDonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabel_donBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel_datBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabel_taoDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_donBan, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jlabel_datBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_taoDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Bàn:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tổng giá:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiền khách:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tiền Trả:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_thanhtoan.setText("Thanh Toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btn_thanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Jpanel_Khuvuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Jpanel_Khuvuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        CTHOADON cthdbn = new CTHOADON();
        QuanHangDAO qh = new QuanHangDAO();
        String mamoi = qh.taoMaHoaDonMoi();
        MonAnBan ma = new MonAnBan();
        String makhach = jTextField2.getText().trim();
        if (bandangchon == -1){
        JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn để thanh toán", "Errol", JOptionPane.ERROR_MESSAGE);
        return;
        }
        String trangthai = BanManager.dsBan[bandangchon].getTrangthai();
        if("Trống".equals(trangthai)){
        JOptionPane.showMessageDialog(null, "Bàn đang trống không thể thanh toán", "Errol", JOptionPane.ERROR_MESSAGE);
        return;
        } 
        else if(!makhach.equals("") && !qh.kiemTraTonTaiKH(makhach)){
            JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại", "Errol", JOptionPane.ERROR_MESSAGE);
        }
        else if("Đang Dùng".equals(trangthai)){
        String cthdMaKH = cthdbn.getMaKH();
        boolean ktkhach = makhach != null;
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn Thanh toán không? (Nếu đã thanh toán hãy Reset)", "Thông báo", JOptionPane.YES_NO_OPTION);
        if(chon == JOptionPane.YES_OPTION){
        double Tong = 0;
        for(MonAnBan a:BanManager.dsmab[bandangchon].getDSMAB()){
            Tong += a.getThanhtien();
        }
        cthdbn.setMaHoaDon(mamoi);
        cthdbn.setThoiGian(new Date());
        cthdbn.setThanhTien(Tong);        
        cthdbn.setDsma(BanManager.dsmab[bandangchon].getDSMAB());
        if(ktkhach && qh.kiemTraTonTaiKH(makhach)){
            cthdbn.setMaKH(makhach);
            qh.themHDBH(cthdbn, makhach,String.valueOf(bandangchon));
        }else {
            cthdbn.setMaKH(null);
        qh.themHDBH(cthdbn,null,String.valueOf(bandangchon));
        }
        JOptionPane.showMessageDialog(null,"Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        BanManager.thanhtoan(bandangchon);
        BanManager.Capnhattt(bandangchon, "Trống");
            capnhatbutton(bandangchon);
        }
        }
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void jlabel_donBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_donBanMouseClicked
        if(bandangchon == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn để reset", "Errol", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn reset bàn "+ (bandangchon) + "không", "thông báo", JOptionPane.YES_NO_OPTION);
        if(chon == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Bàn đã được đặt lại trạng thái ban đầu");
            BanManager.thanhtoan(bandangchon);
            BanManager.Capnhattt(bandangchon, "Trống");
            capnhatbutton(bandangchon);
        }
    }//GEN-LAST:event_jlabel_donBanMouseClicked

    private void jlabel_taoDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_taoDonMouseClicked
        if (bandangchon == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn để tạo đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String trangthai = BanManager.dsBan[bandangchon].getTrangthai();

        if ("Trống".equals(trangthai)) {
            BanManager.taoDon(bandangchon);
            moDialogthucdon();
        } else {
            int chon = JOptionPane.showConfirmDialog(null,
                    "Bàn đang sử dụng. Bạn có muốn xem lại đơn không?",
                    "Thông báo", JOptionPane.YES_NO_OPTION);

            if (chon == JOptionPane.YES_OPTION) {
                moDialogthucdon();
                BanManager.laydsmon(bandangchon);
            }
        }
        // Cập nhật trạng thái bàn sau khi thao tác
        capnhatbutton(bandangchon);
    }//GEN-LAST:event_jlabel_taoDonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel_Khuvuc;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlabel_datBan;
    private javax.swing.JLabel jlabel_donBan;
    private javax.swing.JLabel jlabel_taoDon;
    // End of variables declaration//GEN-END:variables
}
