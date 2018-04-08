package my.bit.sem.ctrl;

import my.bit.sem.gui.MainWindow;

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
