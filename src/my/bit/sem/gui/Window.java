package my.bit.sem.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import my.bit.sem.ctrl.ConnectControler;
import my.bit.sem.enums.Position;
import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class Window extends JFrame {

    private CardLayout cl;
    private JPanel homePanel;


    public Window(JPanel second, ConnectControler cCtrl) {
        cl = new CardLayout();
        homePanel = new JPanel(cl);
        Container contentPane = getContentPane();
        contentPane.add(homePanel, BorderLayout.CENTER);
        setSize(700, 600);
        homePanel.add(new ConnectWindow(cCtrl), Position.FIRST.getName());
        homePanel.add(second, Position.SECOND.getName());
        cl.show(homePanel, Position.FIRST.getName());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("KIV-BIT-Client");
    }

    private class ConnectWindow extends JPanel {

        private ConnectControler cCtrl;
        private JTextField tf;


        public ConnectWindow(ConnectControler cCtrl) {
            this.cCtrl = cCtrl;

            tf = new JTextField();
            setLayout(new MigLayout());
            add(tf, "pushx,growx,wrap");
            add(new JButton(new ConnectAction()), "pushx,growx");
        }

        private class ConnectAction extends AbstractAction {

            public ConnectAction() {
                super("Connect");
            }


            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tf.getText().trim().isEmpty()) {
                    cCtrl.connect(Integer.parseInt(tf.getText()));
                    cl.show(homePanel, Position.SECOND.getName());
                }
            }

        }

    }

}
