package my.bit.sem.client;

import my.bit.sem.ctrl.RecieveControler;
import my.bit.sem.rsa.RSA;


public class HandleRecieve implements Runnable {

    private Buffer buffer;
    private boolean run = true;
    private RecieveControler rCtrl;
    private RSA rsa;


    public HandleRecieve(Buffer buffer, RecieveControler rCtrl, RSA rsa) {
        this.buffer = buffer;
        this.rCtrl = rCtrl;
        this.rsa = rsa;
    }


    @Override
    public void run() {
        while (run) {
            String msg = new String(rsa.decription(buffer.process().getMessage()).toByteArray());
            rCtrl.recieve(msg);
        }

    }


    public void stop() {
        run = false;
    }
}
