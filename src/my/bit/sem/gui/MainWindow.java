package my.bit.sem.gui;

import javax.swing.JPanel;

public interface MainWindow {

    /**
     * Return GUI of MainWidow
     * @return
     */
    JPanel getGUI();
    
    
    /**
     * Show message in GUI
     * @param message
     */
    void recieve(String message);
}
