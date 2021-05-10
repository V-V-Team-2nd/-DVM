package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class GUI_ShowVerificationCode extends JFrame implements KeyListener{

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_ShowVerificationCode window = new GUI_ShowVerificationCode();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GUI_ShowVerificationCode() {
        showVerificationCode();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void showVerificationCode() {
        frame = new JFrame();
        frame.setBounds(10, 10, 645, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel ShowCodeLabel = new JLabel("");
        ShowCodeLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        ShowCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ShowCodeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        ShowCodeLabel.setBounds(158, 274, 305, 56);
        frame.getContentPane().add(ShowCodeLabel);

        JLabel NameLabel = new JLabel("인증코드");
        NameLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        NameLabel.setBackground(new Color(255, 255, 255));
        NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        NameLabel.setBounds(158, 208, 305, 56);
        frame.getContentPane().add(NameLabel);

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
        frame.getContentPane().add(cancelButton);
    }

    private void inputCancel() {
    }

}
