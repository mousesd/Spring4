package net.homenet;

public interface ProductService {
    void addProduct(Product product);
    Product findByProductName(String name);
}
