package uk.co.bradleynichol.snackbarinsights.service;


import uk.co.bradleynichol.snackbarinsights.dto.BrandDTO;

import java.util.List;

public interface BrandService {
    boolean addBrand(BrandDTO brandDTO);
    BrandDTO getBrandById(String brandId);
    void updateBrand(BrandDTO brandDTO);
    void deleteBrand(String brandId);
    List<BrandDTO> getAllBrands();
}


