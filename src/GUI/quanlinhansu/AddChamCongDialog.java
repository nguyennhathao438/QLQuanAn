/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.quanlinhansu;

import DAO.ChamCongDAO;
import DAO.NhanVienDAO;
import DTO.ChamCongDTO;
import DTO.NhanVienDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class AddChamCongDialog extends javax.swing.JDialog {
    Func_class func = new Func_class();
    JButton[] dayButtons = new JButton[42]; // 6 tuần × 7 ngày
    Map<JButton, String> trangThaiNgay = new HashMap<>();
    JButton btnNghi, btnDiTre, btnTangCa, btnXoa, btnThongKe, btnThem;
    JComboBox<String> combobox_months;
    JComboBox<Integer> combobox_years;
    String currentStatus = "";  // Trạng thái hiện tại (Nghỉ, Đi Trễ, Tăng Ca)
    JTable table_NV;  // Khai báo bảng JTable
    ArrayList<NhanVienDTO> listNV;
    JLabel label_thongtinNV = new JLabel();
    ChamCongPanel chamcongPanel;
    ArrayList<ChamCongDTO> listChamCong;
    JPanel jpanel_thongTinNhanVien, jpanel_buttons_chamCong, jpanel_calendar,jpanel_TangCa_option,jpanel_option;
    JRadioButton rb1h, rb2h, rb3h, rb4h;
    ButtonGroup groupTangCa;
    int gioTangCaDangChon = 1;
    public AddChamCongDialog(java.awt.Frame parent, boolean modal,ChamCongPanel chamcongPanel) {
        super(parent, modal);
        initComponents();
        this.chamcongPanel=chamcongPanel;
        GuiChamCong();
        check_chamCong();
    }

    // Khởi tạo các thành phần cần thiết ở đây (nếu cần)
    private void GuiChamCong() {
        this.setTitle("Chấm công theo lịch tháng");
        this.setSize(800, 600);  // Tăng kích thước để đủ chỗ cho cả calendarPanel và bảng
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- Bảng JTable ---
        createTable();
        create_Jpanel_Right();
        createCombobox();
        createButtonThemThongKe();
    }
    public int getMonthCombobox(){
        int month=combobox_months.getSelectedIndex()+1;
        return month;
    }
    public int getYearCombobox(){
        int year=Integer.parseInt(combobox_years.getSelectedItem().toString());
        return year;
    }
    public int getSelectRowNhanVien(){
        int vitriRow=table_NV.getSelectedRow();
        return vitriRow;
    }
    public int getMaNV(){
        int vitriRow=getSelectRowNhanVien();
        int maNV=Integer.parseInt(table_NV.getValueAt(vitriRow,0).toString());
        return maNV;
    }
    public String getTrangThaiChamCong(){
        int vitriRow=getSelectRowNhanVien();
        if(vitriRow != -1){
            String trangThaiChamCong=table_NV.getValueAt(vitriRow,2).toString();
            return trangThaiChamCong;
        }
        return null;
    }
    private String getThongTinNhanVien() {
        int vitriRow=getSelectRowNhanVien();
        if (vitriRow != -1) {
            int maNV = Integer.parseInt(table_NV.getValueAt(vitriRow, 0).toString());
            String tenNV = table_NV.getValueAt(vitriRow, 1).toString();
            return maNV + " : " + tenNV;
        }
        return null;
    }
    public void check_chamCong() {
        listChamCong = new ChamCongDAO().listChamCong();
        listNV = new NhanVienDAO().listNV();
        int selectMonth = getMonthCombobox();
        int selectYear = getYearCombobox();
        for(int row=0;row<table_NV.getRowCount();row++){
            table_NV.setValueAt("Chưa chấm công",row,2);
        }
        for (int i = 0; i < listChamCong.size(); i++) {
            int maNVChamCong = listChamCong.get(i).getMaNV();
            int thangChamCong = listChamCong.get(i).getThangChamCong();
            int namChamCong = listChamCong.get(i).getNamChamCong();
            if (thangChamCong == selectMonth && namChamCong == selectYear) {
                // Duyệt table để tìm đúng dòng
                for (int row = 0; row < table_NV.getRowCount(); row++) {
                    int maNVTable = Integer.parseInt(table_NV.getValueAt(row, 0).toString());
                    if (maNVTable == maNVChamCong) {
                        table_NV.setValueAt("Đã chấm công", row, 2);
                        break;
                    }
                }
            }
        }
    }
    public void hienThiChiTietChamCong(String chiTiet, int thang, int nam) {
        // Reset lịch trước
        for (JButton btn : dayButtons) {
            btn.setBackground(Color.WHITE);
            btn.setEnabled(false);
            trangThaiNgay.remove(btn);
        }
        hienThiLichThang(thang, nam); // Hiển thị lại lịch
        // Tách chi tiết theo dòng
        String[] dongChiTiet = chiTiet.split("\n");
        for (String dong : dongChiTiet) {
            if (dong.trim().isEmpty()) {
                continue;
            }
            try {
                // Tách ngày và trạng thái
                String[] parts = dong.split(": ");
                String ngayStr = parts[0]; // 09/04/2025
                String trangThai = parts[1].trim(); // Nghỉ, Đi trễ, Tăng ca

                // Lấy ngày
                LocalDate ngay = LocalDate.parse(ngayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int day = ngay.getDayOfMonth();

                // Tìm nút tương ứng trên lịch
                for (JButton btn : dayButtons) {
                    if(btn.getText().contains(String.valueOf(day))) {
                        btn.setBackground(getColorForStatus(trangThai));
                        trangThaiNgay.put(btn, trangThai);
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Lỗi parse chi tiết: " + dong);
            }
        }
    }
    
//    -------------------------------CÁC HÀM XỬ LÝ CỦA JCALENDER PHÍA BÊN PHẢI------------------------
    public void xuLyKhiChonNhanVien() {
        String thongTinNV = getThongTinNhanVien();
        label_thongtinNV.setText(thongTinNV);
        int maNV = getMaNV();
        int selectMonth = getMonthCombobox();
        int selectYear = getYearCombobox();
        String trangThaiChamCong = getTrangThaiChamCong();
        if (trangThaiChamCong.equals("Đã chấm công")) {
            ChamCongDTO cc = new ChamCongDAO().getChamCongTheoThangNam(maNV, selectMonth, selectYear);
            if (cc != null) {
                if (!currentStatus.isEmpty()) {
                    currentStatus = "";
                    resetTrangThaiButtonColors();
                }
                hienThiChiTietChamCong(cc.getChiTiet(),selectMonth,selectYear);
            }
        } else {
            if (!currentStatus.isEmpty()) {
                currentStatus = "";
                resetTrangThaiButtonColors();
            }
            hienThiLichThang(selectMonth, selectYear);
        }
    }
    //Tô màu cho các button nghỉ, button đi trễ, button tăng ca, button xóa
    private void resetTrangThaiButtonColors() {
        btnNghi.setBackground(currentStatus.equals("Nghỉ") ? Color.RED : Color.WHITE);
        btnDiTre.setBackground(currentStatus.equals("Đi trễ") ? Color.YELLOW : Color.WHITE);
        btnTangCa.setBackground(currentStatus.equals("Tăng ca") ? Color.CYAN : Color.WHITE);
        btnXoa.setBackground(currentStatus.equals("Xóa") ? Color.GREEN : Color.WHITE); // Xóa trạng thái
    }
    public void create_JPanel_thongTinNhanVien(){
        jpanel_thongTinNhanVien = new JPanel(new FlowLayout(FlowLayout.CENTER));
        label_thongtinNV = new JLabel("Thông tin nhân viên"); // Khởi tạo label
        label_thongtinNV.setFont(new Font("Arial", Font.BOLD, 15));
        jpanel_thongTinNhanVien.add(label_thongtinNV); // Chỉ add một lần
        table_NV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    xuLyKhiChonNhanVien();
                }
            }
        });
    }
    public void create_JPanel_buttons_chamCong() {
        //Khung chứa các button
        btnNghi = new JButton("Nghỉ");
        btnDiTre = new JButton("Đi trễ");
        btnTangCa = new JButton("Tăng ca");
        btnXoa = new JButton("Xóa");
        btnNghi.setFocusPainted(false);
        btnDiTre.setFocusPainted(false);
        btnTangCa.setFocusPainted(false);
        btnXoa.setFocusPainted(false);
        jpanel_option = new JPanel();
        jpanel_option.setLayout(new BorderLayout());
        jpanel_buttons_chamCong = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        jpanel_buttons_chamCong.add(btnNghi);
        jpanel_buttons_chamCong.add(btnDiTre);
        jpanel_buttons_chamCong.add(btnTangCa);
        jpanel_buttons_chamCong.add(btnXoa);
        btnNghi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStatus = "Nghỉ";
                anRadioTangCa();
                resetTrangThaiButtonColors();
            }
        });
        btnDiTre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStatus = "Đi trễ";
                anRadioTangCa();
                resetTrangThaiButtonColors();
            }
        });
        btnTangCa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStatus = "Tăng ca";
                hienThiRadioTangCa();
                resetTrangThaiButtonColors();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStatus = "Xóa";
                anRadioTangCa();
                resetTrangThaiButtonColors();
            }
        });
        jpanel_option.add(jpanel_buttons_chamCong,BorderLayout.CENTER);
    }
    private void hienThiRadioTangCa() {
        if (jpanel_TangCa_option == null) {
            jpanel_TangCa_option = new JPanel(new FlowLayout(FlowLayout.CENTER));
            rb1h = new JRadioButton("1 giờ");
            rb2h = new JRadioButton("2 giờ");
            rb3h = new JRadioButton("3 giờ");
            rb4h = new JRadioButton("4 giờ");
            groupTangCa = new ButtonGroup();
            groupTangCa.add(rb1h);
            groupTangCa.add(rb2h);
            groupTangCa.add(rb3h);
            groupTangCa.add(rb4h);
            rb1h.setSelected(true); // Mặc định chọn 1h
            ActionListener radioListener = e -> {
                if (rb1h.isSelected()) {
                    gioTangCaDangChon = 1;
                } else if (rb2h.isSelected()) {
                    gioTangCaDangChon = 2;
                } else if (rb3h.isSelected()) {
                    gioTangCaDangChon = 3;
                } else if (rb4h.isSelected()) {
                    gioTangCaDangChon = 4;
                }
            };
            jpanel_TangCa_option.add(rb1h);
            jpanel_TangCa_option.add(rb2h);
            jpanel_TangCa_option.add(rb3h);
            jpanel_TangCa_option.add(rb4h);
            rb1h.addActionListener(radioListener);
            rb2h.addActionListener(radioListener);
            rb3h.addActionListener(radioListener);
            rb4h.addActionListener(radioListener);
            jpanel_option.add(jpanel_TangCa_option, BorderLayout.NORTH);
            this.revalidate();
            this.repaint();
        } else {
            jpanel_TangCa_option.setVisible(true);
        }
    }

    private void anRadioTangCa() {
        if (jpanel_TangCa_option != null) {
            jpanel_TangCa_option.setVisible(false);
        }
    }
    public  void create_JPanel_Jcalender(){
        jpanel_calendar = new JPanel(new GridLayout(6, 7, 5, 5));
        for (int i = 0; i < 42; i++) {
            JButton btn = new JButton();
            btn.setFocusPainted(false);
            btn.setFont(new Font("Arial", Font.PLAIN, 10));  // Font nhỏ
            btn.setBackground(Color.WHITE);
            btn.setOpaque(true);
            btn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            btn.addActionListener(e -> toMauSelected(btn)); // Chọn màu khi nút được nhấn
            dayButtons[i] = btn;
            jpanel_calendar.add(btn);
        }
    }
    public void create_Jpanel_Right() {
        JPanel panel_right = new JPanel(new BorderLayout());
        create_JPanel_thongTinNhanVien();
        create_JPanel_Jcalender();
        create_JPanel_buttons_chamCong();
        panel_right.add(jpanel_thongTinNhanVien, BorderLayout.NORTH);
        panel_right.add(jpanel_calendar,BorderLayout.CENTER);
        panel_right.add(jpanel_option,BorderLayout.SOUTH);
        this.add(panel_right,BorderLayout.CENTER);
    }
    
    
    //------------------HÀM TẠO COMBOBOX THÁNG NĂM PHÍA BÊN TRÊN------------------
    public void createCombobox(){
        JPanel panel_top=new JPanel(new BorderLayout());
        LocalDate homNay = LocalDate.now();
        hienThiLichThang(homNay.getMonthValue(), homNay.getYear());
        String[] months={"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        Integer[] years={2020,2021,2022,2023,2024,2025,2026,2027};
        combobox_months=new JComboBox<>(months);
        combobox_years=new JComboBox<>(years);
        func.setUpComBoBox(combobox_years);
        func.setUpComBoBox(combobox_months);
        LocalDate time=LocalDate.now();
        combobox_months.setSelectedIndex(time.getMonthValue()-1);
        combobox_years.setSelectedItem(time.getYear());
        JPanel panel_combobox_date=new JPanel();
        panel_combobox_date.add(combobox_months);
        panel_combobox_date.add(combobox_years);
        panel_top.add(panel_combobox_date,BorderLayout.CENTER);
        panel_top.setPreferredSize(new Dimension(800,60));
        this.add(panel_top,BorderLayout.NORTH);
        ActionListener comboBoxListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectMonth = combobox_months.getSelectedIndex()+1;
                int selectYear=(int) combobox_years.getSelectedItem();
                currentStatus="";
                check_chamCong();
                hienThiLichThang(selectMonth,selectYear);
            }
        };
        combobox_months.addActionListener(comboBoxListener);
        combobox_years.addActionListener(comboBoxListener);
    }
    //------------------HÀM TẠO BẢNG NHÂN VIÊN PHÍA BÊN TRÁI----------------------------
    public void createTable(){
        listNV=new NhanVienDAO().listNV();
        String[] colNames={"Mã NV","Tên NV","Trạng thái"};
        Object[][] rows=new Object[listNV.size()][colNames.length];
        for(int i=0;i<listNV.size();i++){
            rows[i][0]=listNV.get(i).getMaNV();
            rows[i][1]=listNV.get(i).getHoTen();
            rows[i][2]="Chưa chấm công";
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table_NV=new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table_NV);
         func.setUpTable(table_NV,scrollPane);
        func.centerTable(table_NV);
        JPanel jpn_table=new JPanel(new BorderLayout());
        jpn_table.add(scrollPane,BorderLayout.CENTER);
        this.add(jpn_table,BorderLayout.WEST);
    }
    
    //Hàm tạo button thêm và thống kê phía bên dưới
    public void createButtonThemThongKe(){
        JPanel panel_bottom=new JPanel(new FlowLayout());
        btnThem=new JButton("Thêm chấm công");
        btnThongKe=new JButton("Thống kê");
        func.setUpBtnTwo(btnThem,Color.GREEN,Color.GREEN,new Color(211,218,211),14);
        func.setUpBtnTwo(btnThongKe,Color.CYAN,Color.CYAN,new Color(211,218,211),14);
        btnThongKe.setFocusPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setPreferredSize(new Dimension(150,40));
        btnThongKe.setPreferredSize(new Dimension(130,40));
        panel_bottom.add(btnThem);
        panel_bottom.add(btnThongKe);
        thongKeClick();
        themChamCongClick();
        this.add(panel_bottom,BorderLayout.SOUTH);
    }
    public void thongKeClick(){
        btnThongKe.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               int vitriRow=table_NV.getSelectedRow();
               if(vitriRow==-1){
                   JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhân viên để xem thống kê","Error",0);
                   return;
               }
               thongKeChamCong();
           }
        });
    }
    //Hàm xử lí khi nhấn nút thêm chấm công
    public void themChamCongClick() {
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vitriRow = getSelectRowNhanVien();
                if (vitriRow == -1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để chấm công", "Error", 0);
                    return;
                }
                int maNV = getMaNV();
                int selectMonth = getMonthCombobox();
                int selectYear = getYearCombobox();
                ChamCongDTO chamCong = new ChamCongDAO().getChamCongTheoThangNam(maNV, selectMonth, selectYear);
                if (chamCong != null) {
                    JOptionPane.showMessageDialog(null, "Nhân viên đã được chấm công vào tháng này", "Error", 0);
                    currentStatus = "";
                    resetTrangThaiButtonColors();
                    hienThiChiTietChamCong(chamCong.getChiTiet(), selectMonth, selectYear);
                    return;
                }
                int nghi = 0, diTre = 0, tangCa = 0;
                StringBuilder chiTiet = new StringBuilder();
                for (JButton btn : dayButtons) {
                    if (btn.isEnabled() && trangThaiNgay.containsKey(btn)) {
                        String status = trangThaiNgay.get(btn);
                        String ngay = getNgayThangNam(btn.getText(), selectMonth, selectYear); // tự viết hàm này
                        chiTiet.append(ngay).append(": ").append(status).append("\n");
                        if (status.equals("Nghỉ")) {
                            nghi++;
                        } else if (status.equals("Đi trễ")) {
                            diTre++;
                        } else if (status.startsWith("Tăng ca")) {
                            String[] parts = status.split("-");
                            String gioStr = parts[1].trim().replaceAll("giờ", "").trim();
                            int gio = Integer.parseInt(gioStr);
                            tangCa += gio;
                        }
                    }
                }
                int tongNgay = (int) Arrays.stream(dayButtons).filter(JButton::isEnabled).count();
                int diLam = tongNgay - nghi;
                int conFirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc sẽ chấm công cho nhân viên vào tháng này?", "Thêm chấm công", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (conFirm == JOptionPane.YES_OPTION) {
                    chamCong = new ChamCongDTO(maNV, selectMonth, selectYear, diLam, nghi, diTre, tangCa, chiTiet.toString(), "Đã chấm công");
                    int thanhCong = new ChamCongDAO().insertChamCong(chamCong);
                    currentStatus = "";
                    resetTrangThaiButtonColors();
                    if (thanhCong == 1) {
                        table_NV.setValueAt("Đã chấm công", vitriRow, 2);
                    }
                    chamcongPanel.resetTableChamCong();
                }
            }
        });
    }

    //Hàm lấy ngày tháng năm chi tiết chấm công trong database(ví dụ : 02/03/2005: Đi trễ)
    private String getNgayThangNam(String htmlText, int thang, int nam) {
        try {
            // Loại bỏ thẻ HTML, sau đó tách theo dấu xuống dòng hoặc dấu cách
            String stripped = htmlText.replaceAll("<[^>]+>", "").trim(); // "2Hai"
            // Tách thành ngày và thứ bằng cách tách theo chữ cái
            StringBuilder numberPart = new StringBuilder();
            for (char ch : stripped.toCharArray()) {
                if (Character.isDigit(ch)) {
                    numberPart.append(ch);
                } else {
                    break;
                }
            }
            int ngay = Integer.parseInt(numberPart.toString());
            return String.format("%02d/%02d/%d", ngay, thang, nam);
        } catch (Exception e) {
            return "??/??/????";
        }
    }
    //Hàm hiển thị lịch khi khởi tạo, khi thay đổi combobox tháng năm
    private void hienThiLichThang(int thang, int nam) {
        LocalDate firstDay = LocalDate.of(nam, thang, 1);
        int startDayOfWeek = firstDay.getDayOfWeek().getValue(); // 1 (Mon) - 7 (Sun)
        int daysInMonth = firstDay.lengthOfMonth();
        // Reset tất cả nút
        for (JButton btn : dayButtons) {
            btn.setText("");
            btn.setEnabled(false);
            btn.setBackground(Color.WHITE);
        }
        int startIndex = (startDayOfWeek % 7); // CN = 0
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate current = LocalDate.of(nam, thang, day);
            DayOfWeek dow = current.getDayOfWeek();
            String thu = getThuVietnam(dow);
            JButton btn = dayButtons[startIndex++];
            btn.setText("<html><center>" + day + "<br>" + thu +"</center></html>");
            btn.setEnabled(true);
            if (btn != null && !btn.getText().isEmpty()) {
                if (!currentStatus.isEmpty()) {
                    btn.setBackground(getColorForStatus(currentStatus));  // Thay đổi màu sắc theo trạng thái
                    trangThaiNgay.put(btn, currentStatus);  // Lưu trạng thái vào map
                } else {
                    btn.setBackground(Color.WHITE);
                    trangThaiNgay.remove(btn);  // Xóa trạng thái
                }
            }
        }
    }
    private int getSoGioTangCa() {
        if (rb1h.isSelected()) {
            return 1;
        }
        if (rb2h.isSelected()) {
            return 2;
        }
        if (rb3h.isSelected()) {
            return 3;
        }
        if (rb4h.isSelected()) {
            return 4;
        }
        return 1; // mặc định là 1 giờ nếu chưa chọn
    }
    
    //Tô màu khi nhấn vào button calendar,thay đổi text theo trạng thái currentStatus
    private void toMauSelected(JButton btn) {
        if(currentStatus.equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn trạng thái chấm công","Error",0);
            return;
        }
        int vitriRow=table_NV.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhân viên để chấm công","Error",0);
            return;
        }
        String text = btn.getText(); //text trong button có dạng :<html><center>day<br><thu></center></html>
        String[] parts = text.split("<br>");
        String ngayStr = parts[0].replaceAll("<html><center>", "");
        String thu = parts[1].replaceAll("</center></html>", "");
        if (currentStatus.equals("Nghỉ")) {
            btn.setBackground(getColorForStatus("Nghỉ"));
            btn.setText("<html><center>" + ngayStr + "<br>" + thu + "<br>" +"Nghỉ"+ "</center></html>");
            trangThaiNgay.put(btn, currentStatus);
        } else if (currentStatus.equals("Đi trễ")) {
            btn.setBackground(getColorForStatus("Đi trễ"));
            btn.setText("<html><center>" + ngayStr + "<br>" + thu + "<br>" +"Đi trễ"+ "</center></html>");
            trangThaiNgay.put(btn, currentStatus);
        } else if (currentStatus.equals("Tăng ca")) {
            btn.setBackground(getColorForStatus("Tăng ca"));
            int soGio = getSoGioTangCa();
            String trangThaiChamCong = "Tăng ca";
            String gioTangCa = "<br>" + soGio + " giờ";
            trangThaiNgay.put(btn, currentStatus + " - " + soGio + " giờ");
            btn.setText("<html><center>" + ngayStr + "<br>" + thu + "<br>" + trangThaiChamCong + gioTangCa + "</center></html>");
        } else {
            btn.setBackground(Color.WHITE);
            trangThaiNgay.remove(btn);
            btn.setText("<html><center>" + ngayStr + "<br>" + thu + "</center></html>");
        }
    }
    
    private String getTextForStatus(String status){
        switch (status) {
            case "Nghỉ":
                return "Nghỉ";
            case "Đi trễ":
                return "Đi trễ";
            case "Tăng ca":
                return "Tăng ca";
            default:
                return "";
        }
    }
    private Color getColorForStatus(String status) {
        if (status.equals("Nghỉ")) {
            return Color.RED;
        } else if (status.equals("Đi trễ")) {
            return Color.YELLOW;
        } else if (status.startsWith("Tăng ca")) {
            return Color.CYAN;
        } else {
            return Color.WHITE;
        }
    }
    //Thống kê nghỉ , đi trễ, nghỉ bao nhiêu
    private void thongKeChamCong() {
        int nghi = 0, diTre = 0, tangCa = 0;
        for (String status : trangThaiNgay.values()) {
            System.out.println("Trang thai : "+ status);
            if (status.equals("Nghỉ")) {
                nghi++;
            } else if (status.equals("Đi trễ")) {
                diTre++;
            }
            else{
                String[] parts= status.split("-");
                int time = Integer.parseInt(parts[1].replaceAll("giờ","").trim());
                tangCa+=time;
            }
        }
        int tongNgay = 0;
        for (JButton btn : dayButtons) {
            if (btn.isEnabled()) {
                tongNgay++;
            }
        }
        int diLam = tongNgay - nghi;
        String msg = String.format(
                "Thống kê chấm công:\n- Ngày đi làm: %d ngày\n- Nghỉ: %d ngày \n- Đi trễ: %d ngày \n- Tăng ca: %d giờ",
                diLam, nghi, diTre, tangCa
        );
        JOptionPane.showMessageDialog(this, msg, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }

    private String getThuVietnam(DayOfWeek dow) {
        switch (dow) {
            case MONDAY:
                return "Hai";
            case TUESDAY:
                return "Ba";
            case WEDNESDAY:
                return "Tư";
            case THURSDAY:
                return "Năm";
            case FRIDAY:
                return "Sáu";
            case SATURDAY:
                return "Bảy";
            case SUNDAY:
                return "CN";
            default:
                return "";
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
