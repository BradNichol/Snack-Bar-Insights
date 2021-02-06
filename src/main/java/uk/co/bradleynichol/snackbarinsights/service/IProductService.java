package uk.co.bradleynichol.snackbarinsights.service;

import uk.co.bradleynichol.snackbarinsights.dto.ProductDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

import java.util.List;

public interface IProductService {
    boolean addProduct(ProductDTO productDTO);
    ProductDTO getProductById(String productId);
    void updateProduct(Product product);
    void deleteProduct(String productId);
    List<ProductDTO> getAllProducts();
}
