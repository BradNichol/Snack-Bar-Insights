package uk.co.bradleynichol.snackbarinsights.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.BrandDAO;
import uk.co.bradleynichol.snackbarinsights.dto.BrandDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {


    private final BrandDAO brandDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandDAO brandDAO) {
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
    public void updateBrand(BrandDTO brandDTO) {
        brandDAO.updateBrand(convertToEntity(brandDTO));
    }

    @Override
    public void deleteBrand(String brandId) {
        brandDAO.deleteBrand(brandId);
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        return brandDAO.findAllBrands()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
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
