package Logic;

public class Msg {
    /* Attributes */

    private char src_id;
    private char dst_id;
    private char type;
    private char[] description = new char[21];

    /* Methods */
    Msg(char si, char di, char t, char[] d){
        this.src_id = si;
        this.dst_id = di;
        this.type = t;
        this.description = d;
    }

    public char getSrc_id(){
        return src_id;
    }
    public char getDst_id(){
        return dst_id;
    }
    public char getType(){
        return type;
    }
    public char[] getDescription(){
        return description;
    }
}