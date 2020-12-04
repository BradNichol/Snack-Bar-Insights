package uk.co.bradleynichol.SnackBarInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.SnackBarInsights.dao.IBrandDAO;
import uk.co.bradleynichol.SnackBarInsights.entity.Brand;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandDAO brandDAO;

    @Override
    public boolean addBrand(Brand brand) {
        brandDAO.addBrand(brand);
        return true;
    }

    @Override
    public Brand getBrandById(String brandId) {
        return brandDAO.getBrandById(brandId);
    }
}
