/*
 * Created by JFormDesigner on Sat Apr 23 16:22:09 CST 2022
 */

package Login;

import User.Userframe;

import java.awt.*;
import javax.swing.*;

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
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(95, 85), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(165, 80, 95, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(90, 150), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(170, 145, 90, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("text");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 200), button1.getPreferredSize()));
        button1.addActionListener(e -> {//点击按钮执行操作
            dispose();//关闭当前窗口
            new Userframe(); //显示窗口

        });

        //---- button2 ----
        button2.setText("text");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 200), button2.getPreferredSize()));
        button2.addActionListener(e -> {//点击按钮执行操作

            new UserRegister(); //显示窗口

        });

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
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

