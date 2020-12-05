package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BrandDAOImpl implements IBrandDAO {

    @PersistenceContext
    private EntityManager entityManager;

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
}
