/*
 * Created by JFormDesigner on Fri Apr 29 14:03:36 CST 2022
 */

package View.LoginView;

import View.AdminView.AdminOrderView.AdminOrder;
import View.UserView.*;
import View.UserView.UserOrderView.UserOrder;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField("1111");
        textField2 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("login");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(165, 315), button1.getPreferredSize()));
        button1.addActionListener(e-> {
            if (radioButton1.isSelected()) {
                dispose();//关闭当前界面
                new UserOrder().init();//打开新界面
            } else if (radioButton2.isSelected()) {
                dispose();//关闭当前界面
                new AdminOrder().init();//打开新界面
            }
                }
        );



        //---- button2 ----
        button2.setText("register");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(350, 315), button2.getPreferredSize()));
        button2.addActionListener(e-> {
                    //dispose();//关闭当前界面
                    new Register();//打开新界面
                }
        );



        //---- radioButton1 ----
        radioButton1.setText("User");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(205, 105), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("Admin");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(320, 105), radioButton2.getPreferredSize()));

        ButtonGroup group = new ButtonGroup();    // (重点)给上面的男女多选按钮创建一个组
        group.add(radioButton1);        // 这里把多选按钮 “男” 扔进 group 组里面去
        group.add(radioButton2);


        //---- label1 ----
        label1.setText("account");
        contentPane.add(label1);
        label1.setBounds(170, 165, label1.getPreferredSize().width, 17);

        //---- label2 ----
        label2.setText("password  ");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(170, 220), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(245, 165, 120, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(245, 215, 120, textField2.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(600, 400));//窗口大小
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
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Login();
    }
}

