package uk.co.bradleynichol.snackbarinsights.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.ProductDAO;
import uk.co.bradleynichol.snackbarinsights.dto.ProductDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public boolean addProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        productDAO.addProduct(product);
        return true;
    }

    @Override
    public ProductDTO getProductById(String productId) {
        return convertToDTO(productDAO.getProductById(productId));
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(String productId) {
        productDAO.deleteProduct(productId);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productDAO.findAllProducts()
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
