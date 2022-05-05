package View.AdminView.AdminOrderView;

import javax.swing.*;
import java.awt.*;

public class AdminOrder {
    String sql1="select * from adminItem;";
    String sql2="select * from adminItem;";
    JFrame frame=new JFrame("商家订单信息");
    JPanel panel1=new processPanel().init(sql1);
    JPanel panel2=new finishPanel().init(sql2);

    JTabbedPane jTabbedPane=new JTabbedPane(SwingConstants.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);

    public void init(){
        jTabbedPane.addTab("正在进行",null,panel1);
        jTabbedPane.addTab("已完成订单",null,panel2);
        frame.add(jTabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,400,1000,560);
        frame.setResizable(false);
        frame.setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/java/image/logo.png");
        frame.setIconImage(icon);
    }

    public static void main(String[] args) {
        new AdminOrder().init();
    }
}

