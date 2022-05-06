package View.UserView.UserOrderingView;

import Order.*;
import Order.item.Ordering;
import Pay.WXPay;
import View.PayView.PayView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;


public class ShowOrder extends JPanel {
    JScrollPane scrollPane1 = new JScrollPane();
    JTable table1 = new JTable();
    JLabel label1 = new JLabel();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    //JPanel jPanel2 = new JPanel();

    private String head[] = {"id", "商品名称", "单价", "数量"};
    private Object[][] data = null;

    public JPanel Show(String name, String userid) {
        Connection conn = null;
        String user = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        java.util.List<Ordering> list1 = new ArrayList<Ordering>();
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
//                conn=ConnectionHandler.getConn();
            Statement stmt = null;
            String sql = "SELECT * FROM " + name + " WHERE user_id = " + userid;
            ResultSet rs = null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                Ordering ordering = new Ordering();
                ordering.setId(rs.getInt(1));
                ordering.setTitle(rs.getString(2));
                ordering.setPrice(rs.getFloat(3));
                ordering.setNumber(rs.getInt(4));
                list1.add(ordering);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        data = new Object[list1.size()][head.length];

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list1.get(i).getId();
                data[i][1] = list1.get(i).getTitle();
                data[i][2] = list1.get(i).getPrice();
                data[i][3] = list1.get(i).getNumber();

            }
        }
//                                 return data;

        DefaultTableModel tableModel = new DefaultTableModel(data, head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

//        label1.setFont(new
//                Font("STHeiti Light", Font.BOLD,
//                30));
//        label1.setText("购物车");
//        panel.add(label1);
//        label1.setBounds(460, 0, 600, 60);


        //this jButton1
        jButton1.setText("删除");
        panel.add(jButton1);
        jButton1.setBounds(350, 500, 100, 30);
        jButton1.addActionListener(
                (e) -> {
                    OrderDaoImpl orderDao = new OrderDaoImpl();
                    try {
                        int rowNo = table1.getSelectedRow();//获取所选的行号
                        int id = (int) table1.getValueAt(rowNo, 0);
                        orderDao.DeleteOrder(id);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

        );


        //this jButton2
        jButton2.setText("支付");
        panel.add(jButton2);
        jButton2.setBounds(450, 500, 100, 30);
        jButton2.addActionListener(
                (e) -> {
                    OrderDaoImpl orderDao = new OrderDaoImpl();
                    try {
                        String path = "src/main/java/image/二维码.jpg";
                        File file = new File(path);
                        file.delete();//删除原来的二维码

                        orderDao.pay();
//                        WXPay wxpay = new WXPay();
//                        wxpay.unifiedOrder();
                        new PayView().init(userid);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );

//        //this jButton3
//        jButton3.setText("返回");
//        panel.add(jButton3);
//        jButton3.setBounds(550,500,100,30);
//        jButton3.addActionListener(
//                (e)->{
//                   // dispose();
//                }
//        );

        jButton4.setText("清空");
        panel.add(jButton4);
        jButton4.setBounds(550, 500, 100, 30);
        jButton4.addActionListener(
                (e) -> {
                    OrderDaoImpl orderDao = new OrderDaoImpl();
                    try {
                        orderDao.DeleteOrdering();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
        );


        {
            scrollPane1.setViewportView(table1);//增加滚动条
        }
        panel.add(scrollPane1);
        //panel.add(jPanel2);
        scrollPane1.setBounds(0, 150, 1000, 600);
        //jPanel2.setBounds(0, 150, 1000, 600);

        //
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

        return panel;
    }

}

