package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

public class GUI_VMList {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_VMList window = new GUI_VMList();
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
    public GUI_VMList() {
        showVMList();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void showVMList() {
        frame = new JFrame();
        frame.setBounds(10, 10, 645, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblWkvk = new JLabel("\uC790\uD310\uAE30 \uC120\uD0DD");
        lblWkvk.setHorizontalAlignment(SwingConstants.CENTER);
        lblWkvk.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblWkvk.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        lblWkvk.setBackground(Color.WHITE);
        lblWkvk.setBounds(159, 76, 305, 56);
        frame.getContentPane().add(lblWkvk);

        JList list = new JList();
        list.setBounds(116, 215, 400, 272);
        frame.getContentPane().add(list);

        JButton cancelButton = new JButton("\uCDE8\uC18C");
        cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        cancelButton.setBounds(495, 525, 97, 47);
        frame.getContentPane().add(cancelButton);
    }
}
