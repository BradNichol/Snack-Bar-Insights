package uk.co.bradleynichol.snackbarinsights.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandDAOImplTest {

    private Brand brand;
    private BrandDAO systemUnderTest;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    void beforeEach() {
        brand = new Brand();
        systemUnderTest = new BrandDAOImpl(entityManager);
    }



    @Test
    void getBrandById_GivenId_ReturnsBrand() {
        brand.setId("123");
        brand.setName("Test");
        when(entityManager.find(Brand.class, "123")).thenReturn(brand);

        Brand getBrand = systemUnderTest.getBrandById("123");

        assertThat(getBrand).isEqualTo(brand);
        assertThat(getBrand.getName()).isEqualTo("Test");

    }

    @Test
    void getBrandById_GivenNonExistentId_returnsNull() {
        when(entityManager.find(any(), any())).thenReturn(null);

        Brand getBrand = systemUnderTest.getBrandById("NoRecord");

        assertThat(getBrand).isNull();
    }

}