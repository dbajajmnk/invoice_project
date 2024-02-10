package com.example.summerprelab1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.summerprelab1.data.Item;

public class ItemInvoiceViewHolder extends RecyclerView.ViewHolder {
    TextView itemId, itemName, itemQuantity, itemCost;
    public ItemInvoiceViewHolder(@NonNull View itemView) {
        super(itemView);
        itemId = itemView.findViewById(R.id.txt_itemId_value);
        itemName = itemView.findViewById(R.id.txt_itemName_value);
        itemQuantity = itemView.findViewById(R.id.txt_itemQuantity_value);
        itemCost = itemView.findViewById(R.id.txt_itemCost_value);
    }
    public void bind(Item item){
        itemId.setText(item.getItemId());
        itemName.setText(item.getName());
        itemCost.setText(item.getCost().toString());
        itemQuantity.setText(item.getCost().toString());
    }
}
