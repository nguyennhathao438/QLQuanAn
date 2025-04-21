
package GUI.quankho;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DTO.DSNguyenLieu;
import DAO.QuanKhoDAO;
import DTO.NGUYENLIEU;


public class NguyenLieuDialog extends javax.swing.JDialog {
DSNguyenLieu dsnl=new DSNguyenLieu();
   QuanKhoDAO kn=new QuanKhoDAO();
   String maNguyenLieu="";
    public NguyenLieuDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         setLocationRelativeTo(null);
    }
    public NguyenLieuDialog(java.awt.Frame parent, boolean modal,String maNLieu) {
        super(parent, modal);
        initComponents();
        kn.layNL(dsnl);
        this.maNguyenLieu=maNLieu;
        for(NGUYENLIEU nl:dsnl.getDSNL()){ 
            if(nl.getMaNL().equals(maNguyenLieu)){ 
                maNL.setText(nl.getMaNL());
                loaiNL.setSelectedItem(kn.layTenLoaiNL(nl.getMaLoaiNL()).trim());
                tenNL.setText(nl.getTenNL());
                moTa.setText(nl.getMoTa());
            }
        }
         setLocationRelativeTo(null);
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        maNL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tenNL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        moTa = new javax.swing.JTextArea();
        loaiNL = new javax.swing.JComboBox<>();
        confirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Nguyên Liệu"));

        jLabel1.setText("Mã Nguyên Liệu :");

        jLabel2.setText("Loại Nguyên Liệu :");

        jLabel3.setText("Tên Nguyên Liệu :");

        jLabel4.setText("Mô Tả");

        moTa.setColumns(20);
        moTa.setRows(5);
        jScrollPane1.setViewportView(moTa);

        loaiNL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thit", "Hai San", "Nuoc Uong", "Gia Vi", "Rau Cu", "Trai Cay" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(maNL)
                            .addComponent(jLabel2)
                            .addComponent(loaiNL, 0, 150, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tenNL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(maNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loaiNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        confirm.setText("Xác nhận");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(confirm)
                .addGap(14, 14, 14))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirm)
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {
        kn.layNL(dsnl);
        String text=maNL.getText();
        NGUYENLIEU nl=new NGUYENLIEU();
        nl.setMaNL(maNL.getText());
         
             nl.setMaLoaiNL(kn.layMaLoaiNL((String) loaiNL.getSelectedItem()).trim());
         
        nl.setTenNL(tenNL.getText());
        nl.setMoTa(moTa.getText());
        if(maNguyenLieu.isEmpty()){
            if(maNL.getText().equals("")){ 
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập thông tin");
                return;
            }
            if(tenNL.getText().equals("")){ 
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập thông tin");
                return;
            }
            try {
                for(NGUYENLIEU a: dsnl.getDSNL()){
                    System.out.println(a.getMaNL());
                    if(a.getMaNL().equals(text)){
                        JOptionPane.showMessageDialog(this, "Mã này đã tồn tại");
                        return ;
                    }
                }
                
                kn.themNL(nl);
            } catch (SQLException ex) {
                Logger.getLogger(NguyenLieuDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }   else{    
       
            try {
                kn.suaNL(nl);
            } catch (SQLException ex) {
                Logger.getLogger(NguyenLieuDialog.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
         
     
            
        }
         this.dispose();
    }                                       

    

    // Variables declaration - do not modify                     
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> loaiNL;
    private javax.swing.JTextField maNL;
    private javax.swing.JTextArea moTa;
    private javax.swing.JTextField tenNL;
    // End of variables declaration                   
}
