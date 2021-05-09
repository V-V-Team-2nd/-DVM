package Logic;

public class CardList {
    /* Attributes */
    private Card[] cardList = new Card[10];
    private int nowCard;
    private int nowPrice;

    /* Methods */

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