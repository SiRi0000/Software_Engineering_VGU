public class MealOrder {
    private int customerID;
    private OrderStatus status;
    private int orderID;

    MealOrder(int ID) {
        this.status = OrderStatus.INACTIVE;
        this.orderID = ID;
    }

    public void setStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public int getOrderID() {
        return this.orderID;
    }

}
