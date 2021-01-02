package uk.co.bradleynichol.snackbarinsights.service;

import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

public interface IProductPriceService {
    boolean addProductPrice(ProductPrice productPrice);
    ProductPrice getProductPriceById(String productPriceId);
}
