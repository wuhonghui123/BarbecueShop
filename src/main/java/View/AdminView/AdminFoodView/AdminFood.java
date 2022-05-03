package View.AdminView.AdminFoodView;

import Food.FoodItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


/**
 * @liwei
 */
public class AdminFood extends JFrame {
    public AdminFood() {
        initComponents();
    }

    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();

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
        label1.setBounds(460, 0, 800, 60);

        button1.setText("删除");
        contentPane.add(button1);
        button1.setBounds(510, 355, 100, 30);

        button2.setText("新增");
        contentPane.add(button2);
        button2.setBounds(610, 355, 100, 30);
        button2.addActionListener((e)->{

        });
        contentPane.add(textField1);
        textField1.setBounds(270, 355, 130, 30);



        button3.setText("修改");
        contentPane.add(button3);
        button3.setBounds(710, 355, 100, 30);
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

                    FoodItem foodItem =new FoodItem(id,title,price,description,sales,img_url
                    );

                    UpdateFoodItem updateFoodItem =new UpdateFoodItem(foodItem);
                    updateFoodItem.setVisible(true);
                }
        );
        contentPane.add(textField1);
        textField1.setBounds(270, 355, 130, 30);

        button4.setText("查询");
        contentPane.add(button4);
        button4.setBounds(410, 355, 100, 30);

        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 50, 1000, 600);
        //contentPane.setPreferredSize(new Dimension(1000, 800));
        pack();
        setLocationRelativeTo(getOwner());
        this.setBounds(300, 300, 1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Object[][] getDataFromDatabase() {

        java.util.List<FoodItem> list = new ArrayList<FoodItem>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://localhost:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;
        String sql = "SELECT * FROM item";
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
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
    private String head[] = {"id", "商品名称", "单价", "描述", "促销价", "商品图片"};
    private Object[][] data = null;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label1;

    public static void main(String[] args) {
        new AdminFood();
    }
}