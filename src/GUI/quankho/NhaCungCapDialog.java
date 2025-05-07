/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.quankho;

import DAO.QuanKhoDAO;
import DTO.NHACUNGCAP;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.Func_class;

/**
 *
 * @author THANH HIEU
 */
public class NhaCungCapDialog extends JDialog {
    Func_class func=new Func_class();
    private JTextField txtMaNCC, txtTenNCC, txtSDT;
    private JButton btnLuu, btnHuy;
    private JLabel lblThongBao;
    private boolean isEditMode = false;
    private boolean succeeded = false;
    private NHACUNGCAP nhaCungCap;
    private QuanKhoDAO dao = new QuanKhoDAO(); // DAO để kiểm tra mã trùng
    public NhaCungCapDialog(Frame parent, String title, NHACUNGCAP data) {
        super(parent, title, true);
        initComponents();
        setUpBtn();
        func.notAllowText(txtSDT);
        if (data != null) {
            isEditMode = true;
            nhaCungCap = data;
            setForm(data);
            txtMaNCC.setEnabled(false); // Không cho sửa mã khi edit
        } else {
            nhaCungCap = new NHACUNGCAP();
        }
        btnLuu.addActionListener(e -> {
            lblThongBao.setText(""); // Xoá thông báo cũ
            if (!validateForm()) {
                lblThongBao.setText("Vui lòng nhập đầy đủ thông tin!");
                return;
            }
            if (!isEditMode && dao.kiemTraTrungMaNCC(txtMaNCC.getText().trim())) {
                lblThongBao.setText("Mã nhà cung cấp đã tồn tại!");
                return;
            }
            if (txtSDT.getText().length() != 10 || txtSDT.getText().charAt(0) != '0') {
                lblThongBao.setText("Số điện thoại không hợp lệ");
                return;
            }
            getFormData();
            succeeded = true;
            dispose();
        });
        btnHuy.addActionListener(e -> {
            succeeded = false;
            dispose();
        });
    }
    private void initComponents() {
        txtMaNCC = new JTextField(20);
        txtTenNCC = new JTextField(20);
        txtSDT = new JTextField(20);
        btnLuu = new JButton("Lưu");
        btnHuy = new JButton("Hủy");
        lblThongBao = new JLabel("");
        lblThongBao.setForeground(Color.RED);
        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.add(new JLabel("Mã NCC:"));
        form.add(txtMaNCC);
        form.add(new JLabel("Tên NCC:"));
        form.add(txtTenNCC);
        form.add(new JLabel("SĐT:"));
        form.add(txtSDT);
        form.add(lblThongBao); // Dòng hiển thị thông báo
        form.add(new JLabel()); // Dòng trống
        form.add(btnLuu);
        form.add(btnHuy);
        this.add(form);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    public void setUpBtn(){
        func.setUpBtn(btnLuu, Color.WHITE, Color.GREEN);
        func.setUpBtn(btnHuy, Color.WHITE, Color.RED);
    }
    private void setForm(NHACUNGCAP ncc) {
        txtMaNCC.setText(ncc.getMaNCC());
        txtTenNCC.setText(ncc.getTenNCC());
        txtSDT.setText(ncc.getSdt());
    }

    private void getFormData() {
        nhaCungCap.setMaNCC(txtMaNCC.getText().trim());
        nhaCungCap.setTenNCC(txtTenNCC.getText().trim());
        nhaCungCap.setSdt(txtSDT.getText().trim());
    }

    private boolean validateForm() {
        return !txtMaNCC.getText().isEmpty() &&
               !txtTenNCC.getText().isEmpty() &&
               !txtSDT.getText().isEmpty();
    }

    public NHACUNGCAP getNhaCungCap() {
        return nhaCungCap;
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}