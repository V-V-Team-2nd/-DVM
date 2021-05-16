package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_VerificationCodeMode extends JPanel implements KeyListener{

    private GUI_Frame gui_frame;
    private JTextField textField;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JButton btnNewButton_11;
    private JButton[] numBtn;
    String codeString;


    /**
     * Initialize the contents of the frame.
     */
    public GUI_VerificationCodeMode(GUI_Frame gui_frame) {
        this.gui_frame = gui_frame;
        this.setLayout(null);
        setBounds(10, 10, 645, 645);

        JLabel NameLabel = new JLabel("인증코드 입력");
        NameLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        NameLabel.setBackground(new Color(255, 255, 255));
        NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        NameLabel.setBounds(158, 100, 305, 56);
        this.add(NameLabel);



        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(172, 180, 277, 34);
        textField.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        textField.setColumns(10);
        this.add(textField);


        panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        panel.setBounds(197, 301, 221, 70);
        panel.setLayout(new GridLayout(1, 0, 0, 0));
        this.add(panel);

        numBtn = new JButton[10];

        for(int i=1;i<4;i++){
            int j = i;
            numBtn[i] = new JButton(Integer.toString(i));
            numBtn[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(textField.getText().length() >=6) {
                        return;
                    }else {
                        textField.setText(textField.getText() + j);
                    }
                }
            });
            numBtn[i].setFont(new Font("맑은 고딕", Font.BOLD, 22));
            panel.add(numBtn[i]);
        }

        panel_1 = new JPanel();
        panel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        panel_1.setBounds(197, 373, 221, 70);
        this.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        for(int i=4;i<7;i++){
            int j = i;
            numBtn[i] = new JButton(Integer.toString(i));
            numBtn[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(textField.getText().length() >=6) {
                        return;
                    }else {
                        textField.setText(textField.getText() + j);
                    }
                }
            });
            numBtn[i].setFont(new Font("맑은 고딕", Font.BOLD, 22));
            panel_1.add(numBtn[i]);
        }

        panel_2 = new JPanel();
        panel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        panel_2.setBounds(197, 445, 221, 70);
        this.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 0, 0, 0));

        for(int i=7;i<10;i++){
            int j = i;
            numBtn[i] = new JButton(Integer.toString(i));
            numBtn[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(textField.getText().length() >=6) {
                        return;
                    }else {
                        textField.setText(textField.getText() + j);
                    }
                }
            });
            numBtn[i].setFont(new Font("맑은 고딕", Font.BOLD, 22));
            panel_2.add(numBtn[i]);
        }

        numBtn[0] = new JButton("0");
        numBtn[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().length() >=6){
                    return;
                }else {
                    textField.setText(textField.getText() + 0);
                }
            }
        });
        numBtn[0].setFont(new Font("맑은 고딕", Font.BOLD, 22));
        numBtn[0].setBounds(271, 514, 73, 70);
        this.add(numBtn[0]);


        btnNewButton_11 = new JButton("Del");
        btnNewButton_11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codeString = textField.getText();
                if(codeString.length() >0) {
                    codeString = codeString.substring(0, codeString.length() - 1);
                    textField.setText(codeString);
                }
            }
        });
        btnNewButton_11.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        btnNewButton_11.setBounds(345, 514, 73, 70);
        this.add(btnNewButton_11);


        JButton btnNewButton = new JButton("입력");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codeString = textField.getText();
                inputCode(codeString);
                textField.setText("");
            }
        });
        btnNewButton.setBounds(260, 230, 97, 43);
        btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        this.add(btnNewButton);

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
        textField.setText("");
    }

    public void inputCode(String code){
        gui_frame.checkCode(code);
        textField.setText("");
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
