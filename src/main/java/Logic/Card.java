package Logic;

public class Card {
    /* Attributes */
    private String cardID;
    private boolean isValid;
    private int balance;

    /* Methods */

    /*  Functionality :
    *       생성자. 만약 잔액이 음수라면 0으로 설정.
    *   Parameters : 카드번호, 유효성, 잔액
    *   Return values : void */
    Card(String cardID, boolean isValid, int balance){
        this.cardID = cardID;
        this.isValid = isValid;
        this.balance = balance;
        if(this.balance < 0){
            this.balance = 0;
        }
    }
    public boolean getIsValid(){
        return this.isValid;
    }
    public int getBalance() {
        return balance;
    }

    /*public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setIsValid(boolean valid) {
        isValid = valid;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        *//* if (this.balance < 0) {
            this.balance = 0;
        }*//*
    }*/

    /*  Functionality :
            인자로 들어온 카드 번호를 cardID와 비교한 후
            일치하면 true, 일치하지 않으면 false를 반환함.
    *   Parameters : 비교할 카드 번호
    *   Return values :
            true : 일치함
            false : 일치하지 않음 */
    public boolean checkCardID(String cid){
        return cardID.equals(cid);
    }

    /*  Functionality :
            인자로 들어온 금액 만큼 기존 카드의 잔액을 차감하는 함수이다.
            기존 카드의 잔액이 더 적을 경우 잔액 차감에 실패하고 false를 반환한다.
    *   Parameters : 차감할 금액
    *   Return values :
    *       true : success
    *       false : fail
    * */
    public boolean reduceBalance(int amount){
        if(this.balance < amount){
            return false;
        }
        this.balance -= amount;
        return true;
    }

    /*  Fuctionality :
            인자로 들어온 금액 만큼 기존의 카드 잔액을 증가하는 함수이다.
        Parameters : 증가시킬 금액
        Return values : void
    * */
    public void restoreBalance(int amount) {
        this.balance += amount;
    }
}
