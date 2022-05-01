/*
 * Created by JFormDesigner on Sun May 01 23:22:14 CST 2022
 */

package View.AdminView;

import View.LoginView.Register;
import View.UserView.UserOrder;
import View.UserView.UserView;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class AdminView extends JFrame {
    public AdminView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("1");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u67e5\u770b\u83dc\u5355");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(150, 185), button1.getPreferredSize()));
        button1.addActionListener(e-> new AdminOrder().init()
        );

        //---- button2 ----
        button2.setText("\u67e5\u770b\u8ba2\u5355");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(390, 185), button2.getPreferredSize()));
        button2.addActionListener(e-> new AdminOrder().init()
        );

        contentPane.setPreferredSize(new Dimension(800, 600));//窗口大小
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
        this.setResizable(false);//锁定窗口大小
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
