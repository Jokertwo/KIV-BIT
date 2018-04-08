package my.bit.sem.enums;

public enum Position {
    FIRST("first"),
    SECOND("second");
    
    private String name;
    
    private Position(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
