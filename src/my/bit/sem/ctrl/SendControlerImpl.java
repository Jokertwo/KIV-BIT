package my.bit.sem.ctrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.client.Client;
import my.bit.sem.enums.KindOfM;
import my.bit.sem.message.Message;
import my.bit.sem.rsa.RSA;


public class SendControlerImpl implements SendControler {

    private Client client;
    private RSA rsa;


    public static final Logger logger = LogManager.getLogger();

    public SendControlerImpl(Client client, RSA rsa) {
        this.client = client;
        this.rsa = rsa;
    }





    @Override
    public void send(int kind,String message) {
        
        String msg = rsa.encryption(message, rsa.getPublicKey()).toString();
        client.sendMessage(new Message(KindOfM.MESSAGE.getKind(), msg));
    }





    @Override
    public void disconnect() {
        client.disconect();
    }

}
