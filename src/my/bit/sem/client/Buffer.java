package my.bit.sem.client;

import my.bit.sem.message.Message;


public interface Buffer {

    void add(Message message);


    Message process();
}
