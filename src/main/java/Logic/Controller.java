package Logic;

import java.io.BufferedReader;
import java.io.FileReader;

public class Controller {

    /* Attributes */

    private VMList vmList = new VMList();
    private CardList cardList = new CardList();
    private VerificationCodeList verificationCodeList = new VerificationCodeList();
    private Network network;
    private Beverage[] beverages = new Beverage[20];
    private int[] stock = new int[20];
    private int nowMenu;

    /* Methods */

    /*  Functionality :
            DVM 시스템의 동작을 전반적으로 관리하고 GUI에서 이 class에 정의된 operations를 이용하여
            DVM이 동작하게 된다.
            이 생성자에서는 ./TextFiles/VMInfo.txt파일을 읽어 아이디, 주소, 관리자 번호를 설정하고
            20가지 음료의 이름과 가격을 설정하며,
            CardList 객체를 생성하며 (CardList의 생성자 참고),
            시스템 동작에 필요한 주요 객체들을 생성하여 관리한다.
    *   Parameters : void
    *   Return values : void
    * */
    public Controller() {
        network = new Network(this);
        /* VM id, address, 관리자 코드 설정. */
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./TextFiles/VMInfo.txt"));
            String newLine;

            /* vmID setting part */
            newLine = bufferedReader.readLine();
            try{
                int id = Integer.parseInt(newLine);
                if(id < 1 || id > 10){
                    System.out.println("vmID는 1이상 10 이하의 숫자여야 합니다.");
                    System.exit(-1);
                }
                vmList.setMyID(id);
                network.setMyID(id);
            }catch(Exception e){
                e.printStackTrace();
                System.exit(-1);
            }

            /* vm address setting part */
            newLine = bufferedReader.readLine();
            if(newLine.length() > 10 || newLine.length() < 1){
                System.out.println("주소의 길이는 1 이상 10 이하여야 합니다.");
                System.exit(-1);
            }
            vmList.setMyAddress(newLine);

            /* admin code setting part */
            newLine = bufferedReader.readLine();
            if(newLine.length() == 6){
                /* 숫자인지 확인하는 부분 */
                try{
                    Integer.parseInt(newLine);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("오류 : 관리자 코드는 6자리의 숫자여야 합니다.");
                    System.exit(-1);
                }
                verificationCodeList.setAdminCode(newLine);
            }
            else{
                System.out.println("오류 : 관리자 코드는 6자리의 숫자여야 합니다.");
            }

            bufferedReader.close();
        } catch(Exception e){
            e.printStackTrace();
        }

        /* 음료 설정 부분 */
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./TextFiles/BeverageInfo.txt"));
            String newLine;

            /* vmID setting part */
            for(int i=0;i<20;i++){
                newLine = bufferedReader.readLine();
                String[] split = newLine.split("\\s+");
                beverages[i] = new Beverage(i, split[0], Integer.parseInt(split[1]));
            }
            bufferedReader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        updateStock();
    }

    /* GUI에서 사용할 interfaces */

    /*  Functionality :
            GUI에서 사용자로부터 입력받은 메뉴의 번호를 인자로 받아
            해당 메뉴의 재고를 확인한 뒤 재고가 있으면 true, 없으면 false를 리턴함.
    *   Parameters : beverage ID
    *   Return values :
    *       true : 재고 있음
            false : 재고 없음
    * */
    public boolean checkStock(int beverageID){
        nowMenu = beverageID;
        if(stock[beverageID] == 0){
            return false;
        }
        else{
            return true;
        }
    }

    /*  Functionality :
            Network를 통해 stock available한 DVM들의 주소를 리턴한다.
            크기가 10인 String 배열을 return 하며 각 index 값 + 1이 자판기의 아이디이고,
            주소가 null이면 해당 자판기는 available 하지 않은 것이다.
    *   Parameters : void
    *   Return values : String[10]
    * */
    public String[] requestStock(){
        boolean[] availableList = network.requestStock(nowMenu);
        String[] returnList = new String[10];

        for(int i=0;i<10;i++){
            returnList[i] = null;
        }
        /* 주소 추가하는 과정 */
        for(int i=0;i<10;i++){
            if(availableList[i]){
                returnList[i] = vmList.getSelectedVMAddress(i);
            }
        }

        return returnList;
    }
    /*  Functionality :
            GUI에서 사용자로부터 입력받은 카드 번호를 인자로 받아 결제를 진행한다.
            해당 카드의 정보를 조회한 뒤, 결제 결과를 반환한다.
    *   Parameters : cardID
    *   Return values :
    *       0 : 결제 성공
    *       1 : 일치하는 카드가 없음
    *       2 : 일치하는 카드 있음 & 카드가 유효하지 않음
    *       3 : 일치하는 카드가 있음 & 유효 & 잔액이 부족
    * */
    public int cardPayment(String cardID){
        int result = cardList.checkCard(cardID, beverages[nowMenu].getPrice());
        if(result == 0){
            stock[nowMenu]--;
        }
        return result;
    }

    /*  Functionality :
    *       선결제 대상 자판기에 인증코드 생성을 요청한다.
    *       인증코드를 응답 받으면 해당 인증코드를 반환하고, 재고가 없어 환불 요청을 받으면 null을 반환한다.
    *   Parameters : cardID
    *   Return values :
    *       인증코드 : 결제 성공
    *       null : 환불 됨
    * */
    public String requestVerificationCode(int selectedDVM) {
        return network.requestVerificationCode(selectedDVM,nowMenu);
    }

    /*  Functionality : Network에서 환불 요청 발생 시 결제한 카드의 잔액 복구
    *   Parameters : void
    *   Return values : void
    *  */
    public void refund(){
        cardList.refund();
    }

    public int checkCode(String code){
        if(code.length() == 6){
            if(code.equals(verificationCodeList.getAdminCode())){
                return 20;
            }
            return -1;
        }
        else if(code.length() == 4){
            return verificationCodeList.checkVerificationCode(code);
        }
        else{
            return -1;
        }
    }

    /*  Functionality :
            ./TextFiles/BeverageInfo.txt 파일을 읽어 재고를 업데이트한다.
    *
    * */
    public void updateStock(){
        try {
            int count=0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./TextFiles/Stock.txt"));
            String newLine;

            /* vmID setting part */
            for(int i=0;i<20;i++){
                newLine = bufferedReader.readLine();
                stock[i] = Integer.parseInt(newLine);
                if(stock[i]>0){
                    count++;
                }
            }
            if(count > 7){
                System.out.println("음료는 7종류만 판매할 수 있습니다.");
                System.exit(-1);
            }
            bufferedReader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Beverage[] getBeverages(){
        return beverages;
    }
    public String getBeverageName(){
        return beverages[nowMenu].getName();
    }

    public int[] getStock(){
        return stock;
    }

    public String getMyAddress(){
        return vmList.getMyAddress();
    }
    public void deleteVM(int vmID){
        vmList.deleteVM(vmID);
    }
    public void addVM(int vmID, String address){
        //System.out.println(address);
        vmList.addVM(vmID, address);
    }
    public String makeVerificationCode(int menu){
        stock[menu]--;
        /* 인증코드 생성됨 */
        String code = verificationCodeList.makeVerificationCode(menu);
        if(code != null){
            return code;
        }
        else{
            stock[menu]++;
            return null;
        }
    }
    public void runNetwork(){
        this.network.run();
    }
    public void vmOff(){
        network.requestVmOff();
    }
}