/*
 * Created by JFormDesigner on Sat Apr 23 15:45:38 CST 2022
 */

package User;

import Login.AdminLogin;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Userframe extends JFrame {
    public Userframe() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u70b9\u9910");
        contentPane.add(button1);
        button1.setBounds(130, 145, 175, 95);
        button1.addActionListener(e->{
                    // new AdminLogin();//打开点餐界面
                }

        );

        //---- button2 ----
        button2.setText("\u67e5\u770b\u8ba2\u5355");
        contentPane.add(button2);
        button2.setBounds(430, 145, 175, 95);
        button2.addActionListener(e->{
                    //   new AdminLogin();//打开订单界面
                }

        );

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
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
