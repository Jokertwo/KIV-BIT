package my.bit.sem.client;

import my.bit.sem.message.Message;


public interface Client {

    public void sendMessage(Message msg);


    void start(int port);


    public void disconect();

}