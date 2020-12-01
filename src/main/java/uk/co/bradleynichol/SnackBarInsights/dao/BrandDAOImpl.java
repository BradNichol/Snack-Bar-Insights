package uk.co.bradleynichol.SnackBarInsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.SnackBarInsights.entity.Brand;

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
}
