package com.example.summerprelab1;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.summerprelab1.data.DataHandler;
import com.example.summerprelab1.data.Invoice;
import com.example.summerprelab1.data.Item;
import com.example.summerprelab1.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DashboardActivity extends AppCompatActivity {

    private static final int READ_SMS_PERMISSION_CODE = 1;
    TextView buyerName, issuerName, buyerAddress, buyerId, invoiceId, invoice_total, total_items;
    RecyclerView invoiceItems;
    CheckBox isPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_SMS}, READ_SMS_PERMISSION_CODE);
        }

        String smsInput = "invoice:IssuerName;BuyerName;BuyerAddress;IsPaid\n" +
                "invoice:Alex;Tom;Melbourne;TRUE";
        Invoice invoice = Util.readSMSForInvoice(smsInput);
        Log.d("invoice: ", invoice.toString());

        // Generate and set the InvoiceId
        String iId = generateInvoiceId();
        invoiceId = findViewById(R.id.txt_label_invoice_id); // Replace with actual TextView ID
        invoiceId.setText("InvoiceId: " + iId);

        // get buyer name
        buyerName = findViewById(R.id.txt_input_buyername);
        buyerName.setText(invoice.getBuyerName());

        // Generate and set the BuyerID
        String bId = generateBuyerId(buyerName.getText().toString()); // Replace with the actual buyer's name
        buyerId = findViewById(R.id.txt_input_BuyerID); // Replace with your actual TextView ID
        buyerId.setText(bId);
//
        // get issuer name
        issuerName = findViewById(R.id.txt_input_issuername);
        issuerName.setText(invoice.getIssuerName());
        total_items = findViewById(R.id.txt_total_items);
        invoice_total = findViewById(R.id.txt_invoice_total);

        // get buyerAddress
        buyerAddress = findViewById(R.id.txt_input_buyerAddress);
        buyerAddress.setText(invoice.getBuyerAddress());

        //checkbox bool
        isPaid = findViewById(R.id.cBox_isPaid);
        isPaid.setChecked(invoice.getPaid());

        invoiceItems = findViewById(R.id.rcy_invoiceItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        invoiceItems.setLayoutManager(layoutManager);

        List<Item> InvoiceItemList = new ArrayList<>();
        InvoiceItemList.add(new Item("1", "Shirt", 10f, 10));
        InvoiceItemList.add(new Item("1", "Shirt", 10f, 10));
        InvoiceItemList.add(new Item("1", "Shirt", 10f, 10));
        invoice.setItems(InvoiceItemList);

        InvoiceAdapter invoiceAdapter = new InvoiceAdapter(InvoiceItemList);
        invoiceItems.setAdapter(invoiceAdapter);
        invoice_total.setText(String.valueOf(invoice.getTotalValue()));
        String invoiceJson = DataHandler.convertInvoiceToString(invoice);
        Log.d("Invoice Json", invoiceJson);
        Invoice newInvoice = DataHandler.convertStringToInvoice(invoiceJson);
        Log.d("New Invoice", DataHandler.convertInvoiceToString(invoice));
        total_items.setText(String.valueOf(invoice.getQunantity()));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == READ_SMS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


            }
        }
    }

    //Invoice id
    private String generateInvoiceId() {
        // Generate 2 random characters
        char randomChar1 = generateRandomChar();
        char randomChar2 = generateRandomChar();

        // Generate 4 random digits
        int randomDigits = generateRandomDigits();

        // Create the InvoiceId
        String invoiceId = "I" + randomChar1 + randomChar2 + "-" + randomDigits;

        return invoiceId;
    }

    private char generateRandomChar() {
        Random random = new Random();
        // ASCII values for uppercase letters A-Z
        return (char) (random.nextInt(26) + 'A');
    }

    private int generateRandomDigits() {
        Random random = new Random();
        return random.nextInt(10000); // Generates random digits from 0 to 9999
    }

    //buyerId
    private String generateBuyerId(String buyerName) {
        // Check if buyerName has at least 2 characters
        if (buyerName.length() < 2) {
            throw new IllegalArgumentException("Buyer's name must have at least 2 characters");
        }

        // Get the first two characters of the buyer's name
        String firstTwoChars = buyerName.substring(0, 2);

        // Generate 3 random digits
        int randomDigits = generateRandomDigits();

        // Create the BuyerID
        String buyerId = "B" + firstTwoChars + "-" + randomDigits;

        return buyerId;
    }


}