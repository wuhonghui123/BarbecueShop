/*
 * Created by JFormDesigner on Sat Apr 23 16:09:17 CST 2022
 */

package View.LoginView;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class LoginUI extends JFrame {
    public LoginUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.setSize(600,400);


        //---- button1 ----
        button1.setText("\u7528\u6237");
        contentPane.add(button1);
        button1.setBounds(55, 125, 110, 55);
        button1.addActionListener(e-> {
                    dispose();//关闭当前界面
                    new UserLogin();//打开新界面
                }
        );

        //---- button2 ----
        button2.setText("\u7ba1\u7406");
        contentPane.add(button2);
        button2.setBounds(230, 125, 110, 55);
        button2.addActionListener(e->{
                    dispose();//关闭当前界面
                    new AdminLogin();//打开新界面

                }

        );

        contentPane.setPreferredSize(new Dimension(400, 300));//窗口大小
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new LoginUI().setVisible(true);
    }
}

