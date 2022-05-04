/*
 * Created by JFormDesigner on Fri Apr 29 14:03:36 CST 2022
 */

package View.LoginView;

import View.AdminView.AdminOrderView.*;
import View.AdminView.AdminOrderView.AdminOrder;
import View.UserView.*;
import View.UserView.UserOrderView.UserOrder;

import java.awt.*;
import java.sql.*;
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
        textField1 = new JTextField();
        textField2 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("登录");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(165, 315), button1.getPreferredSize()));
        button1.addActionListener(e-> {
            if (radioButton1.isSelected()) {
                String userid = textField1.getText();
                String password = textField2.getText();
                String user = "root";
                String dbPassword = "123456";
                String url = "jdbc:mysql://120.25.164.209:3306/barbecueshopsystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                Connection conn = null;
                String sql = "SELECT * FROM user WHERE user_id='" + userid + "' AND user_password='" + password + "'";
                ResultSet rs = null;
                Statement stmt = null;
                try {
                    conn = DriverManager.getConnection(url, user, dbPassword);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        //System.out.println("登录成功");
                        dispose();//关闭当前界面
                        new UserOrder().init(userid);//打开新界面，并传递一个ID给新界面
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "账号或密码错误");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else if (radioButton2.isSelected()) {
                String adminname = textField1.getText();
                String password = textField2.getText();

                String user = "root";
                String dbPassword = "123456";
                String url = "jdbc:mysql://120.25.164.209:3306/barbecueshopsystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                Connection conn = null;
                String sql = "SELECT * FROM admin WHERE admin_name='" + adminname + "' AND admin_password='" + password + "'";
                System.out.println(sql);
                ResultSet rs = null;
                Statement stmt = null;
                try {
                    conn = DriverManager.getConnection(url, user, dbPassword);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        System.out.println("登录成功");
                        dispose();//关闭当前界面
                        new AdminOrder().init();//打开新界面
                       // this.setVisible(false);
                    } else {
                        System.out.println("用户名或密码错误");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
                }
        );



        //---- button2 ----
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(350, 315), button2.getPreferredSize()));
        button2.addActionListener(e-> {
                    //dispose();//关闭当前界面
                    new Register();//打开新界面
                }
        );



        //---- radioButton1 ----
        radioButton1.setText("用户");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(205, 105), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("管理员");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(320, 105), radioButton2.getPreferredSize()));

        ButtonGroup group = new ButtonGroup();    // (重点)给上面的男女多选按钮创建一个组
        group.add(radioButton1);        // 这里把多选按钮 “男” 扔进 group 组里面去
        group.add(radioButton2);


        //---- label1 ----
        label1.setText("账号");
        contentPane.add(label1);
        label1.setBounds(170, 165, label1.getPreferredSize().width, 17);

        //---- label2 ----
        label2.setText("密码");
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

