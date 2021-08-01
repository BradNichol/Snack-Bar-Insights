package uk.co.bradleynichol.snackbarinsights.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.DAO;
import uk.co.bradleynichol.snackbarinsights.dto.BrandDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandGenericServiceImpl implements GenericService<BrandDTO> {


    private final DAO<Brand> brandDAO;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public BrandGenericServiceImpl(DAO<Brand> brandDAO, ModelMapper modelMapper) {
        this.brandDAO = brandDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean save(BrandDTO brandDTO) {
        Brand brand = convertToEntity(brandDTO);
        brandDAO.create(brand);
        return true;
    }

    @Override
    public BrandDTO getById(String brandId) {
        return convertToDTO(brandDAO.findById(brandId));

    }

    @Override
    public void update(BrandDTO brandDTO) {
        brandDAO.update(convertToEntity(brandDTO));
    }

    @Override
    public void delete(String brandId) {
        brandDAO.delete(brandId);
    }

    @Override
    public List<BrandDTO> getAll() {
        return brandDAO.findAll()
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
