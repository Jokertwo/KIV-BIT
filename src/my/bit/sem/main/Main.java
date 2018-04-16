package my.bit.sem.main;

import java.awt.CardLayout;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.client.Buffer;
import my.bit.sem.client.BufferImpl;
import my.bit.sem.client.Client;
import my.bit.sem.client.ClientImpl;
import my.bit.sem.client.Reciever;
import my.bit.sem.ctrl.ConnectCtrl;
import my.bit.sem.ctrl.IConnectCtrl;
import my.bit.sem.ctrl.IRecieveCtrl;
import my.bit.sem.ctrl.ISendCtrl;
import my.bit.sem.ctrl.ISwitchCardCtrl;
import my.bit.sem.ctrl.RecieveCtrl;
import my.bit.sem.ctrl.SendCtrl;
import my.bit.sem.ctrl.SwitchCardCtrl;
import my.bit.sem.gui.ConnectWindow;
import my.bit.sem.gui.HomePanel;
import my.bit.sem.gui.MainWindow;
import my.bit.sem.gui.Window;
import my.bit.sem.pm.PrimeNumbersE;
import my.bit.sem.rsa.RSA;
import my.bit.sem.rsa.RSAImpl;


public class Main {
    static {
        System.setProperty("log4j.configurationFile",
            "./log/log_config.xml");
    }
    public static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) throws InvocationTargetException, InterruptedException {

        logger.info("Start client app");

        RSA rsa = new RSAImpl(PrimeNumbersE.pN1.getPn(), PrimeNumbersE.pN2.getPn());
        Buffer buffer = new BufferImpl();

        Client client = new ClientImpl("localhost", buffer);

        ISendCtrl sendCtrl = new SendCtrl(client, rsa);

        MainWindow mw = new MainWindow(sendCtrl);
        IRecieveCtrl rCtrl = new RecieveCtrl(mw);

        new Thread(new Reciever(buffer, rCtrl, rsa)).start();
        SwingUtilities.invokeAndWait(() -> {

            CardLayout cl = new CardLayout();
            HomePanel homePanel = new HomePanel(cl);
            ISwitchCardCtrl switchCtrl = new SwitchCardCtrl(cl, homePanel);

            homePanel.addPanels(new ConnectWindow(sendCtrl, switchCtrl), mw);
            switchCtrl.next();
            new Window(homePanel);
        });

    }
}
