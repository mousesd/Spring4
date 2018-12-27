package net.homenet;

import net.homenet.domain.Product;
import net.homenet.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        ProductService productService = context.getBean(ProductService.class);
        productService.addProduct(new Product("Book", 1000));
        productService.findByProductName("Book");
        productService.findByProductName("Book");
        productService.findByProductName("Book");

        productService.addProduct(new Product("Book", 2000));
        productService.findByProductName("Book");
        productService.findByProductName("Book");
        productService.findByProductName("Book");
    }
}
