/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.quanlinhansu;

import javax.swing.JFrame;

/**
 *
 * @author kiman
 */
public class testFrame {
    public static void main(String[] args){
        JFrame fr=new JFrame();
        DetailsNhanVienPanel pn=new DetailsNhanVienPanel();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(400,550);
        fr.add(pn);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
    }
}
