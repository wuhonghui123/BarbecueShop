package User.UserOrder;

import User.UserOrder.nowPanel;

import javax.swing.*;

public class UserOrder {
    String sql1="select * from item;";
    String sql2="select * from history;";
    JFrame frame=new JFrame("订单信息");
    JPanel panel1=new nowPanel().init(sql1);
    JPanel panel2=new historyPanel().init(sql2);

    JTabbedPane jTabbedPane=new JTabbedPane(SwingConstants.NORTH,JTabbedPane.SCROLL_TAB_LAYOUT);

    public void init(){
        jTabbedPane.addTab("当前订单",null,panel1);
        jTabbedPane.addTab("历史订单",null,panel2);
        frame.add(jTabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,1000,560);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UserOrder().init();
    }
}
