package Order.item;

import java.util.Objects;

public class CompleteOrderItem {

    private int userId;

    @Override
    public String toString() {
        return "Completeorderitem{" +
                "userId=" + userId +
                ", orderid=" + orderid +
                ", foodid=" + foodid +
                ", foodtitle='" + foodtitle + '\'' +
                ", foodprice='" + foodprice + '\'' +
                ", number=" + number +
                '}';
    }

    private int orderid;
    private int foodid;
    private String foodtitle;
    private String foodprice;
    private int number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompleteOrderItem)) return false;
        CompleteOrderItem that = (CompleteOrderItem) o;
        return getUserId() == that.getUserId() && getOrderid() == that.getOrderid() && getFoodid() == that.getFoodid() && getNumber() == that.getNumber() && getFoodtitle().equals(that.getFoodtitle()) && getFoodprice().equals(that.getFoodprice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getOrderid(), getFoodid(), getFoodtitle(), getFoodprice(), getNumber());
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getFoodtitle() {
        return foodtitle;
    }

    public void setFoodtitle(String foodtitle) {
        this.foodtitle = foodtitle;
    }

    public String getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(String foodprice) {
        this.foodprice = foodprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    public CompleteOrderItem(){}

    public CompleteOrderItem(int userId, int orderid, int foodid, String foodtitle, String foodprice, int number) {
        this.userId = userId;
        this.orderid = orderid;
        this.foodid = foodid;
        this.foodtitle = foodtitle;
        this.foodprice = foodprice;
        this.number = number;
    }
}
