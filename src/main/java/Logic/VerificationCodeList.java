package Logic;

import java.util.ArrayList;
import java.util.Iterator;

public class VerificationCodeList {
    /* Attributes */
    private ArrayList<VerificationCode> codeList = new ArrayList<VerificationCode>();
    private String adminCode;

    /* Methods */

    /* getter, setter */
    public String getAdminCode(){
        return this.adminCode;
    }

    public void setAdminCode(String adminCode){
        this.adminCode = adminCode;
    }

    /*  Functionality : 중복이 없는 길이가 4인 인증코드를 생성한다.
    *   Parameters : 음료 아이디
    *   Return value :
    *       true: 4자리 인증코드
    *       false: null */
    public String makeVerificationCode(int beverageID){
        /* 코드의 개수가 이미 1000개 이상이므로 추가 불가 */
        if(codeList.size()>=1000){
            return null;
        }

        while(true){
            /* 랜덤 코드 코드 생성 부분 */
            char[] randCode = new char[4];
            for(int i=0;i<4;i++){
                randCode[i] = (char)((Math.random()*10) + 48);
            }
            String newCode = new String(randCode);

            /* 생성된 코드를 기존 codeList에서 비교함 */
            for(int i=0;i<codeList.size();i++){
                if(newCode.equals(codeList.get(i).getCode())){
                    continue;
                }
            }
            /* 같은 코드가 없어 코드 추가함. */
            codeList.add(new VerificationCode(beverageID, newCode));
            return newCode;
        }
    }
    /*  Functionality :
            parameter로 들어온 code가 codeList에 있는지 확인한다.
            codeList에 있다면 해당하는 음료의 ID를 반환하고,
            없다면 -1을 반환한다.
    *   Parameters : 인증코드 문자열
    *   Return value :
    *       0~19 : success
    *       -1 : fail */
    public int checkVerificationCode(String code){
        int length = codeList.size();

        for(int i=0;i<length;i++) {
            if (this.codeList.get(i).getCode().equals(code)) {
                int beverageID = this.codeList.get(i).getBeverageID();
                /* 해당되는 인증코드 삭제 작업 */
                codeList.remove(i);
                return beverageID;
            }
        }
        return -1;
    }
/*    *//*  Functionality : parameter로 들어온 code가 관리자 코드와 일치하는지 확인한다.
     *   Parameters : 인증코드 문자열
     *   Return value :
     *       true : success
     *       false : fail *//*
    public boolean checkAdminCode(String code){
        if(this.adminCode.equals(code)) {
            return true;
        }
        return false;
    }*/
}