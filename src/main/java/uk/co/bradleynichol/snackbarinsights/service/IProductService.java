package uk.co.bradleynichol.snackbarinsights.service;

import uk.co.bradleynichol.snackbarinsights.dto.ProductDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

public interface IProductService {
    boolean addProduct(Product product);
    ProductDTO getProductById(String productId);
    void updateProduct(Product product);
    void deleteProduct(String productId);
}
