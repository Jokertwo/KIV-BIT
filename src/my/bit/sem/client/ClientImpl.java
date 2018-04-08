package my.bit.sem.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import my.bit.sem.message.Message;


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
    public void start(int port) {

        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        logger.info("Connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        listener = new Listener(sInput, buffer);
        new Thread(listener).start();
    }


    /* (non-Javadoc)
     * @see my.bit.sem.client.Client#sendMessage(my.bit.sem.message.Message)
     */
    @Override
    public void sendMessage(Message msg) {
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
        sendMessage(new Message(Message.LOGOUT, "",null));
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
