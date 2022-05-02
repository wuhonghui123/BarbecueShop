package Order;

import java.sql.SQLException;

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

    float pay()throws SQLException;
}
