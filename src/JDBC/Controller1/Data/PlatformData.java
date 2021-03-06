package JDBC.Controller1.Data;

public class PlatformData {
    private int id;
    private String name;
    private String url;
    private double sales_fee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getSales_fee() {
        return sales_fee;
    }

    public void setSales_fee(double sales_fee) {
        this.sales_fee = sales_fee;
    }

    @Override
    public String toString() {
        return "PlatformData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sales_fee=" + sales_fee +
                '}';
    }
}
