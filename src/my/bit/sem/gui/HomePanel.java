package my.bit.sem.gui;

import java.awt.CardLayout;
import javax.swing.JPanel;
import my.bit.sem.enums.Position;


public class HomePanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public HomePanel(CardLayout cl) {
        setLayout(cl);

    }


    public void addPanels(JPanel... panels) {
        for (int i = 0; i < panels.length; i++) {
            add(panels[i], Position.values()[i].getName());
        }
    }

}
