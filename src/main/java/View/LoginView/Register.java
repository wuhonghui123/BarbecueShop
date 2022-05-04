/*
 * Created by JFormDesigner on Fri Apr 29 14:14:27 CST 2022
 */

package View.LoginView;


import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.sql.PreparedStatement;


/**
 * @author 1
 */
public class Register extends JFrame {
    public Register() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        setTitle("Register");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- radioButton1 ----
        radioButton1.setText("user");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(205, 60), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("admin");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(300, 60), radioButton2.getPreferredSize()));

        ButtonGroup group = new ButtonGroup();    // 给上面的用户和管理员按钮创建一个组，实现两个选项只能选一个
        group.add(radioButton1);
        group.add(radioButton2);

        contentPane.add(textField1);
        textField1.setBounds(220, 105, 115, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(220, 145, 115, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(220, 180, 110, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(220, 220, 110, textField4.getPreferredSize().height);

        //---- button1 ----
        button1.setText("Register");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(185, 290), button1.getPreferredSize()));
        button1.addActionListener(e-> {
                    if (radioButton1.isSelected()) {

                        Connection conn = null;
                        String user = "root";
                        String dbPassword = "123456";
                        String url = "jdbc:mysql://120.25.164.209:3306/barbecueshopsystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                        String sql = "insert into user (use_id,user_name,user_password,user_phone) values(?,?,?,?)";
                        try {
                            conn = DriverManager.getConnection(url, user, dbPassword);
                            PreparedStatement pst = conn.prepareStatement(sql);// 创建一个Statment对象
                            pst.setString(1, textField1.getText());
                            pst.setString(2, textField2.getText());
                            pst.setString(3, textField3.getText());
                            pst.setString(4, textField4.getText());
                            pst.executeUpdate();// 执行sql语句
                            conn.close();// 关闭数据库连接对象
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else if (radioButton2.isSelected()) {

                        Connection conn = null;
                        String user = "root";
                        String dbPassword = "123456";
                        String url = "jdbc:mysql://120.25.164.209:3306/barbecueshopsystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                        String sql = "insert into admin (admin_id,admin_name,admin_password,admin_phone) values(?,?,?,?)";
                        try {
                            conn = DriverManager.getConnection(url, user, dbPassword);
                            PreparedStatement pst = conn.prepareStatement(sql);
                            // 创建一个Statment对象
                            pst.setString(1, textField1.getText());
                            pst.setString(2, textField2.getText());
                            pst.setString(3, textField3.getText());
                            pst.setString(4, textField4.getText());
                            pst.executeUpdate();// 执行sql语句
                            conn.close();// 关闭数据库连接对象
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );

        //---- button2 ----
        button2.setText("return");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(305, 290), button2.getPreferredSize()));
        button2.addActionListener(e-> {
                    dispose();//关闭当前界面
                }
        );

        //---- label1 ----
        label1.setText("id");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(140, 110), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("name");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(140, 150), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("passward");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(140, 185), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("phone");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(140, 225), label4.getPreferredSize()));



        contentPane.setPreferredSize(new Dimension(600, 400));//窗口大小
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
        this.setResizable(false);//锁定窗口大小
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Login();
    }
}