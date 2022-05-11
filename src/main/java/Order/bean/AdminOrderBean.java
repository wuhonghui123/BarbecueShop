package Order.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class AdminOrderBean {
    private int UserId;
    private int id;
    private int itemId;
    private String naem;
    private int number;
    private Timestamp subDate;
    private int score;
    public AdminOrderBean(){

    }
    public AdminOrderBean(int UserId, int id, int itemId, String naem, int number, Timestamp subDate, int score){
        this.UserId = UserId;
        this.id = id;
        this.itemId = itemId;
        this.naem = naem;
        this.number = number;
        this.subDate = subDate;
        this.score = score;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Timestamp getSubDate() {
        return subDate;
    }

    public void setSubDate(Timestamp subDate) {
        this.subDate = subDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminOrderBean AdminOrderBean = (AdminOrderBean) o;
        return UserId == AdminOrderBean.UserId && id == AdminOrderBean.id && itemId == AdminOrderBean.itemId && number == AdminOrderBean.number && score == AdminOrderBean.score && Objects.equals(naem, AdminOrderBean.naem) && Objects.equals(subDate, AdminOrderBean.subDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, id, itemId, naem, number, subDate, score);
    }

    @Override
    public String toString() {
        return "adminItem{" +
                "UserId=" + UserId +
                ", id=" + id +
                ", itemId=" + itemId +
                ", naem='" + naem + '\'' +
                ", number=" + number +
                ", subDate=" + subDate +
                ", score=" + score +
                '}';
    }
}

