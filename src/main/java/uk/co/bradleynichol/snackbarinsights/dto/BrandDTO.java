package uk.co.bradleynichol.snackbarinsights.dto;


import uk.co.bradleynichol.snackbarinsights.entity.Product;


import java.util.List;

public class BrandDTO {


    private String id;
    private String name;
    private List<Product> products;

    public BrandDTO() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
