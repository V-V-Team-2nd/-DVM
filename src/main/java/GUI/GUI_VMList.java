package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_VMList extends JPanel {

    private GUI_Frame gui_frame;
    private JList list;
    private JPanel btnPanel;

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

        btnPanel = new JPanel();
        btnPanel.setBounds(116, 210, 400, 280);
        btnPanel.setLayout(new GridLayout(10,1));
        this.add(btnPanel);

        JButton cancelButton = new JButton("\uCDE8\uC18C");
        cancelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        cancelButton.setBounds(495, 525, 97, 47);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui_frame.selectCancel();
            }
        });
        this.add(cancelButton);
    }

    /* VMList를 반영하는 함수 */
    public void showVMList(String[] address) {
        btnPanel.removeAll();
        boolean flag = false;
        for(int i=0;i<10;i++){
            if(address[i] != null){
                flag = true;
                /* 버튼 생성 및 List에 추가하기. */
                int j = i+1;
                JButton btn = new JButton(address[i]);
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        gui_frame.selectDVM(j);
                    }
                });
                btn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
                btnPanel.add(btn);
            }
        }
        if(!flag){
            JLabel error = new JLabel("판매 가능한 자판기가 없습니다.");
            error.setFont(new Font("맑은 고딕", Font.BOLD, 22));
            error.setHorizontalAlignment(SwingConstants.CENTER);
            btnPanel.add(error);
        }
    }
}
