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

import dangviet.com.test_recycleview.Models.Product;
import dangviet.com.test_recycleview.ProductDetailActivity;
import dangviet.com.test_recycleview.R;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.ViewHolder> {

    private Context context;
    private List<Product> productList;

    public StaggeredAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product_staggered, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        
        holder.textName.setText(product.getName());
        holder.textDesc.setText(product.getDescription());
        holder.textPrice.setText(product.getPrice());

        int resId = context.getResources().getIdentifier(
                product.getImageUrl(),
                "drawable",
                context.getPackageName()
        );
        
        if (resId != 0) {
            holder.imageProduct.setImageResource(resId);
        } else {
            holder.imageProduct.setImageResource(R.drawable.ic_launcher_foreground);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", product.getName());
            bundle.putString("description", product.getDescription());
            bundle.putString("price", product.getPrice());
            bundle.putString("imageUrl", product.getImageUrl());
            intent.putExtra("data", bundle);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProduct;
        TextView textName, textDesc, textPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.imageProductStaggered);
            textName = itemView.findViewById(R.id.textNameStaggered);
            textDesc = itemView.findViewById(R.id.textDescStaggered);
            textPrice = itemView.findViewById(R.id.textPriceStaggered);
        }
    }
}
