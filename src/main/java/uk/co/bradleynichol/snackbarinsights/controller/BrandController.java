package uk.co.bradleynichol.snackbarinsights.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.bradleynichol.snackbarinsights.entity.Brand;
import uk.co.bradleynichol.snackbarinsights.service.BrandServiceImpl;

@RestController
@Tag(name = "brand", description = "API endpoint for Brands")
@RequestMapping("/api/brands")
public class BrandController {


    private BrandServiceImpl brandService;

    @Autowired
    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBrand(@RequestBody Brand brand, UriComponentsBuilder builder) {
        boolean flag = brandService.addBrand(brand);
        if (!flag) return new ResponseEntity<>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/brands").buildAndExpand(brand.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") String id) {
        Brand brand = brandService.getBrandById(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Brand> updateBrand(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") String id) {
        brandService.deleteBrand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
