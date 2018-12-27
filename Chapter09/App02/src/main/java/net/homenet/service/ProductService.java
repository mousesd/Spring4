package net.homenet.service;

import net.homenet.domain.Product;

public interface ProductService {
    void addProduct(Product product);
    Product findByProductName(String productName);
}
