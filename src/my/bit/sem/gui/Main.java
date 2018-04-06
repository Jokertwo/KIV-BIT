package my.bit.sem.gui;

import javax.swing.SwingUtilities;
import my.bit.sem.rsa.RSAImpl;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SampleWindow(new RSAImpl()));
    }
}
