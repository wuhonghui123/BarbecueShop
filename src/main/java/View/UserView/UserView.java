/*
 * Created by JFormDesigner on Sun May 01 23:26:27 CST 2022
 */

package View.UserView;

import View.AdminView.AdminView;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class UserView extends JFrame {
    public UserView() {
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
        button1.setBounds(new Rectangle(new Point(165, 210), button1.getPreferredSize()));
        button2.addActionListener(e-> new UserOrder().init()
        );

        //---- button2 ----
        button2.setText("\u8ba2\u5355");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(425, 210), button2.getPreferredSize()));
        button2.addActionListener(e-> new UserOrder().init()
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
