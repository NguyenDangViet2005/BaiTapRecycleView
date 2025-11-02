package dangviet.com.test_recycleview;


// MainActivity.java
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dangviet.com.test_recycleview.Models.Product;
import dangviet.com.test_recycleview.Adapters.ProductAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn status bar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        loadSampleData();

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }

    private void loadSampleData() {
        productList.add(new Product("Áo thun Basic", "₫120,000", "Áo thun cotton mát, form rộng.", "product1"));
        productList.add(new Product("Giày Sneaker", "₫650,000", "Giày thể thao năng động, đế êm.", "product2"));
        productList.add(new Product("Tai nghe Bluetooth", "₫350,000", "Tai nghe v5.0, pin 8h.", "product3"));
        productList.add(new Product("Balo Laptop", "₫420,000", "Balo chống nước, ngăn laptop 15.6 inch.", "product4"));
        productList.add(new Product("Đồng hồ Nam", "₫890,000", "Mặt kính sapphire, dây da cao cấp.", "product5"));
        productList.add(new Product("Nón Lưỡi Trai", "₫150,000", "Nón cotton, phong cách thể thao.", "product6"));
        productList.add(new Product("Áo Khoác Hoodie", "₫320,000", "Hoodie nỉ, giữ ấm tốt, unisex.", "product7"));
        productList.add(new Product("Bình Nước Inox", "₫220,000", "Dung tích 800ml, giữ nhiệt 12 tiếng.", "product8"));
        productList.add(new Product("Sạc Dự Phòng", "₫490,000", "10,000mAh, sạc nhanh PD 18W.", "product9"));
        productList.add(new Product("Chuột Không Dây", "₫210,000", "Kết nối 2.4GHz, pin 6 tháng.", "product10"));
        productList.add(new Product("Bàn Phím Cơ", "₫1,200,000", "Switch Blue, đèn RGB 16 triệu màu.", "product11"));
        productList.add(new Product("Loa Bluetooth Mini", "₫580,000", "Âm thanh nổi, pin 10 tiếng.", "product12"));
    }
}
