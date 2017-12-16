package com.mit.lab.meta;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.meta.Donut</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 11/28/2017
 */
public class Donut {

    private double price;
    private double quantity;

    public Donut() {
        this.price = 0.0;
        this.quantity = 0.0;
    }

    public Donut(double quantity) {
        this.quantity = quantity;
        this.price = 1.0;
    }

    public Donut(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double calculate() {
        return this.price * this.quantity;
    }
}
