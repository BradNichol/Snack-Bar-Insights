package uk.co.bradleynichol.snackbarinsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.IProductDAO;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public boolean addProduct(Product product) {
        productDAO.addProduct(product);
        return true;
    }

    @Override
    public Product getProductById(String productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(String productId) {
        productDAO.deleteProduct(productId);
    }
}
