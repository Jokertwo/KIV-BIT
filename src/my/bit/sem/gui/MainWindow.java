package my.bit.sem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import my.bit.sem.ctrl.ISendCtrl;
import my.bit.sem.message.MessageType;
import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class MainWindow extends JPanel {

    private JTextArea forReading = new JTextArea();
    private JTextArea forWriting = new JTextArea();
    private JScrollPane forRsp = new JScrollPane(forReading);
    private JScrollPane forWsp = new JScrollPane(forWriting);

    private JButton send = new JButton("Send");
    private JButton disco = new JButton("Disconnect");

    private ISendCtrl ctrl;


    public MainWindow(ISendCtrl ctrl) {
        this.ctrl = ctrl;
        addAction();
        createChatPanel();
    }


    private void createChatPanel() {
        setLayout(new MigLayout());

        forReading.setEditable(false);
        add(forRsp, "w 100%, h 80%,wrap");
        add(forWsp, "w 100% ,h 20%,wrap");
        add(send, "split");
        add(disco);
    }


    public void recieve(String message) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                forReading.append(String.format("Server : %s\n", message));
                forRsp.getVerticalScrollBar().setValue(forRsp.getVerticalScrollBar().getMaximum());
            });
        } catch (InvocationTargetException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void addAction() {
        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!forWriting.getText().trim().isEmpty()) {
                    ctrl.send(MessageType.MESSAGE, forWriting.getText(), null);
                    forWriting.setText("");
                }

            }
        });
        disco.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.disconnect();
            }
        });
    }

}
