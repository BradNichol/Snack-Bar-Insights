package uk.co.bradleynichol.snackbarinsights.service;

import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {


    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public Product getProductById(String productId) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(String productId) {

    }
}
