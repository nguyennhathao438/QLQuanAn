/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.quanlinhansu;

import DAO.ChamCongDAO;
import DAO.CongViecDAO;
import DAO.LuongDAO;
import DAO.NhanVienDAO;
import DTO.ChamCongDTO;
import DTO.LuongDTO;
import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import util.Func_class;


import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Luong extends javax.swing.JFrame {
    private Func_class func=new Func_class();
    private JPanel jpanel_combobox_thangNam;
    private JComboBox<String> combobox_months;
    private JComboBox<Integer> combobox_years;
    private ArrayList<NhanVienDTO> listNV;
    private ArrayList<ChamCongDTO> listCC;
    private ArrayList<LuongDTO> listLuong;
    private HashMap<String,String> listMapCV;
    public Luong() {
        initComponents();
        this.setTitle("Bảng Lương");
        this.setLocationRelativeTo(null);
        createComBoBoxThangNam();
        setUpTable();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table_luong = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlabel_look = new javax.swing.JLabel();
        jtf_find = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_luong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_luong);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("BẢNG LƯƠNG");

        jPanel3.setBackground(new java.awt.Color(211, 218, 211));

        jlabel_look.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_find, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_look, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_look, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTable getTableLuong(){
        return this.table_luong;
    }
    public void setUpTable(){
        func.setUpTable(table_luong);
    }
    public int getMonthCombobox(){
        int selectMonth=combobox_months.getSelectedIndex()+1;
        return selectMonth;
    }
    public int getYearCombobox(){
        int selectYear=Integer.parseInt(combobox_years.getSelectedItem().toString());
        return selectYear;
    }
    public void createComBoBoxThangNam(){
        this.setLayout(new BorderLayout());
        String[] months={"Tháng 1","Tháng 2","Tháng 3","Tháng 4","Tháng 5","Tháng 6","Tháng 7","Tháng 8","Tháng 9","Tháng 10","Tháng 11","Tháng 12"};
        Integer[] years={2019,2020,2021,2022,2023,2024,2025};
        combobox_months=new JComboBox<>(months);
        combobox_years=new JComboBox<>(years);
        jpanel_combobox_thangNam=new JPanel();
        LocalDate time=LocalDate.now();
        combobox_months.setSelectedIndex(time.getMonthValue()-1);
        combobox_years.setSelectedItem(time.getYear());
        tinhLuong();
        ActionListener comboBoxListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhLuong();
            }
        };
        combobox_months.addActionListener(comboBoxListener);
        combobox_years.addActionListener(comboBoxListener);
        jpanel_combobox_thangNam.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpanel_combobox_thangNam.add(combobox_months);
        jpanel_combobox_thangNam.add(combobox_years);
        this.add(jpanel_combobox_thangNam,BorderLayout.NORTH);
    }
    public void tinhLuong() {
        int selectmonth = getMonthCombobox();
        int selectyear = getYearCombobox();
        listCC = new ChamCongDAO().listChamCongTheoThangNam(selectmonth, selectyear);
        for (ChamCongDTO chamcong : listCC) {
            int maBCC = chamcong.getMaBCC();
            if (new LuongDAO().checkLuongExists(maBCC)) {
                continue; // Nếu có, bỏ qua và không tính lại lương
            }
            int maNV = chamcong.getMaNV();
            double luongCoBan = new CongViecDAO().getLuongCoBanByMaNV(maNV);
            double phuCap = new CongViecDAO().getPhuCap(maNV);
            double heSoLuong = new CongViecDAO().getHeSoLuong(maNV);
            double luongThucTe = luongCoBan * heSoLuong;
            double luongThuong = chamcong.getSoGioLamThem() * 45000 + phuCap;
            double cacKhoanTru = chamcong.getSoNgayTre() * 45000;
            double luongThucLanh = luongThucTe + luongThuong - cacKhoanTru;
            LuongDTO luong = new LuongDTO(maBCC, luongThuong, luongThucTe, cacKhoanTru, luongThucLanh);
            new LuongDAO().insertLuong(luong);
        }
        loadDataLuong();
        func.centerTable(table_luong);
    }
    
    public void loadDataLuong(){
        int selectMonth=getMonthCombobox();
        int selectYear=getYearCombobox();
        listLuong=new LuongDAO().listLuong(selectMonth,selectYear);
        listNV=new NhanVienDAO().listNV();
        String[] colNames={"Mã Lương","Nhân viên","Lương cơ bản","Lương thực tế","Lương thưởng","Các khoản trừ","Thực lãnh"};
        Object[][] rows=new Object[listLuong.size()][colNames.length];
        DecimalFormat df=new DecimalFormat("#,###");
        for(int i=0;i<listLuong.size();i++){
            rows[i][0]=listLuong.get(i).getMaLuong();
            HashMap<Integer,Integer> mapChamCong=new ChamCongDAO().mapChamCong();
            int maBCC=listLuong.get(i).getMaBCC();
            int maNV=func.getKeyInt(mapChamCong, maBCC);
            String tenNV=null;
            for(int j=0;j<listNV.size();j++){
                if(maNV==listNV.get(j).getMaNV())
                    tenNV=listNV.get(j).getHoTen();
            }
            rows[i][1]=maNV+"-"+tenNV;
            double luongCoBan=new LuongDAO().getLuongCoBanByMaLuong(listLuong.get(i).getMaLuong());
            rows[i][2]=df.format(luongCoBan);
            rows[i][3]=df.format(listLuong.get(i).getLuongThucTe());
            rows[i][4]=df.format(listLuong.get(i).getLuongThuong());
            rows[i][5]=df.format(listLuong.get(i).getCacKhoanTru());
            rows[i][6]=df.format(listLuong.get(i).getThucLanh());
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table_luong.setModel(model);
    }
       

 
    
    
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
            java.util.logging.Logger.getLogger(Luong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Luong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Luong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Luong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Luong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel_look;
    private javax.swing.JTextField jtf_find;
    private javax.swing.JTable table_luong;
    // End of variables declaration//GEN-END:variables
}
