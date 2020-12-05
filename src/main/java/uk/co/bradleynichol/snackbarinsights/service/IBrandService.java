package uk.co.bradleynichol.snackbarinsights.service;


import uk.co.bradleynichol.snackbarinsights.entity.Brand;

public interface IBrandService {
    boolean addBrand(Brand brand);
    Brand getBrandById(String brandId);
    void updateBrand(Brand brand);
    void deleteBrand(String brandId);
}


