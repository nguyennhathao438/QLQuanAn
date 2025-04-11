/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import DAO.CongViecDAO;
import DAO.NhanVienDAO;
import DTO.ChamCongDTO;
import DTO.CongViecDTO;
import DTO.LuongDTO;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kiman
 */
public class Func_class {
    public void disPlayImage(int width,int height,String linkImage,JLabel jlabel){
        ImageIcon imageIcon=new ImageIcon(getClass().getResource(linkImage));
        Image image=imageIcon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        jlabel.setIcon(new ImageIcon(image));
    }
    public void disPlayImageBtn(int width,int height,String linkImage,JButton btn){
        ImageIcon imageIcon=new ImageIcon(getClass().getResource(linkImage));
        Image image=imageIcon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(image));
    }
    public void centerTable(JTable table){
        DefaultTableCellRenderer center=new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        //lấy renderer mặc định của jtableHeader(jtableHeader có một renderer mặc định là DefaultTableCellRenderer)
        DefaultTableCellRenderer centerHeader=(DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        //Gán center cho các jlabel của header table
        centerHeader.setHorizontalAlignment(JLabel.CENTER);
    }
    public void setUpTable(JTable table){
        table.setRowHeight(25);
        table.setBackground(Color.white);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);
        table.setFillsViewportHeight(true);
        Font font_hearderTable=new Font("Arial",Font.BOLD,15);
        table.getTableHeader().setFont(font_hearderTable);
    }
    public String getKey(HashMap<String,Integer> map,int value){
        String keyString = null;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(value)){
                keyString=entry.getKey();
            }
        }
        return keyString;
    }
    public int getKeyInt(HashMap<Integer,Integer> map,int value){
        int keyInt=-1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(value)){
                keyInt=entry.getKey();
            }
        }
        return keyInt;
    }
    public void loadDataNV(ArrayList<NhanVienDTO> list,JTable table){
        String[] colNames={"Mã NV","Họ tên","Ngày sinh","Giới tính","Số điện thoại","Công việc"};
        Object[][] rows=new Object[list.size()][colNames.length];
        HashMap<String,Integer> mapCV=new CongViecDAO().mapCV();
        for(int i=0;i<list.size();i++){
            rows[i][0]=list.get(i).getMaNV();
            rows[i][1]=list.get(i).getHoTen();
            rows[i][2]=list.get(i).getNgaySinh();
            rows[i][3]=list.get(i).getGioiTinh();
            rows[i][4]=list.get(i).getSDT();
            int maCV=list.get(i).getmaCongViec();
            rows[i][5]=getKey(mapCV, maCV);
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table.setModel(model);
    }
    public void loadDataCongViec(ArrayList<CongViecDTO> list,JTable table){
        String[] colNames={"Mã công việc","Tên công việc","Lương cơ bản","Phụ cấp","Hệ số lương"};
        Object[][] rows=new Object[list.size()][colNames.length];
        for(int i=0;i<list.size();i++){
            rows[i][0]=list.get(i).getMaCV();
            rows[i][1]=list.get(i).getTenCV();
            rows[i][2]=(list.get(i).getLuongCoBan());
            rows[i][3]=(list.get(i).getPhuCap());
            rows[i][4]=list.get(i).getHeSoLuong();
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table.setModel(model);
    }
    public void loadDataChamCong(ArrayList<ChamCongDTO> listCC, JTable table) {
        String[] colNames = {"Mã BCC", "Nhân viên", "Tháng Năm", "Ngày làm", "Ngày nghỉ", "Ngày trễ", "Số giờ tăng ca"};
        Object[][] rows = new Object[listCC.size()][colNames.length];
        ArrayList<NhanVienDTO> listNV = new NhanVienDAO().listNV();
        for (int i = 0; i < listCC.size(); i++) {
            rows[i][0] = listCC.get(i).getMaBCC();
            int maNV = listCC.get(i).getMaNV();
            String tenNV = null;
            for (int j = 0; j < listNV.size(); j++) {
                if (maNV == listNV.get(j).getMaNV()) {
                    tenNV = listNV.get(j).getHoTen();
                }
            }
            rows[i][1] = maNV + "-" + tenNV;
            rows[i][2] = listCC.get(i).getThangChamCong() + "/" + listCC.get(i).getNamChamCong();
            rows[i][3] = listCC.get(i).getSoNgayLamViec();
            rows[i][4] = listCC.get(i).getSoNgayNghi();
            rows[i][5] = listCC.get(i).getSoNgayTre();
            rows[i][6] = listCC.get(i).getSoGioLamThem();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table.setModel(model);
    }
    public void loadDataTableLuong(ArrayList<LuongDTO> list, JTable table) {
        String[] colNames = {"Mã lương", "Mã BCC", "Lương thưởng", "Lương thực tế", "Các khoản trừ", "Thực lãnh"};
        Object[][] rows = new Object[list.size()][colNames.length];
        DecimalFormat df = new DecimalFormat("#,###");
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getMaLuong();
            rows[i][1] = list.get(i).getMaBCC();
            rows[i][2] = df.format(list.get(i).getLuongThuong());
            rows[i][3] = df.format(list.get(i).getLuongThucTe());
            rows[i][4] = df.format(list.get(i).getCacKhoanTru());
            rows[i][5] = df.format(list.get(i).getThucLanh());
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table.setModel(model);
    }
}
