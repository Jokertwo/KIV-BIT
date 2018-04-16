package my.bit.sem.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.message.Message;


public class Listener implements Runnable {

    private ObjectInputStream sInput;
    private Buffer buffer;
    private boolean run = true;

    public static final Logger logger = LogManager.getLogger();


    public Listener(ObjectInputStream sInput, Buffer buffer) {
        this.sInput = sInput;
        this.buffer = buffer;
    }


    @Override
    public void run() {
        logger.info("Started listen server");
        Thread.currentThread().setName("listener-of-server");
        while (run) {
            try {
                Message msg = (Message) sInput.readObject();
                logger.trace("Recieve message '" + msg.getType() + "' from server");
                buffer.add(msg);
            } catch (IOException e) {
                logger.info("Socket was close.",e);
            } catch (ClassNotFoundException e) {
                logger.error("Cant find class " + Message.class.getName(), e);
            }
        }
    }


    public void stop() {
        run = false;
    }

}
