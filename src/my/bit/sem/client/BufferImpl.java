package my.bit.sem.client;

import java.util.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.message.Message;


public class BufferImpl implements Buffer {

    private Vector<Message> buffer;
    public static final Logger logger = LogManager.getLogger();


    public BufferImpl() {
        buffer = new Vector<>();
    }


    @Override
    public synchronized void add(Message message) {
        logger.trace(Thread.currentThread().getName() + " store value to buffer.");
        buffer.addElement(message);
        notify();
    }


    @Override
    public synchronized Message process() {
        while (buffer.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Message msg = buffer.firstElement();
        buffer.remove(msg);
        logger.trace(Thread.currentThread().getName() + " pick and remove value to buffer.");
        return msg;

    }

}
