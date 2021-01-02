package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ProductPriceDAOImpl implements IProductPriceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProductPrice(ProductPrice productPrice) {
        entityManager.persist(productPrice);

    }

    @Override
    public ProductPrice getProductPriceById(String productPriceId) {
        return entityManager.find(ProductPrice.class, productPriceId);
    }
}
