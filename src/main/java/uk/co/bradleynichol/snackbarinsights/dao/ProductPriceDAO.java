package uk.co.bradleynichol.snackbarinsights.dao;

import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

public interface ProductPriceDAO {
    void addProductPrice(ProductPrice productPrice);
    ProductPrice getProductPriceById(String productPriceId);
}
