package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;


public class GUI_ShowVerificationCode extends JPanel {

    private GUI_Frame gui_frame;
    private JLabel NameLabel;
    private JLabel ShowCodeLabel;

    /**
     * Create the application.
     */
    public GUI_ShowVerificationCode(GUI_Frame gui_frame) {
        this.gui_frame = gui_frame;
        showVerificationCode();
    }

    /**
     * Initialize the contents of the frame.
     */

    private void showVerificationCode() {


        this.setBounds(10, 10, 645, 645);
        this.setLayout(null);

        ShowCodeLabel = new JLabel();
        ShowCodeLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        ShowCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ShowCodeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        ShowCodeLabel.setBounds(158, 274, 305, 56);
        this.add(ShowCodeLabel);

        NameLabel = new JLabel("인증코드");
        NameLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        NameLabel.setBackground(new Color(255, 255, 255));
        NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        NameLabel.setBounds(158, 208, 305, 56);
        this.add(NameLabel);

        JButton cancelButton = new JButton("취소");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputCancel();
            }
        });
        cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        cancelButton.setBounds(259, 355, 97, 47);
        this.add(cancelButton);
    }

    private void inputCancel() {
        gui_frame.selectCancel();
    }
    public void setCode(String code){
        ShowCodeLabel.setText(code);
    }
}
