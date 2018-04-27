package my.bit.sem.ctrl.impl;

import my.bit.sem.ctrl.RecieveCtrl;
import my.bit.sem.gui.MainWindowImpl;

public class RecieveCtrlImpl implements RecieveCtrl{

    
    private MainWindowImpl mw;
    
    public RecieveCtrlImpl(MainWindowImpl mw) {
        this.mw = mw;
    }

    @Override
    public void recieve(String message) {
        mw.recieve(message);
    }

}
