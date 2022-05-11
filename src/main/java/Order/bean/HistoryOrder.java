package Order.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class HistoryOrder {
    private int order_id;
    private int user_id;
    private float order_price;
    private Timestamp order_date;
    private String orser_pay;

    public HistoryOrder(){

    }

    public HistoryOrder(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(float order_price) {
        this.order_price = order_price;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public String getOrser_pay() {
        return orser_pay;
    }

    public void setOrser_pay(String orser_pay) {
        this.orser_pay = orser_pay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryOrder that = (HistoryOrder) o;
        return order_id == that.order_id && user_id == that.user_id && Float.compare(that.order_price, order_price) == 0 && Objects.equals(order_date, that.order_date) && Objects.equals(orser_pay, that.orser_pay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, user_id, order_price, order_date, orser_pay);
    }

    @Override
    public String toString() {
        return "Orderitem{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", order_price=" + order_price +
                ", order_date=" + order_date +
                ", orser_pay='" + orser_pay + '\'' +
                '}';
    }
}
