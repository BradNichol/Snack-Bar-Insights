package uk.co.bradleynichol.snackbarinsights.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.IProductDAO;
import uk.co.bradleynichol.snackbarinsights.dto.ProductDTO;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductDAO productDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(IProductDAO productDAO) {
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
