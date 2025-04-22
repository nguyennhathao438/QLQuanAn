
package GUI.quanlibanhang;

import DAO.QuanHangDAO;
import DTO.DSKhach;
import DTO.khachDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.prompt.PromptSupport;

public class AddKhachHangDialog extends javax.swing.JDialog {

    DSKhach dsk = new DSKhach();
    QuanHangDAO qh = new QuanHangDAO();
    public AddKhachHangDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        khoitao();
        qh.LayKH(dsk);
        setIcon();
        setTextHidden();
    }
    public void setIcon(){
        btn_them.setIcon(new FlatSVGIcon("./resources/icon/Customer.svg",0.05f));
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Nhập Mã khách", text_khach);
        PromptSupport.setForeground(Color.GRAY, text_khach);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, text_khach);
        PromptSupport.setPrompt("Nhập tên khách hàng", text_ten);
        PromptSupport.setForeground(Color.GRAY, text_ten);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, text_ten);
        PromptSupport.setPrompt("Nhập số điện thoại", Text_SDT);
        PromptSupport.setForeground(Color.GRAY, Text_SDT);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, Text_SDT);
        PromptSupport.setPrompt("Nhập địa chỉ", Text_DiaChi);
        PromptSupport.setForeground(Color.GRAY, Text_DiaChi);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, Text_DiaChi);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_khach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_ten = new javax.swing.JTextField();
        Text_SDT = new javax.swing.JTextField();
        Text_DiaChi = new javax.swing.JTextField();
        cbb_loaikhach = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel1.setText("Mã khách:");

        jLabel2.setText("Tên khách:");

        jLabel3.setText("Loại khách:");

        jLabel4.setText("SĐT:");

        jLabel5.setText("Địa Chỉ:");

        text_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_tenActionPerformed(evt);
            }
        });

        Text_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_SDTActionPerformed(evt);
            }
        });

        cbb_loaikhach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_SDT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Text_DiaChi)
                            .addComponent(cbb_loaikhach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_ten)
                            .addComponent(text_khach, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text_khach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbb_loaikhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Text_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int ktSDT(String SDT){
        if(SDT.matches("0\\d{8}")) // kt số 0 ở đầu và có 9 số sau
        {
            return 1;
        }
        return 0;
    }
    public void khoitao(){
        cbb_loaikhach.removeAllItems();
        cbb_loaikhach.addItem("--Chọn loại khách hàng--");
        cbb_loaikhach.addItem("Thành viên");
        cbb_loaikhach.addItem("Khách lẻ");
    }
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String makhach = text_khach.getText().trim();
        String tenkhach = text_ten.getText().trim();
        String loaikhach = cbb_loaikhach.getSelectedItem().toString();
        String SDT = Text_SDT.getText().trim();
        String diachi = Text_DiaChi.getText().trim();
        
        if(makhach.isEmpty() || tenkhach.isEmpty() || loaikhach.equals("--Chọn loại khách hàng--")|| SDT.isEmpty() || diachi.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(ktSDT(SDT) == 1){
            JOptionPane.showMessageDialog(null, "Định dạng sai Số điện thoại", "Errol", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            for(khachDTO kh:dsk.getDSK()){
               if(kh.getMaKH().equals(makhach)){
                   JOptionPane.showMessageDialog(null, "Mã bị trùng vui lòng nhập mã khác", "Error", JOptionPane.ERROR_MESSAGE);
                   return;
               }
            }
            khachDTO kh = new khachDTO();
            kh.setMaKhach(makhach);
            kh.setTenkhach(tenkhach);
            kh.setLoaiKhach(loaikhach);
            kh.setSDT(SDT);
            kh.setDiachi(diachi);
            
            qh.themKH(kh);
            JOptionPane.showMessageDialog(null,"Thêm Thành công");
            
            dispose();
        }
        
    }//GEN-LAST:event_btn_themActionPerformed

    private void Text_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_SDTActionPerformed

    private void text_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_tenActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddKhachHangDialog dialog = new AddKhachHangDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Text_DiaChi;
    private javax.swing.JTextField Text_SDT;
    private javax.swing.JButton btn_them;
    private javax.swing.JComboBox<String> cbb_loaikhach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField text_khach;
    private javax.swing.JTextField text_ten;
    // End of variables declaration//GEN-END:variables
}
