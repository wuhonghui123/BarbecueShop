package Bean;

public class FoodBean {
    private int food_id;
    private String food_name;
    private Float price;
    private int food_sales;
    private String food_image;
    private String food_introduce;

    public int getFood_id() { return food_id; }
    public void setFood_id(int food_id) { this.food_id = food_id; }

    public String getFood_name() { return food_name; }
    public void setFood_name(String food_name) { this.food_name = food_name; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public int getFood_sales() { return food_sales; }
    public void setFood_sales(int food_sales) { this.food_sales = food_sales; }

    public String getFood_image() { return food_image; }
    public void setFood_image(String food_image) { this.food_image = food_image; }

    public String getFood_introduce() { return food_introduce; }
    public void setFood_introduce(String food_introduce) { this.food_introduce = food_introduce; }
}