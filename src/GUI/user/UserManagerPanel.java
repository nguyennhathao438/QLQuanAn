package GUI.user;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THANH HIEU
 */
import DAO.USerDAO1;
import DTO.User;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class UserManagerPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private USerDAO1 dao = new USerDAO1();

    public UserManagerPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Tài khoản", "Tên", "Vai trò", "Trạng thái"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panelChucNang = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        panelChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));

        JButton btnThem = new JButton("Thêm", new ImageIcon(getClass().getResource("/img/iconthem.png")));
        JButton btnSua  = new JButton("Sửa",  new ImageIcon(getClass().getResource("/img/edit-icon.png")));
        JButton btnXoa  = new JButton("Xoá",  new ImageIcon(getClass().getResource("/img/delete-icon.png")));

        Dimension buttonSize = new Dimension(100, 80);
        for (JButton btn : new JButton[]{btnThem, btnSua, btnXoa}) {
            btn.setPreferredSize(buttonSize);
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(true);
            btn.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            panelChucNang.add(btn);
        }

        btnThem.addActionListener(e -> {
            JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Thêm người dùng", Dialog.ModalityType.APPLICATION_MODAL);
            UserFormPanel form = new UserFormPanel(this, dialog, null);
            dialog.setContentPane(form);
            dialog.pack(); dialog.setLocationRelativeTo(this); dialog.setVisible(true);
        });

        btnSua.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = (int) model.getValueAt(row, 0);
                User user = dao.getUserById(id);
                JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Sửa người dùng", Dialog.ModalityType.APPLICATION_MODAL);
                UserFormPanel form = new UserFormPanel(this, dialog, user);
                dialog.setContentPane(form);
                dialog.pack(); dialog.setLocationRelativeTo(this); dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn người dùng để sửa.");
            }
        });

        btnXoa.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = (int) model.getValueAt(row, 0);
                dao.voHieuHoaUser(id);
                loadUsers();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn người dùng để xoá.");
            }
        });

        add(panelChucNang, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        loadUsers();
    }

    public void loadUsers() {
        model.setRowCount(0);
        List<User> list = dao.getAllUsers();
        for (User u : list) {
           if(u.getTrangThai()!=0) {String trangThaiStr = u.getTrangThai() == 2 ? "Hoạt động" : "Không hoạt động";
            model.addRow(new Object[]{
                u.getId(), u.getTaiKhoan(), u.getTen(), u.getVaiTro(), trangThaiStr
            });}
        }
    }
}

