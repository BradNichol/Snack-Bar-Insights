package uk.co.bradleynichol.snackbarinsights.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.DAO;
import uk.co.bradleynichol.snackbarinsights.dto.ProductDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements GenericService<ProductDTO> {

    private final DAO<Product> productDAO;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(DAO<Product> productDAO, ModelMapper modelMapper) {
        this.productDAO = productDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean save(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        productDAO.create(product);
        return true;
    }

    @Override
    public ProductDTO getById(String productId) {
        return convertToDTO(productDAO.findById(productId));
    }

    @Override
    public void update(ProductDTO productDTO) {
        productDAO.update(convertToEntity(productDTO));
    }

    @Override
    public void delete(String productId) {
        productDAO.delete(productId);
    }

    @Override
    public List<ProductDTO> getAll() {
        return productDAO.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDTO(Product product) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(product, ProductDTO.class);

    }

    private Product convertToEntity(ProductDTO productDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(productDTO, Product.class);

    }
}
