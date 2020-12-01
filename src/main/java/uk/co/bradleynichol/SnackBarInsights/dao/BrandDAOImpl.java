package uk.co.bradleynichol.SnackBarInsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.SnackBarInsights.entity.Brand;

import javax.transaction.Transactional;

@Transactional
@Repository
public class BrandDAOImpl implements IBrandDAO {

    @Override
    public void addBrand(Brand brand) {

    }
}
