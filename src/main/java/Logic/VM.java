package Logic;

public class VM {
    /* Attributes */

    private int vmID;
    private String vmAddress;
    private boolean isOperating;

    public VM(){
        this.vmID = 0;
        this.vmAddress = null;
        this.isOperating = false;
    }
    public String getVmAddress(){
        return vmAddress;
    }
    public boolean getIsOperating(){
        return isOperating;
    }
    public void setVmID(int id){
        this.vmID = id;
    }
    public void setVmAddress(String vmA){
        this.vmAddress = vmA;
    }
    public void setIsOperating(boolean b){
        this.isOperating = b;
    }
}
