package Order;

import java.util.Objects;

public class Order {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && number == order.number && Objects.equals(title, order.title) && Objects.equals(price, order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, number);
    }

    public Order(int id, String title, Float price, int number) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.number = number;
    }

    public Order(){}

    private int id;
    private String title;
    private Float price;
    private  int number;
}
