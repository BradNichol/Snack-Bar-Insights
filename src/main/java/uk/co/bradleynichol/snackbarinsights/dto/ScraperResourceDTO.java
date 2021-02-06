package uk.co.bradleynichol.snackbarinsights.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import uk.co.bradleynichol.snackbarinsights.entity.Product;

public class ScraperResourceDTO {

    private String id;
    private Product product;
    private String domain;
    private String path;
    private String xPath;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getxPath() {
        return xPath;
    }

    public void setxPath(String xPath) {
        this.xPath = xPath;
    }
}
