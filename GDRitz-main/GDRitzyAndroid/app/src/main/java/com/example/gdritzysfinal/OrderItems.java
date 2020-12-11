package com.example.gdritzysfinal;

public class OrderItems {
    private String itemName;
    private Double cost;
    private String custom;

    //constructor for the order items
    public OrderItems(String itemName, Double cost, String custom){
        this.itemName = itemName;
        this.cost = cost;
        this.custom = custom;
    }

    //getters for the name cost and custom requests
    public String getItemName() {
        return itemName;
    }

    public Double getCost() {
        return cost;
    }

    public String getCustom() {
        return custom;
    }

    //toString for the order items
    public String toString(){
        return getItemName()+ " " + String.valueOf(getCost()) + " " +  getCustom();
    }
}
