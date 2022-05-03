package Order;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Timestamp;
import java.util.Objects;

public class AdminOrderitem {
    private int UserId;
    private int id;
    private int itemId;
    private String naem;
    private int number;
    private Timestamp subDate;
    private int score;
    public AdminOrderitem(){

    }
    public AdminOrderitem(int UserId,int id,int itemId,String naem,int number,Timestamp subDate,int score){
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
        AdminOrderitem AdminOrderitem = (AdminOrderitem) o;
        return UserId == AdminOrderitem.UserId && id == AdminOrderitem.id && itemId == AdminOrderitem.itemId && number == AdminOrderitem.number && score == AdminOrderitem.score && Objects.equals(naem, AdminOrderitem.naem) && Objects.equals(subDate, AdminOrderitem.subDate);
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

