package View.UserView.UserOrderingView;


import Food.FoodItem;
import Order.OrderDaoImpl;
import View.UserView.ConnectionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 */
public class UserOrderingMain extends JFrame {
    Connection conn=null;
    public UserOrderingMain() {
        initComponents();
    }

    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label1 = new JLabel();


        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
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
        label1.setText("商品信息");
        contentPane.add(label1);
        label1.setBounds(460, 0, 600, 60);

        button1.setText("支付");
        contentPane.add(button1);
        button1.setBounds(500, 355, 100, 30);
        button1.addActionListener(
                (e)->{
                    OrderDaoImpl orderDao=new OrderDaoImpl();
                    try {
                        orderDao.pay();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );


/*        button2.setText("删除");
        contentPane.add(button2);
        button2.setBounds(610, 355, 100, 30);
        //button2.setBounds(610, 355, 100, 30);
        button2.addActionListener(
                (e)->{
                    *//*int rowNo = table1.getSelectedRow();//获取所选的行号
                    int id=(int)table1.getValueAt(rowNo, 0);
                    String title=(String)table1.getValueAt(rowNo, 1);
                    Float price=(Float)table1.getValueAt(rowNo, 2);
                    int number=(int) table1.getValueAt(rowNo,3);

                    //Item item=new Item(id,title,price,description,sales,img_url);
                    Order order=new Order(id,title,price,number);*//*


                }
        );*/

        button3.setText("购买");
        contentPane.add(button3);
//        button3.setBounds(510, 355, 100, 30);
        button3.setBounds(300, 355, 100, 30);
        button3.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    int id=(int)table1.getValueAt(rowNo, 0);
                    String title=(String)table1.getValueAt(rowNo, 1);
                    Float price=(Float)table1.getValueAt(rowNo, 2);
                    String description=(String)table1.getValueAt(rowNo, 3);
                    int sales=(int)table1.getValueAt(rowNo, 4);
                    String img_url=(String)table1.getValueAt(rowNo, 5);
                    /*System.out.println(id);
                    System.out.println(title);
                    System.out.println(price);
                    System.out.println(description);
                    System.out.println(sales);
                    System.out.println(img_url);*/

                    FoodItem foodItem =new FoodItem(id,title,price,description,sales,img_url);

                    OrderItem1 orderItem1=new OrderItem1(foodItem);
                    orderItem1.setVisible(true);

                   /* UpdateItem updateItem=new UpdateItem(item);
                    updateItem.setVisible(true);*/
                }
        );

        button5.setText("返回");
        contentPane.add(button5);
        button5.setBounds(600, 355, 130, 30);
        button5.addActionListener(
                (e)-> this.setVisible(false)
        );

        button4.setText("购物车");
        contentPane.add(button4);
        button4.setBounds(400, 355, 100, 30);
        button4.addActionListener(
                (e)-> {
                    ShowOrder showOrder= new ShowOrder();
                    showOrder.Show("`order`");
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
        this.setBounds(300, 300, 1000, 415);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Object[][] getDataFromDatabase() {

        java.util.List<FoodItem> list = new ArrayList<>();
        Connection conn = null;
        /*String user = "root";
        String dbPassword = "757722";
        String url = "jdbc:mysql://localhost:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";*/
        Statement stmt = null;
        String sql = "SELECT * FROM food";
        ResultSet rs = null;
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setId(rs.getInt(1));
                foodItem.setTitle(rs.getString(2));
                foodItem.setPrice(rs.getFloat(3));
                foodItem.setDescription(rs.getString(4));
                foodItem.setSales(rs.getInt(5));
                foodItem.setImg_url(rs.getString(6));
                list.add(foodItem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getTitle();
                data[i][2] = list.get(i).getPrice();
                data[i][3] = list.get(i).getDescription();
                data[i][4] = list.get(i).getSales();
                data[i][5] = list.get(i).getImg_url();
            }
        }
        return data;
    }

    private JScrollPane scrollPane1;
    private JTable table1;
    private String head[] = {"id","商品名称", "单价", "描述", "促销价", "商品图片"};
    private Object[][] data = null;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel label1;

    public static void main(String[] args) {
        new UserOrderingMain();
    }
}