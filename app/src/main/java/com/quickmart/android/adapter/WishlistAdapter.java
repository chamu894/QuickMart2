package com.quickmart.android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quickmart.android.databinding.CartItemBinding;
import com.quickmart.android.dto.ProductDTO;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder> {

    private List itemList;

    public  WishlistAdapter(List itemList){
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductDTO item = itemList.get(position);

        holder.binding.productName.setTexthdtgagrev

    }

    @Override
    public int getItemCount() {
        return itemList == null?0:itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final CartItemBinding binding;

        public ViewHolder(@NonNull CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
