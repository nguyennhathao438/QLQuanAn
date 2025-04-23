package GUI.Layout;

import DAO.PhanQuyenDAL;
import DAO.UserDAO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.Bean;
import controller.ChuyenTrang;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author kiman
 */
public class Menu extends javax.swing.JFrame {

    JButton logoutButton;
    JLabel titleLabel;
    JPanel sidebarPanel;
    List<JPanel> menuItemPanels = new ArrayList<>();
    PhanQuyenDAL pqDao = new PhanQuyenDAL();
    HashMap<String, String> mapIcons;
    HashMap<String, String> mapQuyens;
    String maVT = "";
    UserDAO us = new UserDAO();
    public Menu(String maVT) {
        this.maVT = maVT;
        initComponents();
        guiMenu();
        

    }

    public void guiMenu() {
        setTitle("Quản Lí Quán Ăn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 650);
        setLayout(new BorderLayout());

        // Create sidebar panel
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(Color.DARK_GRAY);

        // Top spacing
        sidebarPanel.add(Box.createVerticalStrut(30));

        // Title Label
        titleLabel = new JLabel("QUẢN LÍ QUÁN ĂN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebarPanel.add(titleLabel);

        sidebarPanel.add(Box.createVerticalStrut(30));

        // Danh sách quyền (mô phỏng, bạn nên thay thế phần này theo nhu cầu)
        ArrayList<String> arrs = pqDao.getDSQuyen(maVT);
        mapQuyens = getMapQuyens();
        JPanel jpnView = new JPanel();
        jpnView = new JPanel();
        jpnView.setLayout(new BorderLayout()); // Bạn có thể đổi layout tùy nội dung bên trong
        jpnView.setBackground(Color.WHITE); // Tuỳ chỉnh màu nền

        //Lấy mapIcons
        mapIcons = getMapIcons();

// Thêm panel chính vào giữa
        this.add(jpnView, BorderLayout.CENTER);

        ChuyenTrang ct = new ChuyenTrang(jpnView);
        ct.setTrang(jpnView);
        ArrayList<Bean> menu = new ArrayList<>();
        for (Map.Entry<String, String> entry : mapQuyens.entrySet()) {
            String maQuyen = entry.getKey();
            String tenQuyen = entry.getValue();
            if (arrs.contains(maQuyen)) {
                String iconPath = mapIcons.get(maQuyen);
                JPanel menuItem = createMenuItem(tenQuyen, iconPath);
                menu.add(new Bean(maQuyen, menuItem));
                menuItemPanels.add(menuItem);
                sidebarPanel.add(menuItem);
                sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        ct.setEvent(menu);

        sidebarPanel.add(Box.createVerticalGlue());
        logoutButton = new JButton("Đăng xuất");
        logoutButton.setIcon(new FlatSVGIcon("./resources/icon/logout.svg", 0.3f));
        logoutButton.setPreferredSize(new Dimension(100, 35));
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFocusPainted(false);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sidebarPanel.add(logoutButton);
        sidebarPanel.add(Box.createVerticalStrut(20));
        logoutButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                 us.dangXuat(us.getIDUserLogin());
                 JOptionPane.showMessageDialog(null, "Đăng xuất thành công !");
                 dispose();
    }
});
        // ---------- Thêm JScrollPane ở đây ----------
        JScrollPane scrollPane = new JScrollPane(sidebarPanel);
        scrollPane.setPreferredSize(new Dimension(250, 650));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(180, 180, 180); // màu thanh kéo
                this.trackColor = new Color(60, 60, 60);    // màu nền thanh cuộn
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return invisibleButton();
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return invisibleButton();
            }
            private JButton invisibleButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                button.setVisible(false);
                return button;
            }
            protected Dimension getThumbSize() {
                return new Dimension(8, 40); // độ dày thanh cuộn
            }
        });
        verticalScrollBar.setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
        this.add(scrollPane, BorderLayout.WEST);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private JPanel createMenuItem(String text, String iconPath) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(190, 35));
        panel.setMaximumSize(new Dimension(190, 120));
        panel.setBackground(Color.ORANGE);
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(text);
        label.setIcon(new FlatSVGIcon(iconPath, 0.25f));
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.BLACK);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // 👈 padding left 5px
        panel.add(label, BorderLayout.CENTER);
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!panel.getBackground().equals(Color.WHITE)) {
                    panel.setBackground(new Color(255, 200, 0));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!panel.getBackground().equals(Color.WHITE)) {
                    panel.setBackground(Color.ORANGE);
                }
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                for (JPanel p : menuItemPanels) {
                    p.setBackground(Color.ORANGE);
                }
                panel.setBackground(Color.WHITE);
            }
        });
        return panel;
    }

    public HashMap<String, String> getMapQuyens() {
        HashMap<String, String> quyenMap = new HashMap<>();
        quyenMap.put("Q03", "Món ăn");
        quyenMap.put("Q01", "Nguyên Liệu");
        quyenMap.put("Q04", "Hoá Đơn Nhập Hàng");
        quyenMap.put("Q02", "Nhà Cung Cấp");
        quyenMap.put("Q07", "Bàn");
        quyenMap.put("Q08", "Khách hàng");
        quyenMap.put("Q05", "Hóa đơn bán hàng");
        quyenMap.put("Q11", "Tài khoản");
        quyenMap.put("Q10", "Chấm công");
        quyenMap.put("Q09", "Tính lương");
        quyenMap.put("Q06", "Thống kê");
        quyenMap.put("Q12", "Phân quyền");
        quyenMap.put("Q13", "Công việc");
        quyenMap.put("Q14", "Nhân viên");
        return quyenMap;
    }

    public HashMap<String, String> getMapIcons() {
        HashMap<String, String> iconMap = new HashMap<>();
        iconMap.put("Q03", "./resources/icon/food.svg");
        iconMap.put("Q01", "./resources/icon/ingredient.svg");
        iconMap.put("Q04", "./resources/icon/import.svg");
        iconMap.put("Q02", "./resources/icon/supplier.svg");
        iconMap.put("Q07", "./resources/icon/table.svg");
        iconMap.put("Q08", "./resources/icon/customer.svg");
        iconMap.put("Q05", "./resources/icon/sell.svg");
        iconMap.put("Q11", "./resources/icon/user.svg");
        iconMap.put("Q10", "./resources/icon/attendance.svg");
        iconMap.put("Q09", "./resources/icon/salary.svg");
        iconMap.put("Q06", "./resources/icon/statistics.svg");
        iconMap.put("Q12", "./resources/icon/permission.svg");
        iconMap.put("Q13", "./resources/icon/job.svg");
        iconMap.put("Q14", "./resources/icon/employee.svg");
        return iconMap;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
