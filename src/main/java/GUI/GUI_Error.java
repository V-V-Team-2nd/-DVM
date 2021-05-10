package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

public class GUI_Error implements ActionListener
{
    private final int ONE_SECOND = 1000;

    private Timer timer;
    private JFrame frame;
    private JLabel msgLabel;

    public GUI_Error(String errorMsg)
    {
        frame = new JFrame();
        frame.setBounds(10, 10, 645, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel(errorMsg);
        lblName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName.setBounds(159, 256, 308, 122);
        frame.getContentPane().add(lblName);

        JLabel lblName_1 = new JLabel("ERROR!");
        lblName_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblName_1.setForeground(Color.RED);
        lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblName_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName_1.setBounds(159, 181, 308, 65);
        frame.getContentPane().add(lblName_1);

        timer = new Timer (this.ONE_SECOND * 5, this);
        // only need to fire up once to make the message box disappear
        timer.setRepeats(false);
    }

    /**
     * Start the timer
     */
    public void start ()
    {
        // make the message box appear and start the timer
        frame.setVisible(true);

        timer.start();
    }

    /**
     * Handling the event fired by the timer
     */
    public void actionPerformed (ActionEvent event)
    {
        // stop the timer and kill the message box
        timer.stop();
        frame.dispose();
    }

    public static void main (String[] args)
    {
        //errorMsg string으로 가져오기
        String errorMsg = "유효하지 않은 카드";
        GUI_Error dm = new GUI_Error(errorMsg);
        dm.start();
    }
}