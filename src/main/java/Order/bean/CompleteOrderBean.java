package Order.bean;

import java.util.Objects;

public class CompleteOrderBean {



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
    private int userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompleteOrderBean)) return false;
        CompleteOrderBean that = (CompleteOrderBean) o;
        return getUserId() == that.getUserId() && getOrderid() == that.getOrderid() && getFoodid() == that.getFoodid() && Float.compare(that.getFoodprice(), getFoodprice()) == 0 && getNumber() == that.getNumber() && Objects.equals(getFoodtitle(), that.getFoodtitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getOrderid(), getFoodid(), getFoodtitle(), getFoodprice(), getNumber());
    }

    private int orderid;
    private int foodid;
    private String foodtitle;
    private float foodprice;
    private int number;





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

    public float getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(float foodprice) {
        this.foodprice = foodprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    public CompleteOrderBean(){}

    public CompleteOrderBean(int userId, int orderid, int foodid, String foodtitle, float foodprice, int number) {
        this.userId = userId;
        this.orderid = orderid;
        this.foodid = foodid;
        this.foodtitle = foodtitle;
        this.foodprice = foodprice;
        this.number = number;
    }
}
