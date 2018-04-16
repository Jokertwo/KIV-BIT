package my.bit.sem.ctrl;

import java.awt.CardLayout;
import javax.swing.JPanel;
import my.bit.sem.enums.Position;


public class SwitchCardCtrl implements ISwitchCardCtrl {

    private CardLayout cl;
    private JPanel homePanel;
    private int actual;


    public SwitchCardCtrl(CardLayout cl, JPanel homePanel) {
        super();
        this.cl = cl;
        this.homePanel = homePanel;
    }


    @Override
    public void next() {
        cl.show(homePanel, Position.values()[actual].getName());
        actual++;

    }


    @Override
    public void back() {
        actual--;
        cl.show(homePanel, Position.values()[actual].getName());

    }

}
