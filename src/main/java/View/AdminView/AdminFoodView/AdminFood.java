package View.AdminView.AdminFoodView;

import Food.FoodBean;
import Food.FoodDaoImpl;
import View.UserView.ConnectionSQL;

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
public class AdminFood  extends JPanel {
    //  Connection conn=null;
    private JLabel label1 = new JLabel();
    private JButton button5 = new JButton();
    private JButton button1 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();
    private Object[][] data = null;
    private JScrollPane scrollPane1 = new JScrollPane();
    private JTable table1 = new JTable();
    private String head[] = {"id","商品名称", "单价", "描述", "销量", "商品图片"};

    public JPanel init() {

        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);



        label1.setFont(new
                Font("STHeiti Light", Font.BOLD,
                30));
        label1.setText("商品信息");
        // panel.add(label1);
        label1.setBounds(460, 0, 600, 60);

        button1.setText("修改");
        panel.add(button1);
        button1.setBounds(500, 360, 100, 30);
        button1.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    int id=(int)table1.getValueAt(rowNo, 0);
                    String title=(String)table1.getValueAt(rowNo, 1);
                    Float price=(Float)table1.getValueAt(rowNo, 2);
                    String description=(String)table1.getValueAt(rowNo, 3);
                    int sales=(int)table1.getValueAt(rowNo, 4);
                    String img_url=(String)table1.getValueAt(rowNo, 5);
                    FoodBean foodBean =new FoodBean(id,title,price,description,sales,img_url);
                    GaiFood gaiFood = new GaiFood(foodBean);
                    gaiFood.setVisible(true);
                }
        );


        button3.setText("查看");
        panel.add(button3);
//        button3.setBounds(510, 355, 100, 30);
        button3.setBounds(300, 360, 100, 30);
        button3.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    int id=(int)table1.getValueAt(rowNo, 0);
                    String title=(String)table1.getValueAt(rowNo, 1);
                    Float price=(Float)table1.getValueAt(rowNo, 2);
                    String description=(String)table1.getValueAt(rowNo, 3);
                    int sales=(int)table1.getValueAt(rowNo, 4);
                    String img_url=(String)table1.getValueAt(rowNo, 5);
                    FoodBean foodBean =new FoodBean(id,title,price,description,sales,img_url);
                    SeeFood seeFood = new SeeFood(foodBean);
                    seeFood.setVisible(true);

                }
        );

        button5.setText("删除");
        panel.add(button5);
        button5.setBounds(600, 360, 100, 30);
        button5.addActionListener((e)-> {
            int rowNo = table1.getSelectedRow();
            int id=(int)table1.getValueAt(rowNo, 0);
            FoodDaoImpl foodDao = new FoodDaoImpl();
            foodDao.DeleteFood(id);
                }
        );

        button4.setText("添加");
        panel.add(button4);
        button4.setBounds(400, 360, 100, 30);
        button4.addActionListener(
                (e)-> {

                    new AddFood();

                }
        );


        {
            scrollPane1.setViewportView(table1);//增加滚动条
        }
        panel.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 1000, 300);
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

    public Object[][] getDataFromDatabase() {

        java.util.List<FoodBean> list = new ArrayList<>();
        Connection conn = null;
        /*String user = "root";
        String dbPassword = "757722";
        String url = "jdbc:mysql://localhost:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";*/
        Statement stmt = null;
        String sql = "SELECT * FROM food";
        ResultSet rs = null;
        try {
            conn = ConnectionSQL.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                FoodBean foodBean = new FoodBean();
                foodBean.setId(rs.getInt(1));
                foodBean.setTitle(rs.getString(2));
                foodBean.setPrice(rs.getFloat(3));
                foodBean.setDescription(rs.getString(4));
                foodBean.setSales(rs.getInt(5));
                foodBean.setImg_url(rs.getString(6));
                list.add(foodBean);
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
}
