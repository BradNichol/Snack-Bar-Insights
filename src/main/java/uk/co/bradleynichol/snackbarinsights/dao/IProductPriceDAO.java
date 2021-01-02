package uk.co.bradleynichol.snackbarinsights.dao;

import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

public interface IProductPriceDAO {
    void addProductPrice(ProductPrice productPrice);
    ProductPrice getProductPriceById(String productPriceId);
}
