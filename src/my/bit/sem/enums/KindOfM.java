package my.bit.sem.enums;

public enum KindOfM {

    MESSAGE(10,"message"),
    LOGOUT(20,"logOut"),
    LOGIN(0,"logIn");

    private int kind;
    private String name;


    private KindOfM(int kind,String name) {
        this.kind = kind;
    }


    public int getKind() {
        return kind;
    }
    
    public String getName(){
        return name;
    }
}
