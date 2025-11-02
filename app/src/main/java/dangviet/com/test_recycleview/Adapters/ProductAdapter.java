package dangviet.com.test_recycleview.Adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import dangviet.com.test_recycleview.ProductDetailActivity;
import dangviet.com.test_recycleview.R;
import dangviet.com.test_recycleview.Models.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.textName.setText(product.getName());
        holder.textPrice.setText(product.getPrice());
        holder.textDesc.setText(product.getDescription());

        String imgName = product.getImageUrl();

        if (imgName != null && !imgName.isEmpty()) {
            int resId = holder.itemView.getContext()
                    .getResources()
                    .getIdentifier(imgName, "drawable", holder.itemView.getContext().getPackageName());
            if (resId != 0) {
                holder.imageProduct.setImageResource(resId);
            } else {
                holder.imageProduct.setImageResource(R.drawable.ic_launcher_foreground);
            }
        } else {
            holder.imageProduct.setImageResource(R.drawable.ic_launcher_foreground);
        }
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", product.getName());
            bundle.putString("description", product.getDescription());
            bundle.putString("price", product.getPrice());
            bundle.putString("imageUrl", product.getImageUrl());
            intent.putExtra("data", bundle);
            v.getContext().startActivity(intent);
        });
    }



    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProduct;
        TextView textName, textPrice, textDesc;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.imageProduct);
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);
            textDesc = itemView.findViewById(R.id.textDesc);
        }
    }
}
