package my.bit.sem.ctrl;

import my.bit.sem.key.Key;
import my.bit.sem.message.MessageType;


public interface ISendCtrl {

    void send(MessageType type, String message, Key key);


    void disconnect();


    boolean connect(int port);


    void login();
}
