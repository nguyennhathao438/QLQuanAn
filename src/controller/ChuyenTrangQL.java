
package controller;


import GUI.quanlinhansu.ChamCongPanel;
import GUI.quanlinhansu.CongViecPanel;
import GUI.quanlinhansu.LuongPanel;
import GUI.quanlinhansu.NhanVienPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChuyenTrangQL {
    private JPanel root;
    private String kindSelected="";
    private ArrayList<Bean> menu = null;
    public ChuyenTrangQL(JPanel root) {
        this.root = root;
    }
    public void setTrang(JPanel jpn,JLabel jlb){ 
        kindSelected="NhanVien";
        jpn.setBackground(new Color(184,210,11));
        jlb.setForeground(Color.black);
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new NhanVienPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(ArrayList<Bean> menu){ 
        this.menu=menu;
        for(Bean a:menu){ 
            a.getJlb().addMouseListener(new LabelEvent(a.getKind(),a.getJpn(),a.getJlb()));
        }
        
    } 
    class LabelEvent implements MouseListener {

      private JPanel node;
      private String kind;
      private JPanel jpnItem;
      private JLabel jlbItem;

      public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
           this.kind = kind;
           this.jpnItem = jpnItem;
           this.jlbItem = jlbItem;
      }

      @Override
      public void mouseClicked(MouseEvent e) {
          switch (kind) {
              case "NhanVien":
                  node = new NhanVienPanel();
                  break;
              case "Luong":
                  node = new LuongPanel();
                  break;
              case "CongViec":
                  node = new CongViecPanel();
                  break;
              case "ChamCong":
                  node = new ChamCongPanel();
                  break;
              default:
                  break;
          }
          root.removeAll();
          root.setLayout(new BorderLayout());
          root.add(node);
          root.validate();
          root.repaint();
          setChangeBackground(kind);
      }

      @Override
      public void mousePressed(MouseEvent e) {
           kindSelected = kind;
           jpnItem.setBackground(new Color(184,210,11));
        jlbItem.setForeground(Color.black);
      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
          jpnItem.setBackground(new Color(184,210,11));
        jlbItem.setForeground(Color.black);
      }

      @Override
      public void mouseExited(MouseEvent e) {
          if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(247, 118, 04));
                jlbItem.setForeground(new Color(204, 255, 255));
          }
      }
     private void setChangeBackground(String kind){ 
        for(Bean a:menu){ 
            JPanel jpnItem = a.getJpn();
        JLabel jlbItem = a.getJlb();
            if(a.getKind().equalsIgnoreCase(kind)){ 
                jpnItem.setBackground(new Color(184,210,11));
        jpnItem.setForeground(Color.black);
            }else { 
                jpnItem.setBackground(new Color(247, 118, 04));
                jlbItem.setForeground(new Color(204, 255, 255));
            }
        }
     }
     public void setDashboard(JPanel jpnItem, JLabel jlbItem) {
       kindSelected = "TrangChinh";
       jpnItem.setBackground(new Color(96, 100, 191));
       jlbItem.setBackground(new Color(96, 100, 191));
       JPanel node = new NhanVienPanel();
       root.removeAll();
       root.setLayout(new BorderLayout());
       root.add(node);
       root.validate();
       root.repaint();
}
}
}
