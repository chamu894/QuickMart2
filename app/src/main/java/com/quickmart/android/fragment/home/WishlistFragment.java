package com.quickmart.android.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quickmart.android.R;
import com.quickmart.android.adapter.WishlistAdapter;
import com.quickmart.android.databinding.FragmentWishlistBinding;
import com.quickmart.android.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class WishlistFragment extends Fragment {

    private FragmentWishlistBinding wishlistBinding;


    public WishlistFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.wishlistBinding = FragmentWishlistBinding.inflate(inflater,container,false);
        return wishlistBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<ProductDTO> items = new ArrayList();

        items.add(new ProductDTO().setName("P1").setPrice(300.00));
        items.add(new ProductDTO().setName("P2").setPrice(200.00));
        

        
        wishlistBinding.itemList.setLayoutManager(new LinearLayoutManager(
                requireActivity(),LinearLayoutManager.VERTICAL,
                false
        ));

        wishlistBinding.itemList.setAdapter(new WishlistAdapter(items));
        
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.wishlistBinding = null;
    }
}