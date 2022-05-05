package View.PayView;

/*
 * Created by JFormDesigner on Mon May 02 16:21:21 CST 2022
 */

import Order.OrderDaoImpl;
import Pay.WXPay;

import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class PayView extends JFrame {

    public PayView() {
        initComponents();
    }
    OrderDaoImpl pay = new OrderDaoImpl();
    public String orderid = pay.OrderId();


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label4 = new JLabel();
        label2 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        panel1 = new JPanel();
        label6 = new JLabel();
        textField = new TextField();
        panel2 = new JPanel();


        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
//        label1.setText("订单号:");
//        contentPane.add(label1);
//        label1.setBounds(new Rectangle(new Point(90, 50), label1.getPreferredSize()));
//
//        label4.setText(orderid);
//        contentPane.add(label4);
//        label4.setBounds(new Rectangle(new Point(155, 50), label4.getPreferredSize()));



        String path = "src/main/java/image/二维码.jpg";
        File file = new File(path);
        file.delete();//删除原来的二维码



        //---- label2 ----
        label2.setText("价格:");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(90, 100), label2.getPreferredSize()));

        try {
            label5.setText(String.valueOf(pay.pay()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(155, 100), label5.getPreferredSize()));

        //---- label3 ----
        label3.setText("支付方式");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(90, 160), label3.getPreferredSize()));

        label6.setText("付款码：");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(90, 190), label6.getPreferredSize()));

        textField.setText("");
        contentPane.add(textField);
        textField.setBounds(150, 190,100,20);
        String ma = textField.getText();

        //======== panel2 ========
//        JLabel label2 = new JLabel();
//        label2.setIcon(new ImageIcon("src/main/java/image/二维码.jpg"));
//        label2.setBounds(0,0,300,300);
//        panel2.add(label2);


        //======== panel1 ========
        //添加二维码图片到窗口

        JLabel label = new JLabel();

        label.setBounds(0,0,300,300);
        panel1.add(label);
        contentPane.add(panel1);
        panel1.setBounds(285, 50, 300, 300);

        //---- button1 ----
        button1.setText("扫码支付");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 230), button1.getPreferredSize()));
        button1.addActionListener(e->{
            OrderDaoImpl orderDao=new OrderDaoImpl();
            try {
                orderDao.pay();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            WXPay wxpay = new WXPay();
            wxpay.unifiedOrder();
            label.setIcon(new ImageIcon("src/main/java/image/二维码.jpg"));//显示二维码
        });

        //---- button2 ----
        button2.setText("付款码支付");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(155, 230), button2.getPreferredSize()));
        button2.addActionListener(e -> {



        });


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
    private JLabel label4;
    private JLabel label2;
    private JLabel label5;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label6;
    private TextField textField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new PayView();
    }
}

