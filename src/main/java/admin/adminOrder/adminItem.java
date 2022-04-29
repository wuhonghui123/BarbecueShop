package admin.adminOrder;

import java.sql.Timestamp;
import java.util.Objects;

public class adminItem {
    private int UserId;
    private int id;
    private int itemId;
    private String naem;
    private int number;
    private Timestamp subDate;
    private int score;

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
        adminItem adminItem = (adminItem) o;
        return UserId == adminItem.UserId && id == adminItem.id && itemId == adminItem.itemId && number == adminItem.number && score == adminItem.score && Objects.equals(naem, adminItem.naem) && Objects.equals(subDate, adminItem.subDate);
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
