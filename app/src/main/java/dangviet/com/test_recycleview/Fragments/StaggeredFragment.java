package dangviet.com.test_recycleview.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dangviet.com.test_recycleview.Adapters.StaggeredAdapter;
import dangviet.com.test_recycleview.Models.Product;
import dangviet.com.test_recycleview.R;

public class StaggeredFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaggeredAdapter adapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_staggered, container, false);
        
        recyclerView = view.findViewById(R.id.recyclerViewStaggered);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        
        productList = new ArrayList<>();
        loadSampleData();
        
        adapter = new StaggeredAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);
        
        return view;
    }

    private void loadSampleData() {
        productList.add(new Product("Áo thun Basic", "₫120,000", "Áo thun cotton mát, form rộng, thoải mái.", "product1"));
        productList.add(new Product("Giày Sneaker", "₫650,000", "Giày thể thao năng động.", "product2"));
        productList.add(new Product("Tai nghe Bluetooth", "₫350,000", "Tai nghe v5.0, pin 8h, âm thanh sống động, chất lượng cao.", "product4"));
        productList.add(new Product("Balo Laptop", "₫420,000", "Balo chống nước.", "product6"));
        productList.add(new Product("Đồng hồ Nam", "₫890,000", "Mặt kính sapphire, dây da cao cấp, sang trọng.", "product1"));
        productList.add(new Product("Nón Lưỡi Trai", "₫150,000", "Nón cotton.", "product2"));
        productList.add(new Product("Áo Khoác", "₫320,000", "Hoodie nỉ, giữ ấm tốt.", "product4"));
        productList.add(new Product("Bình Nước", "₫220,000", "Dung tích 800ml, giữ nhiệt 12 tiếng.", "product6"));
    }
}
