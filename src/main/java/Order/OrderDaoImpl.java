package Order;


import Order.bean.OrderBean;
import Order.bean.Ordering;
import util.ConnectionHandler;

import java.sql.*;
import java.util.Random;

public class OrderDaoImpl implements OrderDao {
    Connection conn=null;

    @Override
    public void confirm(String orderid){
        try {
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql="INSERT INTO history SELECT * FROM `orders` WHERE order_id = ?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, orderid);

            pstmt.executeUpdate();//真正执行sql语句
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

@Override
    public void addOrder(String orderid,String userid) {
        try {
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql="INSERT INTO completeorder (food_id,food_title,food_price,number,user_id,order_id)\n" +
                    "SELECT food_id,food_title,food_price,number,user_id,order_id FROM ordering WHERE user_id = ?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userid);

            pstmt.executeUpdate();//真正执行sql语句
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void Updateordering(String orderid,String userid){
        try {
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql="UPDATE ordering SET order_id = ? WHERE user_id = ?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,orderid);
            pstmt.setString(2,userid);
            pstmt.executeUpdate();//真正执行sql语句
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    @Override
    public float pay(String userid)throws SQLException{
        float money=0;
        String user = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        conn = DriverManager.getConnection(url, user, dbPassword);
        String sql="SELECT sum(food_price*number) FROM `ordering` WHERE user_id = "+userid;
        Statement stmt = null;
        ResultSet rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            money= rs.getFloat(1);
        }
        conn.close();

        return money;
    }


    //随机生成一个订单号
    public String OrderId() {
        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<9;i++){
            int number=random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }



//用于确认送达将表order的数据传送给表history后删除表order中这个数据
    @Override
    public  void DeleteOrders(String orderid) throws SQLException{
        try {
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql="DELETE FROM `orders` WHERE order_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,orderid);

            pstmt.executeUpdate();//真正执行sql语句
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            conn.close();
        }
    }

    //删除购物车中一行数据
@Override
    public  void DeleteOrder(int id) throws SQLException{
        try {
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            String sql="DELETE FROM `ordering` WHERE food_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();//真正执行sql语句
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            conn.close();
        }
    }

    //清空购物车的数据
    @Override
    public void DeleteOrdering(String userid) throws SQLException{
        String user = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);


            String sql="DELETE FROM `ordering` WHERE user_id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            conn.close();
        }
    }



    @Override
    public void newOrder(Ordering ordering) throws SQLException{
        try {
//            conn= ConnectionHandler.getConn();
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql="INSERT INTO `ordering` VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1, ordering.getId());
            pstmt.setString(2, ordering.getTitle());
            pstmt.setFloat(3, ordering.getPrice());
            pstmt.setInt(4, ordering.getNumber());
            pstmt.setInt(5,ordering.getUser_id());
            pstmt.setInt(6,ordering.getOrder_id());
            /*pstmt.setString(1,order.getId());
            pstmt.setInt(2,order.getMch_id());
            pstmt.setString(3,order.getOut_trade_no());
            pstmt.setTimestamp(4,order.getOrder_time());
            pstmt.setString(5,order.getTransaction_id());
            pstmt.setInt(6,order.getUserId());
            pstmt.setInt(7,order.getItem_id());
            pstmt.setFloat(8,order.getItem_price());
            pstmt.setInt(9,order.getAmount());
            pstmt.setFloat(10,order.getOrder_price());*/

            pstmt.executeUpdate();//真正执行sql语句

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("新增订单失败");
        }finally {
            conn.close();
        }
    }

    @Override
    public void newOrders(String orderid,String userid,float money,Timestamp timestamp) throws SQLException{
        Connection conn = null;
        try {

            conn = ConnectionHandler.getConn();
            // System.out.println(conn.hashCode());
            //conn.setAutoCommit(false);//取消自动提交，自己控制，也叫开始事务
            String sql="INSERT INTO `orders` VALUES(?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,orderid);
            pstmt.setString(2,userid);
            pstmt.setFloat(3,money);
            pstmt.setTimestamp(4,timestamp);
            pstmt.setString(5,"未支付");
//            pstmt.setInt(7,order.getItem_id());
//            pstmt.setFloat(8,order.getItem_price());
//            pstmt.setInt(9,order.getAmount());
//            pstmt.setFloat(10,order.getOrder_price());

            pstmt.executeUpdate();

            //conn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw  new SQLException("新增订单失败");

        }
    }
}
