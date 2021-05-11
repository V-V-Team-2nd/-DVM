package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Rectangle;

public class GUI_Main extends JPanel {

    private JFrame gui_frame;
    private JButton btnNewButton_5;
    private JButton btnNewButton_1;
    private JButton btnNewButton_1_2;
    private JButton btnNewButton_1_1_2;
    private JButton btnNewButton_1_1_1_1;
    private JButton btnNewButton_1_2_1;
    private JButton btnNewButton_3;
    private JButton btnNewButton_3_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_2_1_1;
    private JButton btnNewButton_2_1;
    private JButton btnNewButton_1_1_2_1;
    private JButton btnNewButton_1_1_1_1_1;
    private JButton btnNewButton_1_1_1;
    private JButton btnNewButton_1_1;
    private JButton btnNewButton_3_1_1;
    private JButton btnNewButton_1_2_1_1;
    private JButton btnNewButton_2_1_1_1;
    private JButton btnNewButton_1_1_1_1_1_1;
    private JButton btnNewButton_4;

    /**
     * Create the application.
     */
    public GUI_Main(GUI_Frame gui_frame) {
        this.gui_frame = gui_frame;
        this.setLayout(null);
        setBounds(10, 10, 645, 645);

        btnNewButton_5 = new JButton("코카콜라");
        btnNewButton_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(0);
            }
        });
        btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_5.setBounds(12, 49, 120, 63);
        this.add(btnNewButton_5);



        btnNewButton_1 = new JButton("제로콜라");
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(1);
            }
        });
        btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1.setBounds(134, 49, 120, 63);
        this.add(btnNewButton_1);





        btnNewButton_1_2 = new JButton("게토레이");
        btnNewButton_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(2);
            }
        });
        btnNewButton_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_2.setBounds(134, 170, 120, 63);
        this.add(btnNewButton_1_2);




        btnNewButton_1_1_2 = new JButton("포카리스웨트");
        btnNewButton_1_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1_2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(3);
            }
        });
        btnNewButton_1_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1_2.setBounds(376, 170, 120, 63);
        this.add(btnNewButton_1_1_2);




        btnNewButton_1_1_1_1 = new JButton("핫식스");
        btnNewButton_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(4);
            }
        });
        btnNewButton_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1_1_1.setBounds(497, 170, 120, 63);
        this.add(btnNewButton_1_1_1_1);




        btnNewButton_1_2_1 = new JButton("몬스터");
        btnNewButton_1_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(5);
            }
        });
        btnNewButton_1_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_2_1.setBounds(134, 297, 120, 63);
        this.add(btnNewButton_1_2_1);




        btnNewButton_3 = new JButton("파워에이드");
        btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(6);
            }
        });
        btnNewButton_3.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_3.setBounds(12, 170, 120, 63);
        this.add(btnNewButton_3);




        btnNewButton_3_1 = new JButton("\uD658\uD0C0");
        btnNewButton_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_3_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(7);
            }
        });
        btnNewButton_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_3_1.setBounds(12, 297, 120, 63);
        this.add(btnNewButton_3_1);



        btnNewButton_2 = new JButton("칠성사이다");
        btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(8);
            }
        });
        btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_2.setBounds(255, 49, 120, 63);
        this.add(btnNewButton_2);




        btnNewButton_2_1_1 = new JButton("코코팜");
        btnNewButton_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(9);
            }
        });
        btnNewButton_2_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_2_1_1.setBounds(255, 297, 120, 63);
        this.add(btnNewButton_2_1_1);




        btnNewButton_2_1 = new JButton("레쓰비");
        btnNewButton_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(10);
            }
        });
        btnNewButton_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_2_1.setBounds(255, 170, 120, 63);
        this.add(btnNewButton_2_1);




        btnNewButton_1_1_2_1 = new JButton("갈아만든 배");
        btnNewButton_1_1_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1_2_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(11);
            }
        });
        btnNewButton_1_1_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1_2_1.setBounds(376, 297, 120, 63);
        this.add(btnNewButton_1_1_2_1);

        btnNewButton_1_1_1_1_1 = new JButton("레모네이드");
        btnNewButton_1_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1_1_1_1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(12);
            }
        });
        btnNewButton_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1_1_1_1.setBounds(497, 297, 120, 63);
        this.add(btnNewButton_1_1_1_1_1);




        btnNewButton_1_1_1 = new JButton("제주감귤");
        btnNewButton_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(13);
            }
        });
        btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1_1.setBounds(497, 49, 120, 63);
        this.add(btnNewButton_1_1_1);



        btnNewButton_1_1 = new JButton("초록매실");
        btnNewButton_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(14);
            }
        });
        btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1.setBounds(376, 49, 120, 63);
        this.add(btnNewButton_1_1);



        btnNewButton_3_1_1 = new JButton("웰치스");
        btnNewButton_3_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_3_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(15);
            }
        });

        btnNewButton_3_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_3_1_1.setBounds(12, 419, 120, 63);
        this.add(btnNewButton_3_1_1);




        btnNewButton_1_2_1_1 = new JButton("토레타");
        btnNewButton_1_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_2_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(16);
            }

        });
        btnNewButton_1_2_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_2_1_1.setBounds(134, 419, 120, 63);
        this.add(btnNewButton_1_2_1_1);

        btnNewButton_2_1_1_1 = new JButton("쿠우");
        btnNewButton_2_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(17);
            }

        });
        btnNewButton_2_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_2_1_1_1.setBounds(255, 419, 120, 63);
        this.add(btnNewButton_2_1_1_1);

        JButton btnNewButton_1_1_2_1_1 = new JButton("쌕쌕");
        btnNewButton_1_1_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1_2_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(18);
            }
        });
        btnNewButton_1_1_2_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1_2_1_1.setBounds(376, 419, 120, 63);
        this.add(btnNewButton_1_1_2_1_1);




        btnNewButton_1_1_1_1_1_1 = new JButton("T.O.P");
        btnNewButton_1_1_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectMenu(19);
            }
        });
        btnNewButton_1_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        btnNewButton_1_1_1_1_1_1.setBounds(497, 419, 120, 63);
        this.add(btnNewButton_1_1_1_1_1_1);




        btnNewButton_4 = new JButton("인증코드 입력");
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.changeToVerificationMode();
            }
        });
        btnNewButton_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        btnNewButton_4.setBounds(241, 526, 154, 50);
        this.add(btnNewButton_4);


        JLabel num_0 = new JLabel("0");
        num_0.setBounds(new Rectangle(0, 127, 0, 0));
        num_0.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_0.setBounds(60, 127, 29, 15);
        this.add(num_0);

        JLabel num_1 = new JLabel("0");
        num_1.setBounds(new Rectangle(0, 127, 0, 0));
        num_1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_1.setBounds(188, 127, 29, 15);
        this.add(num_1);

        JLabel num_2 = new JLabel("0");
        num_2.setBounds(new Rectangle(0, 127, 0, 0));
        num_2.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_2.setBounds(312, 127, 29, 15);
        this.add(num_2);

        JLabel num_3 = new JLabel("0");
        num_3.setBounds(new Rectangle(0, 127, 0, 0));
        num_3.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_3.setBounds(428, 127, 29, 15);
        this.add(num_3);

        JLabel num_4 = new JLabel("0");
        num_4.setBounds(new Rectangle(0, 127, 0, 0));
        num_4.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_4.setBounds(551, 127, 29, 15);
        this.add(num_4);

        JLabel num_5 = new JLabel("0");
        num_5.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_5.setBounds(new Rectangle(0, 127, 0, 0));
        num_5.setBounds(60, 243, 29, 15);
        this.add(num_5);

        JLabel num_7 = new JLabel("0");
        num_7.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_7.setBounds(new Rectangle(0, 127, 0, 0));
        num_7.setBounds(188, 243, 29, 15);
        this.add(num_7);

        JLabel num_8 = new JLabel("0");
        num_8.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_8.setBounds(new Rectangle(0, 127, 0, 0));
        num_8.setBounds(312, 243, 29, 15);
        this.add(num_8);

        JLabel num_9 = new JLabel("0");
        num_9.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_9.setBounds(new Rectangle(0, 127, 0, 0));
        num_9.setBounds(428, 243, 29, 15);
        this.add(num_9);

        JLabel num_10 = new JLabel("0");
        num_10.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_10.setBounds(new Rectangle(0, 127, 0, 0));
        num_10.setBounds(551, 243, 29, 15);
        this.add(num_10);

        JLabel num_11 = new JLabel("0");
        num_11.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_11.setBounds(new Rectangle(0, 127, 0, 0));
        num_11.setBounds(60, 374, 29, 15);
        this.add(num_11);

        JLabel num_12 = new JLabel("0");
        num_12.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_12.setBounds(new Rectangle(0, 127, 0, 0));
        num_12.setBounds(188, 374, 29, 15);
        this.add(num_12);

        JLabel num_13 = new JLabel("0");
        num_13.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_13.setBounds(new Rectangle(0, 127, 0, 0));
        num_13.setBounds(312, 374, 29, 15);
        this.add(num_13);

        JLabel num_14 = new JLabel("0");
        num_14.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_14.setBounds(new Rectangle(0, 127, 0, 0));
        num_14.setBounds(428, 374, 29, 15);
        this.add(num_14);

        JLabel num_15 = new JLabel("0");
        num_15.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_15.setBounds(new Rectangle(0, 127, 0, 0));
        num_15.setBounds(551, 374, 29, 15);
        this.add(num_15);

        JLabel num_16 = new JLabel("0");
        num_16.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_16.setBounds(new Rectangle(0, 127, 0, 0));
        num_16.setBounds(60, 492, 29, 15);
        this.add(num_16);

        JLabel num_17 = new JLabel("0");
        num_17.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_17.setBounds(new Rectangle(0, 127, 0, 0));
        num_17.setBounds(188, 492, 29, 15);
        this.add(num_17);

        JLabel num_18 = new JLabel("0");
        num_18.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_18.setBounds(new Rectangle(0, 127, 0, 0));
        num_18.setBounds(312, 492, 29, 15);
        this.add(num_18);

        JLabel num_19 = new JLabel("0");
        num_19.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_19.setBounds(new Rectangle(0, 127, 0, 0));
        num_19.setBounds(428, 492, 29, 15);
        this.add(num_19);

        JLabel num_20 = new JLabel("0");
        num_20.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        num_20.setBounds(new Rectangle(0, 127, 0, 0));
        num_20.setBounds(551, 492, 29, 15);
        this.add(num_20);

    }
}
