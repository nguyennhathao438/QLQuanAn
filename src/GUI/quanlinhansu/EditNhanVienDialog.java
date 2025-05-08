
package GUI.quanlinhansu;

import DAO.CongViecDAO;
import DAO.NhanVienDAO;
import DTO.CongViecDTO;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import util.Func_class;
public class EditNhanVienDialog extends javax.swing.JDialog {
    NhanVienPanel nvPanel;
    Func_class func=new Func_class();
    HashMap<String,Integer> mapCV;
    NhanVienDAO nvDao=new NhanVienDAO();
    CongViecDAO cvDao=new CongViecDAO();
    NhanVienDTO nv;
    public EditNhanVienDialog(java.awt.Frame parent, boolean modal,NhanVienPanel nvPanel,NhanVienDTO nv) {
        super(parent, modal);
        initComponents();
        this.setTitle("Chỉnh sửa thông tin nhân viên");
        this.nvPanel=nvPanel;
        this.nv=nv;
        khoiTao();
    }
    public void khoiTao() {
        fillCbb();
        khoiTaoButtonGroup();
        setUpEnable();
        jtf_name_nv.setText(nv.getHoTen());
        jtf_sdt_nv.setText(nv.getSDT());
        jdatechooser_ngaySinh.setDate(nv.getNgaySinh());
        mapCV = cvDao.mapCV();
        String tenCV = func.getKey(mapCV, nv.getmaCongViec());
        combobox_cv.setSelectedItem(tenCV);
        if (nv.getGioiTinh().equals("Nam")) {
            jradio_nam.setSelected(true);
        }
        if (nv.getGioiTinh().equals("Nữ")) {
            jradio_nu.setSelected(true);
        }
        this.setLocationRelativeTo(null);
    }
    public void setUpEnable(){
        func.notAllowNumber(jtf_name_nv);
        func.notAllowText(jtf_sdt_nv);
    }
    public void khoiTaoButtonGroup(){
        ButtonGroup btnGrp=new ButtonGroup();
        btnGrp.add(jradio_nam);
        btnGrp.add(jradio_nu);
    }
    public void fillCbb(){
        ArrayList<CongViecDTO> listCV = cvDao.listCV();
        func.setUpComBoBox(combobox_cv);
        for(CongViecDTO cv : listCV){
            combobox_cv.addItem(cv.getTenCV());
        }
    }
    public int check_edit_NhanVien(){
        if(jtf_name_nv.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập tên nhân viên","Erorr",0);
            return 0;
        }
        else if(jtf_sdt_nv.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập số điện thoại","Erorr",0);
            return 0;
        }
        else if(jdatechooser_ngaySinh.getDate()==null){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn ngày sinh","Erorr",0);
            return 0;
        }
        return 1;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtf_name_nv = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_sdt_nv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_update_nv = new javax.swing.JButton();
        btn_exit_nv = new javax.swing.JButton();
        combobox_cv = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jradio_nam = new javax.swing.JRadioButton();
        jradio_nu = new javax.swing.JRadioButton();
        jdatechooser_ngaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Chỉnh Sửa Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        btn_update_nv.setBackground(new java.awt.Color(51, 255, 51));
        btn_update_nv.setText("Cập nhật");
        btn_update_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_update_nvMouseClicked(evt);
            }
        });

        btn_exit_nv.setBackground(new java.awt.Color(255, 0, 0));
        btn_exit_nv.setText("Hủy bỏ");
        btn_exit_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exit_nvMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Công việc");

        jradio_nam.setText("Nam");

        jradio_nu.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(btn_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btn_exit_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combobox_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_name_nv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtf_sdt_nv)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jradio_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jradio_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jdatechooser_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_name_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_sdt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdatechooser_ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jradio_nu)
                    .addComponent(jradio_nam))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_update_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_nvMouseClicked
        if(check_edit_NhanVien()==1){
            int maNV=nv.getMaNV();
            String tenNV=jtf_name_nv.getText();
            String sdt=jtf_sdt_nv.getText();
            if(sdt.length()!=10||sdt.charAt(0)!='0'){
                JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ","Error",0);
                return;
            }
            int maCV = mapCV.get(combobox_cv.getSelectedItem().toString());
            Date ngaySinh = jdatechooser_ngaySinh.getDate();
            java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinh.getTime());
            String gioiTinh=null;
            if(jradio_nam.isSelected())
            gioiTinh=jradio_nam.getText();
            else
            gioiTinh=jradio_nu.getText();
            nv=new NhanVienDTO(maNV,tenNV,ngaySinhSQL,gioiTinh,sdt,maCV);
            nvDao.updateNhanVien(nv);
            nvPanel.setUpTable();
            this.dispose();
        }
    }//GEN-LAST:event_btn_update_nvMouseClicked

    private void btn_exit_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exit_nvMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exit_nvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit_nv;
    private javax.swing.JButton btn_update_nv;
    private javax.swing.JComboBox<String> combobox_cv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdatechooser_ngaySinh;
    private javax.swing.JRadioButton jradio_nam;
    private javax.swing.JRadioButton jradio_nu;
    private javax.swing.JTextField jtf_name_nv;
    private javax.swing.JTextField jtf_sdt_nv;
    // End of variables declaration//GEN-END:variables
}
