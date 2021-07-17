package uk.co.bradleynichol.snackbarinsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.DAO;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

import java.util.Date;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    private final DAO<ProductPrice> productPriceDAO;

    @Autowired
    public ProductPriceServiceImpl(DAO<ProductPrice> productPriceDAO) {
        this.productPriceDAO = productPriceDAO;
    }

    @Override
    public boolean addProductPrice(ProductPrice productPrice) {
        productPrice.setDate(new Date());
        productPriceDAO.create(productPrice);
        return true;
    }

    @Override
    public ProductPrice getProductPriceById(String productPriceId) {
        return productPriceDAO.findById(productPriceId);
    }
}
