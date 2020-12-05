package uk.co.bradleynichol.snackbarinsights.dao;

import uk.co.bradleynichol.snackbarinsights.entity.Brand;

public interface IBrandDAO {
    void addBrand(Brand brand);
    Brand getBrandById(String brandId);
    void updateBrand(Brand brand);
    void deleteBrand(String brandId);
}
