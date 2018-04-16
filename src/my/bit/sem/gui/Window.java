package my.bit.sem.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Window extends JFrame {

    public Window(JPanel homePanel) {
        getContentPane().add(homePanel, BorderLayout.CENTER);
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("KIV-BIT-Client");
    }

}
