package View.UserView.UserOrderingView;

import Order.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class ShowOrder extends JFrame{
    JScrollPane scrollPane1 = new JScrollPane();
    JTable table1 = new JTable();
    JLabel label1 = new JLabel();
    JButton jButton1=new JButton();
    JButton jButton2=new JButton();
    JButton jButton3=new JButton();

    private String head[] = {"id", "商品名称", "单价", "数量"};
    private Object[][] data = null;
    public void Show(String name){
        Connection conn=null;
        String user = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        java.util.List<Ordering> list1 = new ArrayList<Ordering>();
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
//                conn=ConnectionHandler.getConn();
            Statement stmt = null;
            String sql = "SELECT * FROM "+name;
            ResultSet rs = null;
            PreparedStatement pstmt=conn.prepareStatement(sql);
            rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                Ordering ordering =new Ordering();
                ordering.setId(rs.getInt(1));
                ordering.setTitle(rs.getString(2));
                ordering.setPrice(rs.getFloat(3));
                ordering.setNumber(rs.getInt(4));
                list1.add(ordering);
            }


        }  catch (SQLException throwables) {
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

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        label1.setFont(new
                Font("STHeiti Light", Font.BOLD,
                30));
        label1.setText("购物车");
        contentPane.add(label1);
        label1.setBounds(460, 0, 600, 60);


        //this jButton1
        jButton1.setText("删除");
        this.add(jButton1);
        jButton1.setBounds(350,350,100,30);
        jButton3.addActionListener(
                (e)-> {
                    OrderDaoImpl orderDao=new OrderDaoImpl();
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
        this.add(jButton2);
        jButton2.setBounds(450,350,100,30);
        jButton2.addActionListener(
                (e)->{
                    OrderDaoImpl orderDao=new OrderDaoImpl();
                    try {
                        orderDao.pay();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );

        //this jButton3
        jButton3.setText("返回");
        this.add(jButton3);
        jButton3.setBounds(550,350,100,30);
        jButton3.addActionListener(
                (e)->{
                    dispose();
                }
        );


        {
            scrollPane1.setViewportView(table1);//增加滚动条
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 50, 1000, 300);

        {
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        this.setBounds(300, 300, 1000, 450);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

