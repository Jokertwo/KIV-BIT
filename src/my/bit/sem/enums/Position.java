package my.bit.sem.enums;

public enum Position {
    CONNECT("connect"),
    COMUNICATE("communicate");
    
    private String name;
    
    private Position(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
