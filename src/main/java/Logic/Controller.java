package Logic;

public class Controller {
    Controller() {
        /* 인증코드 관리 object 생성 및 기초 설정 */
        VerificationCodeList verficationManager = new VerificationCodeList();
        verficationManager.setAdminCode("123456");          //관리자 코드 설정

    }
}
