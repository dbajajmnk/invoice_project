package com.example.summerprelab1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.summerprelab1.data.Item;

import java.util.Arrays;
import java.util.List;

public class InvoiceAdapter extends RecyclerView.Adapter<ItemInvoiceViewHolder>{
    List<Item> listOfItems ;

    public InvoiceAdapter(List<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    @NonNull
    @Override
    public ItemInvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_item, parent,false);
        return new ItemInvoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemInvoiceViewHolder holder, int position) {
        Item item = this.listOfItems.get(position);
        holder.bind(item);

    }

    @Override
    public int getItemCount() {
        return this.listOfItems.size();
    }
}
