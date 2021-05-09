package Logic;

import java.io.BufferedReader;
import java.io.FileReader;

public class Controller {

    /* Attributes */

    VMList vmList = new VMList();
    CardList cardList = new CardList();
    VerificationCodeList verificationCodeList = new VerificationCodeList();
    Network network = new Network(this);
    Beverage[] beverages = new Beverage[20];
    int[] stock = new int[20];

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

}