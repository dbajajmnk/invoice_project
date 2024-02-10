package com.example.summerprelab1.data;

public class Item {
//    input field

    String ItemId, Name;
    Float Cost;
    Integer Quantity;
    float total;

    public Item(String itemId, String name, Float cost, Integer quantity) {
        ItemId = itemId;
        Name = name;
        Cost = cost;
        Quantity = quantity;
        total=quantity*cost;
    }

    public Item(String name, Float cost, Integer quantity) {
        Name = name;
        Cost = cost;
        Quantity = quantity;
        total=quantity*cost;
    }



    public String getName() {
        return Name;
    }

    public Float getCost() {
        return Cost;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public String getItemId(){return ItemId;}

    public float getTotal(){
        return total;
    }


}
