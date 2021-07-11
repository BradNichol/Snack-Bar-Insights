package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BrandDAOImpl implements BrandDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    public BrandDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addBrand(Brand brand) {
        entityManager.persist(brand);
    }

    @Override
    public Brand getBrandById(String brandId) {
        return entityManager.find(Brand.class, brandId);
    }

    @Override
    public void updateBrand(Brand brand) {
        Brand getBrand = getBrandById(brand.getId());
        getBrand.setName(brand.getName());
        entityManager.flush();
    }

    @Override
    public void deleteBrand(String brandId) {
        entityManager.remove(getBrandById(brandId));
    }

    @Override
    public List<Brand> findAllBrands() {
        return entityManager.createQuery("from Brand", Brand.class).getResultList();
    }
}
