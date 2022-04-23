package admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Adminfram {

    //创造全局变量，并且私有
    private static JFrame frame = new JFrame();

    private static JPanel panel = null;

    public Adminfram() {

        frame = new JFrame("管理系统");
        frame.setBounds(100, 100, 1200, 800);
        frame.getContentPane().setLayout(null);

        //使窗体不能放大
        frame.setResizable(false);

        //使窗体在屏幕中间出现
        frame.setResizable(false);

        // 菜单栏
        // 新建一个菜单条
        JMenuBar jb = new JMenuBar();
        jb.setBounds(0, 0, 1200, 30);
        frame.getContentPane().add(jb);


        // 新建一个菜单选项
        JMenu jmenu1 = new JMenu("选项一");
        jb.add(jmenu1);
        JMenu jmenu2 = new JMenu("选项二");
        jb.add(jmenu2);
        // 新建一个菜单项
        JMenuItem jm1 = new JMenuItem("界面一");

        jmenu1.add(jm1);

        JMenuItem jm2 = new JMenuItem("界面二");
        jmenu1.add(jm2);


        //初始  panel
        panel = new JPanel();

        frame.add(panel);

        panel.setBounds(-1, 31, 1187, 730);
        panel.setLayout(null);

        JLabel label = new JLabel("首页");
        label.setFont(new Font("宋体", Font.PLAIN, 99));
        label.setBounds(356, 108, 326, 297);

        JButton jButton1 = new JButton("添加菜品");
        jButton1.setBounds(900,200,100,50);
        //事件触发
        jButton1.addActionListener(e -> {
            //new 弹窗


        });

        JButton jButton2 = new JButton("修改菜品");
        jButton2.setBounds(900,350,100,50);
        jButton1.addActionListener(e -> {
            //new 弹窗


        });

        JButton jButton3 = new JButton("删除菜品");
        jButton3.setBounds(900,500,100,50);
        jButton1.addActionListener(e -> {
            //new 弹窗


        });
        panel.add(label);
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(jButton3);



        //关键地方来了，下面就是窗体的切换过程了。

        //打开界面一
        jm1.addActionListener(e -> {

            frame.remove(panel);
            panel = OrderAdmin.firstView();

            //在这里，我们为什么要先frame.remove(panel)，这是因为，如果我们不是remove，
            //而是add()话，会出现，有一些组件重合，那么就会导致我们一些功能，无法使用，所以我们要先remve掉frame当前的panel。

            //为什么要？panel = FirstPanel.firstView();
            //这是因为，frame添加的panel已经改变了，如果我们不重新赋值panel的话，那我们，想要再次切换时，将会remove以前的panel
            //对frame现在添加的panel，没有任何影响，所以要重新赋值panel
        });

        //打开界面二
        jm2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.remove(panel);
                panel = SecondPanel.secondView();
                //原因同上。
            }
        });


        //使窗体可见
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JFrame returnJFrame() {

        return frame;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new Adminfram();
    }

}




