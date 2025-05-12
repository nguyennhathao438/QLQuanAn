
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
        func.setUpComBoBox(combobox_years);
        func.setUpComBoBox(combobox_months);
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
        label_title.setFont(new Font("Arial",Font.BOLD,16));
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
        for (ChamCongDTO chamcong : listCC) {
            int maBCC = chamcong.getMaBCC();
            if (luongDao.checkLuongExists(maBCC)) {
                continue; // Nếu có, bỏ qua và không tính lại lương
            }
            int maNV = chamcong.getMaNV();
            double luongCoBan = cvDao.getLuongCoBanByMaNV(maNV);
            double phuCap = cvDao.getPhuCap(maNV);
            double heSoLuong = cvDao.getHeSoLuong(maNV);

            int soNgayLamViec = chamcong.getSoNgayLamViec();
            int soNgayNghi = chamcong.getSoNgayNghi();
            int soNgayTre = chamcong.getSoNgayTre();
            int soGioTangCa = chamcong.getSoGioLamThem();

            final int SO_NGAY_CONG_CHUAN = 26;
            final double TIEN_DI_TRE = 45000;
            final double TIEN_TANG_CA = 45000;

            double luongNgay = luongCoBan / SO_NGAY_CONG_CHUAN;
            double luongThucTe = (luongNgay * soNgayLamViec * heSoLuong)+(soGioTangCa*TIEN_TANG_CA)+phuCap;
            double cacKhoanTru = soNgayTre * TIEN_DI_TRE + soNgayNghi * luongNgay;
            double luongThucLanh = luongThucTe - cacKhoanTru;

            LuongDTO luong = new LuongDTO(maBCC, luongThucTe, cacKhoanTru, luongThucLanh);
            luongDao.insertLuong(luong);
        }
        loadDataLuong();
        func.centerTable(table_luong);
    }
    
    public void loadDataLuong() {
        this.removeAll(); // Xóa hết các components cũ trước khi add lại
        this.setLayout(new BorderLayout()); // Reset lại layout
        this.add(jpanel_top, BorderLayout.NORTH); // Thêm jpanel_top vào vị trí NORTH

        int selectMonth = getMonthCombobox();
        int selectYear = getYearCombobox();
        listLuong = luongDao.listLuong(selectMonth, selectYear);

        String[] colNames = {"Mã Lương", "Mã NV-Họ Tên", "Lương Cơ Bản", "Lương Thực Tế","Các Khoản Trừ", "Thực Lãnh"};
        Object[][] rows = new Object[listLuong.size()][colNames.length];
        DecimalFormat df = new DecimalFormat("#,###");

        // Tạo dữ liệu cho bảng
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
            rows[i][4] = df.format(listLuong.get(i).getCacKhoanTru());
            rows[i][5] = df.format(listLuong.get(i).getThucLanh());
        }

        // Tạo bảng và mô hình dữ liệu
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_luong = new JTable(model);

        // Giả sử func.setUpTable sẽ được sử dụng như sau
        func.setUpTable(table_luong, null); // Bạn có thể truyền vào null nếu không cần trực tiếp dùng JScrollPane tại đây

        // Căn giữa cho bảng
        func.centerTable(table_luong);

        // Tạo JScrollPane chứa bảng
        JScrollPane scrollPane = new JScrollPane(table_luong);

        // Tạo JPanel chứa JScrollPane
        JPanel jpn_table = new JPanel(new BorderLayout());
        jpn_table.add(scrollPane, BorderLayout.CENTER);

        // Thêm JPanel chứa bảng vào UI
        this.add(jpn_table, BorderLayout.CENTER);
        this.revalidate(); // Cập nhật lại UI
        this.repaint();

        // Điều chỉnh độ rộng cột
        table_luong.getColumnModel().getColumn(0).setPreferredWidth(45);
        table_luong.getColumnModel().getColumn(1).setPreferredWidth(150);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
