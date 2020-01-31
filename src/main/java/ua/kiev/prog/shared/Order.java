package ua.kiev.prog.shared;

public class Order {

    @Id
    private int id;

    private String title;
    private int orderNumber;

    public Order() {
    }

    public Order(String title, int orderNumber) {
        this.title = title;
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
