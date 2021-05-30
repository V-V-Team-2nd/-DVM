package tests;

import Logic.Msg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MsgTest {
    Msg[] msgs = new Msg[8];
    int src_id = 3;
    int dst_id = 4;
    String description = "TestMsg";

    public void initMsg(){
        for(int i=0;i<8;i++){
            msgs[i] = new Msg(src_id,dst_id,i,description);
        }
    }

    @Test
    public void testGetSrc_id(){
        initMsg();
        for(int i=0;i<8;i++){
            assertEquals(msgs[i].getSrc_id(), src_id);
        }
    }

    @Test
    public void testGetDst_id(){
        initMsg();
        for(int i=0;i<8;i++){
            assertEquals(msgs[i].getDst_id(), dst_id);
        }
    }

    @Test
    public void testGetType(){
        initMsg();
        for(int i=0;i<8;i++){
            assertEquals(msgs[i].getType(), i);
        }
    }

    @Test
    public void testGetDescription(){
        initMsg();
        for(int i=0;i<8;i++){
            assertEquals(msgs[i].getDescription(), description);
        }
    }
}
