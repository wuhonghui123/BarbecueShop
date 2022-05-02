/*
 * Created by JFormDesigner on Sat Apr 23 16:22:09 CST 2022
 */

package View.LoginView;

import java.awt.*;
import javax.swing.*;
import View.UserView.MainUserView;
//用户登录界面
/**
 * @author 1
 */
public class UserLogin extends JFrame {
    public UserLogin() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("账号");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(95, 85), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(165, 80, 95, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("密码");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(90, 150), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(170, 145, 90, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("登录");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 200), button1.getPreferredSize()));
        button1.addActionListener(e -> {//点击按钮执行操作
            dispose();//关闭当前窗口
            new MainUserView(); //显示窗口

        });

        //---- button2 ----
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 200), button2.getPreferredSize()));
        button2.addActionListener(e -> {//点击按钮执行操作

            new UserRegister(); //显示窗口

        });

        contentPane.setPreferredSize(new Dimension(400, 300));//窗口大小
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

