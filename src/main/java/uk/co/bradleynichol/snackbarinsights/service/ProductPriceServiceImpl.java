package uk.co.bradleynichol.snackbarinsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.IProductPriceDAO;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

import java.util.Date;

@Service
public class ProductPriceServiceImpl implements IProductPriceService {

    private final IProductPriceDAO productPriceDAO;

    @Autowired
    public ProductPriceServiceImpl(IProductPriceDAO productPriceDAO) {
        this.productPriceDAO = productPriceDAO;
    }

    @Override
    public boolean addProductPrice(ProductPrice productPrice) {
        productPrice.setDate(new Date());
        productPriceDAO.addProductPrice(productPrice);
        return true;
    }

    @Override
    public ProductPrice getProductPriceById(String productPriceId) {
        return productPriceDAO.getProductPriceById(productPriceId);
    }
}
