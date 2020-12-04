package uk.co.bradleynichol.SnackBarInsights.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.bradleynichol.SnackBarInsights.entity.Brand;
import uk.co.bradleynichol.SnackBarInsights.service.BrandServiceImpl;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {


    private BrandServiceImpl brandService;

    @Autowired
    public BrandsController(BrandServiceImpl brandService) {
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
        return new ResponseEntity<Brand>(brand, HttpStatus.OK);
    }



}
