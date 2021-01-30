package uk.co.bradleynichol.snackbarinsights.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.IBrandDAO;
import uk.co.bradleynichol.snackbarinsights.dto.BrandDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

@Service
public class BrandServiceImpl implements IBrandService {


    private IBrandDAO brandDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(IBrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    @Override
    public boolean addBrand(Brand brand) {
        brandDAO.addBrand(brand);
        return true;
    }

    @Override
    public Brand getBrandById(String brandId) {
        return brandDAO.getBrandById(brandId);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDAO.updateBrand(brand);
    }

    @Override
    public void deleteBrand(String brandId) {
        brandDAO.deleteBrand(brandId);
    }


    private BrandDTO convertToBrandDTO(Brand brand) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);
        return brandDTO;
    }
}
