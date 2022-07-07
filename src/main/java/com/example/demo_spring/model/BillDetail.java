package com.example.demo_spring.model;

import javax.persistence.*;

@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int amountTotal;
    private double moneyTotal;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Bill bill;

    public BillDetail() {
    }

    public BillDetail(long id, int amountTotal, double moneyTotal, Product product, Bill bill) {
        this.id = id;
        this.amountTotal = amountTotal;
        this.moneyTotal = moneyTotal;
        this.product = product;
        this.bill = bill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(int amountTotal) {
        this.amountTotal = amountTotal;
    }

    public double getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
