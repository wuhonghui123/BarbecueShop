package View.AdminView.adminOrder;


import javax.swing.*;

public class AdminOrder {
    String sql1="select * from adminItem;";
    String sql2="select * from adminItem;";
    static JFrame frame=new JFrame("商家订单信息");
    JPanel panel1=new processPanel().init(sql1);
    JPanel panel2=new finishPanel().init(sql2);

    JTabbedPane jTabbedPane=new JTabbedPane(SwingConstants.NORTH,JTabbedPane.SCROLL_TAB_LAYOUT);

    public void init(){
        jTabbedPane.addTab("正在进行",null,panel1);
        jTabbedPane.addTab("已完成订单",null,panel2);
        frame.add(jTabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,1000,560);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminOrder().init();
    }
}
