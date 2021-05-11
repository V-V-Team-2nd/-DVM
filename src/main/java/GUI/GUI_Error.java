package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class GUI_Error extends JPanel implements ActionListener
{
    private final int ONE_SECOND = 1000;
    private Timer timer;
    private GUI_Frame gui_frame;
    private JLabel lblName;

    public GUI_Error(GUI_Frame gui_frame)
    {
        this.gui_frame = gui_frame;
        this.setLayout(null);
        setBounds(10, 10, 645, 645);

        lblName = new JLabel();
        lblName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName.setBounds(159, 256, 308, 122);

        this.add(lblName);

        JLabel lblName_1 = new JLabel("ERROR!");
        lblName_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblName_1.setForeground(Color.RED);
        lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblName_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName_1.setBounds(159, 181, 308, 65);
        this.add(lblName_1);
    }

    /**
     * Start the timer
     */
    /*  1.유효한 카드가 아닙니다.
        2.카드의 잔액이 부족합니다.
        3.유효한 인증코드가 아닙니다.(관리자+음료인증코드)
        4.재고가 없습니다. 환불을 진행합니다.
    * */
    public void start (int errorType)
    {
        timer = new Timer (this.ONE_SECOND * 5, this);
        // only need to fire up once to make the message box disappear
        timer.setRepeats(false);
        switch(errorType){
            case 1:
                lblName.setText("유효한 카드가 아닙니다.");
                break;
            case 2:
                lblName.setText("카드의 잔액이 부족합니다.");
                break;
            case 3:
                lblName.setText("유효한 인증코드가 아닙니다.");
                break;
            case 4:
                lblName.setText("해당 자판기에 재고가 없습니다. 환불을 진행합니다.");
                break;
        }

        // make the message box appear and start the timer
        timer.start();
    }

    /**
     * Handling the event fired by the timer
     */
    public void actionPerformed (ActionEvent event)
    {
        // stop the timer and kill the message box
        timer.stop();
        gui_frame.selectCancel();
    }
}