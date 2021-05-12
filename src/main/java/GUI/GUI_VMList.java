package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class GUI_VMList extends JPanel {

    private GUI_Frame gui_frame;
    private JList list;

    /**
     * Create the application.
     */
    public GUI_VMList(GUI_Frame gui_frame) {
        this.gui_frame = gui_frame;

        this.setLayout(null);
        this.setBounds(10, 10, 645, 645);

        JLabel lblWkvk = new JLabel("\uC790\uD310\uAE30 \uC120\uD0DD");
        lblWkvk.setHorizontalAlignment(SwingConstants.CENTER);
        lblWkvk.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblWkvk.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        lblWkvk.setBackground(Color.WHITE);
        lblWkvk.setBounds(159, 76, 305, 56);
        this.add(lblWkvk);

        list = new JList();
        list.setBounds(116, 215, 400, 272);
        this.add(list);

        JButton cancelButton = new JButton("\uCDE8\uC18C");
        cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        cancelButton.setBounds(495, 525, 97, 47);
        this.add(cancelButton);
    }

    /* VMList를 반영하는 함수 */
    private void showVMList(String[] address) {
        for(int i=0;i<20;i++){
            if(!(address[i] == null)){
                /* 버튼 생성 및 List에 추가하기. */
            }
        }
    }
}
