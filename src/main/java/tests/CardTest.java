package tests;

import Logic.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    String cardID = "123412341234";
    int balance = 1024;
    Card card = new Card(cardID, true, balance);
    Card card2 = new Card(cardID, false, balance);

    @Test
    public void testGetIsValid(){
        assertTrue(card.getIsValid());
        assertFalse(card2.getIsValid());
    }

    @Test
    public void testCheckCardID(){
        assertTrue(card.checkCardID(cardID));
        assertFalse(card.checkCardID("123"));
        assertTrue(card.checkCardID(cardID));
        assertFalse(card.checkCardID("3456"));
    }

    @Test
    public void testReduceBalance(){
        assertFalse(card.reduceBalance(2048));
        assertTrue(card.reduceBalance(1));
        assertTrue(card.reduceBalance(3));
        assertTrue(card.reduceBalance(1020));
    }

    @Test
    public void testRestoreBalance(){
        card.restoreBalance(2048);
        assertTrue(card.reduceBalance(2048));
        card.restoreBalance(4000);
        assertTrue(card.reduceBalance(4000));
    }
}
