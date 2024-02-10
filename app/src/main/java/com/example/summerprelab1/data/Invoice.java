package com.example.summerprelab1.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invoice {
    String InvoiceId,BuyerName,IssuerName, BuyerID, BuyerAddress;
    Boolean isPaid;
    Float TotalValue=0f;
    Integer qunantity=0;
    List<Item> Items;

    public Invoice(String buyerName, String issuerName, String buyerAddress, Boolean isPaid) {
        BuyerName = buyerName;
        IssuerName = issuerName;
        BuyerAddress = buyerAddress;
        this.isPaid = isPaid;

    }


    @Override
    public String toString() {
        return "Invoice{" +
                "InvoiceId='" + InvoiceId + '\'' +
                ", BuyerName='" + BuyerName + '\'' +
                ", IssuerName='" + IssuerName + '\'' +
                ", BuyerID='" + BuyerID + '\'' +
                ", BuyerAddress='" + BuyerAddress + '\'' +
                ", isPaid=" + isPaid +
                ", TotalValue=" + TotalValue +
                '}';
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public String getIssuerName() {
        return IssuerName;
    }

    public String getBuyerAddress() {
        return BuyerAddress;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setItems(List items) {
        Items = items;
    }

    public Float getTotalValue() {
        for (Item item : Items) {
            TotalValue+=item.getTotal();
            qunantity+=item.getQuantity();
        }
        return TotalValue;
    }

    public Integer getQunantity() {
        return qunantity;
    }
}
