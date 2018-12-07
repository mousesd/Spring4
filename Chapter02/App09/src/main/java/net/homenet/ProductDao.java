package net.homenet;

public interface ProductDao {
    void addProduct(Product product);
    Product findByProductName(String name);
}
