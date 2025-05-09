
package GUI.quankho;

import DAO.NLNhapDAO;
import DAO.SellMonAnDAO;
import DAO.ThongKeDAO;
import DTO.NLNhapDTO;
import DTO.SellMonAnDTO;
import DTO.ThongKeThuChi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import util.Func_class;

public class ThongKeJPanel extends javax.swing.JPanel {

    ThongKeDAO kn = new ThongKeDAO();
    NLNhapDAO nl = new NLNhapDAO();
    SellMonAnDAO ma = new SellMonAnDAO();
    Func_class func = new Func_class();
    public ThongKeJPanel() {
        initComponents();
        setThongKeThang("2024");
        func.setUpComBoBox(nam);
        func.setUpComBoBox(thangQuy);
        func.setUpComBoBox(loaiThongKe);
        func.setUpBtnTwo(seenBD, Color.CYAN, Color.CYAN,new Color(211,218,211),14);
    }
    public void setThongKeThang(String year) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeThuChi> dstkthu = kn.thongKeThuThang(year);
        ArrayList<ThongKeThuChi> dstkchi = kn.thongKeChiThang(year);
        for (ThongKeThuChi a : dstkthu) {
            dataset.addValue(a.getSoTien(), "Thu", String.valueOf(a.getThoiGian()));
        }
        for (ThongKeThuChi a : dstkchi) {
            dataset.addValue(a.getSoTien(), "Chi", String.valueOf(a.getThoiGian()));
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê nhập bán hàng",
                "Tháng",
                "Số tiền",
                dataset
        );
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.05);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(678, 441));

        pnThongKe.removeAll();

        pnThongKe.setLayout(new BorderLayout());
        pnThongKe.add(chartPanel, BorderLayout.CENTER);
        pnThongKe.validate();
    }

    public void setThongKeLuongThang(String year) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeThuChi> dstkluong = kn.thongKeLuongThang(year);
        for (ThongKeThuChi a : dstkluong) {
            dataset.addValue(a.getSoTien(), "Tiền trả lương", String.valueOf(a.getThoiGian()));
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê lương nhân viên",
                "Tháng",
                "Số tiền",
                dataset
        );
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.05);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(678, 441));

        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());
        pnThongKe.add(chartPanel, BorderLayout.CENTER);
        pnThongKe.validate();
    }
    public void setThongKeLuongQuy(String year) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeThuChi> dstkluong = kn.thongKeLuongQuy(year);
        for (ThongKeThuChi a : dstkluong) {
            dataset.addValue(a.getSoTien(), "Tiền trả lương", String.valueOf(a.getThoiGian()));
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê lương nhân viên",
                "Quý",
                "Số tiền",
                dataset
        );
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.05);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(678, 441));

        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());
        pnThongKe.add(chartPanel, BorderLayout.CENTER);
        pnThongKe.validate();
    }
    public void setThongKeQuy(String year) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeThuChi> dstkthu = kn.thongKeThuQuy(year);
        ArrayList<ThongKeThuChi> dstkchi = kn.thongKeChiQuy(year);
        for (ThongKeThuChi a : dstkthu) {
            dataset.addValue(a.getSoTien(), "Thu", "Quý " + a.getThoiGian());
        }
        for (ThongKeThuChi a : dstkchi) {
            dataset.addValue(a.getSoTien(), "Chi", "Quý " + a.getThoiGian());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê nhập bán hàng",
                "Quý",
                "Số tiền",
                dataset
        );
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.05);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(678, 441));

        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());
        pnThongKe.add(chartPanel, BorderLayout.CENTER);
        pnThongKe.validate();
    }

    public void setThongKeDoanhThuThang(String year) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeThuChi> dstkdt = kn.thongKeDoanhThuThang(year);
        for (ThongKeThuChi a : dstkdt) {
            dataset.addValue(a.getSoTien(), "Doanh thu", String.valueOf(a.getThoiGian()));
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê tổng doanh thu quán ăn",
                "Tháng",
                "Số tiền",
                dataset
        );
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.05);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(678, 441));

        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());
        pnThongKe.add(chartPanel, BorderLayout.CENTER);
        pnThongKe.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        thangQuy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nam = new javax.swing.JComboBox<>();
        seenBD = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        loaiThongKe = new javax.swing.JComboBox<>();
        pnThongKe = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        thangQuy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tháng", "quý" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Thời gian");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Năm");

        nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025" }));

        seenBD.setText("Xem biểu đồ");
        seenBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seenBDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Thống kê theo");

        loaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhập bán hàng", "Lương nhân viên", "Doanh thu", "Nguyên liệu nhập", "Món ăn bán chạy" }));
        loaiThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seenBD)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(loaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(thangQuy, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thangQuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addComponent(seenBD, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnThongKeLayout = new javax.swing.GroupLayout(pnThongKe);
        pnThongKe.setLayout(pnThongKeLayout);
        pnThongKeLayout.setHorizontalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnThongKeLayout.setVerticalGroup(
            pnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
public void setThongKeNLThang(String year) {
        // Lấy dữ liệu từ DAO
        ArrayList<NLNhapDTO> nln = nl.getTKMonth(year);
        ArrayList<NLNhapDTO> originalData = new ArrayList<>(nln); // Lưu dữ liệu gốc

        // Cột của bảng
        String[] columnNames = {"Tháng", "Mã NL", "Tên NL", "Loại NL", "Số lượng", "Tổng tiền"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Đổ dữ liệu ban đầu
        for (NLNhapDTO a : nln) {
            Object[] rowData = {
                "Tháng " + a.getNgayNhap(),
                a.getMaNL(),
                a.getTenNL(),
                a.getLoaiNL(),
                a.getSoluong(),
                a.getGia()
            };
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        func.centerTable(table);
        func.setUpTable(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(678, 441));

        // Hiển thị bảng
        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());

        JButton btnTop5 = new JButton("Top 5 theo Tháng/Quý");
        func.setUpBtnTwo(btnTop5, Color.WHITE, Color.WHITE,new Color(211,218,211),14);
        pnThongKe.add(btnTop5, BorderLayout.NORTH);
        pnThongKe.add(scrollPane, BorderLayout.CENTER);
        pnThongKe.validate();
        pnThongKe.repaint();

        // Cờ theo dõi trạng thái
        final boolean[] isTop5 = {false};

        // Gắn sự kiện cho nút
        btnTop5.addActionListener(e -> {
            DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);
            if (!isTop5[0]) {
                // Chuyển sang chế độ top 5

                nln.sort((a, b) -> Double.compare(b.getSoluong(), a.getSoluong()));
                List<NLNhapDTO> top5 = nln.stream().limit(5).toList();

                for (NLNhapDTO a : top5) {
                    newModel.addRow(new Object[]{
                        "Tháng " + a.getNgayNhap(),
                        a.getMaNL(),
                        a.getTenNL(),
                        a.getLoaiNL(),
                        a.getSoluong(),
                        a.getGia()
                    });
                }

                btnTop5.setText("Hiển thị tất cả");
                isTop5[0] = true;
            } else {
                // Quay lại hiển thị đầy đủ
                for (NLNhapDTO a : originalData) {
                    newModel.addRow(new Object[]{
                        "Tháng " + a.getNgayNhap(),
                        a.getMaNL(),
                        a.getTenNL(),
                        a.getLoaiNL(),
                        a.getSoluong(),
                        a.getGia()
                    });
                }

                btnTop5.setText("Top 5 theo Tháng/Quý");
                isTop5[0] = false;
            }

            table.setModel(newModel); // Cập nhật model mới
            func.centerTable(table);
            func.setUpTable(table);
        });
    }
    public void setThongKeNLQuy(String year) {
        // Lấy dữ liệu từ DAO
        ArrayList<NLNhapDTO> nln = nl.getTKQuy(year);
        ArrayList<NLNhapDTO> originalData = new ArrayList<>(nln); // Lưu dữ liệu gốc

        // Cột của bảng
        String[] columnNames = {"Tháng", "Mã NL", "Tên NL", "Loại NL", "Số lượng", "Tổng tiền"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Đổ dữ liệu ban đầu
        for (NLNhapDTO a : nln) {
            Object[] rowData = {
                "Quý " + a.getNgayNhap(),
                a.getMaNL(),
                a.getTenNL(),
                a.getLoaiNL(),
                a.getSoluong(),
                a.getGia()
            };
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        func.centerTable(table);
        func.setUpTable(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(678, 441));

        // Hiển thị bảng
        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());

        JButton btnTop5 = new JButton("Top 5 theo Tháng/Quý");
        func.setUpBtnTwo(btnTop5, Color.WHITE, Color.WHITE, new Color(211,218,211),14);
        pnThongKe.add(btnTop5, BorderLayout.NORTH);
        pnThongKe.add(scrollPane, BorderLayout.CENTER);
        pnThongKe.validate();
        pnThongKe.repaint();

        // Cờ theo dõi trạng thái
        final boolean[] isTop5 = {false};

        // Gắn sự kiện cho nút
        btnTop5.addActionListener(e -> {
            DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);
            if (!isTop5[0]) {
                // Chuyển sang chế độ top 5

                nln.sort((a, b) -> Double.compare(b.getSoluong(), a.getSoluong()));
                List<NLNhapDTO> top5 = nln.stream().limit(5).toList();

                for (NLNhapDTO a : top5) {
                    newModel.addRow(new Object[]{
                        "Quý " + a.getNgayNhap(),
                        a.getMaNL(),
                        a.getTenNL(),
                        a.getLoaiNL(),
                        a.getSoluong(),
                        a.getGia()
                    });
                }

                btnTop5.setText("Hiển thị tất cả");
                isTop5[0] = true;
            } else {
                // Quay lại hiển thị đầy đủ
                for (NLNhapDTO a : originalData) {
                    newModel.addRow(new Object[]{
                        "Quý " + a.getNgayNhap(),
                        a.getMaNL(),
                        a.getTenNL(),
                        a.getLoaiNL(),
                        a.getSoluong(),
                        a.getGia()
                    });
                }

                btnTop5.setText("Top 5 theo Tháng/Quý");
                isTop5[0] = false;
            }

            table.setModel(newModel); // Cập nhật model mới
            func.centerTable(table);
            func.setUpTable(table);
        });
    }

     
    public void setThongKeMAThang(String year) {
        // Lấy dữ liệu từ DAO
        ArrayList<SellMonAnDTO> nln = ma.getMAMonth(year);
        ArrayList<SellMonAnDTO> originalData = new ArrayList<>(nln); // Lưu dữ liệu gốc

        // Tạo cột cho bảng
        String[] columnNames = {"Tháng", "Mã MA", "Tên MA", "Loại MA", "Số lượng"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Đổ dữ liệu vào bảng
        for (SellMonAnDTO a : nln) {
            Object[] rowData = {
                "Tháng " + a.getTime(),
                a.getMaMA(),
                a.getTenMA(),
                a.getLoaiMA(),
                a.getSoLuong(),};
            model.addRow(rowData);
        }

        // Tạo JTable và đặt trong JScrollPane
        JTable table = new JTable(model);
        func.centerTable(table);
        func.setUpTable(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(678, 441));

        // Hiển thị bảng trong panel
        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());

        JButton btnTop5 = new JButton("Top 5 theo Tháng");
        func.setUpBtnTwo(btnTop5, Color.WHITE, Color.WHITE, new Color(211,218,211),14);
        pnThongKe.add(btnTop5, BorderLayout.NORTH);
        pnThongKe.add(scrollPane, BorderLayout.CENTER);
        pnThongKe.validate();
        pnThongKe.repaint();
        // Cờ theo dõi trạng thái
        final boolean[] isTop5 = {false};
        btnTop5.addActionListener(e -> {
            DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);
            if (!isTop5[0]) {
                // Chuyển sang chế độ top 5
                nln.sort((a, b) -> Integer.compare(b.getSoLuong(), a.getSoLuong()));  // Sắp xếp theo số lượng
                List<SellMonAnDTO> top5 = nln.stream().limit(5).toList();
                for (SellMonAnDTO a : top5) {
                    newModel.addRow(new Object[]{
                        "Tháng " + a.getTime(),
                        a.getMaMA(),
                        a.getTenMA(),
                        a.getLoaiMA(),
                        a.getSoLuong(),});
                }
                btnTop5.setText("Hiển thị tất cả");
                isTop5[0] = true;
            } else {
                // Quay lại hiển thị đầy đủ
                for (SellMonAnDTO a : originalData) {
                    newModel.addRow(new Object[]{
                        "Tháng " + a.getTime(),
                        a.getMaMA(),
                        a.getTenMA(),
                        a.getLoaiMA(),
                        a.getSoLuong(),});
                }
                btnTop5.setText("Top 5 theo Tháng");
                isTop5[0] = false;
            }
            table.setModel(newModel); // Cập nhật model mới
            func.centerTable(table);
            func.setUpTable(table);
        });
    }

    public void setThongKeMAQuy(String year) {
        // Lấy dữ liệu từ DAO
        ArrayList<SellMonAnDTO> nln = ma.getMAQuy(year);
        ArrayList<SellMonAnDTO> originalData = new ArrayList<>(nln); // Lưu dữ liệu gốc

        // Tạo cột cho bảng
        String[] columnNames = {"Quý", "Mã MA", "Tên MA", "Loại MA", "Số lượng"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Đổ dữ liệu vào bảng
        for (SellMonAnDTO a : nln) {
            Object[] rowData = {
                "Quý " + a.getTime(),
                a.getMaMA(),
                a.getTenMA(),
                a.getLoaiMA(),
                a.getSoLuong(),};
            model.addRow(rowData);
        }
        
        // Tạo JTable và đặt trong JScrollPane
        JTable table = new JTable(model);
        func.centerTable(table);
        func.setUpTable(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(678, 441));

        // Hiển thị bảng trong panel
        pnThongKe.removeAll();
        pnThongKe.setLayout(new BorderLayout());

        JButton btnTop5 = new JButton("Top 5 theo Quý");
        func.setUpBtnTwo(btnTop5, Color.WHITE, Color.WHITE, new Color(211,218,211),14);
        pnThongKe.add(btnTop5, BorderLayout.NORTH);
        pnThongKe.add(scrollPane, BorderLayout.CENTER);
        pnThongKe.validate();
        pnThongKe.repaint();

        // Cờ theo dõi trạng thái
        final boolean[] isTop5 = {false};

        // Gắn sự kiện cho nút
        btnTop5.addActionListener(e -> {
            DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);
            if (!isTop5[0]) {
                // Chuyển sang chế độ top 5
                nln.sort((a, b) -> Integer.compare(b.getSoLuong(), a.getSoLuong()));  // Sắp xếp theo số lượng
                List<SellMonAnDTO> top5 = nln.stream().limit(5).toList();

                for (SellMonAnDTO a : top5) {
                    newModel.addRow(new Object[]{
                        "Quý " + a.getTime(),
                        a.getMaMA(),
                        a.getTenMA(),
                        a.getLoaiMA(),
                        a.getSoLuong(),});
                }

                btnTop5.setText("Hiển thị tất cả");
                isTop5[0] = true;
            } else {
                // Quay lại hiển thị đầy đủ
                for (SellMonAnDTO a : originalData) {
                    newModel.addRow(new Object[]{
                        "Quý " + a.getTime(),
                        a.getMaMA(),
                        a.getTenMA(),
                        a.getLoaiMA(),
                        a.getSoLuong(),});
                }

                btnTop5.setText("Top 5 theo Quý");
                isTop5[0] = false;
            }

            table.setModel(newModel); // Cập nhật model mới
            func.centerTable(table);
            func.setUpTable(table);
        });
    }
    private void seenBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seenBDActionPerformed
        String year = (String) nam.getSelectedItem();
        String thoiGian = (String) thangQuy.getSelectedItem();
        int mode = loaiThongKe.getSelectedIndex();
        if (mode == 0) {
            if (thoiGian.equals("tháng")) {
                setThongKeThang(year);
            } else {
                setThongKeQuy(year);
            }
        } else if (mode == 1) {
            if (thoiGian.equals("tháng")) {
                setThongKeLuongThang(year);
            } else {
                setThongKeLuongQuy(year);
            }
            

        } else if (mode == 2) {
            System.out.println("Hello");
            setThongKeDoanhThuThang(year);
        } else if (mode == 3) {
            if (thoiGian.equals("tháng")) {
                setThongKeNLThang(year);
            } else {
                setThongKeNLQuy(year);
            }
        } else if (mode == 4) {
            if (thoiGian.equals("tháng")) {
                setThongKeMAThang(year);
            } else {
                setThongKeMAQuy(year);
            }
        }
        
    }//GEN-LAST:event_seenBDActionPerformed

    private void loaiThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> loaiThongKe;
    private javax.swing.JComboBox<String> nam;
    private javax.swing.JPanel pnThongKe;
    private javax.swing.JButton seenBD;
    private javax.swing.JComboBox<String> thangQuy;
    // End of variables declaration//GEN-END:variables
}
