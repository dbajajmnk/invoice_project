package com.example.summerprelab1.data;

public class DataHandler {

    String input=  "invoice:IssuerName;BuyerName;BuyerAddress;IsPaid";

    String[] contents = input.split(":");
    String[] titles = contents[1].split(";");



}
