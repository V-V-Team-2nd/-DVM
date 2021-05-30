package Logic;

public class VerificationCode {

    /* Attributes */
    private int beverageID;
    private String code;

    /* Methods */
    public VerificationCode(int id, String code){
        this.beverageID = id;
        this.code = code;
    }

    public int getBeverageID() {
        return beverageID;
    }

    public String getCode(){
        return code;
    }
}