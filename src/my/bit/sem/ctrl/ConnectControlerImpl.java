package my.bit.sem.ctrl;

import my.bit.sem.client.Client;

public class ConnectControlerImpl implements ConnectControler {

    private Client client;


    public ConnectControlerImpl(Client client) {
        this.client = client;
    }


    @Override
    public void connect(int port) {
        client.start(port);
    }

}
