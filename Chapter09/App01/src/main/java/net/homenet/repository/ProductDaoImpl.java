package net.homenet.repository;

import net.homenet.domain.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    private Map<String, Product> storage = new HashMap<>();

    @Override
    @CacheEvict(value = "area", key = "#product.name")
    public void addProduct(Product product) {
        storage.put(product.getName(), product);
    }

    @Override
    @Cacheable(value = "area", key = "#productName")
    public Product findByProductName(String productName) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return storage.get(productName);
    }
}
