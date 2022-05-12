package View.AdminView.AdminOrderView;

import Order.bean.OrderBean;
import View.UserView.UserOrderView.completeorder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class processPanel extends JPanel{
    private JScrollPane scrollPanel=null;
    private String TableHead[] = {"订单号","用户ID","商品总价格","订单提交日期","订单支付状态"};
    private Object[][] data = null;
    private JTable table=new JTable();
    public JPanel init(String sql){
        JPanel panel=new JPanel();
        //JPanel mainPanel=new JPanel();
        panel.setLayout(new BorderLayout());

        /*--------------------------------------中间部分----------------------------------------*/
      //  JPanel center=new JPanel();
        Container container2=new Container();//容器，存放中面板所用
        scrollPanel=new JScrollPane();
        DefaultTableModel tableModel=new DefaultTableModel(queryData(sql),TableHead){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table=new JTable(tableModel);
        scrollPanel.setViewportView(table);
        panel.add(scrollPanel);
        scrollPanel.setBounds(45, 35, 415, 295);
        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < panel.getComponentCount(); i++) {
                Rectangle bounds = panel.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = panel.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            panel.setMinimumSize(preferredSize);
            panel.setPreferredSize(preferredSize);
        }
       // panel.add(center,BorderLayout.CENTER);
        /*--------------------------------------中间部分----------------------------------------*/

        /*--------------------------------------上方部分----------------------------------------*/

        JPanel north=new JPanel();
        Container container1=new Container();//容器，存放上面板所用
//        JLabel label1=new JLabel("用户Id");
        JButton button1=new JButton("查询");
        JButton button3=new JButton("刷新");
//        JTextField text1=new JTextField();
        JLabel text2=new JLabel("");
        JLabel text3=new JLabel("");
        JLabel label5=new JLabel("");
        JLabel label4=new JLabel("");
        container1.setLayout(new GridLayout(1,5));
//        container1.add(label1);
//        container1.add(text1);
        container1.add(button1);
        container1.add(label4);
        container1.add(button3);

        /*--------------------------------查询订单--------------------------------*/
        button1.addActionListener(e -> {
            int count= table.getSelectedRow();
            String orderId=table.getValueAt(count,0).toString();
//            String sql3="select * from completeorder where order_id="+orderId;
            new completeorder().completeorder(orderId);
        });
        button3.addActionListener(e -> {
            DefaultTableModel tableModel1=new DefaultTableModel(queryData(sql),TableHead){
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table=new JTable(tableModel1);
            scrollPanel.setViewportView(table);
        });
        /*--------------------------------查询订单--------------------------------*/


        north.add(container1);
        panel.add(north,BorderLayout.NORTH);
        /*--------------------------------------上方部分----------------------------------------*/

        return panel;
    }

    private Connection connection(String sql){
        Connection conn = null;
        String user = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/barbecueshopsystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Object[][] queryData(String sql) {

        java.util.List<OrderBean> list = new ArrayList<>();
        Statement stmt = null;//SQL语句对象，拼SQL
        ResultSet rs = null;
        Connection conn=connection(sql);
        try {
            stmt = conn.createStatement();
            if (sql.startsWith("select")||sql.startsWith("SELECT")){
                rs = stmt.executeQuery(sql);
            }else {
                stmt.executeUpdate(sql);
                rs = stmt.executeQuery(sql);
            }
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                OrderBean item = new OrderBean();
                item.setOrder_id(rs.getInt(1));
                item.setUser_id(rs.getInt(2));
                item.setOrder_price(rs.getFloat(3));
                item.setOrder_date(rs.getTimestamp(4));
                item.setOrser_pay(rs.getString(5));
                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }


        Object[][] data = new Object[list.size()][TableHead.length];
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < TableHead.length; k++) {
                data[i][0] = list.get(i).getOrder_id();
                data[i][1] = list.get(i).getUser_id();
                data[i][2] = list.get(i).getOrder_price();
                data[i][3] = list.get(i).getOrder_date();
                data[i][4] = list.get(i).getOrser_pay();
            }
        }
        return data;
    }
}

