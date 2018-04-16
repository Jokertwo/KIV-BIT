package my.bit.sem.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.message.Message;
import my.bit.sem.message.MessageType;


public class ClientImpl implements Client {

    public static final Logger logger = LogManager.getLogger();

    private String address;
    private Socket socket;
    private ObjectOutputStream sOutput;
    private ObjectInputStream sInput;
    private Listener listener;
    private Buffer buffer;


    public ClientImpl(String address, Buffer buffer) {
        this.address = address;
        this.buffer = buffer;
    }


    @Override
    public boolean start(int port) {
        logger.info("Try connect to server with port: " + port);
        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            logger.error("Unable connect to server!!!", e);
            return false;
        }
        logger.info("Connection accepted " + socket.toString());
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        listener = new Listener(sInput, buffer);
        new Thread(listener).start();
        return true;
    }


    /* (non-Javadoc)
     * @see my.bit.sem.client.Client#sendMessage(my.bit.sem.message.Message)
     */
    @Override
    public void sendMessage(Message msg) {
        logger.trace("Send message to server.Kind '" + msg.getType() + "'");
        try {
            sOutput.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* (non-Javadoc)
     * @see my.bit.sem.client.Client#disconect()
     */
    @Override
    public void disconect() {
        logger.info("Clint disconect from server");
        sendMessage(new Message("", null, MessageType.LOGOUT));
        close();
    }


    private void close() {
        listener.stop();
        try {
            if (sOutput != null) {
                sOutput.close();
            }
            if (sInput != null) {
                sInput.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
   
}
