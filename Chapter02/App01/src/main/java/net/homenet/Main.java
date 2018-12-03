package net.homenet;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl(new ProductDaoImpl());

        productService.addProduct(new Product("Book", 100));
        Product product = productService.findByProductName("Book");
        System.out.println(product);
    }
}
