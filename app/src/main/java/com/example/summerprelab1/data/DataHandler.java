package com.example.summerprelab1.data;
import com.google.gson.Gson;

/**
 * Used to Handle Data related operations like
 * Conversion  string to object
 * Object to String
 */

public class DataHandler {
         private static  Gson gson = new Gson();

    /**
     * Convert Invoice object to string
     * @param invoice
     * @return
     */
    public static String convertInvoiceToString(Invoice invoice)
        {

            return gson.toJson(invoice,Invoice.class);
        }

    /**
     * Convert jsonString to Invoice
     * @param invoiceJson
     * @return
     */
    public static  Invoice convertStringToInvoice(String invoiceJson)
        {
            return gson.fromJson(invoiceJson,Invoice.class);
        }



}
