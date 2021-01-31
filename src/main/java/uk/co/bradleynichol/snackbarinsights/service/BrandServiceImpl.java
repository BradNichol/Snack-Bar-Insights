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


    private final IBrandDAO brandDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(IBrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    @Override
    public boolean addBrand(BrandDTO brandDTO) {
        Brand brand = convertToEntity(brandDTO);
        brandDAO.addBrand(brand);
        return true;
    }

    @Override
    public BrandDTO getBrandById(String brandId) {
        return convertToDTO(brandDAO.getBrandById(brandId));

    }

    @Override
    public void updateBrand(Brand brand) {
        brandDAO.updateBrand(brand);
    }

    @Override
    public void deleteBrand(String brandId) {
        brandDAO.deleteBrand(brandId);
    }


    private BrandDTO convertToDTO(Brand brand) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(brand, BrandDTO.class);

    }

    private Brand convertToEntity(BrandDTO brandDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(brandDTO, Brand.class);

    }
}
