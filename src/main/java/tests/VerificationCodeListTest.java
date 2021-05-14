package tests;

import Logic.VerificationCodeList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationCodeListTest {
    VerificationCodeList verificationCodeList = new VerificationCodeList();
    @Test
    void makeVerificationCode() {
        assertNotNull(verificationCodeList.makeVerificationCode(1));
        assertNotNull(verificationCodeList.makeVerificationCode(2));
        assertNotNull(verificationCodeList.makeVerificationCode(3));
        assertNotNull(verificationCodeList.makeVerificationCode(6));
        assertNotNull(verificationCodeList.makeVerificationCode(8));
        assertNotNull(verificationCodeList.makeVerificationCode(10));
        assertNotNull(verificationCodeList.makeVerificationCode(14));
        assertNotNull(verificationCodeList.makeVerificationCode(18));
        assertNotNull(verificationCodeList.makeVerificationCode(19));
    }

    @Test
    void checkVerificationCode() {
        assertEquals(verificationCodeList.checkVerificationCode("123"),-1);
        assertEquals(verificationCodeList.checkVerificationCode("153445"),-1);
        assertEquals(verificationCodeList.checkVerificationCode("14523"),-1);
        assertEquals(verificationCodeList.checkVerificationCode("12"),-1);

        assertEquals(verificationCodeList.checkVerificationCode(verificationCodeList.makeVerificationCode(0)), 0);
        assertEquals(verificationCodeList.checkVerificationCode(verificationCodeList.makeVerificationCode(1)), 1);
        assertEquals(verificationCodeList.checkVerificationCode(verificationCodeList.makeVerificationCode(2)), 2);
        assertEquals(verificationCodeList.checkVerificationCode(verificationCodeList.makeVerificationCode(3)), 3);
        assertEquals(verificationCodeList.checkVerificationCode(verificationCodeList.makeVerificationCode(10)), 10);
        assertEquals(verificationCodeList.checkVerificationCode(verificationCodeList.makeVerificationCode(19)), 19);
    }
}