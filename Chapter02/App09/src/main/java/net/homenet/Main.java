package net.homenet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProductConfiguration.class);

        ProductService productService = context.getBean(ProductService.class);
        productService.addProduct(new Product("Book", 100));
        Product product = productService.findByProductName("Book");
        System.out.println(product);
    }
}
