package Logic;

public class VM {
    /* Attributes */

    private char vmID;
    private char[] vmAddress = new char[21];
    private boolean isOperating;

    /* Methods */
    /*public char getVmID(){
        return vmID;
    }*/
    VM(){
        this.isOperating = false;
    }
    public char[] getVmAddress(){
        return vmAddress;
    }
    public boolean getIsOperating(){
        return isOperating;
    }
    public void setVmID(char id){
        this.vmID = id;
    }
    public void setVmAddress(char[] vmA){
        this.vmAddress = vmA;
    }
    public void setIsOperating(boolean b){
        this.isOperating = b;
    }
}
