package View.PayView;

/*
 * Created by JFormDesigner on Mon May 02 16:21:21 CST 2022
 */

import Order.OrderDaoImpl;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class PayView extends JFrame {
    public PayView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        OrderDaoImpl pay = new OrderDaoImpl();
        //---- label1 ----
        label1.setText("商品描述");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(90, 50), label1.getPreferredSize()));

        textField1.setText("热狗");
        contentPane.add(textField1);
        textField1.setBounds(new Rectangle(new Point(155, 50), textField1.getPreferredSize()));

        //---- label2 ----
        label2.setText("价格");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(90, 95), label2.getPreferredSize()));

        try {
            textField2.setText(String.valueOf(pay.pay()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        contentPane.add(textField2);
        textField2.setBounds(new Rectangle(new Point(155, 100), textField2.getPreferredSize()));

        //---- label3 ----
        label3.setText("支付方式");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(100, 160), label3.getPreferredSize()));

        //---- button1 ----
        button1.setText("扫码支付");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 215), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("付款码支付");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(155, 215), button2.getPreferredSize()));

        //======== panel1 ========
        //添加二维码图片到窗口
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/main/java/image/二维码.jpg"));
        label.setBounds(0,0,300,300);
        panel1.add(label);

        contentPane.add(panel1);
        panel1.setBounds(285, 60, 300, 300);

        contentPane.setPreferredSize(new Dimension(600, 400));//窗口大小
        pack();
        setLocationRelativeTo(getOwner());
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
        this.setResizable(false);//锁定窗口大小
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new PayView();
    }
}

