package User.UserOrder;

import java.sql.Timestamp;
import java.util.Objects;

public class Item {
    private int id;
    private int itemId;
    private String naem;
    private int number;
    private Timestamp subDate;
    private int score;

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
        Item item = (Item) o;
        return id == item.id && itemId == item.itemId && number == item.number && score == item.score && Objects.equals(naem, item.naem) && Objects.equals(subDate, item.subDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, naem, number, subDate, score);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", naem='" + naem + '\'' +
                ", number=" + number +
                ", subDate=" + subDate +
                ", score=" + score +
                '}';
    }
}