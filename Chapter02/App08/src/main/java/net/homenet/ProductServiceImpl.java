package net.homenet;

@SuppressWarnings("WeakerAccess")
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public Product findByProductName(String name) {
        return productDao.findByProductName(name);
    }
}
