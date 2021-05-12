package tests;

import Logic.CardList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardListTest {

    @Test
    void checkCard() {
        CardList cardList = new CardList();
        /* 해당하는 카드가 없는 경우 */
        assertEquals(cardList.checkCard("123451234512",423),1);
        assertEquals(cardList.checkCard("52431",4123),1);
        assertEquals(cardList.checkCard("622435252534",42523),1);
        /* 해당하는 카드가 있지만 유효하지 않을 경우 */
        assertEquals(cardList.checkCard("444444444444",2000),2);
        assertEquals(cardList.checkCard("666666666666",0),2);
        assertEquals(cardList.checkCard("888888888888",30000),2);
        /* 해당하는 카드가 있고 유효하지만 잔액이 없는 경우 */
        assertEquals(cardList.checkCard("111111111111",999000),3);
        assertEquals(cardList.checkCard("777777777777",1000),3);
        assertEquals(cardList.checkCard("999999999999",50000),3);
        /* 해당하는 카드가 있고, 유효하고, 잔액이 충분한 경우 */
        assertEquals(cardList.checkCard("111111111111",500),0);
        assertEquals(cardList.checkCard("555555555555",9200),0);
    }
}