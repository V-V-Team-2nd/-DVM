package Logic;

import java.io.BufferedReader;
import java.io.FileReader;

public class CardList {
    /* Attributes */
    private Card[] cardList = new Card[10];
    private int nowCard;
    private int nowPrice;

    /* Methods */

    /*  Functionality :
            CardList의 생성자.
            ./TextFiles/CardInfo.txt 파일을 읽어 카드 번호, 유효성, 잔액을 생성하여 cardList에 저장한다.
        Requirements of CardInfo.txt :
            반드시 10개의 카드 정보가 있어야한다.
            카드 번호는 반드시 12자리의 숫자로 구성되어야 한다.
            카드 번호는 중복되면 안된다.
            잔액은 2,147,483,647 이하의 숫자여야 한다.
    *   Parameters : void
    *   Return values : void
    * */
    public CardList(){
        try{
            /* 경로 수정 필요 */
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./TextFiles/CardInfo.txt"));
            String newLine;

            for(int i=0;i<10;i++){
                newLine = bufferedReader.readLine();
                String[] split = newLine.split("\\s+");
                if(split[0].length() != 12){
                    System.out.println("올바른 카드 형식이 아닙니다.");
                    System.exit(-1);
                }
                try{
                    Long.parseLong(split[0]);
                }catch(Exception e){
                    System.out.println("올바른 카드 형식이 아닙니다.");
                    System.exit(-1);
                }
                cardList[i] = new Card(split[0], Boolean.parseBoolean(split[1]), Integer.parseInt(split[2]));
                /* cardList[i].setCardID(split[0]);
                cardList[i].setIsValid(Boolean.parseBoolean(split[1]));
                cardList[i].setBalance(Integer.parseInt(split[2]));*/
            }

            bufferedReader.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /*  Functionality :
            입력 인자로 카드 번호를 받아 DVM에 저장된 카드 번호를 검색하고 결제를 진행한다.
            일치하는 카드가 없으면 1
            일치하는 카드가 있으나 유효하지 않으면 2
            일치하는 카드가 있고 유효하지만 잔액이 부족하면 3
            결제가 성공하면 0
    *   Parameters : 카드 번호
    *   Return value :
    *       0 : 결제 성공
    *       1 : 일치하는 카드가 없음
    *       2 : 일치하는 카드 있음 & 카드가 유효하지 않음
    *       3 : 일치하는 카드가 있음 & 유효 & 잔액이 부족
    * */
    public int checkCard(String cardNum, int nowPrice){
        this.nowPrice = nowPrice;
        /* 카드 번호를 카드 리스트에서 검색함 */
        this.nowCard = -1;
        for(int i=0;i<10;i++){
            if(cardList[i].checkCardID(cardNum)){
                this.nowCard = i;
                break;
            }
        }
        if(this.nowCard == -1){
            return 1;
        }
        /* 유효성 검사 */
        if(!this.cardList[this.nowCard].getIsValid()){
            return 2;
        }
        /* 잔액 검사 */
        if(!this.cardList[this.nowCard].reduceBalance(this.nowPrice)){
            return 3;
        }
        return 0;
    }

    /*  Functionality :
    *       결제했던 카드의 잔액을 결제한 금액만큼 증가시킨다.
    *   Parameter : void
    *   Return value : void
    * */
    public void refund(){
        this.cardList[this.nowCard].restoreBalance(this.nowPrice);
    }
}