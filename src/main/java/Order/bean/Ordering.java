package Order.bean;

import java.util.Objects;

public class Ordering {
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordering ordering = (Ordering) o;
        return id == ordering.id && number == ordering.number && Objects.equals(title, ordering.title) && Objects.equals(price, ordering.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, number);
    }

    public Ordering(int id, String title, Float price, int number) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.number = number;
    }

    public Ordering(){}

    private int id;
    private String title;
    private Float price;
    private  int number;
    private int user_id;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    private int order_id;




}
