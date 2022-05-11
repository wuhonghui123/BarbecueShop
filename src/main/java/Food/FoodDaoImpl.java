package Food;

import Food.FoodBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodDaoImpl implements FoodDao{
    Connection conn=null;
    @Override
    public void addFood(FoodBean foodBean) {
        try {
//            conn= ConnectionHandler.getConn();
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://120.25.164.209:3306/BarbecueShopSystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);

            String sql="INSERT INTO `food` VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1, foodBean.getId());;
            pstmt.setString(2, foodBean.getTitle());
            pstmt.setFloat(3, foodBean.getPrice());
            pstmt.setString(4, foodBean.getDescription());
            pstmt.setInt(5,0);
            pstmt.setString(6, foodBean.getImg_url());
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
            try {
                throw new SQLException("新增订单失败");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
