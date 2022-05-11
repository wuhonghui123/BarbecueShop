package User;

import java.sql.Timestamp;
import java.util.Objects;

public class UserBean {
    private int id;
    private int itemId;
    private String naem;
    private int number;
    private Timestamp subDate;
    private int score;
    public UserBean(){

    }
    public UserBean(int id, int itemId, String naem, int number, Timestamp subDateint, int score){
        this.id = id;
        this.itemId = itemId;
        this.naem = naem;
        this.number = number;
        this.subDate = subDate;
        this.score = score;
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
        UserBean item = (UserBean) o;
        return id == item.id && itemId == item.itemId && number == item.number && score == item.score && Objects.equals(naem, item.naem) && Objects.equals(subDate, item.subDate);
    }
}

