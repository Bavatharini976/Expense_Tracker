package com.example.expensetracker.model;

public class Expense {

    private String id;
    private String title;
    private double amount;

    public Expense() {}

    public Expense(String id, String title, double amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}