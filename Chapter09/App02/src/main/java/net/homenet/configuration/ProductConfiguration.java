package net.homenet.configuration;

import net.homenet.repository.ProductDao;
import net.homenet.repository.ProductDaoImpl;
import net.homenet.service.ProductService;
import net.homenet.service.ProductServiceImpl;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@EnableCaching
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
    public ConcurrentMapCacheFactoryBean concurrentMapCacheFactory() {
        ConcurrentMapCacheFactoryBean concurrentMapCacheFactory = new ConcurrentMapCacheFactoryBean();
        concurrentMapCacheFactory.setName("area");
        return concurrentMapCacheFactory;
    }

    @Bean
    public SimpleCacheManager cacheManager(ConcurrentMapCacheFactoryBean cache) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(cache.getObject()));
        return cacheManager;
    }
}
