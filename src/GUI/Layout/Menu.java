/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Layout;

import DAO.PhanQuyenDAL;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import controller.Bean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    PhanQuyenDAL pqDao=new PhanQuyenDAL();
    public Menu() {
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
        ArrayList<String> arrs = pqDao.getDSQuyen("QLNS");

        Map<String, String> menuMap = new LinkedHashMap<>();
        menuMap.put("Q03", "Món ăn");
        menuMap.put("Q01", "Nguyên Liệu");
        menuMap.put("Q04", "Hoá Đơn Nhập Hàng");
        menuMap.put("Q02", "Nhà Cung Cấp");
        menuMap.put("Q07", "Bàn");
        menuMap.put("Q08", "Khách hàng");
        menuMap.put("Q05", "Hóa đơn bán hàng");
        menuMap.put("Q11", "User");
        menuMap.put("Q10", "Chấm công");
        menuMap.put("Q09", "Tính lương");
        menuMap.put("Q06", "Thống kê");
        menuMap.put("Q12", "Phân quyền");
        menuMap.put("Q13", "Công việc");
        menuMap.put("Q14", "Nhân viên");

        
        for (Map.Entry<String, String> entry : menuMap.entrySet()) {
            String maQuyen = entry.getKey();
            String tenQuyen = entry.getValue();

            if (arrs.contains(maQuyen)) {
                JPanel menuItem = createMenuItem(tenQuyen);
                menuItemPanels.add(menuItem);
                sidebarPanel.add(menuItem);
                sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

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

        // ---------- Thêm JScrollPane ở đây ----------
        JScrollPane scrollPane = new JScrollPane(sidebarPanel);
        scrollPane.setPreferredSize(new Dimension(250, 650));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Tùy chọn: ẩn viền của scroll pane cho đẹp
        scrollPane.setBorder(null);
        // Tùy chỉnh thanh cuộn gọn gàng, hiện đại
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

        // Add scroll pane to frame
        this.add(scrollPane, BorderLayout.WEST);
        // ---------------------------------------------

        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    private JPanel createMenuItem(String text) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(190, 30));
        panel.setMaximumSize(new Dimension(190, 120));
        panel.setBackground(Color.ORANGE);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panel.add(label, BorderLayout.CENTER);

        // Hover effect (không đổi nếu đã chọn)
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
                // Reset tất cả panel về cam
                for (JPanel p : menuItemPanels) {
                    p.setBackground(Color.ORANGE);
                }
                // Tô trắng panel được chọn
                panel.setBackground(Color.WHITE);
            }
        });
        return panel;
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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
