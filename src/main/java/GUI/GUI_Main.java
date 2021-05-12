package GUI;

import Logic.Beverage;

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
    private JButton[] beverageMenu;
    private JButton btnNewButton_4;
    private JLabel[] price;

    /**
     * Create the application.
     */
    public GUI_Main(GUI_Frame gui_frame, Beverage[] beverages) {
        this.gui_frame = gui_frame;
        this.setLayout(null);
        setBounds(10, 10, 645, 645);

        /* 버튼 설정 part */
        beverageMenu = new JButton[20];
        for(int i=0;i<20;i++){
            int j = i;
            beverageMenu[i] = new JButton();
            beverageMenu[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    gui_frame.selectMenu(j);
                }
            });
            beverageMenu[i].setHorizontalTextPosition(SwingConstants.CENTER);
            beverageMenu[i].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
            beverageMenu[i].setText(beverages[i].getName());
        }

        beverageMenu[0].setBounds(12, 49, 120, 63);
        beverageMenu[1].setBounds(134, 49, 120, 63);
        beverageMenu[2].setBounds(255, 49, 120, 63);
        beverageMenu[3].setBounds(376, 49, 120, 63);
        beverageMenu[4].setBounds(497, 49, 120, 63);

        beverageMenu[5].setBounds(12, 170, 120, 63);
        beverageMenu[6].setBounds(134, 170, 120, 63);
        beverageMenu[7].setBounds(255, 170, 120, 63);
        beverageMenu[8].setBounds(376, 170, 120, 63);
        beverageMenu[9].setBounds(497, 170, 120, 63);

        beverageMenu[10].setBounds(12, 297, 120, 63);
        beverageMenu[11].setBounds(134, 297, 120, 63);
        beverageMenu[12].setBounds(255, 297, 120, 63);
        beverageMenu[13].setBounds(376, 297, 120, 63);
        beverageMenu[14].setBounds(497, 297, 120, 63);

        beverageMenu[15].setBounds(12, 419, 120, 63);
        beverageMenu[16].setBounds(134, 419, 120, 63);
        beverageMenu[17].setBounds(255, 419, 120, 63);
        beverageMenu[18].setBounds(376, 419, 120, 63);
        beverageMenu[19].setBounds(497, 419, 120, 63);


        for(int i=0;i<20;i++){
            this.add(beverageMenu[i]);
        }

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

        /* Label 설정 part */
        price = new JLabel[20];
        for(int i=0;i<20;i++){
            price[i] = new JLabel(Integer.toString(beverages[i].getPrice()));
            price[i].setFont(new Font("맑은 고딕", Font.BOLD, 19));
        }

        price[0].setBounds(60, 127, 29, 15);
        price[1].setBounds(188, 127, 29, 15);
        price[2].setBounds(312, 127, 29, 15);
        price[3].setBounds(428, 127, 29, 15);
        price[4].setBounds(551, 127, 29, 15);
        price[5].setBounds(60, 243, 29, 15);
        price[6].setBounds(188, 243, 29, 15);
        price[7].setBounds(312, 243, 29, 15);
        price[8].setBounds(428, 243, 29, 15);
        price[9].setBounds(551, 243, 29, 15);
        price[10].setBounds(60, 374, 29, 15);
        price[11].setBounds(188, 374, 29, 15);
        price[12].setBounds(312, 374, 29, 15);
        price[13].setBounds(428, 374, 29, 15);
        price[14].setBounds(551, 374, 29, 15);
        price[15].setBounds(60, 492, 29, 15);
        price[16].setBounds(188, 492, 29, 15);
        price[17].setBounds(312, 492, 29, 15);
        price[18].setBounds(428, 492, 29, 15);
        price[19].setBounds(551, 492, 29, 15);


        for(int i=0;i<20;i++){
            this.add(price[i]);
        }
    }
    public void changeButtonColor(int[] stock){
        Color available = new Color(0x66FF66);
        Color soldOut = new Color(0xFF6666);
        for(int i=0;i<20;i++){
            if(stock[i] > 0){
                beverageMenu[i].setBackground(available);
            }
            else{
                beverageMenu[i].setBackground(soldOut);
            }
        }
    }
}
