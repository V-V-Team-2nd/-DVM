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

public class GUI_Admin extends JPanel {

    private GUI_Frame gui_frame;

    /**
     * Create the application.
     */
    public GUI_Admin(GUI_Frame gui_frame) {
        this.gui_frame = gui_frame;
        showAdmin();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void showAdmin() {
        this.setLayout(null);
        setBounds(10, 10, 645, 645);

        JButton btnNewButton = new JButton("음료 재고 관리");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                manageStock();
            }
        });
        btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnNewButton.setBounds(212, 206, 198, 64);
        this.add(btnNewButton);

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
        btnNewButton_1.setBounds(300, 300, 176, 75);
        this.add(btnNewButton_1);

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
        this.add(cancelButton);
    }

    private void inputCancel() {
        gui_frame.selectCancel();
    }

    private void inputVMOoff() {

    }

    private void manageStock() {
        gui_frame.updateStock();
        gui_frame.selectCancel();
    }

}
