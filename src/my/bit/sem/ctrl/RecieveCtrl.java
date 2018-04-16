package my.bit.sem.ctrl;

import my.bit.sem.gui.MainWindow;

public class RecieveCtrl implements IRecieveCtrl{

    
    private MainWindow mw;
    
    public RecieveCtrl(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void recieve(String message) {
        mw.recieve(message);
    }

}
