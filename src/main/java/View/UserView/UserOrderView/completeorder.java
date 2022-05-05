package View.UserView.UserOrderView;

import Order.item.CompleteOrderItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class completeorder extends JFrame {
    private JScrollPane scrollPanel;
    private String TableHead[] = {"用户ID","订单号","食品ID","食物名称","食物价格","数量"};
    private JFrame frame=new JFrame("订单详细信息");
    private Object[][] data=null;
    private JTable table=new JTable();
    public Frame completeorder(String sql){
        scrollPanel=new JScrollPane();
        DefaultTableModel tableModel=new DefaultTableModel(queryData(sql),TableHead){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table=new JTable(tableModel);
        scrollPanel.setViewportView(table);
        frame.add(scrollPanel);
        frame.setBounds(400,400,600,350);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }


    public Object[][] queryData(String sql){
        java.util.List<CompleteOrderItem> list=new ArrayList<>();
        Statement stmt=null;
        ResultSet rs=null;
        //String sql="select * from completeorder";
        Connection conn=null;
        String user = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/barbecueshopsystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                CompleteOrderItem item=new CompleteOrderItem();
                item.setUserId(rs.getInt(1));
                item.setOrderid(rs.getInt(2));
                item.setFoodid(rs.getInt(3));
                item.setFoodtitle(rs.getString(4));
                item.setFoodprice(rs.getString(5));
                item.setNumber(rs.getInt(6));
                list.add(item);
            }
        }catch(SQLException e){
            e.printStackTrace();
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
                data[i][0] = list.get(i).getUserId();
                data[i][1] = list.get(i).getOrderid();
                data[i][2] = list.get(i).getFoodid();
                data[i][3] = list.get(i).getFoodtitle();
                data[i][4] = list.get(i).getFoodprice();
                data[i][5] = list.get(i).getNumber();
            }
        }
        return data;
    }

    /*public static void main(String[] args) {
        new completeorder();
    }*/
}
