package Logic;

import java.io.BufferedReader;
import java.io.FileReader;

public class Controller {

    /* Attributes */

    private VMList vmList = new VMList();
    private CardList cardList = new CardList();
    private VerificationCodeList verificationCodeList = new VerificationCodeList();
    private Network network = new Network(this);
    private Beverage[] beverages = new Beverage[20];
    private int[] stock = new int[20];
    private int nowMenu;

    /* Methods */

    /*  Functionality :
            DVM 시스템의 동작을 전반적으로 관리하고 GUI에서 이 class에 정의된 operations를 이용하여
            DVM이 동작하게 된다.
            이 생성자에서는 VMInfo.txt파일을 읽어 아이디, 주소, 관리자 번호를 설정하고
            20가지 음료의 이름과 가격을 설정하며,
            CardList 객체를 생성하며 (CardList의 생성자 참고),
            시스템 동작에 필요한 주요 객체들을 생성하여 관리한다.
    *   Parameters : void
    *   Return values : void
    * */
    Controller() {

        /* VM id, address, 관리자 코드 설정. */
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("VMInfo.txt"));
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

    }

    /* GUI에서 사용할 interfaces */
    /*  Functionality :
            GUI에서 사용자로부터 입력받은 메뉴의 번호를 인자로 받아
            해당 메뉴의 재고를 확인한 뒤 재고가 있으면 null을 return하고, (이후 GUI에서 Cardpayment 실행)
            재고가 없으면 Network를 통해 stock available한 DVM들의 주소를 리턴한다.
            이 경우, 크기가 10인 String 배열을 return 하며 각 index 값 + 1이 자판기의 아이디이고,
            주소가 null이면 해당 자판기는 available 하지 않은 것이다.
    *   Parameters : beverage ID
    *   Return values :
    *       null : Stock
    * */
    public String[] checkStock(int beverageID){
        nowMenu = beverageID;
        if(stock[beverageID] == 0){
            return network.requestStock(beverageID);
        }
        else{
            return null;
        }
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
        return cardList.checkCard(cardID, beverages[nowMenu].getPrice());
    }
    /*  Functionality :
    *       GUI에서 사용자로부터 입력받은 카드 번호를 인자로 받아 선결제를 진행한다.
    *       해당 카드의 번호를 조회하고, 인증코드 생성 여부에 따라 결과를 아래 Return values로 반환한다.
    *   Parameters : cardID
    *   Return values :
    *       인증코드 : 결제 성공
    *       "1" : 일치하는 카드가 없음
    *       "2" : 일치하는 카드가 있음 & 카드가 유효하지 않음
    *       "3" : 일치하는 카드가 있음 & 유효 & 잔액이 부족
    *       "4" : 환불 됨
    * */
    public String cardPrepay(String cardID){
        String s = Integer.toString( cardList.checkCard( cardID, beverages[nowMenu].getPrice() ) );
        if(s.equals("0")){
            /* 결제 성공 시 동작 */
            return s;
        }
        else {
            return s;
        }
    }
}