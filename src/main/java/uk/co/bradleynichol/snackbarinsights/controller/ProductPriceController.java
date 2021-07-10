package uk.co.bradleynichol.snackbarinsights.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;
import uk.co.bradleynichol.snackbarinsights.service.ProductPriceService;

@Hidden
@RestController
@RequestMapping("/api/price")
public class ProductPriceController {

    private final ProductPriceService productPriceService;

    @Autowired
    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }


    @PostMapping("/add")
    public ResponseEntity<Void> addProductPrice(@RequestBody ProductPrice productPrice, UriComponentsBuilder builder) {
        boolean flag = productPriceService.addProductPrice(productPrice);
        if (!flag) return new ResponseEntity<>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("api/price").buildAndExpand(productPrice.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPrice> getProductPriceById(@PathVariable("id") String id) {
        ProductPrice productPrice = productPriceService.getProductPriceById(id);
        return new ResponseEntity<>(productPrice, HttpStatus.OK);
    }
}
