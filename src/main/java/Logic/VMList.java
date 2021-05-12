package Logic;

public class VMList {
    /* Attributes */
    private VM[] operatingList = new VM[10];
    private int myID;
    private String myAddress;
    //private boolean[] stockAvailable = new boolean[10];
    private int count;
    private int operatingLength;

    /* Methods */

    /*  Functionality :
            VMList의 생성자
            operatingList의 id를 1부터 10까지 설정함.
            count와 operatingLength를 0으로 초기화 함.
    *   Parameters : void
    *   Return value : void
    * */
    VMList(){
        for(int i=0;i<10;i++){
            operatingList[i] = new VM();
            operatingList[i].setVmID(i+1);
        }
        count = 0;
        operatingLength = 0;
    }

    public VM[] getOperatingList() {
        return operatingList;
    }
    public int getOperatingLength(){
        return operatingLength;
    }
    public int getMyID() {
        return myID;
    }

    public String getMyAddress() {
        return myAddress;
    }

/*    public boolean[] getStockAvailable() {
        return stockAvailable;
    }*/
    public void setMyID(int myID){
        this.myID = myID;
    }
    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }
    /*public void setCount(int count){ this.count = count; }*/

    /*  Functionality :
            다른 자판기로(broadcast) 재고 여부 요청 메시지를 보낸 후
            재고 응답 메시지를 받으면
            해당하는 자판기의 id와 재고 가능 여부를 리스트에 저장한다.
    *   Parameters : VM 아이디, 재고 여부
    *   Return values : void
    *  */
/*    public boolean[] receiveStock(int vmID, boolean available){
        boolean[] availableList = new boolean[10];
        return availableList;
    }*/

    /* 어떤 함수인지 불명확함.
        addOperatingList와 이름을 명확히 구분할 필요가 있음 */
/*    public void addVM(int vmID, String address){

    }*/
    /*  Functionality :
            다른 자판기로부터 종료 메시지를 받아 해당 자판기의 주소를 null로 초기화하고,
            작동 중이 아님을 표시한다.
    *   Parameters : VM 아이디
    *   Return values : void
    * */
    public void deleteVM(int vmID){
        this.operatingList[vmID-1].setVmAddress(null);
        this.operatingList[vmID-1].setIsOperating(false);
        operatingLength--;
    }
    /*  Functionality :
            다른 자판기로부터 시작 메시지를 받아 해당 자판기의 주소를 업데이트하고,
            작동 중임을 표시한다.
    *   Parameters : VM 아이디, 주소
    *   Return values : void
    *   */
    public void addVM(int vmID, String address){
        this.operatingList[vmID-1].setVmAddress(address);
        this.operatingList[vmID-1].setIsOperating(true);
        operatingLength++;
        //System.out.println(address + " **** 설정 완료");
    }

    public String getSelectedVMAddress(int index){
        return operatingList[index].getVmAddress();
    }
    public boolean[] getOperating(){
        boolean[] operating = new boolean[10];
        for(int i=0;i<10;i++){
            operating[i] = operatingList[i].getIsOperating();
        }
        return operating;
    }
}