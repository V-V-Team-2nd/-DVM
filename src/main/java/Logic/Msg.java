package Logic;

import java.io.Serializable;

public class Msg implements Serializable {
    /* Attributes */
    private static final long serialVersionUID = 1L;

    private int src_id;
    private int dst_id;
    private int type;
    private String description;

    /* Methods */
    public Msg(int si, int di, int t, String d){
        this.src_id = si;
        this.dst_id = di;
        this.type = t;
        this.description = d;
    }

    public int getSrc_id(){
        return src_id;
    }
    public int getDst_id(){
        return dst_id;
    }
    public int getType(){
        return type;
    }
    public String getDescription(){
        return description;
    }
}