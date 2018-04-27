package my.bit.sem.ctrl.impl;

import my.bit.sem.client.Client;
import my.bit.sem.ctrl.IConnectCtrl;

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
