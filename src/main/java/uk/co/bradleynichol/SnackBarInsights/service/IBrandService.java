package uk.co.bradleynichol.SnackBarInsights.service;


import uk.co.bradleynichol.SnackBarInsights.entity.Brand;

public interface IBrandService {
    boolean addBrand(Brand brand);
    Brand getBrandById(String brandId);
    void updateBrand(Brand brand);
}


