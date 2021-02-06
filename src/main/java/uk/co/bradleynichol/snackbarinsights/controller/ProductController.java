package uk.co.bradleynichol.snackbarinsights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.bradleynichol.snackbarinsights.dto.ProductDTO;
import uk.co.bradleynichol.snackbarinsights.service.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO, UriComponentsBuilder builder) {
        boolean flag = productService.addProduct(productDTO);
        if (!flag) return new ResponseEntity<>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("api/product").buildAndExpand(productDTO.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") String id) {
        ProductDTO productDTO = productService.getProductById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

}
