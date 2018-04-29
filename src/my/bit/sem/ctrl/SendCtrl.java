package my.bit.sem.ctrl;

import my.bit.sem.key.Key;
import my.bit.sem.message.MessageType;
import my.bit.sem.message.Operation;


public interface SendCtrl {

    void send(MessageType type, String message, Key key,Operation operation);


    void disconnect();


    boolean connect(int port);


    void login();
}
