package net.homenet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ProductConfiguration {
    @Bean
    public ProductDao productDao() {
        return new ProductDaoImpl();
    }

    @Bean
    public ProductService productService(ProductDao productDao) {
        return new ProductServiceImpl(productDao);
    }

    @Bean
    public ProductAspect productAspect() {
        return new ProductAspect();
    }
}
