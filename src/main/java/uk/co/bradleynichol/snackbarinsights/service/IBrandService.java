package uk.co.bradleynichol.snackbarinsights.service;


import uk.co.bradleynichol.snackbarinsights.dto.BrandDTO;

public interface IBrandService {
    boolean addBrand(BrandDTO brandDTO);
    BrandDTO getBrandById(String brandId);
    void updateBrand(BrandDTO brandDTO);
    void deleteBrand(String brandId);
}


