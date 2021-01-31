package uk.co.bradleynichol.snackbarinsights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.bradleynichol.snackbarinsights.entity.Product;
import uk.co.bradleynichol.snackbarinsights.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@RequestBody Product product, UriComponentsBuilder builder) {
        boolean flag = productService.addProduct(product);
        if (!flag) return new ResponseEntity<>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("api/product").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
