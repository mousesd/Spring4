package net.homenet;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {
    private Map<String, Product> storage = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        storage.put(product.getName(), product);
    }

    @Override
    public Product findByProductName(String name) {
        return storage.get(name);
    }
}
