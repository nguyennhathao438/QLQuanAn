
package controller;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bean {
    private String kind;
    private JPanel jpn;

    public Bean(String kind, JPanel jpn) {
        this.kind = kind;
        this.jpn = jpn;
    }
    
    public String getKind() {
        return kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    
    
}
