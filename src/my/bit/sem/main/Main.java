package my.bit.sem.main;

import java.awt.CardLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.client.Buffer;
import my.bit.sem.client.BufferImpl;
import my.bit.sem.client.ClientImpl;
import my.bit.sem.client.Reciever;
import my.bit.sem.ctrl.SendCtrl;
import my.bit.sem.ctrl.SwitchCardCtrl;
import my.bit.sem.ctrl.impl.SendCtrlImpl;
import my.bit.sem.ctrl.impl.SwitchCardCtrlImpl;
import my.bit.sem.gui.ConnectWindow;
import my.bit.sem.gui.HomePanel;
import my.bit.sem.gui.MainWindow;
import my.bit.sem.gui.MainWindowImpl;
import my.bit.sem.gui.Window;
import my.bit.sem.pm.PrimeNumbersE;
import my.bit.sem.rsa.RSA;
import my.bit.sem.rsa.RSAImpl;


public class Main {
    
    
    //inicialization of logger
    static {
        System.setProperty("log4j.configurationFile",
            "./log/log_config.xml");
    }
    public static final Logger logger = LogManager.getLogger();

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private MainWindow mw;
    private RSA rsa;
    private Buffer buffer;


    public Main() throws InvocationTargetException, InterruptedException {
        
        logger.info("Start client app");
        
        //implementation of RSA
        rsa = new RSAImpl(PrimeNumbersE.pN1.getPn(), PrimeNumbersE.pN2.getPn());
        buffer = new BufferImpl();
        
        //connection to server
        SendCtrl sendCtrl = new SendCtrlImpl(new ClientImpl("localhost", buffer), rsa);

        //init of gui
        SwingUtilities.invokeAndWait(() -> {
            //layout for switch between window/panel
            CardLayout cl = new CardLayout();
            
            //panel where is store others panel
            HomePanel homePanel = new HomePanel(cl);
            
            //cotroler for cardLayout
            SwitchCardCtrl switchCtrl = new SwitchCardCtrlImpl(cl, homePanel);
            mw = new MainWindowImpl(sendCtrl);
            homePanel.addPanels(new ConnectWindow(sendCtrl, switchCtrl), mw.getGUI());
           
            //frame
            new Window(homePanel);
        });
        
        //handle of recieve message
        executor.execute(new Reciever(buffer, mw, rsa));
        executor.shutdown();
    }


    public static void main(String[] args) throws InvocationTargetException, InterruptedException {       
            new Main();      
    }
}
