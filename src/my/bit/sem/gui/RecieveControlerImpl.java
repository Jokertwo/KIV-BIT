package my.bit.sem.gui;

import my.bit.sem.ctrl.RecieveControler;

public class RecieveControlerImpl implements RecieveControler{

    
    private MainWindow mw;
    
    public RecieveControlerImpl(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void recieve(String message) {
        mw.recieve(message);
    }

}
