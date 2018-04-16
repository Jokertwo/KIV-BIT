package my.bit.sem.gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import my.bit.sem.ctrl.ISendCtrl;
import my.bit.sem.ctrl.ISwitchCardCtrl;
import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class ConnectWindow extends JPanel {

    private ISendCtrl cCtrl;
    private JTextField tf;
    private ISwitchCardCtrl sCtrl;


    public ConnectWindow(ISendCtrl cCtrl, ISwitchCardCtrl sCtrl) {
        this.cCtrl = cCtrl;
        this.sCtrl = sCtrl;
        tf = new JTextField();
        setLayout(new MigLayout());
        add(tf, "pushx,growx,align center,wrap");
        add(new JButton(new ConnectAction()), "pushx,growx");
    }

    private class ConnectAction extends AbstractAction {

        public ConnectAction() {
            super("Connect");
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (!tf.getText().trim().isEmpty()) {
                if (cCtrl.connect(Integer.parseInt(tf.getText()))) {
                    cCtrl.login();
                    sCtrl.next();
                }
            }
        }

    }

}
