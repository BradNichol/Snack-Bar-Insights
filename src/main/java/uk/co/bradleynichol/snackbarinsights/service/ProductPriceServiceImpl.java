package uk.co.bradleynichol.snackbarinsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.DAO;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

import java.util.Date;
import java.util.List;

@Service
public class ProductPriceServiceImpl implements GenericService<ProductPrice> {

    private final DAO<ProductPrice> productPriceDAO;

    @Autowired
    public ProductPriceServiceImpl(DAO<ProductPrice> productPriceDAO) {
        this.productPriceDAO = productPriceDAO;
    }

    @Override
    public boolean save(ProductPrice productPrice) {
        productPrice.setDate(new Date());
        productPriceDAO.create(productPrice);
        return true;
    }

    @Override
    public ProductPrice getById(String productPriceId) {
        return productPriceDAO.findById(productPriceId);
    }

    @Override
    public void update(ProductPrice entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(String brandId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ProductPrice> getAll() {
        throw new UnsupportedOperationException();
    }
}
