package my.bit.sem.ctrl;

import my.bit.sem.client.Client;

public class ConnectCtrl implements IConnectCtrl {

    private Client client;


    public ConnectCtrl(Client client) {
        this.client = client;
    }


    @Override
    public boolean connect(int port) {
        return client.start(port);
    }

}
