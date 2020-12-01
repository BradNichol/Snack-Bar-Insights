package uk.co.bradleynichol.SnackBarInsights.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.bradleynichol.SnackBarInsights.service.BrandServiceImpl;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    private BrandServiceImpl brandService;

    //@PostMapping("/add")
    //public ResponseEntity<Void> add



}
