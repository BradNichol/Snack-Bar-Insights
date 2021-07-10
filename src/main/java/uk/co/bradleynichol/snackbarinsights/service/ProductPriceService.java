package uk.co.bradleynichol.snackbarinsights.service;

import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

public interface ProductPriceService {
    boolean addProductPrice(ProductPrice productPrice);
    ProductPrice getProductPriceById(String productPriceId);
}
