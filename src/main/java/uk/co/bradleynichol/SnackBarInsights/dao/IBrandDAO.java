package uk.co.bradleynichol.SnackBarInsights.dao;

import uk.co.bradleynichol.SnackBarInsights.entity.Brand;

public interface IBrandDAO {
    void addBrand(Brand brand);
    Brand getBrandById(String brandId);
    void updateBrand(Brand brand);
}
