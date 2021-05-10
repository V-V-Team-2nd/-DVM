package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class GUI_Admin {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_Admin window = new GUI_Admin();
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
    public GUI_Admin() {
        showAdmin();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void showAdmin() {
        frame = new JFrame();
        frame.setBounds(10, 10, 645, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("음료 재고 관리");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                manageStock();
            }
        });
        btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnNewButton.setBounds(212, 206, 198, 64);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("종료");
        btnNewButton_1.setForeground(new Color(165, 42, 42));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputVMOoff();
            }
        });
        btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        btnNewButton_1.setMaximumSize(new Dimension(100, 100));
        btnNewButton_1.setIconTextGap(7);
        btnNewButton_1.setBounds(419, 505, 176, 75);
        frame.getContentPane().add(btnNewButton_1);

        JButton cancelButton = new JButton("취소");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inputCancel();
            }
        });
        cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        cancelButton.setBounds(500, 530, 97, 47);
        frame.getContentPane().add(cancelButton);
    }

    private void inputCancel() {
    }

    private void inputVMOoff() {
    }

    private void manageStock() {
    }

}
