package my.bit.sem.ctrl.impl;

import java.awt.CardLayout;
import javax.swing.JPanel;
import my.bit.sem.ctrl.SwitchCardCtrl;
import my.bit.sem.enums.Position;


public class SwitchCardCtrlImpl implements SwitchCardCtrl {

    private CardLayout cl;
    private JPanel homePanel;


    public SwitchCardCtrlImpl(CardLayout cl, JPanel homePanel) {
        super();
        this.cl = cl;
        this.homePanel = homePanel;
    }


    @Override
    public void next() {
        cl.show(homePanel, Position.COMUNICATE.getName());
    }


    @Override
    public void back() {
        cl.show(homePanel, Position.CONNECT.getName());
    }

}
