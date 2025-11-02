package dangviet.com.test_recycleview;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn status bar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_product_detail);

        ImageView imageView = findViewById(R.id.imageUrl);
        TextView nameView = findViewById(R.id.name);
        TextView descView = findViewById(R.id.description);
        TextView priceView = findViewById(R.id.price);
        Button backBtn = findViewById(R.id.back_btn);

        // Lấy Intent và Bundle được truyền sang
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra("data");
            if (bundle != null) {
                String name = bundle.getString("name");
                String description = bundle.getString("description");
                String price = bundle.getString("price");
                String imageUrl = bundle.getString("imageUrl");

                // Gán dữ liệu lên layout
                nameView.setText(name);
                descView.setText(description);
                priceView.setText(price);

                // Nếu bạn đang dùng ảnh trong res/drawable
                // imageUrl chứa tên ảnh (ví dụ: "product1")
                int resId = getResources().getIdentifier(imageUrl, "drawable", getPackageName());
                if (resId != 0) {
                    imageView.setImageResource(resId);
                } else {
                    imageView.setImageResource(R.drawable.ic_launcher_foreground);
                }
            }
        }

        // Nút quay lại
        backBtn.setOnClickListener(v -> finish());
    }
}