package net.homenet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
    //# 1.
    @Bean
    public ProductDao productDao() {
        return new ProductDaoImpl();
    }

    @Bean
    public ProductService productService(ProductDao productDao) {
        return new ProductServiceImpl(productDao);
    }

    //# 2.
    //@Bean
    //public ProductDao productDao() {
    //    return new ProductDaoImpl();
    //}
    //
    //@Bean
    //public ProductService productService() {
    //    return new ProductServiceImpl(productDao());
    //}

    //# 3.
    //@Bean
    //public ProductDao productDao() {
    //    return new ProductDaoImpl();
    //}
    //
    //@Autowired
    //private ProductDao productDao;
    //
    //@Bean
    //public ProductService productService() {
    //    return new ProductServiceImpl(productDao);
    //}
}
