package lk.ijse.spicesystem.to;

public class Order {
    private String orderID;
    private String ShopID;
    private String FinishedItem;
    private int amount;
    private double price;

    public Order(String orderID, String shopID, String finishedItem, int amount, double price) {
        this.orderID = orderID;
        ShopID = shopID;
        FinishedItem = finishedItem;
        this.amount = amount;
        this.price = price;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public String getFinishedItem() {
        return FinishedItem;
    }

    public void setFinishedItem(String finishedItem) {
        FinishedItem = finishedItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
