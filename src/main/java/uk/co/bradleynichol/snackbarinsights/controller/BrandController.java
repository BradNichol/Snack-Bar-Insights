package uk.co.bradleynichol.snackbarinsights.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.bradleynichol.snackbarinsights.dto.BrandDTO;
import uk.co.bradleynichol.snackbarinsights.service.GenericService;

import java.util.List;

@RestController
@Tag(name = "brand", description = "API endpoint for Brands")
@RequestMapping("/api/brands")
public class BrandController {


    private final GenericService<BrandDTO> brandService;

    @Autowired
    public BrandController(GenericService<BrandDTO> brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBrand(@RequestBody BrandDTO brandDTO, UriComponentsBuilder builder) {
        boolean flag = brandService.save(brandDTO);
        if (!flag) return new ResponseEntity<>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/brands").buildAndExpand(brandDTO.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable("id") String id) {
        BrandDTO brandDTO = brandService.getById(id);
        return new ResponseEntity<>(brandDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        List<BrandDTO> brandDTOList = brandService.getAll();
        return new ResponseEntity<>(brandDTOList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BrandDTO> updateBrand(@RequestBody BrandDTO brandDTO) {
        brandService.update(brandDTO);
        return new ResponseEntity<>(brandDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") String id) {
        brandService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
