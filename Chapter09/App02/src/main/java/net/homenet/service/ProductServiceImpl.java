package net.homenet.service;

import net.homenet.domain.Product;
import net.homenet.repository.ProductDao;
import org.springframework.util.StopWatch;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public Product findByProductName(String productName) {
        StopWatch watch = new StopWatch();
        watch.start();

        Product product = productDao.findByProductName(productName);

        watch.stop();
        System.out.format("Seconds=%1$s, value=%2$s%n", watch.getTotalTimeSeconds(), product);

        return product;
    }
}
