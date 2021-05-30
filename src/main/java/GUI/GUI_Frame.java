package GUI;

import Logic.Beverage;
import Logic.Controller;

import javax.swing.*;

public class GUI_Frame extends JFrame {
    private GUI_Main gui_main = null;
    private GUI_Admin gui_admin = null;
    private GUI_VerificationCodeMode gui_verificationCodeMode = null;
    private GUI_CardPayment gui_cardPayment = null;
    private GUI_Dispenser gui_dispenser = null;
    private GUI_VMList gui_vmList = null;
    private GUI_Prepay gui_prepay = null;
    private GUI_ShowVerificationCode gui_showVerificationCode = null;
    private GUI_Error gui_error = null;
    private Controller controller = null;
    private int selectedDVM;

    public static void main(String[] args){
        new GUI_Frame();
    }

    public GUI_Frame(){
        super();
        setBounds(10, 10, 665, 665);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        controller = new Controller(this);
        gui_main = new GUI_Main(this, controller.getBeverages());
        gui_admin = new GUI_Admin(this);
        gui_verificationCodeMode = new GUI_VerificationCodeMode(this);
        gui_cardPayment = new GUI_CardPayment(this);
        gui_dispenser = new GUI_Dispenser(this);
        gui_vmList = new GUI_VMList(this);
        gui_prepay = new GUI_Prepay(this);
        gui_showVerificationCode = new GUI_ShowVerificationCode(this);
        gui_error = new GUI_Error(this);

        this.setTitle("DVM " + Integer.toString(controller.getMyID()) + " " + controller.getMyAddress());
        gui_main.changeButtonColor(controller.getStock());
        this.getContentPane().add(gui_main);
        //this.getContentPane().add(gui_cardPayment);
        this.setVisible(true);
        controller.runNetwork();
    }
    /*  Functionality :
    *   Parameters : type
    *       0 : Main
    *       1 : Admin
    *       2 : VerificationCodeMode
    *       3 : CardPayment
    *       4 : Dispenser
    *       5 : VMList
    *       6 : Prepay
    *       7 : ShowVerificationCode
    *       8 : Error
    *   Return values :
    *   */

    /**/
    public void selectMenu(int beverageID){
        /* 재고가 있을 경우 */
        if(controller.checkStock(beverageID)){
            this.getContentPane().removeAll();
            this.getContentPane().add(gui_cardPayment);
        }
        /* 재고가 없을 경우 */
        else{
            String[] address = controller.requestStock();
            for(int i=0;i<10;i++){
                System.out.println(address[i]);
            }
            gui_vmList.showVMList(address);
            this.getContentPane().removeAll();
            this.getContentPane().add(gui_vmList);
        }
        revalidate();
        repaint();
    }

    public void selectCancel(){
        this.getContentPane().removeAll();
        gui_main.changeButtonColor(controller.getStock());
        this.getContentPane().add(gui_main);
        revalidate();
        repaint();
    }
    public void changeButtonColor(){
        gui_main.changeButtonColor(controller.getStock());
        revalidate();
        repaint();
    }

    public void changeToVerificationMode(){
        this.getContentPane().removeAll();
        this.getContentPane().add(gui_verificationCodeMode);
        revalidate();
        repaint();
    }

    public void checkCode(String code){
        int result = controller.checkCode(code);
        if(result == -1){
            this.getContentPane().removeAll();
            gui_error.start(3);
            this.getContentPane().add(gui_error);
        }
        else if(result == 20){
            this.getContentPane().removeAll();
            this.getContentPane().add(gui_admin);
        }
        else{
            Beverage[] beverages = controller.getBeverages();
            gui_dispenser.start(beverages[result].getName());
            this.getContentPane().removeAll();
            this.getContentPane().add(gui_dispenser);
        }
        revalidate();
        repaint();
    }

    public void updateStock(){
        controller.updateStock();
    }
    /* 결제할 때 사용하는 methods */
    public void checkCard(String cardID){
        int result = controller.cardPayment(cardID);

        this.getContentPane().removeAll();

        if(result == 0){
            gui_dispenser.start(controller.getBeverageName());
            this.getContentPane().add(gui_dispenser);
        }
        else {
            switch (result) {
                case 1:
                case 2:
                    gui_error.start(1);
                    break;
                case 3:
                    gui_error.start(2);
                    break;
            }
            this.getContentPane().add(gui_error);
        }
        revalidate();
        repaint();
    }

    /* 선결제 할 때 사용하는 methods */
    public void checkCardPrepay(String cardID){
        int result = controller.cardPayment(cardID);

        if(result == 0){
            String code = controller.requestVerificationCode(selectedDVM);
            /* 환불 요청 */
            if(code == null){
                gui_error.start(4);
                this.getContentPane().removeAll();
                this.getContentPane().add(gui_error);
            }
            /* 인증코드 보여줌 */
            else{
                gui_showVerificationCode.setCode(code);
                this.getContentPane().removeAll();
                this.getContentPane().add(gui_showVerificationCode);
            }
        }
        else {
            switch (result) {
                case 1:
                case 2:
                    gui_error.start(1);
                    break;
                case 3:
                    gui_error.start(2);
                    break;
            }
            this.getContentPane().removeAll();
            this.getContentPane().add(gui_error);
        }
        revalidate();
        repaint();
    }


    /* 자판기 목록 중 하나의 DVM을 선택한 경우 호출 */
    public void selectDVM(int vmID){
        selectedDVM = vmID;
        /*결제 요청*/
        this.getContentPane().removeAll();
        this.getContentPane().add(gui_prepay);
        revalidate();
        repaint();

    }

    public void vmOff(){
        this.setVisible(false);
        controller.vmOff();
    }
}
