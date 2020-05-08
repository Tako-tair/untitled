package sample;

import java.io.Serializable;

public class Order implements Serializable {
    private  String eat;

    public Order(String eat) {
        this.eat = eat;
    }

    public Order(String bread, String count) {
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }
}
