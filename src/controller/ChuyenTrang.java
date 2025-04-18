
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import GUI.quankho.QKHDNHJPanel;
import GUI.quankho.QKMonAnJPanel;
import GUI.quankho.QKNCCJPanel;
import GUI.quankho.QKNLJPanel;
import GUI.quankho.ThongKeJPanel;
import GUI.quanlibanhang.BanJPanel;
import GUI.quanlibanhang.HoaDonPanel;
import GUI.quanlibanhang.KhachHangPanel;
import GUI.quanlinhansu.ChamCongPanel;
import GUI.quanlinhansu.CongViecPanel;
import GUI.quanlinhansu.LuongPanel;
import GUI.quanlinhansu.NhanVienPanel;
import GUIADM.PhanQuyenManagerPanel;

public class ChuyenTrang {
    private JPanel root;
    private String kindSelected="";
    private ArrayList<Bean> menu = null;
    public ChuyenTrang(JPanel root) {
        this.root = root;
    }
    public void setTrang(JPanel jpn){ 
        kindSelected="MonAn";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QKMonAnJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(ArrayList<Bean> menu){ 
        this.menu=menu;
        for(Bean a:menu){ 
            a.getJpn().addMouseListener(new LabelEvent(a.getKind(),a.getJpn()));
        }
        
    } 
    class LabelEvent implements MouseListener {

      private JPanel node;
      private String kind;
      private JPanel jpnItem;

      public LabelEvent(String kind, JPanel jpnItem) {
           this.kind = kind;
           this.jpnItem = jpnItem;
      }
      @Override
      public void mouseClicked(MouseEvent e) {
          try {
              switch (kind) {
                  case "Q03":
                      node = new QKMonAnJPanel();
                      break;
                  case "Q01":
                      node = new QKNLJPanel();
                      break;
                  case "Q04":
                      node = new QKHDNHJPanel();
                      break;
                  case "Q02":
                      node = new QKNCCJPanel();
                      break;
                  case "Q06":
                      node = new ThongKeJPanel();
                      break;
                  case "Q09":
                      node = new LuongPanel();
                      break;
                  case "Q10":
                      node = new ChamCongPanel();
                      break;
                  case "Q14":
                      node = new NhanVienPanel();
                      break;
                  case "Q13":
                      node = new CongViecPanel();
                      break;
                  case "Q07":
                      node = new BanJPanel();
                      break;
                  case "Q05":
                      node = new HoaDonPanel();
                      break;
                  case "Q08":
                      node = new KhachHangPanel();
                      break;
                  case "Q12":
                      node = new PhanQuyenManagerPanel();
                      break;
//                  case "Q11":
//                      node = new UserPanelPanel();
//                      break;
                  default:
                      break;
              }
              root.removeAll();
              root.setLayout(new BorderLayout());
              root.add(node);
              root.validate();
              root.repaint();
          } catch (SQLException ex) {
              Logger.getLogger(ChuyenTrang.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

      @Override
      public void mousePressed(MouseEvent e) {
           kindSelected = kind;
      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
          
      }
     
     public void setDashboard(JPanel jpnItem) {
       kindSelected = "TrangChinh";
       JPanel node = new QKMonAnJPanel();
       root.removeAll();
       root.setLayout(new BorderLayout());
       root.add(node);
       root.validate();
       root.repaint();
}
    }
}

