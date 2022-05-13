package View.PayView;

/*
 * Created by JFormDesigner on Mon May 02 16:21:21 CST 2022
 */

import Order.OrderDaoImpl;
import Pay.WXPay;

import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.*;

/**
 * @author 1
 */
public class PayView{
    // public PayView() {
//        initComponents();
//    }




    public void init(String userid,float money) {
        OrderDaoImpl pay = new OrderDaoImpl();
        String orderid = pay.OrderId();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        JLabel label1 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label3 = new JLabel();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JPanel panel1 = new JPanel();
        JLabel label6 = new JLabel();
        TextField textField = new TextField();
        JPanel panel2 = new JPanel();

        JFrame frame = new JFrame("支付");
        //======== this ========
        //var contentPane = getContentPane();
        frame.setLayout(null);

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
        frame.add(label2);
        label2.setBounds(new Rectangle(new Point(90, 100), label2.getPreferredSize()));

        label5.setText(String.valueOf(money));
        frame.add(label5);
        label5.setBounds(new Rectangle(new Point(155, 100), label5.getPreferredSize()));

        //---- label3 ----
        label3.setText("支付方式");
        frame.add(label3);
        label3.setBounds(new Rectangle(new Point(90, 160), label3.getPreferredSize()));

        label6.setText("付款码：");
        frame.add(label6);
        label6.setBounds(new Rectangle(new Point(90, 190), label6.getPreferredSize()));

        textField.setText("");
        frame.add(textField);
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
        frame.add(panel1);
        panel1.setBounds(285, 50, 300, 300);

        //---- button1 ----
        button1.setText("扫码支付");
        frame.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 230), button1.getPreferredSize()));
        button1.addActionListener(e->{
            try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            OrderDaoImpl orderDao=new OrderDaoImpl();
            orderDao.Updateordering(orderid,userid);
            orderDao.addOrder(orderid,userid);
            orderDao.DeleteOrdering(userid);
            orderDao.newOrders(orderid,userid,money,timestamp);
            WXPay wxpay = new WXPay();
            wxpay.unifiedOrder(orderid,userid,money);
            label.setIcon(new ImageIcon("src/main/java/image/二维码.jpg"));//显示二维码
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        //---- button2 ----
        button2.setText("付款码支付");
        frame.add(button2);
        button2.setBounds(new Rectangle(new Point(155, 230), button2.getPreferredSize()));
        button2.addActionListener(e -> {
            WXPay wxPay = new WXPay();
            try {
                wxPay.scanCodeToPay(ma,orderid,userid,money);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });


//        contentPane.setPreferredSize(new Dimension(600, 400));//窗口大小
//        pack();
//        setLocationRelativeTo(getOwner());
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作

        frame.setBounds(400, 400, 600, 400);
        frame.setResizable(false);//锁定窗口大小
        frame.setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/java/image/logo.png");
        frame.setIconImage(icon);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

