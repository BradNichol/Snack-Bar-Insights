package uk.co.bradleynichol.snackbarinsights.service;


import uk.co.bradleynichol.snackbarinsights.dto.BrandDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

public interface IBrandService {
    boolean addBrand(Brand brand);
    BrandDTO getBrandById(String brandId);
    void updateBrand(Brand brand);
    void deleteBrand(String brandId);
}


