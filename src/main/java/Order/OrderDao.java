package Order;

import Order.bean.OrderBean;
import Order.bean.Ordering;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 操作订单
 * 插入订单（当前）
 * 查询订单（后续）
 * 删除订单（后续）
 */
public interface OrderDao {

    /*
    只规定能做什么
     */
    void newOrder(Ordering ordering) throws SQLException;

    void DeleteOrder(int id) throws SQLException;

    void DeleteOrders(String orderid) throws SQLException;

    void DeleteOrdering(String userid) throws SQLException;

    float pay(String userid)throws SQLException;

    void addOrder(String orderid,String userid) throws SQLException;

    void confirm(String orderid) throws SQLException;

    void Updateordering(String orderid,String userid) throws SQLException;

    void newOrders(String orderid, String userid, float money, Timestamp timestamp) throws SQLException;
}
