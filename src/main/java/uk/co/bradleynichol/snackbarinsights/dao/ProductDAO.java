package uk.co.bradleynichol.snackbarinsights.dao;


import uk.co.bradleynichol.snackbarinsights.entity.Product;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    Product getProductById(String productId);
    void updateProduct(Product product);
    void deleteProduct(String productId);
    List<Product> findAllProducts();
}
