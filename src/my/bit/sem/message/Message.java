package my.bit.sem.message;

import java.io.Serializable;

public class Message implements Serializable{

    private static final long serialVersionUID = -585085161844650095L;

    
    private int type;
    private String message;
    
    
    public Message(int type, String message){
        this.message = message;
        this.type = type;
    }
    
    public int getType(){
        return type;
    }
    
    public String getMessage(){
        return message;
    }
}
