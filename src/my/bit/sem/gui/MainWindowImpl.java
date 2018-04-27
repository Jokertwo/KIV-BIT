package my.bit.sem.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import my.bit.sem.ctrl.SendCtrl;
import my.bit.sem.message.MessageType;
import my.bit.sem.message.Operation;
import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
public class MainWindowImpl extends JPanel implements MainWindow {

    private JTextArea forReading;
    private JTextArea forWriting = new JTextArea();
    private JScrollPane forRsp;

    private JButton send;
    private JButton disconect;

    private SendCtrl ctrl;

    private JTextField number1;
    private JTextField number2;
    private JComboBox<Operation> operation;

    private Font font;


    public MainWindowImpl(SendCtrl ctrl) {
        this.ctrl = ctrl;
        init();
        addAction();
        fillPanel();
    }


    /**
     * Initialize of component
     */
    private void init() {
        font = new Font(Font.MONOSPACED, Font.PLAIN, 18);
        number1 = new JTextField();
        number1.setFont(font);
        number2 = new JTextField();
        number2.setFont(font);
        send = new JButton("Send");
        disconect = new JButton("Disconnect and close");
        operation = new JComboBox<Operation>(Operation.values());
        forReading = new JTextArea();
        forReading.setFont(font);
        forRsp = new JScrollPane(forReading);
    }


    /**
     * Add component to panel
     */
    private void fillPanel() {
        setLayout(new MigLayout());

        forReading.setEditable(false);
        add(forRsp, "grow,push,wrap");
        add(number1, "growx,pushx,split");
        add(operation, "growx,pushx,split");
        add(number2, "growx,pushx,split,wrap");
        add(send, "growx,pushx,split");
        add(disconect, "growx,pushx");
    }


    @Override
    public void recieve(String message) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                forReading.append(String.format("Server respose: %s\n", message));
                forRsp.getVerticalScrollBar().setValue(forRsp.getVerticalScrollBar().getMaximum());
            });
        } catch (InvocationTargetException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * Add action to buttons
     */
    private void addAction() {
        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!number1.getText().trim().isEmpty()) {
                    ctrl.send(MessageType.MESSAGE, number1.getText(), null);
                    number1.setText("");
                }

            }
        });
        disconect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(
                    null,
                    "Yout will be diconect from server \n"
                            + "and application will be close.\n",
                    "Do you want continue?",
                    JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.OK_OPTION) {
                    ctrl.disconnect();
                    System.exit(0);
                }
            }
        });
    }


    @Override
    public JPanel getGUI() {
        return this;
    }

}
