
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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.Func_class;


public class LuongPanel extends javax.swing.JPanel {
    Func_class func=new Func_class();
    LuongDAO luongDao=new LuongDAO();
    CongViecDAO cvDao=new CongViecDAO();
    NhanVienDAO nvDao=new NhanVienDAO();
    ChamCongDAO chamcongDao=new ChamCongDAO();
    HashMap<Integer,Integer> mapChamCong;
    JPanel jpanel_combobox_thangNam;
    JPanel jpanel_title;
    JPanel jpanel_top;
    JComboBox<String> combobox_months;
    JComboBox<Integer> combobox_years;
    JLabel label_title;
    ArrayList<ChamCongDTO> listCC;
    ArrayList<LuongDTO> listLuong;
    JTable table_luong;
    public LuongPanel() {
        initComponents();
        createComBoBoxThangNam();
    }
    public JTable getTableLuong(){
        return this.table_luong;
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
        jpanel_top=new JPanel(new BorderLayout());
        jpanel_combobox_thangNam=new JPanel();
        LocalDate time=LocalDate.now();
        combobox_months.setSelectedIndex(time.getMonthValue()-1);
        combobox_years.setSelectedItem(time.getYear());
        jpanel_combobox_thangNam.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpanel_combobox_thangNam.add(combobox_months);
        jpanel_combobox_thangNam.add(combobox_years);
        jpanel_title=new JPanel(new FlowLayout(FlowLayout.CENTER));
        label_title=new JLabel("BẢNG TÍNH LƯƠNG THEO THÁNG");
        label_title.setFont(new Font("Arial",Font.BOLD,14));
        jpanel_title.add(label_title);
        tinhLuong();
        ActionListener comboBoxListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhLuong();
            }
        };
        combobox_months.addActionListener(comboBoxListener);
        combobox_years.addActionListener(comboBoxListener);
        jpanel_top.add(jpanel_combobox_thangNam,BorderLayout.NORTH);
        jpanel_top.add(jpanel_title,BorderLayout.CENTER);
        this.add(jpanel_top,BorderLayout.NORTH);
    }
    public void tinhLuong() {
        int selectmonth = getMonthCombobox();
        int selectyear = getYearCombobox();
        listCC = chamcongDao.listChamCongTheoThangNam(selectmonth, selectyear);
        for (ChamCongDTO chamcong : listCC ) {
            int maBCC = chamcong.getMaBCC();
            if (luongDao.checkLuongExists(maBCC)) {
                continue; // Nếu có, bỏ qua và không tính lại lương
            }
            int maNV = chamcong.getMaNV();
            double luongCoBan = cvDao.getLuongCoBanByMaNV(maNV);
            double phuCap = cvDao.getPhuCap(maNV);
            double heSoLuong = cvDao.getHeSoLuong(maNV);
            double luongThucTe = luongCoBan * heSoLuong;
            double luongThuong = chamcong.getSoGioLamThem() * 45000 + phuCap;
            double cacKhoanTru = chamcong.getSoNgayTre() * 45000;
            double luongThucLanh = luongThucTe + luongThuong - cacKhoanTru;
            LuongDTO luong = new LuongDTO(maBCC, luongThuong, luongThucTe, cacKhoanTru, luongThucLanh);
            luongDao.insertLuong(luong);
        }
        loadDataLuong();
        func.centerTable(table_luong);
    }
    
    public void loadDataLuong() {
        this.removeAll(); // 👉 xóa hết components cũ trước khi add lại
        this.setLayout(new BorderLayout()); // cần reset lại layout
        this.add(jpanel_top, BorderLayout.NORTH); // 
        int selectMonth = getMonthCombobox();
        int selectYear = getYearCombobox();
        listLuong = luongDao.listLuong(selectMonth, selectYear);
        String[] colNames = {"Mã Lương", "Nhân viên", "Lương cơ bản", "Lương thực tế", "Lương thưởng", "Các khoản trừ", "Thực lãnh"};
        Object[][] rows = new Object[listLuong.size()][colNames.length];
        DecimalFormat df = new DecimalFormat("#,###");
        for (int i = 0; i < listLuong.size(); i++) {
            rows[i][0] = listLuong.get(i).getMaLuong();
            mapChamCong = chamcongDao.mapChamCong();
            int maBCC = listLuong.get(i).getMaBCC();
            int maNV = mapChamCong.get(maBCC);
            String tenNV = null;
            for (NhanVienDTO nv : nvDao.listNV()) {
                if (maNV == nv.getMaNV()) {
                    tenNV = nv.getHoTen();
                }
            }
            rows[i][1] = maNV + "-" + tenNV;
            double luongCoBan = new LuongDAO().getLuongCoBanByMaLuong(listLuong.get(i).getMaLuong());
            rows[i][2] = df.format(luongCoBan);
            rows[i][3] = df.format(listLuong.get(i).getLuongThucTe());
            rows[i][4] = df.format(listLuong.get(i).getLuongThuong());
            rows[i][5] = df.format(listLuong.get(i).getCacKhoanTru());
            rows[i][6] = df.format(listLuong.get(i).getThucLanh());
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_luong = new JTable(model);
        func.setUpTable(table_luong);
        func.centerTable(table_luong);
        JScrollPane scrollPane = new JScrollPane(table_luong);
        JPanel jpn_table = new JPanel(new BorderLayout());
        jpn_table.add(scrollPane, BorderLayout.CENTER);
        this.add(jpn_table, BorderLayout.CENTER);
        this.revalidate(); // 👉 cập nhật lại UI
        this.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlabel_look = new javax.swing.JLabel();
        jtf_find = new javax.swing.JTextField();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(482, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlabel_look;
    private javax.swing.JTextField jtf_find;
    // End of variables declaration//GEN-END:variables
}
