package Bean;

import java.sql.Timestamp;
import java.util.Objects;

public class History {

    private int id;
    private int itemId;
    private String naem;
    private int number;
    private Timestamp subDate;
    private int score;
    private String  pay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
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

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return id == history.id && itemId == history.itemId && number == history.number && score == history.score && Objects.equals(naem, history.naem) && Objects.equals(subDate, history.subDate) && Objects.equals(pay, history.pay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, naem, number, subDate, score, pay);
    }

    @Override
    public String toString() {
        return "history{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", naem='" + naem + '\'' +
                ", number=" + number +
                ", subDate=" + subDate +
                ", score=" + score +
                ", pay='" + pay + '\'' +
                '}';
    }
}
