package my.bit.sem.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
import my.bit.sem.ctrl.SendCtrl;
import my.bit.sem.ctrl.SwitchCardCtrl;
import my.bit.sem.intFilter.IntFilter;
import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class ConnectWindow extends JPanel {

    private SendCtrl cCtrl;
    private JTextField tf;
    private SwitchCardCtrl sCtrl;
    private JLabel infoLabel = new JLabel(" ");


    public ConnectWindow(SendCtrl cCtrl, SwitchCardCtrl sCtrl) {
        this.cCtrl = cCtrl;
        this.sCtrl = sCtrl;
        tf = new JTextField();
        PlainDocument doc = (PlainDocument) tf.getDocument();
        doc.setDocumentFilter(new IntFilter());
        setLayout(new MigLayout());
        add(tf, "pushx,growx,wrap");
        add(infoLabel, "align center,wrap");
        add(new JButton(new ConnectAction()), "pushx,growx");
    }


    private void showInfoLabel(String message) {
        infoLabel.setForeground(Color.RED);
        infoLabel.setText(message);
        new MyTimer(infoLabel, 3000);
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
                } else {
                    showInfoLabel("Unable connect to server!");
                }
            }
            else{
                showInfoLabel("Write number of port please");
            }
        }

    }

}
