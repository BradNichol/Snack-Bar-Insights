package uk.co.bradleynichol.snackbarinsights.dao;


import uk.co.bradleynichol.snackbarinsights.entity.Product;

public interface IProductDAO {
    void addProduct(Product product);
    Product getProductById(String productId);
    void updateProduct(Product product);
    void deleteProduct(String productId);
}
