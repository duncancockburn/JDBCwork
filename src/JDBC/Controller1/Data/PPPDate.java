package JDBC.Controller1.Data;

public class PPPDate {

    private double price;
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PPPDate{" +
                "price=" + price +
                ", id=" + id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
