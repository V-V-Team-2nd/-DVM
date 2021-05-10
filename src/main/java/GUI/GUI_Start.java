package GUI;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class GUI_Start extends JFrame implements KeyListener{

    private JFrame frame;
    private JTextField textField;
    private JPanel keyboard;
    private JPanel panel;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JPanel panel_1;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JPanel panel_2;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JButton btnNewButton_9;
    private JButton btnNewButton_10;
    private JButton btnNewButton_11;
    String codeString;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new GUI_Start().setVisible(true);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_Start window = new GUI_Start();
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
    public GUI_Start() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showStart();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void showStart() {
        frame = new JFrame();
        frame.setBounds(10, 10, 645, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(172, 180, 277, 34);
        textField.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        frame.getContentPane().add(textField);
        textField.setColumns(10);


        JButton btnNewButton = new JButton("시작");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btnNewButton.setBounds(260, 230, 97, 43);
        btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        frame.getContentPane().add(btnNewButton);

        panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        panel.setBounds(197, 301, 221, 70);
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));

        btnNewButton_2 = new JButton("1");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+1);
                }else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 1);
                }
            }
        });
        btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel.add(btnNewButton_2);

        btnNewButton_3 = new JButton("2");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+2);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 2);
                }
            }
        });
        btnNewButton_3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel.add(btnNewButton_3);

        btnNewButton_1 = new JButton("3");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+3);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 3);
                }
            }
        });
        btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel.add(btnNewButton_1);

        panel_1 = new JPanel();
        panel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        panel_1.setBounds(197, 373, 221, 70);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        btnNewButton_4 = new JButton("4");
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+4);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 4);
                }
            }
        });
        btnNewButton_4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel_1.add(btnNewButton_4);

        btnNewButton_5 = new JButton("5");
        btnNewButton_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+5);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 5);
                }
            }
        });
        btnNewButton_5.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel_1.add(btnNewButton_5);

        btnNewButton_6 = new JButton("6");
        btnNewButton_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+6);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 6);
                }
            }
        });
        btnNewButton_6.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel_1.add(btnNewButton_6);

        panel_2 = new JPanel();
        panel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        panel_2.setBounds(197, 445, 221, 70);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(new GridLayout(1, 0, 0, 0));

        btnNewButton_7 = new JButton("7");
        btnNewButton_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+7);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 7);
                }
            }
        });
        btnNewButton_7.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel_2.add(btnNewButton_7);

        btnNewButton_8 = new JButton("8");
        btnNewButton_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+8);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 8);
                }
            }
        });
        btnNewButton_8.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel_2.add(btnNewButton_8);

        btnNewButton_9 = new JButton("9");
        btnNewButton_9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+9);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 9);
                }
            }
        });
        btnNewButton_9.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        panel_2.add(btnNewButton_9);

        btnNewButton_10 = new JButton("0");
        btnNewButton_10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText(""+0);
                } else if(textField.getText().length() >=10){
                    return;
                }else {
                    textField.setText(textField.getText() + 0);
                }
            }
        });
        btnNewButton_10.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        btnNewButton_10.setBounds(271, 514, 73, 70);
        frame.getContentPane().add(btnNewButton_10);


        btnNewButton_11 = new JButton("Del");
        btnNewButton_11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().equals("0")) {
                    textField.setText("");
                } else {
                    codeString = textField.getText();
                    codeString = codeString.substring(0, codeString.length()-1);
                    textField.setText(codeString);
                }
            }
        });
        btnNewButton_11.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        btnNewButton_11.setBounds(345, 514, 73, 70);
        frame.getContentPane().add(btnNewButton_11);


    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
