package net.homenet.repository;

import net.homenet.domain.Product;

public interface ProductDao {
    void addProduct(Product product);
    Product findByProductName(String productName);
}
