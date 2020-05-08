package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private Order order;
    private ArrayList<Order> orders;

    public PackageData(String operationType, Order order) {
        this.operationType = operationType;
        this.order = order;
    }

    public PackageData(String operationType) {/// List all info from server
        this.operationType = operationType;
    }

    public PackageData(ArrayList<Order> orders) {/// Send back to client
        this.orders = orders;
    }

    public PackageData() {

    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Order getStudent() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
