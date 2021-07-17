package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductDAOImpl implements DAO<Product> {

    @PersistenceContext
    private final EntityManager entityManager;

    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(String productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public void update(Product product) {
        Product getProduct = findById(product.getId());
        getProduct.setName(product.getName());
        getProduct.setPackSize(product.getPackSize());
        getProduct.setType(product.getType());
        entityManager.flush();
    }

    @Override
    public void delete(String productId) {
        entityManager.remove(findById(productId));
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }
}
