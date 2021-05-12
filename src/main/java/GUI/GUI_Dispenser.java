package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class GUI_Dispenser extends JPanel implements ActionListener
{
    private final int ONE_SECOND = 1000;

    private GUI_Frame gui_frame;
    private Timer timer;
    private JLabel msgLabel;
    JLabel lblName;

    public GUI_Dispenser(GUI_Frame gui_frame)
    {
        this.gui_frame = gui_frame;
        this.setLayout(null);
        this.setBounds(10, 10, 645, 645);

        lblName = new JLabel();
        lblName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName.setBounds(159, 256, 308, 122);
        this.add(lblName);

        JLabel lblName_1 = new JLabel("음료가 나왔습니다");
        lblName_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblName_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblName_1.setBounds(159, 181, 308, 65);
        this.add(lblName_1);

        JButton cancelButton = new JButton("취소");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                gui_frame.selectCancel();

            }
        });
        cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        cancelButton.setBounds(263, 504, 97, 47);
        add(cancelButton);


    }

    /**
     * Start the timer
     */
    public void start (String bevName)
    {
        timer = new Timer (this.ONE_SECOND * 5, this);
        // only need to fire up once to make the message box disappear
        timer.setRepeats(false);
        // make the message box appear and start the timer
        lblName.setText(bevName);
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