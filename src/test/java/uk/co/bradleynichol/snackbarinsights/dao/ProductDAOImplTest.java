package uk.co.bradleynichol.snackbarinsights.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductDAOImplTest {

    private Product product;
    private DAO<Product> systemUnderTest;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    void beforeEach() {
        product = new Product();
        systemUnderTest = new ProductDAOImpl(entityManager);
    }

    @Test
    void getProductById_GivenId_ReturnsProduct() {
        product.setName("Prod1");
        when(entityManager.find(Product.class, "123")).thenReturn(product);

        Product getProduct = systemUnderTest.findById("123");

        assertThat(getProduct).isEqualTo(product);
        assertThat(getProduct.getName()).isEqualTo("Prod1");
    }

    @Test
    void getProductById_GivenNonExistentId_ReturnsNull() {
        when(entityManager.find(any(), any())).thenReturn(null);

        Product getProduct = systemUnderTest.findById("NoRecord");

        assertThat(getProduct).isNull();
    }


}