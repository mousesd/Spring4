package net.homenet.configuration;

import net.homenet.repository.ProductDao;
import net.homenet.repository.ProductDaoImpl;
import net.homenet.service.ProductService;
import net.homenet.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
    @Bean
    public ProductDao productDao() {
        return new ProductDaoImpl();
    }

    @Bean
    public ProductService productService(ProductDao productDao) {
        return new ProductServiceImpl(productDao);
    }
}
