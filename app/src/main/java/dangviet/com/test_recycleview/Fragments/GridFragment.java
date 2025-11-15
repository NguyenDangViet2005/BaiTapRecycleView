package dangviet.com.test_recycleview.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dangviet.com.test_recycleview.Adapters.GridAdapter;
import dangviet.com.test_recycleview.Models.Product;
import dangviet.com.test_recycleview.R;

public class GridFragment extends Fragment {

    private RecyclerView recyclerView;
    private GridAdapter adapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        
        recyclerView = view.findViewById(R.id.recyclerViewGrid);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 columns
        
        productList = new ArrayList<>();
        loadSampleData();
        
        adapter = new GridAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private void loadSampleData() {
        productList.add(new Product("Áo Khoác Hoodie", "₫320,000", "Hoodie nỉ, giữ ấm tốt.", "product1"));
        productList.add(new Product("Bình Nước Inox", "₫220,000", "Dung tích 800ml.", "product2"));
        productList.add(new Product("Sạc Dự Phòng", "₫490,000", "10,000mAh, sạc nhanh.", "product4"));
        productList.add(new Product("Chuột Không Dây", "₫210,000", "Kết nối 2.4GHz.", "product6"));
        productList.add(new Product("Bàn Phím Cơ", "₫1,200,000", "Switch Blue, đèn RGB.", "product1"));
        productList.add(new Product("Loa Bluetooth", "₫580,000", "Âm thanh nổi.", "product2"));
        productList.add(new Product("Máy tính bảng", "₫2,500,000", "Màn hình 10 inch.", "product4"));
        productList.add(new Product("Kính mắt", "₫450,000", "Chống tia UV.", "product6"));
    }
}
