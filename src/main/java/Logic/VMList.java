package Logic;

public class VMList {
    /* Attributes */
    private VM[] operatingList = new VM[10];
    private char myID;
    private char[] myAddress = new char[21];
    private boolean[] stockAvailable = new boolean[10];
    private int count;
    private int operatingLength;

    /* Methods */
    VMList(){
        char i;
        for(i=1;i<11;i++){
            operatingList[i].setVmID(i);
        }
    }

    public VM[] getOperatingList() {
        return operatingList;
    }

    public char getMyID() {
        return myID;
    }

    public char[] getMyAddress() {
        return myAddress;
    }

    public boolean[] getStockAvailable() {
        return stockAvailable;
    }

    public void setMyAddress(char[] myAddress) {
        this.myAddress = myAddress;
    }

    public void receiveStock(char vmID, boolean available){

    }

    /* 어떤 함수인지 불명확함.
        addOperatingList와 이름을 명확히 구분할 필요가 있음 */
    public void addVM(char vmID, char[] address){

    }

    public void deleteVM(char vmID){

    }
    public void addOperatingList(char vmID, char[] address){

    }
}
