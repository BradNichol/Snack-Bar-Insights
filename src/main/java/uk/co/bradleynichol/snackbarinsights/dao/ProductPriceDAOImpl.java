package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository
public class ProductPriceDAOImpl implements DAO<ProductPrice> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(ProductPrice productPrice) {
        entityManager.persist(productPrice);

    }

    @Override
    public ProductPrice findById(String productPriceId) {
        return entityManager.find(ProductPrice.class, productPriceId);
    }

    @Override
    public void update(ProductPrice entity) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void delete(String entityId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ProductPrice> findAll() {
        throw new UnsupportedOperationException();
    }
}
