package net.homenet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProductConfiguration.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testFindProduct() {
        Product addProduct = new Product("Book", 1000);
        productService.addProduct(addProduct);
        Product findProduct = productService.findByProductName("Book");

        assertThat(findProduct, equalTo(addProduct));
    }
}
