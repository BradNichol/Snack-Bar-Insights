package uk.co.bradleynichol.snackbarinsights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.bradleynichol.snackbarinsights.dto.ScraperResourceDTO;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;
import uk.co.bradleynichol.snackbarinsights.service.ScraperResourceService;
import uk.co.bradleynichol.snackbarinsights.service.scraper.ScraperService;

import java.util.List;

@RestController
@RequestMapping("/api/scraperResource")
public class ScraperResourceController {

    private final ScraperResourceService scraperResourceService;


    @Autowired
    public ScraperResourceController(ScraperResourceService scraperResourceService, ScraperService scraperService) {
        this.scraperResourceService = scraperResourceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addScraperResource(@RequestBody ScraperResource scraperResource, UriComponentsBuilder builder) {
        boolean flag = scraperResourceService.addResource(scraperResource);
        if (!flag) return new ResponseEntity<>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("api/scraperResource").buildAndExpand(scraperResource.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScraperResource> getScraperResourceById(@PathVariable("id") String id) {
        ScraperResource scraperResource = scraperResourceService.getResourceById(id);
        return new ResponseEntity<>(scraperResource, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScraperResourceDTO>> getAllScraperResources() {
        List<ScraperResourceDTO> scraperResources = scraperResourceService.getAllResources();
        return new ResponseEntity<>(scraperResources, HttpStatus.OK);
    }

}
