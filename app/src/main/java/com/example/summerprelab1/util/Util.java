package com.example.summerprelab1.util;

import com.example.summerprelab1.data.Invoice;

public class Util {

    public static Invoice readSMSForInvoice(String sms)
    {
        //split string

        String[] lines = sms.split("\n");

        System.out.println(lines[0]);
        System.out.println(lines[1]);

        String[] invoiceValues = lines[1].split(";");
        String issuerName = invoiceValues[0].split(":")[1];
        String buyerName = invoiceValues[1];
        String buyerAddress = invoiceValues[2];
        Boolean isPaid = Boolean.valueOf(invoiceValues[3]);
        
        return new Invoice(issuerName, buyerName, buyerAddress, isPaid);
    }
}
