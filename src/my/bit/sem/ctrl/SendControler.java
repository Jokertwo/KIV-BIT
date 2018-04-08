package my.bit.sem.ctrl;

import my.bit.sem.key.Key;

public interface SendControler {

    void send(int kind, String message,Key key);


    void disconnect();
}
