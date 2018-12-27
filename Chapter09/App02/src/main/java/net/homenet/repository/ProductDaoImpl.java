package net.homenet.repository;

import net.homenet.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    private Map<String, Product> storage = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        storage.put(product.getName(), product);
    }

    @Override
    public Product findByProductName(String productName) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return storage.get(productName);
    }
}
