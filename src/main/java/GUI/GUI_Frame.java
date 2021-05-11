package GUI;

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

    public static void main(String[] args){
        new GUI_Frame();
    }

    GUI_Frame(){
        super("DVM");
        setBounds(10, 10, 665, 665);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        controller = new Controller();
        gui_main = new GUI_Main(this);
        gui_admin = new GUI_Admin(this);
        gui_verificationCodeMode = new GUI_VerificationCodeMode(this);
        gui_cardPayment = new GUI_CardPayment(this);
        gui_dispenser = new GUI_Dispenser(this);
//        gui_vmList = new GUI_VMList(this);
//        gui_prepay = new GUI_Prepay(this);
//        gui_showVerificationCode = new GUI_ShowVerificationCode(this);*/
        gui_error = new GUI_Error(this);


        this.getContentPane().add(gui_main);
        //this.getContentPane().add(gui_cardPayment);
        this.setVisible(true);
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
            revalidate();
            repaint();
        }
        /* 재고가 없을 경우 */
        else{
            controller.requestStock();
            this.getContentPane().removeAll();
        }
    }

    public void selectCancel(){
        this.getContentPane().removeAll();
        this.getContentPane().add(gui_main);
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
            revalidate();
            repaint();
        }
        else if(result == 20){
            this.getContentPane().removeAll();
            this.getContentPane().add(gui_admin);
            revalidate();
            repaint();
        }
        else{

        }
    }

    public void updateStock(){
        controller.updateStock();
    }
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
}
