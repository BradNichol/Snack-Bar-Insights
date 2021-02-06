package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductDAOImpl implements IProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product getProductById(String productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public void updateProduct(Product product) {
        Product getProduct = getProductById(product.getId());
        getProduct.setName(product.getName());
        getProduct.setPackSize(product.getPackSize());
        getProduct.setType(product.getType());
        entityManager.flush();
    }

    @Override
    public void deleteProduct(String productId) {
        entityManager.remove(getProductById(productId));
    }

    @Override
    public List<Product> findAllProducts() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }
}
