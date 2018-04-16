package my.bit.sem.ctrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.client.Client;
import my.bit.sem.key.Key;
import my.bit.sem.message.Message;
import my.bit.sem.message.MessageType;
import my.bit.sem.rsa.RSA;


public class SendCtrl implements ISendCtrl {

    private Client client;
    private RSA rsa;

    public static final Logger logger = LogManager.getLogger();


    public SendCtrl(Client client, RSA rsa) {
        this.client = client;
        this.rsa = rsa;
    }


    @Override
    public void disconnect() {
        client.disconect();
    }


    @Override
    public void send(MessageType type, String message, Key key) {
        String msg = rsa.encryption(message, rsa.getPublicKey()).toString();
        client.sendMessage(new Message(msg, key, type));

    }


    @Override
    public boolean connect(int port) {
        return client.start(port);
    }


    @Override
    public void login() {
        send(MessageType.LOGIN, "Petr", rsa.getPublicKey());
    }

}
