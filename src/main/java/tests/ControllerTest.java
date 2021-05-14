/*
package tests;

import GUI.GUI_Frame;
import Logic.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller controller = new Controller();
    @Test
    void checkStock() {

        assertEquals(controller.checkStock(0),true);
        assertEquals(controller.checkStock(1),true);
        assertEquals(controller.checkStock(2),true);
        assertEquals(controller.checkStock(3),true);
        assertEquals(controller.checkStock(4),true);
        assertEquals(controller.checkStock(5),true);
        assertEquals(controller.checkStock(6),true);
        assertEquals(controller.checkStock(10),false);
        assertEquals(controller.checkStock(14),false);
        assertEquals(controller.checkStock(19),false);
    }

    @Test
    void cardPayment() {
        controller.checkStock(0);
        assertEquals(controller.cardPayment("111111111111"),0);
        controller.checkStock(1);
        assertEquals(controller.cardPayment("111111111111"),0);
        controller.checkStock(2);
        assertEquals(controller.cardPayment("131313131313"),1);
        controller.checkStock(3);
        assertEquals(controller.cardPayment("242424242424"),1);
        controller.checkStock(4);
        assertEquals(controller.cardPayment("666666666666"),2);
        controller.checkStock(5);
        assertEquals(controller.cardPayment("888888888888"),2);
        controller.checkStock(6);
        assertEquals(controller.cardPayment("999999999999"),3);

    }

    @Test
    void requestVerificationCode() {
        assertEquals(controller.requestVerificationCode(1),null);
        assertEquals(controller.requestVerificationCode(4),null);
        assertEquals(controller.requestVerificationCode(9),null);
    }

    @Test
    void checkCode() {
        assertEquals(controller.checkCode("123456"),20);
        assertEquals(controller.checkCode("12345"),-1);
        assertEquals(controller.checkCode("1234"),-1);
        assertEquals(controller.checkCode("12"),-1);
        assertEquals(controller.checkCode("1"),-1);
    }

    @Test
    void makeVerificationCode() {
        assertNotNull(controller.makeVerificationCode(5));
        assertNotNull(controller.makeVerificationCode(3));
        assertNotNull(controller.makeVerificationCode(4));
        assertNotNull(controller.makeVerificationCode(2));
        assertNotNull(controller.makeVerificationCode(6));
        assertNotNull(controller.makeVerificationCode(5));
    }
}*/
