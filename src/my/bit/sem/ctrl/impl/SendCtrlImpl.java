package my.bit.sem.ctrl.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.client.Client;
import my.bit.sem.ctrl.SendCtrl;
import my.bit.sem.key.Key;
import my.bit.sem.message.Message;
import my.bit.sem.message.MessageType;
import my.bit.sem.message.Operation;
import my.bit.sem.rsa.RSA;


public class SendCtrlImpl implements SendCtrl {

    private Client client;
    private RSA rsa;

    public static final Logger logger = LogManager.getLogger();


    public SendCtrlImpl(Client client, RSA rsa) {
        this.client = client;
        this.rsa = rsa;
    }


    @Override
    public void disconnect() {
        client.disconect();
    }


    @Override
    public void send(MessageType type, String message, Key key, Operation operation) {
        String msg = rsa.encryption(message).toString();
        client.sendMessage(new Message(msg, key, type, operation));

    }


    @Override
    public boolean connect(int port) {
        return client.start(port);
    }


    @Override
    public void login() {
        client.sendMessage(new Message(null, rsa.getPublicKey(), MessageType.LOGIN, null));
    }

}
