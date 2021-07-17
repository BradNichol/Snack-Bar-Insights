package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BrandDAOImpl implements DAO<Brand> {

    @PersistenceContext
    private final EntityManager entityManager;

    public BrandDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Brand brand) {
        entityManager.persist(brand);
    }

    @Override
    public Brand findById(String brandId) {
        return entityManager.find(Brand.class, brandId);
    }

    @Override
    public void update(Brand brand) {
        Brand getBrand = findById(brand.getId());
        getBrand.setName(brand.getName());
        entityManager.flush();
    }

    @Override
    public void delete(String brandId) {
        entityManager.remove(findById(brandId));
    }

    @Override
    public List<Brand> findAll() {
        return entityManager.createQuery("from Brand", Brand.class).getResultList();
    }
}
