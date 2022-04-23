package admin;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondPanel {
    private static JPanel panel = null;
    private static JFrame frame = null;

    public static JPanel secondView() {

        //导入frame
        frame = Adminfram.returnJFrame();

        panel = new JPanel();

        //添加新的panel
        frame.add(panel);

        panel.setBounds(-1, 31, 1103, 718);
        panel.setLayout(null);

        JLabel label = new JLabel("界面二");
        label.setFont(new Font("宋体", Font.PLAIN, 99));
        label.setBounds(356, 108, 326, 297);
        panel.add(label);

        return panel;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}


