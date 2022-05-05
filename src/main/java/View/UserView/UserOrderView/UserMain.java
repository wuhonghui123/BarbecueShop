package View.UserView.UserOrderView;

import javax.swing.*;
import View.UserView.UserOrderingView.*;
public class UserMain {

    public void init(String string) {
        String sql1 = "select * from `order`";
        String sql2 = "select * from history;";
        String sql3 = "ordering";
        String userid = string;//登录的用户id

        JPanel panel1 = new nowPanel().init(sql1);
        JPanel panel2 = new historyPanel().init(sql2);
        JPanel panel3 = new UserOrdering().init(userid);
        JPanel panel4 = new ShowOrder().Show(sql3);

        JTabbedPane jTabbedPane = new JTabbedPane(SwingConstants.NORTH, JTabbedPane.SCROLL_TAB_LAYOUT);


        System.out.println("当前登录的用户ID: "+userid);
        JFrame frame = new JFrame("用户主页  "+userid);


        jTabbedPane.addTab("菜单", null, panel3);
        jTabbedPane.addTab("购物车", null, panel4);
        jTabbedPane.addTab("当前订单", null, panel1);
        jTabbedPane.addTab("历史订单", null, panel2);
        frame.add(jTabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 400, 1000, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
      new UserMain().init("10086");
    }
}


