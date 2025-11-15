package dangviet.com.test_recycleview.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dangviet.com.test_recycleview.Adapters.ProductAdapter;
import dangviet.com.test_recycleview.Models.Product;
import dangviet.com.test_recycleview.R;

public class LinearFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_linear, container, false);
        
        recyclerView = view.findViewById(R.id.recyclerViewLinear);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        productList = new ArrayList<>();
        loadSampleData();
        
        adapter = new ProductAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private void loadSampleData() {
        productList.add(new Product("Áo thun Basic", "₫120,000", "Áo thun cotton mát, form rộng.", "product1"));
        productList.add(new Product("Giày Sneaker", "₫650,000", "Giày thể thao năng động, đế êm.", "product2"));
        productList.add(new Product("Tai nghe Bluetooth", "₫350,000", "Tai nghe v5.0, pin 8h.", "product3"));
        productList.add(new Product("Balo Laptop", "₫420,000", "Balo chống nước, ngăn laptop 15.6 inch.", "product4"));
        productList.add(new Product("Đồng hồ Nam", "₫890,000", "Mặt kính sapphire, dây da cao cấp.", "product5"));
        productList.add(new Product("Nón Lưỡi Trai", "₫150,000", "Nón cotton, phong cách thể thao.", "product6"));
    }
}
