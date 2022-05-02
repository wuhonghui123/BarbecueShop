package View.UserView.UserOrder;

import Bean.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class nowPanel extends JPanel {
    private JScrollPane scrollPanel=null;
    private String TableHead[] = {"订单号","商品号","商品名称","订单数量","订单提交日期","订单金额"};
    private Object[][] data = null;
    private JTable table=new JTable();
    public JPanel init(String sql){
        JPanel panel=new JPanel();
        //JPanel mainPanel=new JPanel();
        panel.setLayout(new BorderLayout());

        /*--------------------------------------中间部分----------------------------------------*/
        JPanel center=new JPanel();
        Container container2=new Container();//容器，存放中面板所用
        scrollPanel=new JScrollPane();
        DefaultTableModel tableModel=new DefaultTableModel(queryData(sql),TableHead){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table=new JTable(tableModel);
        scrollPanel.setViewportView(table);
        center.add(scrollPanel);
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
        panel.add(center,BorderLayout.CENTER);
        /*--------------------------------------中间部分----------------------------------------*/

        /*--------------------------------------上方部分----------------------------------------*/

        JPanel north=new JPanel();
        Container container1=new Container();//容器，存放上面板所用
        JLabel label1=new JLabel("订单号");
        JLabel label2=new JLabel("订单号");
        JLabel label3=new JLabel("数量修改为");
        JButton button1=new JButton("查询");
        JButton button2=new JButton("修改");
        JButton button3=new JButton("返回");
        JTextField text1=new JTextField();
        JLabel text2=new JLabel("");
        JLabel text3=new JLabel("");
        JLabel label5=new JLabel("");
        JLabel label4=new JLabel("");
        JTextField text4=new JTextField();
        JTextField text5=new JTextField();
        container1.setLayout(new GridLayout(1,12));
        container1.add(label1);
        container1.add(text1);
        container1.add(button1);
        container1.add(label4);
        container1.add(label5);
        container1.add(label2);
        container1.add(text4);
        container1.add(label3);
        container1.add(text5);
        container1.add(button2);
        container1.add(new JLabel(""));
        container1.add(button3);

        /*--------------------------------查询订单--------------------------------*/
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql=new String();
                try {
                    int selectId=Integer.parseInt(text1.getText());
                    sql = "SELECT * FROM item where id="+selectId+";";
                }catch (Exception e1){
                    sql="SELECT * FROM item;";
                }finally {
                    DefaultTableModel tableModel=new DefaultTableModel(queryData(sql),TableHead){
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table=new JTable(tableModel);
                    scrollPanel.setViewportView(table);
                }
            }
        });
        /*--------------------------------查询订单--------------------------------*/

        /*--------------------------------修改订单--------------------------------*/
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql1=new String();
                try {
                    int updateId=Integer.parseInt(text4.getText());
                    int updateNum=Integer.parseInt(text5.getText());
                    sql1 = "update item set number="+updateNum+" where id="+updateId;
                    DefaultTableModel tableModel=new DefaultTableModel(queryData(sql1),TableHead){
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table=new JTable(tableModel);
                    scrollPanel.setViewportView(table);
                }
                catch (Exception e1){
                    JDialog jDialog=new JDialog();
                    jDialog.setVisible(true);
                    jDialog.setLayout(new BorderLayout());
                    jDialog.setBounds(500,500,450,300);
                    JLabel lab=new JLabel("您未输入订单id或者修改的数量");
                    Font font=new Font("宋体",Font.PLAIN,28);
                    lab.setFont(font);
                    jDialog.add(lab, JLabel.CENTER);
                    JButton button=new JButton("确定");
                    button.setBounds(450,450,20,10);
                    jDialog.add(button,BorderLayout.SOUTH);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jDialog.dispose();
                        }
                    });
                }
            }
        });
        /*--------------------------------修改订单--------------------------------*/

        north.add(container1);
        panel.add(north,BorderLayout.NORTH);
        /*--------------------------------------上方部分----------------------------------------*/

        /*--------------------------------------下方部分----------------------------------------*/

        JPanel south=new JPanel();
        south.setLayout(new GridLayout(1,5,50,0));
        JButton S_button1=new JButton("支付已选的订单");
        JButton S_button2=new JButton("取消已选的订单");
        south.add(new JLabel(""));
        south.add(S_button1);
        south.add(S_button2);
        south.add(new JLabel(""));
        panel.add(south,BorderLayout.SOUTH);

        /*--------------------------------------下方部分----------------------------------------*/

        /*--------------------------------------删除部分----------------------------------------*/

        S_button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int count= table.getSelectedRow();
                int getId=Integer.parseInt(table.getValueAt(count,0).toString());
                String sql2=new String();
                try {
                    sql2="delete from item where id="+getId;
                    DefaultTableModel tableModel1=new DefaultTableModel(queryData(sql2),TableHead){
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table=new JTable(tableModel1);
                    scrollPanel.setViewportView(table);
                }catch (Exception e1){
                    e1.printStackTrace();
                    JDialog jDialog=new JDialog();
                    jDialog.setVisible(true);
                    jDialog.setLayout(new BorderLayout());
                    jDialog.setBounds(500,500,450,300);
                    JLabel lab=new JLabel("您未输入订单id或者修改的数量");
                    Font font=new Font("宋体",Font.PLAIN,28);
                    lab.setFont(font);
                    jDialog.add(lab, JLabel.CENTER);
                    JButton button=new JButton("确定");
                    button.setBounds(450,450,20,10);
                    jDialog.add(button,BorderLayout.SOUTH);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jDialog.dispose();
                        }
                    });
                }
            }
        });

        /*--------------------------------------删除部分----------------------------------------*/

        /*--------------------------------------支付部分----------------------------------------*/

        S_button1.addActionListener(e -> {
            int count= table.getSelectedRow();
            int getId=Integer.parseInt(table.getValueAt(count,0).toString());
            String sql2=new String();
            String sql3="update history set pay='是' where id="+getId;
            Connection conn1 = connection(sql3);
            try {
                sql2="delete from item where id="+getId;
                Statement stmt = null;//SQL语句对象，拼SQL
                stmt = conn1.createStatement();
                ResultSet rs = null;
                stmt.executeUpdate(sql3);
                DefaultTableModel tableModel1=new DefaultTableModel(queryData(sql2),TableHead){
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table=new JTable(tableModel1);
                scrollPanel.setViewportView(table);


            }catch (Exception e1){
                e1.printStackTrace();
                JDialog jDialog=new JDialog();
                jDialog.setVisible(true);
                jDialog.setLayout(new BorderLayout());
                jDialog.setBounds(500,500,450,300);
                JLabel lab=new JLabel("订单支付失败");
                Font font=new Font("宋体",Font.PLAIN,28);
                lab.setFont(font);
                jDialog.add(lab, JLabel.CENTER);
                JButton button=new JButton("确定");
                button.setBounds(450,450,20,10);
                jDialog.add(button,BorderLayout.SOUTH);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jDialog.dispose();
                    }
                });
            }
        });

        /*--------------------------------------支付部分----------------------------------------*/

        /*---------------------------------------返回------------------------------------------*/

        button3.addActionListener(e -> {
            UserOrder.frame.dispose();
            //上一层界面显示
        });

        /*--------------------------------返回--------------------------------*/


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

        java.util.List<Item> list = new ArrayList<Item>();
        Statement stmt = null;//SQL语句对象，拼SQL
        ResultSet rs = null;
        Connection conn=connection(sql);
        try {
            stmt = conn.createStatement();
            if (sql.startsWith("select")||sql.startsWith("SELECT")){
                rs = stmt.executeQuery(sql);
            }else {
                stmt.executeUpdate(sql);
                rs = stmt.executeQuery("select * from item");
            }
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setItemId(rs.getInt(2));
                item.setNaem(rs.getString(3));
                item.setNumber(rs.getInt(4));
                item.setSubDate(rs.getTimestamp(5));
                item.setScore(rs.getInt(6));
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
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getItemId();
                data[i][2] = list.get(i).getNaem();
                data[i][3] = list.get(i).getNumber();
                data[i][4] = list.get(i).getSubDate();
                data[i][5] = list.get(i).getScore();
            }
        }
        return data;
    }
}