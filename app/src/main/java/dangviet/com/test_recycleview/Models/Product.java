package dangviet.com.test_recycleview.Models;

// Product.java
public class Product {
    private String name;
    private String price; // hoặc dùng double nếu muốn tính toán
    private String description;
    private String imageUrl; // có thể là URL hoặc tên resource (ví dụ "product1")

    public Product(String name, String price, String description, String imageUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // getters
    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
}
