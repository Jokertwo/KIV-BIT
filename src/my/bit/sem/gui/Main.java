package my.bit.sem.gui;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import my.bit.sem.client.Buffer;
import my.bit.sem.client.BufferImpl;
import my.bit.sem.client.Client;
import my.bit.sem.client.ClientImpl;
import my.bit.sem.client.HandleRecieve;
import my.bit.sem.ctrl.ConnectControler;
import my.bit.sem.ctrl.ConnectControlerImpl;
import my.bit.sem.ctrl.RecieveControler;
import my.bit.sem.ctrl.SendControler;
import my.bit.sem.ctrl.SendControlerImpl;
import my.bit.sem.pm.PrimeNumbersE;
import my.bit.sem.rsa.RSA;
import my.bit.sem.rsa.RSAImpl;


public class Main {
    
    
    
    static {
        System.setProperty("log4j.configurationFile",
            "log/log_config.xml");
    }
    

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        
        
        
        

        RSA rsa = new RSAImpl(PrimeNumbersE.pN1.getPn(), PrimeNumbersE.pN2.getPn());
        Buffer buffer = new BufferImpl();
        Client client = new ClientImpl("localhost", buffer);
        ConnectControler cCtrl = new ConnectControlerImpl(client);
        SendControler sCtrl = new SendControlerImpl(client, rsa);
        MainWindow mw = new MainWindow(sCtrl);
        RecieveControler rCtrl = new RecieveControlerImpl(mw);
        new Thread(new HandleRecieve(buffer, rCtrl, rsa)).start();
        SwingUtilities.invokeAndWait(() -> {
            new Window(mw, cCtrl);
        });

    }
}
