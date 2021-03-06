package Logic;

public class VMList {
    /* Attributes */
    private VM[] operatingList = new VM[10];
    private int myID;
    private String myAddress;


    /* Methods */

    /*  Functionality :
            VMList의 생성자
            operatingList의 id를 1부터 10까지 설정함.
            count와 operatingLength를 0으로 초기화 함.
    *   Parameters : void
    *   Return value : void
    * */
    public VMList(){
        for(int i=0;i<10;i++){
            operatingList[i] = new VM();
            operatingList[i].setVmID(i+1);
        }
    }
    public int getMyID() {
        return myID;
    }

    public String getMyAddress() {
        return myAddress;
    }

    public void setMyID(int myID){
        this.myID = myID;
    }
    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }

    /*  Functionality :
            다른 자판기로(broadcast) 재고 여부 요청 메시지를 보낸 후
            재고 응답 메시지를 받으면
            해당하는 자판기의 id와 재고 가능 여부를 리스트에 저장한다.
    *   Parameters : VM 아이디, 재고 여부
    *   Return values : void
    *  */


    /* 어떤 함수인지 불명확함.
        addOperatingList와 이름을 명확히 구분할 필요가 있음 */

    /*  Functionality :
            다른 자판기로부터 종료 메시지를 받아 해당 자판기의 주소를 null로 초기화하고,
            작동 중이 아님을 표시한다.
    *   Parameters : VM 아이디
    *   Return values : void
    * */
    public void deleteVM(int vmID){
        this.operatingList[vmID-1].setVmAddress(null);
        this.operatingList[vmID-1].setIsOperating(false);
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