package View.LoginView;


import java.awt.*;
import javax.swing.*;
import View.AdminView.MainAdminView;

/**
 * @author 1
 */
public class AdminLogin extends JFrame {
    public AdminLogin() {
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
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(85, 75), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(150, 70, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(85, 130), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(150, 120, 95, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("登录");
        contentPane.add(button1);
        button1.setBounds(100, 195, 90, button1.getPreferredSize().height);
        button1.addActionListener(e -> {//点击按钮执行操作
            dispose();//关闭当前窗口
            new MainAdminView(); //打开新窗口

        });

        //---- button2 ----
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(225, 195, 80, button2.getPreferredSize().height);
        button2.addActionListener(e -> {//点击按钮执行操作
            new AdminRegister(); //打开新窗口

        });

        contentPane.setPreferredSize(new Dimension(400, 300));//窗口大小
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
        this.setResizable(false);//锁定窗口大小
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
