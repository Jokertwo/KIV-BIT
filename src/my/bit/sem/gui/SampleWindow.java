package my.bit.sem.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import my.bit.sem.rsa.RSA;
import net.miginfocom.swing.MigLayout;

public class SampleWindow extends JFrame{

    private RSA rsa;
    private JTextArea insert,coded,encoded;
    private JButton code,decode;
    public SampleWindow(RSA rsa) {
        this.rsa = rsa;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new MigLayout());
        add(insert(),"grow,push");
        add(code());
        add(coded(),"grow,push");
        add(decoded());
        add(encoded(),"grow,push");
        setVisible(true);
        pack();
    }
          
    public JButton code(){
        code = new JButton(new Encripte());
        return code;
    }
    
    public JButton decoded(){
        decode = new JButton(new Decripte());
        return decode;
    }
    
    public JScrollPane insert(){
        insert = new JTextArea(10,10);
        insert.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(insert);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return scroll;
    }
    public JScrollPane coded(){
        coded = new JTextArea(10,10);
        coded.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(coded);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return scroll;
    }
    public JScrollPane encoded(){
        encoded = new JTextArea(10,10);
        encoded.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(encoded);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return scroll;
    }
    
    private class Encripte extends AbstractAction{

        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        public Encripte() {
            super("Encripte");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(insert.getText().trim().length() > 0){
                coded.setText(rsa.encryption(new BigInteger(insert.getText().getBytes()), rsa.getPublicKey()).toString());
            }
            
        }
        
    }
    private class Decripte extends AbstractAction{

        /**
         * 
         */
        private static final long serialVersionUID = 7453305664202699636L;
        public Decripte() {
            super("Decripte");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(coded.getText().trim().length() > 0){
                encoded.setText(new String(rsa.decription(new BigInteger(coded.getText())).toByteArray()));
            }
            
        }
        
    }
}
