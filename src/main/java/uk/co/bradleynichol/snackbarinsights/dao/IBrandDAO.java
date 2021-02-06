package uk.co.bradleynichol.snackbarinsights.dao;

import uk.co.bradleynichol.snackbarinsights.entity.Brand;

import java.util.List;

public interface IBrandDAO {
    void addBrand(Brand brand);
    Brand getBrandById(String brandId);
    void updateBrand(Brand brand);
    void deleteBrand(String brandId);
    List<Brand> findAllBrands();
}
